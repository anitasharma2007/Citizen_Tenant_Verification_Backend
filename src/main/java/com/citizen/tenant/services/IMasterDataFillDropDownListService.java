package com.citizen.tenant.services;

import com.citizen.tenant.entities.master.*;

import java.util.List;

public interface IMasterDataFillDropDownListService {

    //fill nationality dropdown
    List<MNationality> findByIdLangCdAndIdNationalityCdNotAndRecordStatusNotOrderByNationalityAsc(Integer langCd, Integer nationalityCd, String recordStatus);

    //fill state dropdown
    List<MState> findByIdLangCdAndIdStateCdNotAndRecordStatusNotOrderByStateAsc(Integer langCd, Integer stateCd, String recordStatus);

    //fill district dropdown
    List<MDistrict> findByIdLangCdAndStateCdAndIdDistrictCdNotAndRecordStatusNotOrderByDistrict(Integer langCd, Integer stateCd, Integer districtCd, String recordStatus);

    //fill police station dropdown
    List<MPoliceStation>  findByIdLangCdAndStateCdAndDistrictCdAndIdPsCdNotAndRecordStatusNotOrderByPs(Integer langCd, Integer stateCd, Integer districtCd, Integer psCd, String recodStatus);

    //fill occupation dropdown
    List<MOccupation> findByIdLangCdAndIdOccupationCdNotAndRecordStatusNotOrderByOccupationAsc(Integer langCd, Integer occupationCd, String recordStatus);

    //fill gender dropdown
    List<MGender> findByIdLangCdAndIdGenderCdNotAndRecordStatusNotOrderByGender(Integer langCd, Integer genderCd, String recordStatus);

    //fill relative type dropdown
    List<MRelationType> findFilteredRelationTypes(Integer langCd, String recordStatus);

    //fill national doc type dropdown
    List<MNationalIdDocType> findByIdLangCdAndIdNationalIdTypeCdNotOrderByNationalIdTypeAsc (Integer langCd, Integer nationalIdTypeCd);
}
