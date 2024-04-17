package com.citizen.tenant.controllers;

import com.citizen.tenant.DTOs.Requests.AddTenantVerificationRequestDTO;
import com.citizen.tenant.DTOs.Requests.PersonInfoDTO;
import com.citizen.tenant.entities.transaction.TCsTenantVerification;
import com.citizen.tenant.entities.transaction.TCsTenantVerificationId;
import com.citizen.tenant.services.ITCsTenantVerificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/citizen/tenant")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class TenantVerificationController {

    private final ITCsTenantVerificationService tenantVerificationService;

    //REST Api to add tenant verification details
    @PostMapping("/addTenantVerificationDetails")
    public TCsTenantVerification addTenantVerificationDetails(@RequestBody AddTenantVerificationRequestDTO tenantVerificationRequestDTO){
        System.out.println("in add tenant verification details controller " + tenantVerificationRequestDTO);
        return tenantVerificationService.addTenantVerificationDetails(tenantVerificationRequestDTO);
    }

    //REST API to find tenant verification details
    @GetMapping("/getTenantVerificationDetails")
    public AddTenantVerificationRequestDTO getTenantVerificationDetails(@RequestParam Long tenantSrNum, @RequestParam Integer langCd){
        return tenantVerificationService.getTenantVerificationDetails(tenantSrNum, langCd);
    }

    @PostMapping("/updateTenantVerificationDetails")
    public TCsTenantVerification updateTenantVerificationDetails(@RequestBody AddTenantVerificationRequestDTO tenantVerificationRequestDTO , @RequestParam("tenantSrNum") Long tenantSrNum, @RequestParam("langCd") Integer langCd){
        return tenantVerificationService.updateTenantVerificationDetails(tenantSrNum,langCd,tenantVerificationRequestDTO);
    }
}
