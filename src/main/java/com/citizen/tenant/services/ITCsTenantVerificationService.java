package com.citizen.tenant.services;

import com.citizen.tenant.DTOs.Requests.AddTenantVerificationRequestDTO;
import com.citizen.tenant.DTOs.Requests.PersonInfoDTO;
import com.citizen.tenant.entities.transaction.TCsTenantVerification;
import com.citizen.tenant.entities.transaction.TCsTenantVerificationId;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

public interface ITCsTenantVerificationService {

    //method to generate tenant verification serial no (TENANT_SR_NUM)
    String generateTenantVerificationSrNo(String districtCD);
    TCsTenantVerification addTenantVerificationDetails(AddTenantVerificationRequestDTO tenantVerificationRequestDTO);

    AddTenantVerificationRequestDTO getTenantVerificationDetails(Long tenantSrNum, Integer langCd);

    TCsTenantVerification updateTenantVerificationDetails(Long tenantSrNum, Integer langCd, AddTenantVerificationRequestDTO tenantVerificationRequestDTO);
}
