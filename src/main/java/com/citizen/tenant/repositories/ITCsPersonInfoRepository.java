package com.citizen.tenant.repositories;

import com.citizen.tenant.entities.transaction.TCsPersonInfo;
import com.citizen.tenant.entities.transaction.TCsPersonInfoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ITCsPersonInfoRepository extends JpaRepository<TCsPersonInfo, TCsPersonInfoId> {

    //method to get maximum person code
    @Query(value = "SELECT dbo.fnGetCsPersonCode(:PS_CD,:PERSON_TYPE_CD )",nativeQuery = true)
    String getPersonMaxId(@Param("PS_CD") String PS_CD, @Param("PERSON_TYPE_CD") String PERSON_TYPE_CD);
}
