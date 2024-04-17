package com.citizen.tenant.services;

public interface ITCsPersonAddressService {

    //method to generate person code
    String generateAddressCode(String districtCd, String addrType);
}
