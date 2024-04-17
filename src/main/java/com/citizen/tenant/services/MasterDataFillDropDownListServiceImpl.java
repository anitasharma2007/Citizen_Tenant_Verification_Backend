package com.citizen.tenant.services;

import com.citizen.tenant.entities.master.*;
import com.citizen.tenant.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MasterDataFillDropDownListServiceImpl implements IMasterDataFillDropDownListService {

    private final IMasterNationalityRepository nationalityRepository;
    private final IMasterOccupationRepository occupationRepository;
    private final IMasterStateRepository stateRepository;
    private final IMasterDistrictRepository districtRepository;
    private final IMasterPoliceStationRepository policeStationRepository;
    private final IMasterGenderRepository genderRepository;
    private final IMasterRelationTypeRepository relationTypeRepository;
    private final IMNationalIdDocTypeRepository nationalIdDocTypeRepository;

    //fetch nationality details
    @Override
    public List<MNationality> findByIdLangCdAndIdNationalityCdNotAndRecordStatusNotOrderByNationalityAsc(Integer langCd, Integer nationalityCd, String recordStatus) {
        return nationalityRepository.findByIdLangCdAndIdNationalityCdNotAndRecordStatusNotOrderByNationalityAsc(langCd, nationalityCd, recordStatus);
    }

    //fetch state details
    @Override
    public List<MState> findByIdLangCdAndIdStateCdNotAndRecordStatusNotOrderByStateAsc(Integer langCd, Integer stateCd, String recordStatus) {
        return stateRepository.findByIdLangCdAndIdStateCdNotAndRecordStatusNotOrderByStateAsc(langCd, stateCd, recordStatus);
    }

    //fetch district details
    @Override
    public List<MDistrict> findByIdLangCdAndStateCdAndIdDistrictCdNotAndRecordStatusNotOrderByDistrict(Integer langCd, Integer districtCd, Integer stateCd, String recordStatus) {
        return districtRepository.findByIdLangCdAndStateCdAndIdDistrictCdNotAndRecordStatusNotOrderByDistrict(langCd, districtCd, stateCd, recordStatus);
    }

    //fill police station
    @Override
    public List<MPoliceStation> findByIdLangCdAndStateCdAndDistrictCdAndIdPsCdNotAndRecordStatusNotOrderByPs(Integer langCd, Integer stateCd, Integer districtCd, Integer psCd, String recordStatus) {
        return policeStationRepository.findByIdLangCdAndStateCdAndDistrictCdAndIdPsCdNotAndRecordStatusNotOrderByPs(langCd, stateCd, districtCd, psCd, recordStatus);
    }

    //fetch occupation details
    @Override
    public List<MOccupation> findByIdLangCdAndIdOccupationCdNotAndRecordStatusNotOrderByOccupationAsc(Integer langCd, Integer occupationCd, String recordStatus) {
        return occupationRepository.findByIdLangCdAndIdOccupationCdNotAndRecordStatusNotOrderByOccupationAsc(langCd, occupationCd, recordStatus);
    }

    //fetch Gender Details
    @Override
    public List<MGender> findByIdLangCdAndIdGenderCdNotAndRecordStatusNotOrderByGender(Integer langCd, Integer genderCd, String recordStatus) {
        return genderRepository.findByIdLangCdAndIdGenderCdNotAndRecordStatusNotOrderByGender(langCd, genderCd, recordStatus);
    }

    //fill relative type details
    @Override
    public List<MRelationType> findFilteredRelationTypes(Integer langCd, String recordStatus) {
        return relationTypeRepository.findFilteredRelationTypes(langCd,recordStatus);
    }

    //fetch National Doc Type
    @Override
    public List<MNationalIdDocType> findByIdLangCdAndIdNationalIdTypeCdNotOrderByNationalIdTypeAsc (Integer langCd, Integer nationalIdTypeCd) {
        return nationalIdDocTypeRepository.findByIdLangCdAndIdNationalIdTypeCdNotOrderByNationalIdTypeAsc ( langCd,  nationalIdTypeCd);
    }

}
