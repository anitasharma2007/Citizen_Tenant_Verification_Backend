package com.citizen.tenant.services;

import com.citizen.tenant.DTOs.Requests.PersonInfoDTO;
import com.citizen.tenant.entities.transaction.TCsPersonInfo;
import com.citizen.tenant.repositories.ITCsPersonAddressRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class TCsPersonAddressServiceImpl implements ITCsPersonAddressService{
    
    private final ITCsPersonAddressRepository personAddressRepository;

    @Override
    public String generateAddressCode(String districtCd, String addrType) {
        return personAddressRepository.generateAddressCode(districtCd,addrType);
    }
}
