package com.citizen.tenant.services;

import com.citizen.tenant.DTOs.Requests.AddressDTO;
import com.citizen.tenant.DTOs.Requests.PersonInfoDTO;
import com.citizen.tenant.entities.transaction.TCsPersonAddress;
import com.citizen.tenant.entities.transaction.TCsPersonAddressId;
import com.citizen.tenant.entities.transaction.TCsPersonInfo;
import com.citizen.tenant.entities.transaction.TCsPersonInfoId;
import com.citizen.tenant.repositories.ITCsPersonAddressRepository;
import com.citizen.tenant.repositories.ITCsPersonInfoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TCsPersonInfoServiceImpl implements ITCsPersonInfoService {

    private final ITCsPersonInfoRepository personInfoRepository;

    private final ModelMapper modelMapper;

    private final ITCsPersonAddressRepository personAddressRepository;

    //method to generate person code
    @Override
    public String generatePersonCode(String ps_cd, String person_type_cd) {
        return personInfoRepository.getPersonMaxId(ps_cd, person_type_cd);
    }

    //method to save person info data
    @Override
    public TCsPersonInfo savePersonInfoData(PersonInfoDTO personInfoDTO, int ownerPsId) {
        System.out.println("Person Info DTO : " + personInfoDTO);
        //mapping of address dto list to address list
        List<TCsPersonAddress> tCsPersonAddressList = new ArrayList<>();
        for (AddressDTO addressDTO : personInfoDTO.getAddressDTOList()) {
            System.out.println("address DTO : " + addressDTO);
            tCsPersonAddressList.add(modelMapper.map(addressDTO, TCsPersonAddress.class));
        }
        //mapping of personInfoDTO to TCsPersonInfo
        TCsPersonInfo personInfo = modelMapper.map(personInfoDTO, TCsPersonInfo.class);
        //setting composite primary key for each entry in TCsPersonInfo
        TCsPersonInfoId personInfoId = new TCsPersonInfoId();
        personInfoId.setLangCd(77);
        personInfoId.setPersonCode(Long.valueOf(
                Long.valueOf(generatePersonCode(
                        String.valueOf(ownerPsId),
                        String.valueOf(personInfoDTO.getPersonTypeCd())
                ))
        ));
        personInfo.setId(personInfoId);
        //loop to iterate TCsPersonAddress list to add address in database
        for (TCsPersonAddress personAddress : tCsPersonAddressList) {
            //generating composite primary key for each entry in TCsPersonAddress(t_cs_person_address)
            TCsPersonAddressId personAddressId = new TCsPersonAddressId();
            personAddressId.setLangCd(66);
            personAddressId.setAddressCd(
                    Long.valueOf(personAddressRepository.generateAddressCode(
                            String.valueOf(personAddress.getDistrictCd()),
                            String.valueOf(personAddress.getAddrType()))));
            personAddress.setId(personAddressId);
            personAddress.setPersonCode(personInfoId.getPersonCode());
            Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
            personAddress.setRecordCreatedOn(currentTimestamp);
            System.out.println("Address primary key : " + personAddressId);
            //calling ITCsPersonInfoRepository to save data in t_cs_person_address
            //personAddressRepository.save(personAddress);
        }
        personInfo.setAddresses(tCsPersonAddressList);
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        personInfo.setRecordCreatedOn(currentTimestamp);
        System.out.println("id of person info : " + personInfo);
        personInfoRepository.save(personInfo);
        System.out.println("Person info stored in database successfully!!!");
        return personInfo;
    }

    //method to save person info data (in case of modification)
    @Override
    public TCsPersonInfo saveAndUpdatePersonInfoData(PersonInfoDTO personInfoDTO, int ownerPsId) {
        System.out.println("Person Info DTO : " + personInfoDTO);
        //mapping of address dto list to address list
        List<TCsPersonAddress> tCsPersonAddressList = new ArrayList<>();
        for (AddressDTO addressDTO : personInfoDTO.getAddressDTOList()) {
            System.out.println("address DTO : " + addressDTO);
            tCsPersonAddressList.add(modelMapper.map(addressDTO, TCsPersonAddress.class));
        }
        //mapping of personInfoDTO to TCsPersonInfo
        TCsPersonInfo personInfo = modelMapper.map(personInfoDTO, TCsPersonInfo.class);
        //setting composite primary key for each entry in TCsPersonInfo
        TCsPersonInfoId personInfoId = new TCsPersonInfoId();
        personInfoId.setLangCd(77);
        personInfoId.setPersonCode(Long.valueOf(
                Long.valueOf(generatePersonCode(
                        String.valueOf(ownerPsId),
                        String.valueOf(personInfoDTO.getPersonTypeCd())
                ))
        ));
        personInfo.setId(personInfoId);
        //loop to iterate TCsPersonAddress list to add address in database
        for (TCsPersonAddress personAddress : tCsPersonAddressList) {
            //generating composite primary key for each entry in TCsPersonAddress(t_cs_person_address)
            TCsPersonAddressId personAddressId = new TCsPersonAddressId();
            personAddressId.setLangCd(66);
            personAddressId.setAddressCd(
                    Long.valueOf(personAddressRepository.generateAddressCode(
                            String.valueOf(personAddress.getDistrictCd()),
                            String.valueOf(personAddress.getAddrType()))));
            personAddress.setId(personAddressId);
            personAddress.setPersonCode(personInfoId.getPersonCode());
            personAddress.setRecordStatus("U");
            Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
            personAddress.setRecordCreatedOn(currentTimestamp);
            System.out.println("Address primary key : " + personAddressId);
            //calling ITCsPersonInfoRepository to save data in t_cs_person_address
            //personAddressRepository.save(personAddress);
        }
        personInfo.setAddresses(tCsPersonAddressList);
        personInfo.setRecordStatus("U");
        personInfo.setRecordCreatedBy("anita");
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        personInfo.setRecordCreatedOn(currentTimestamp);
        System.out.println("id of person info : " + personInfo);
        personInfoRepository.save(personInfo);
        System.out.println("Person info stored in database successfully!!!");
        return personInfo;
    }
}
