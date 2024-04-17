package com.citizen.tenant.entities.transaction;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import java.sql.Timestamp;

@Entity
@Table(name = "t_cs_person_address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TCsPersonAddress {
    @EmbeddedId
    private TCsPersonAddressId id;

    @Column(name = "PERSON_CODE")
    private Long personCode;

    @Column(name = "ADDR_TYPE")
    private Integer addrType;

    @Size(max = 120)
    @Nationalized
    @Column(name = "ADDRESS_LINE_1", length = 120)
    private String addressLine1;

    @Size(max = 120)
    @Nationalized
    @Column(name = "ADDRESS_LINE_2", length = 120)
    private String addressLine2;

    @Size(max = 120)
    @Nationalized
    @Column(name = "ADDRESS_LINE_3", length = 120)
    private String addressLine3;

    @Size(max = 120)
    @Nationalized
    @Column(name = "VILLAGE", length = 120)
    private String village;

    @Size(max = 120)
    @Nationalized
    @Column(name = "TEHSIL", length = 120)
    private String tehsil;

    @Column(name = "COUNTRY_CD")
    private Integer countryCd;

    @Column(name = "STATE_CD")
    private Integer stateCd;

    @Column(name = "DISTRICT_CD")
    private Integer districtCd;

    @Column(name = "PS_CD")
    private Integer psCd;

    @Column(name = "PINCODE")
    private Integer pincode;

    @Column(name = "MOBILE")
    private Long mobile;

    @Size(max = 20)
    @Nationalized
    @Column(name = "TELEPHONE", length = 20)
    private String telephone;

    @Size(max = 1)
    @Nationalized
    @Column(name = "RECORD_STATUS", length = 1)
    private String recordStatus;

    @Column(name = "RECORD_CREATED_ON")
    private Timestamp recordCreatedOn;

    @Size(max = 50)
    @Nationalized
    @Column(name = "RECORD_CREATED_BY", length = 50)
    private String recordCreatedBy;

    @Column(name = "RECORD_UPDATED_ON")
    private Timestamp recordUpdatedOn;

    @Size(max = 50)
    @Nationalized
    @Column(name = "RECORD_UPDATED_BY", length = 50)
    private String recordUpdatedBy;

    @Size(max = 10)
    @Nationalized
    @Column(name = "RECORD_SYNC_FROM", length = 10)
    private String recordSyncFrom;

    @Size(max = 10)
    @Nationalized
    @Column(name = "RECORD_SYNC_TO", length = 10)
    private String recordSyncTo;

    @Column(name = "RECORD_SYNC_ON")
    private Timestamp recordSyncOn;

    @Size(max = 1)
    @Nationalized
    @Column(name = "RECORD_UPDATED_FROM", length = 1)
    private String recordUpdatedFrom;

    @Size(max = 30)
    @Nationalized
    @Column(name = "DUMMY_COLUMN_1", length = 30)
    private String dummyColumn1;

    @Size(max = 50)
    @Nationalized
    @Column(name = "DUMMY_COLUMN_2", length = 50)
    private String dummyColumn2;

    @Column(name = "ORIGINAL_RECORD")
    private Integer originalRecord;

    @Size(max = 1)
    @Nationalized
    @Column(name = "IS_FIRST_SYNC_DONE", length = 1)
    private String isFirstSyncDone;

    @Size(max = 40)
    @Nationalized
    @Column(name = "STAY_DURATION", length = 40)
    private String stayDuration;

    @Column(name = "STAY_FROM_DT")
    private Timestamp stayFromDt;

    @Column(name = "STAY_TO_DT")
    private Timestamp stayToDt;

    @Size(max = 1)
    @Nationalized
    @Column(name = "IS_PERM_ADDR_SAME", length = 1)
    private String isPermAddrSame;

}