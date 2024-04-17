package com.citizen.tenant.repositories;

import com.citizen.tenant.entities.master.MState;
import com.citizen.tenant.entities.master.MStateId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMasterStateRepository extends JpaRepository<MState, MStateId> {

    List<MState> findByIdLangCdAndIdStateCdNotAndRecordStatusNotOrderByStateAsc(Integer langCd, Integer stateCd, String recordStatus);
}
