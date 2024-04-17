package com.citizen.tenant.repositories;

import com.citizen.tenant.entities.master.MGender;
import com.citizen.tenant.entities.master.MGenderId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMasterGenderRepository extends JpaRepository<MGender, MGenderId> {

    List<MGender> findByIdLangCdAndIdGenderCdNotAndRecordStatusNotOrderByGender(Integer langCd, Integer genderCd, String recordStatus);
}
