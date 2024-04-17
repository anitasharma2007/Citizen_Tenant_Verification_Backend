package com.citizen.tenant.repositories;

import com.citizen.tenant.entities.master.MDistrict;
import com.citizen.tenant.entities.master.MDistrictId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMasterDistrictRepository extends JpaRepository<MDistrict, MDistrictId> {

    List<MDistrict> findByIdLangCdAndStateCdAndIdDistrictCdNotAndRecordStatusNotOrderByDistrict(Integer langCd, Integer districtCd, Integer stateCd, String recordStatus);
    //List<MDistrict> findByIdLangCdAndIdDistrictCdNotAndStateCdRecordStatusNotOrderByDistrict(Integer langCd, Integer districtCd, Integer stateCd, String recordStatus);
}
