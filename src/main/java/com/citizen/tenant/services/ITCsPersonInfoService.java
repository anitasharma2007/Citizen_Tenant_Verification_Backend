package com.citizen.tenant.services;

import com.citizen.tenant.DTOs.Requests.PersonInfoDTO;
import com.citizen.tenant.entities.transaction.TCsPersonInfo;

public interface ITCsPersonInfoService {

    //method to generate person code
    String generatePersonCode(String ps_cd, String person_type_cd);

    //method to save personinfo data in t_cs_person_info table
    TCsPersonInfo savePersonInfoData(PersonInfoDTO personInfoDTO,int ownerPsId);

    TCsPersonInfo saveAndUpdatePersonInfoData(PersonInfoDTO personInfoDTO,int ownerPsId);

}
