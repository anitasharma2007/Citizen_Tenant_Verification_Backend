package com.citizen.tenant.repositories;

import com.citizen.tenant.entities.transaction.TCsPersonAddress;
import com.citizen.tenant.entities.transaction.TCsPersonAddressId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ITCsPersonAddressRepository extends JpaRepository<TCsPersonAddress, TCsPersonAddressId> {

    //method to generate address code
    @Query(value = "SELECT dbo.fnGetAddressCodeCitizen(:DISTRICT_CD,:ADDR_TYPE)",nativeQuery = true)
    String generateAddressCode(@Param("DISTRICT_CD") String districtCd, @Param("ADDR_TYPE") String addrType);
}
