package com.citizen.tenant.repositories;

import com.citizen.tenant.entities.transaction.TCsTenantVerification;
import com.citizen.tenant.entities.transaction.TCsTenantVerificationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TCsTenantVerificationRepository extends JpaRepository<TCsTenantVerification, TCsTenantVerificationId> {

    //method to generate tenant serial no(district code of tenant present city)
    @Query(value = "SELECT dbo.fnGetTenantVerificationSrno(:DISTRICT_CD)",nativeQuery = true)
    String generateTenantSerialNo(@Param("DISTRICT_CD") String districtCD);
}
