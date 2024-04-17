package com.citizen.tenant.DTOs.Requests;

import com.citizen.tenant.entities.transaction.TCsPersonInfo;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    private Integer addrType;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String village;
    private String tehsil;
    private Integer countryCd;
    private Integer stateCd;
    private Integer districtCd;
    private Integer psCd;
    private Integer pincode;
    private Long mobile;
    private String telephone;
    private String recordStatus;
    private Instant recordCreatedOn;
    private String recordCreatedBy;
    private Instant recordUpdatedOn;
    private String recordUpdatedBy;
    private String recordSyncFrom;
    private String recordSyncTo;
    private Instant recordSyncOn;
    private String recordUpdatedFrom;
    private String dummyColumn1;
    private String dummyColumn2;
    private Integer originalRecord;
    private String isFirstSyncDone;
    private String stayDuration;
    private Instant stayFromDt;
    private Instant stayToDt;
    private String isPermAddrSame;
    private TCsPersonInfo personInfo;
    private String addressType;
}
