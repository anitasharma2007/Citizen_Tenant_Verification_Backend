package com.citizen.tenant.services;

import com.citizen.tenant.DTOs.Requests.AddTenantVerificationRequestDTO;
import com.citizen.tenant.DTOs.Requests.AddressDTO;
import com.citizen.tenant.DTOs.Requests.PersonInfoDTO;
import com.citizen.tenant.entities.transaction.*;
import com.citizen.tenant.repositories.ITCsPersonAddressRepository;
import com.citizen.tenant.repositories.ITCsPersonInfoRepository;
import com.citizen.tenant.repositories.TCsTenantVerificationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class TCsTenantVerificationServiceImpl implements ITCsTenantVerificationService {

    private final TCsTenantVerificationRepository tenantVerificationRepository;
    private final ITCsPersonAddressRepository personAddressRepository;
    private final ITCsPersonInfoRepository personInfoRepository;
    private final ITCsPersonInfoService personInfoService;
    private final ModelMapper modelMapper;

    @Override
    public String generateTenantVerificationSrNo(String districtCD) {
        return tenantVerificationRepository.generateTenantSerialNo(districtCD);
    }

    //method to add tenant verification details in t_cs_person_info, t_cs_person_address,t_cs_tenant_verification
    @Override
    public TCsTenantVerification addTenantVerificationDetails(AddTenantVerificationRequestDTO tenantVerificationRequestDTO) {
        int ownerPsId = 0;
        int tenantDistrictCd = 0;
        TCsPersonInfo savePersonInfoData = new TCsPersonInfo();
        System.out.println("in add tenant verification details service layer : " + tenantVerificationRequestDTO);
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        //extracting personinfodto list from tenantverificationrequestdto
        List<PersonInfoDTO> personInfoDTOList = tenantVerificationRequestDTO.getPersonInfoDTOList();
        TCsTenantVerification tenantVerification = modelMapper.map(tenantVerificationRequestDTO, TCsTenantVerification.class);
        boolean insert = false;
        for (PersonInfoDTO personInfoDTO : personInfoDTOList) {

            if (insert == false) {
                //check if the person type is owner
                if (personInfoDTO.getPersonType() == 1) {
                    //calling TCsPersonInfoServiceImpl savePersonInfoData method to save owner information
                    ownerPsId = personInfoDTO.getPsCd();
                    savePersonInfoData = personInfoService.savePersonInfoData(personInfoDTO, ownerPsId);
                    //setting OWNER_PERSON_CD in t_cs_tenant_verificaiton table
                    tenantVerification.setOwnerPersonCd(savePersonInfoData.getId().getPersonCode());
                    insert = true;
                }
            } else {
                //check if the person type is tenant
                if (personInfoDTO.getPersonType() == 2) {
                    //calling TCsPersonInfoServiceImpl savePersonInfoData method to save owner information
                    savePersonInfoData = personInfoService.savePersonInfoData(personInfoDTO, ownerPsId);
                    tenantDistrictCd = personInfoDTO.getDistrictCd();
                    //setting tenant person code to store TENANT_PERSON_CD in t_cs_tenant_verificaiton table
                    tenantVerification.setTenantPersonCd(savePersonInfoData.getId().getPersonCode());
                    System.out.println("Tenant District Cd : " + savePersonInfoData.getDistrictCd());
                    for (TCsPersonAddress personAddress : savePersonInfoData.getAddresses()) {
                        //setting PRESENT_ADDR_CD in t_cs_tenant_verificaiton table
                        if (personAddress.getAddrType() == 1)
                            tenantVerification.setPresentAddrCd(personAddress.getId().getAddressCd());
                            //setting PERM_ADDR_CD in t_cs_tenant_verificaiton table
                        else if (personAddress.getAddrType() == 2)
                            tenantVerification.setPermAddrCd(personAddress.getId().getAddressCd());
                            //setting PREVIOUS_ADDR_CD in t_cs_tenant_verificaiton table
                        else
                            tenantVerification.setPreviousAddrCd(personAddress.getId().getAddressCd());
                    }
                    insert = true;
                }
                //if the person type is family member
                else {
                    //calling TCsPersonInfoServiceImpl savePersonInfoData method to save owner information
                    savePersonInfoData = personInfoService.savePersonInfoData(personInfoDTO, ownerPsId);
                    //setting family member code to store TENANT_PERSON_CD in t_cs_tenant_verificaiton table
                    tenantVerification.setFamilyMemberCd(savePersonInfoData.getId().getPersonCode());
                    insert = true;
                }

            }
        }

        //setting composite primary key of TCsTenantVerification(TENANT_SR_NUM in t_cs_tenant_verification)
        TCsTenantVerificationId tenantVerificationId = new TCsTenantVerificationId();
        tenantVerificationId.setLangCd(34);
        tenantVerificationId.setTenantSrNum(Long.valueOf(generateTenantVerificationSrNo(String.valueOf(tenantDistrictCd))));
        tenantVerification.setId(tenantVerificationId);
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        tenantVerification.setRecordCreatedOn(currentTimestamp);
        tenantVerification.setRecordCreatedBy("anita");
        //tenantVerification.setRunSrno(Integer.valueOf( StringUtils.right(String.valueOf(tenantVerificationId) ,7) ));

        //saving TCsTenantVerification in database
        tenantVerificationRepository.save(tenantVerification);
        System.out.println("data stored successfully in t_cs_tenant_verification!!!!");
        return tenantVerification;
    }

    @Override
    public AddTenantVerificationRequestDTO getTenantVerificationDetails(Long tenantSrNum, Integer langCd) {
        AddTenantVerificationRequestDTO addTenantVerificationRequestDTO = new AddTenantVerificationRequestDTO();
        //binding tenant sr no and langcd to tenant verification id(composite primary key)
        TCsTenantVerificationId tenantVerificationId = new TCsTenantVerificationId();
        tenantVerificationId.setTenantSrNum(tenantSrNum);
        tenantVerificationId.setLangCd(langCd);
        //fetching tenant details from database (t_cs_tenant_verification)
        Optional<TCsTenantVerification> tenantVerificationDetails = tenantVerificationRepository.findById(tenantVerificationId);
        //checking if tenant details is present
        if (tenantVerificationDetails.isPresent()) {
            //using get() method to retrieve the TCsTenantVerification object
            TCsTenantVerification tenantVerification = tenantVerificationDetails.get();
            /************************************ Owner Details ************************************/
            //getting owner person code from TCsTenantVerification
            Long ownerPersonCd = tenantVerification.getOwnerPersonCd();
            TCsPersonInfoId ownerInfoId = new TCsPersonInfoId();
            ownerInfoId.setPersonCode(ownerPersonCd);
            ownerInfoId.setLangCd(77);
            //fetching owner details from database (t_cs_person_info)
            Optional<TCsPersonInfo> ownerInfo = personInfoRepository.findById(ownerInfoId);
            System.out.println("Owner Details : " + ownerInfo);
            //initializing personinfodto list
            List<PersonInfoDTO> personInfoDTOList = new ArrayList<>();
            //initializing addressdto list to bind owner address
            List<AddressDTO> ownerAddressesList = new ArrayList<>();
            //initializing addressdto list
            AddressDTO ownerAddressDto = new AddressDTO();
            //check if owner is present
            if (ownerInfo.isPresent()) {
                //using get() method to retrieve the TCsPersonInfo(owner) object
                TCsPersonInfo ownerInfoDetails = ownerInfo.get();
                //fetching owner address details
                List<TCsPersonAddress> ownerAddresses = ownerInfoDetails.getAddresses();
                //iterating list of owner addresses and mapped to addressdto
                for (TCsPersonAddress ownerAddress : ownerAddresses) {
                    ownerAddressDto = modelMapper.map(ownerAddress, AddressDTO.class);
                    ownerAddressesList.add(ownerAddressDto);
                }
                //mapping owner details to personinfoDto
                PersonInfoDTO ownerInfoDtoDetails = modelMapper.map(ownerInfoDetails, PersonInfoDTO.class);
                ownerInfoDtoDetails.setPersonType(1);
                ownerInfoDtoDetails.setAddressDTOList(ownerAddressesList);
                System.out.println("Person info dto  : " + ownerInfoDtoDetails);
                //adding owner details to person info dto list
                personInfoDTOList.add(ownerInfoDtoDetails);
                //setting owner details to AddTenantVerificationRequestDTO
                addTenantVerificationRequestDTO.setPersonInfoDTOList(personInfoDTOList);
                System.out.println("Add Tenant Verification Request DTO  : " + addTenantVerificationRequestDTO);
            }
            /************************************ Tenant Details ************************************/
            Long tenantPersonCd = tenantVerification.getTenantPersonCd();
            TCsPersonInfoId tenantInfoId = new TCsPersonInfoId();
            tenantInfoId.setPersonCode(tenantPersonCd);
            tenantInfoId.setLangCd(77);
            //getting tenant details from database
            Optional<TCsPersonInfo> tenantDetails = personInfoRepository.findById(tenantInfoId);
            System.out.println("Tenant Details : " + tenantDetails);
            List<AddressDTO> tenantAddressesList = new ArrayList<>();
            AddressDTO tenantAddressDto = new AddressDTO();
            if (tenantDetails.isPresent()) {
                TCsPersonInfo tenantInfoDetails = tenantDetails.get();
                List<TCsPersonAddress> tenantAddresses = tenantInfoDetails.getAddresses();
                for (TCsPersonAddress tenantAddress : tenantAddresses) {
                    tenantAddressDto = modelMapper.map(tenantAddress, AddressDTO.class);
                    tenantAddressesList.add(tenantAddressDto);
                }
                //mapping tenant details to personinfo
                PersonInfoDTO tenantInfoDtoDetails = modelMapper.map(tenantInfoDetails, PersonInfoDTO.class);
                tenantInfoDtoDetails.setPersonType(2);
                tenantInfoDtoDetails.setAddressDTOList(tenantAddressesList);
                System.out.println("Person info dto  : " + tenantInfoDtoDetails);
                //adding tenant details to person info dto list
                personInfoDTOList.add(tenantInfoDtoDetails);
                //setting owner details to AddTenantVerificationRequestDTO
                addTenantVerificationRequestDTO.setPersonInfoDTOList(personInfoDTOList);
                System.out.println("Add Tenant Verification Request DTO  : " + addTenantVerificationRequestDTO);
            }
            /************************************ Family Member Details ************************************/
            Long familyMemberPersonCd = tenantVerification.getFamilyMemberCd();
            TCsPersonInfoId familyMemberId = new TCsPersonInfoId();
            familyMemberId.setPersonCode(familyMemberPersonCd);
            familyMemberId.setLangCd(77);
            //getting family member details from database
            Optional<TCsPersonInfo> familyMemberDetails = personInfoRepository.findById(familyMemberId);
            System.out.println("Family Member Details : " + familyMemberDetails);
            if (familyMemberDetails.isPresent()) {
                TCsPersonInfo familyMemberInfo = familyMemberDetails.get();
                PersonInfoDTO familyMemberInfoDto = modelMapper.map(familyMemberInfo, PersonInfoDTO.class);
                familyMemberInfoDto.setPersonType(3);
                personInfoDTOList.add(familyMemberInfoDto);

                addTenantVerificationRequestDTO.setPrevStayFrmDt(tenantVerification.getPrevStayFrmDt());
                addTenantVerificationRequestDTO.setPrevStayToDt(tenantVerification.getPrevStayToDt());
                addTenantVerificationRequestDTO.setTenancyPurpose(tenantVerification.getTenancyPurpose());
                addTenantVerificationRequestDTO.setAddrVerfDocType(tenantVerification.getAddrVerfDocType());
                addTenantVerificationRequestDTO.setAddrVerfDocNum(tenantVerification.getAddrVerfDocNum());
                addTenantVerificationRequestDTO.setAddrOthrDocType(tenantVerification.getAddrOthrDocType());

                addTenantVerificationRequestDTO.setPersonInfoDTOList(personInfoDTOList);
                System.out.println("Add Tenant Verification Request DTO  : " + addTenantVerificationRequestDTO);
            }
            return addTenantVerificationRequestDTO;
        } else {
            System.out.println("Tenant Details is not available!!!!");
            return null;
        }
    }

    @Override
    public TCsTenantVerification updateTenantVerificationDetails(Long tenantSrNum, Integer langCd, AddTenantVerificationRequestDTO tenantVerificationRequestDTO) {
        AddTenantVerificationRequestDTO addTenantVerificationRequestDTO = new AddTenantVerificationRequestDTO();
        int ownerPsId = 0;
        int tenantDistrictCd = 0;
        TCsPersonInfo savePersonInfoData = new TCsPersonInfo();
        //binding tenant sr no and langcd to tenant verification id(composite primary key)
        TCsTenantVerificationId tenantVerificationId = new TCsTenantVerificationId();
        tenantVerificationId.setTenantSrNum(tenantSrNum);
        tenantVerificationId.setLangCd(langCd);
        //fetching tenant details from database (t_cs_tenant_verification)
        Optional<TCsTenantVerification> tenantVerificationDetails = tenantVerificationRepository.findById(tenantVerificationId);
        TCsTenantVerification tenantVerificationUpdatedDetails = null;
        if (tenantVerificationDetails.isPresent()) {
            //using get() method to retrieve the TCsTenantVerification object
            TCsTenantVerification tenantVerification = tenantVerificationDetails.get();
            /************************************ Owner Details ************************************/
            //getting owner person code from TCsTenantVerification
            Long ownerPersonCd = tenantVerification.getOwnerPersonCd();
            TCsPersonInfoId ownerInfoId = new TCsPersonInfoId();

            List<PersonInfoDTO> personInfoDTOList = tenantVerificationRequestDTO.getPersonInfoDTOList();
            tenantVerificationUpdatedDetails = modelMapper.map(tenantVerificationRequestDTO, TCsTenantVerification.class);
            boolean insert = false;
            for (PersonInfoDTO personInfoDTO : personInfoDTOList) {
                if (insert == false) {
                    //check if the person type is owner
                    if (personInfoDTO.getPersonType() == 1) {
                        //calling TCsPersonInfoServiceImpl savePersonInfoData method to save owner information
                        ownerPsId = personInfoDTO.getPsCd();
                        savePersonInfoData = personInfoService.saveAndUpdatePersonInfoData(personInfoDTO, ownerPsId);
                        //setting OWNER_PERSON_CD in t_cs_tenant_verificaiton table
                        tenantVerificationUpdatedDetails.setOwnerPersonCd(savePersonInfoData.getId().getPersonCode());
                        insert = true;
                    }
                } else {
                    //check if the person type is tenant
                    if (personInfoDTO.getPersonType() == 2) {
                        //calling TCsPersonInfoServiceImpl savePersonInfoData method to save owner information
                        savePersonInfoData = personInfoService.saveAndUpdatePersonInfoData(personInfoDTO, ownerPsId);
                        tenantDistrictCd = personInfoDTO.getDistrictCd();
                        //setting tenant person code to store TENANT_PERSON_CD in t_cs_tenant_verificaiton table
                        tenantVerificationUpdatedDetails.setTenantPersonCd(savePersonInfoData.getId().getPersonCode());
                        System.out.println("Tenant District Cd : " + savePersonInfoData.getDistrictCd());
                        for (TCsPersonAddress personAddress : savePersonInfoData.getAddresses()) {
                            //setting PRESENT_ADDR_CD in t_cs_tenant_verificaiton table
                            if (personAddress.getAddrType() == 1)
                                tenantVerificationUpdatedDetails.setPresentAddrCd(personAddress.getId().getAddressCd());
                                //setting PERM_ADDR_CD in t_cs_tenant_verificaiton table
                            else if (personAddress.getAddrType() == 2)
                                tenantVerificationUpdatedDetails.setPermAddrCd(personAddress.getId().getAddressCd());
                                //setting PREVIOUS_ADDR_CD in t_cs_tenant_verificaiton table
                            else
                                tenantVerificationUpdatedDetails.setPreviousAddrCd(personAddress.getId().getAddressCd());
                        }
                        insert = true;
                    }
                    //if the person type is family member
                    else {
                        //calling TCsPersonInfoServiceImpl savePersonInfoData method to save owner information
                        savePersonInfoData = personInfoService.saveAndUpdatePersonInfoData(personInfoDTO, ownerPsId);
                        //setting family member code to store TENANT_PERSON_CD in t_cs_tenant_verificaiton table
                        tenantVerificationUpdatedDetails.setFamilyMemberCd(savePersonInfoData.getId().getPersonCode());
                        insert = true;
                    }

                }
            }

        }

        //setting composite primary key of TCsTenantVerification(TENANT_SR_NUM in t_cs_tenant_verification)
        TCsTenantVerificationId tenantVerificationNewId = new TCsTenantVerificationId();
        tenantVerificationNewId.setLangCd(34);
        tenantVerificationNewId.setTenantSrNum(Long.valueOf(generateTenantVerificationSrNo(String.valueOf(tenantDistrictCd))));
        tenantVerificationUpdatedDetails.setId(tenantVerificationNewId);
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        tenantVerificationUpdatedDetails.setRecordCreatedOn(currentTimestamp);
        tenantVerificationUpdatedDetails.setRecordCreatedBy("anita");
        //tenantVerification.setRunSrno(Integer.valueOf( StringUtils.right(String.valueOf(tenantVerificationId) ,7) ));

        //saving TCsTenantVerification in database
        tenantVerificationRepository.save(tenantVerificationUpdatedDetails);
        System.out.println("data stored successfully in t_cs_tenant_verification!!!!");
        //return tenantVerificationUpdatedDetails;
        return tenantVerificationUpdatedDetails;
    }
}
