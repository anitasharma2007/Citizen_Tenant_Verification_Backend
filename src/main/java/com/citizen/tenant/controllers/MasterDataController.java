package com.citizen.tenant.controllers;

import com.citizen.tenant.entities.master.*;
import com.citizen.tenant.repositories.IMasterOccupationRepository;
import com.citizen.tenant.services.IMasterDataFillDropDownListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/masterData")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200/")
public class MasterDataController {

    private final IMasterDataFillDropDownListService dropDownListService;

    //fill nationality dropdown
    @GetMapping("/nationality/{langCd}")
    List<MNationality> fetchNationality(@PathVariable Integer langCd){
        return dropDownListService.findByIdLangCdAndIdNationalityCdNotAndRecordStatusNotOrderByNationalityAsc(langCd, 0, "D");
    }

    //fill state dropdown
    @GetMapping("/state/{langCd}")
    List<MState> fetchState(@PathVariable Integer langCd){
        return dropDownListService.findByIdLangCdAndIdStateCdNotAndRecordStatusNotOrderByStateAsc(langCd, 0, "D");
    }

    //fill district dropdown
    @GetMapping("/district")
    List<MDistrict> fetchDistrict(@RequestParam Integer langCd, @RequestParam Integer stateCd){
        return dropDownListService.findByIdLangCdAndStateCdAndIdDistrictCdNotAndRecordStatusNotOrderByDistrict(langCd, stateCd,0,"D");
    }

    //fill police station dropdown
    @GetMapping("/policeStation")
    List<MPoliceStation> fetchPoliceStation(@RequestParam Integer langCd, @RequestParam Integer stateCd, @RequestParam Integer districtCd){
        return dropDownListService.findByIdLangCdAndStateCdAndDistrictCdAndIdPsCdNotAndRecordStatusNotOrderByPs(langCd, stateCd,districtCd, 0,"D");
    }

    //fill occupation dropdown
    @GetMapping("/occupation/{langCd}")
    List<MOccupation> fetchOccupation(@PathVariable Integer langCd){
        return dropDownListService.findByIdLangCdAndIdOccupationCdNotAndRecordStatusNotOrderByOccupationAsc(langCd, 0, "D");
    }

    //API to fill gender dropdown
    @GetMapping("/gender/{langCd}")
    List<MGender> fetchGender(@PathVariable Integer langCd){
        return dropDownListService.findByIdLangCdAndIdGenderCdNotAndRecordStatusNotOrderByGender(langCd,0,"D");
    }

    //API to fill relative type dropdown
    @GetMapping("/relationType/{langCd}")
    List<MRelationType> fetchRelationType(@PathVariable Integer langCd){
        return dropDownListService.findFilteredRelationTypes(langCd, "D");
    }

    //API to fill national document type
    @GetMapping("/nationalDocType/{langCd}")
    List<MNationalIdDocType> fetchNationalDocType(@PathVariable Integer langCd){
        return dropDownListService.findByIdLangCdAndIdNationalIdTypeCdNotOrderByNationalIdTypeAsc ( langCd, 0);
    }
}
