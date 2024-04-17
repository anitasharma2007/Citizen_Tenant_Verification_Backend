package com.citizen.tenant.repositories;

import com.citizen.tenant.entities.master.MPoliceStation;
import com.citizen.tenant.entities.master.MPoliceStationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMasterPoliceStationRepository extends JpaRepository<MPoliceStation, MPoliceStationId> {
    List<MPoliceStation> findByIdLangCdAndStateCdAndDistrictCdAndIdPsCdNotAndRecordStatusNotOrderByPs(Integer langCd, Integer stateCd, Integer districtCd, Integer psCd, String recodStatus);
}
