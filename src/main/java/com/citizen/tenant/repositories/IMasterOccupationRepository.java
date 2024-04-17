package com.citizen.tenant.repositories;

import com.citizen.tenant.entities.master.MOccupation;
import com.citizen.tenant.entities.master.MOccupationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMasterOccupationRepository extends JpaRepository<MOccupation, MOccupationId> {

    List<MOccupation> findByIdLangCdAndIdOccupationCdNotAndRecordStatusNotOrderByOccupationAsc(Integer langCd, Integer occupationCd, String recordStatus);
}
