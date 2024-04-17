package com.citizen.tenant.entities.master;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Nationalized;

import java.time.Instant;

@Entity
@Table(name = "m_police_station")
public class MPoliceStation {
    @EmbeddedId
    private MPoliceStationId id;

    @Column(name = "STATE_CD")
    private Integer stateCd;

    @Column(name = "DISTRICT_CD")
    private Integer districtCd;

    @Column(name = "SUB_DISTRICT_CD")
    private Integer subDistrictCd;

    @Size(max = 100)
    @Nationalized
    @Column(name = "PS", length = 100)
    private String ps;

    @Size(max = 1)
    @Nationalized
    @Column(name = "RECORD_STATUS", length = 1)
    private String recordStatus;

    @Column(name = "RECORD_CREATED_ON")
    private Instant recordCreatedOn;

    @Size(max = 50)
    @Nationalized
    @Column(name = "RECORD_CREATED_BY", length = 50)
    private String recordCreatedBy;

    @Column(name = "RECORD_UPDATED_ON")
    private Instant recordUpdatedOn;

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
    private Instant recordSyncOn;

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

    @NotNull
    @Column(name = "ORIGINAL_RECORD", nullable = false)
    private Integer originalRecord;

    @Size(max = 1)
    @Nationalized
    @Column(name = "IS_FIRST_SYNC_DONE", length = 1)
    private String isFirstSyncDone;

    @Size(max = 400)
    @Nationalized
    @Column(name = "PS_IP_ADDRESS", length = 400)
    private String psIpAddress;

    @Column(name = "CIRCLE_CD")
    private Integer circleCd;

    @Size(max = 20)
    @Nationalized
    @Column(name = "LONGITUDE", length = 20)
    private String longitude;

    @Size(max = 20)
    @Nationalized
    @Column(name = "LATITUDE", length = 20)
    private String latitude;

    public MPoliceStationId getId() {
        return id;
    }

    public void setId(MPoliceStationId id) {
        this.id = id;
    }

    public Integer getStateCd() {
        return stateCd;
    }

    public void setStateCd(Integer stateCd) {
        this.stateCd = stateCd;
    }

    public Integer getDistrictCd() {
        return districtCd;
    }

    public void setDistrictCd(Integer districtCd) {
        this.districtCd = districtCd;
    }

    public Integer getSubDistrictCd() {
        return subDistrictCd;
    }

    public void setSubDistrictCd(Integer subDistrictCd) {
        this.subDistrictCd = subDistrictCd;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public Instant getRecordCreatedOn() {
        return recordCreatedOn;
    }

    public void setRecordCreatedOn(Instant recordCreatedOn) {
        this.recordCreatedOn = recordCreatedOn;
    }

    public String getRecordCreatedBy() {
        return recordCreatedBy;
    }

    public void setRecordCreatedBy(String recordCreatedBy) {
        this.recordCreatedBy = recordCreatedBy;
    }

    public Instant getRecordUpdatedOn() {
        return recordUpdatedOn;
    }

    public void setRecordUpdatedOn(Instant recordUpdatedOn) {
        this.recordUpdatedOn = recordUpdatedOn;
    }

    public String getRecordUpdatedBy() {
        return recordUpdatedBy;
    }

    public void setRecordUpdatedBy(String recordUpdatedBy) {
        this.recordUpdatedBy = recordUpdatedBy;
    }

    public String getRecordSyncFrom() {
        return recordSyncFrom;
    }

    public void setRecordSyncFrom(String recordSyncFrom) {
        this.recordSyncFrom = recordSyncFrom;
    }

    public String getRecordSyncTo() {
        return recordSyncTo;
    }

    public void setRecordSyncTo(String recordSyncTo) {
        this.recordSyncTo = recordSyncTo;
    }

    public Instant getRecordSyncOn() {
        return recordSyncOn;
    }

    public void setRecordSyncOn(Instant recordSyncOn) {
        this.recordSyncOn = recordSyncOn;
    }

    public String getRecordUpdatedFrom() {
        return recordUpdatedFrom;
    }

    public void setRecordUpdatedFrom(String recordUpdatedFrom) {
        this.recordUpdatedFrom = recordUpdatedFrom;
    }

    public String getDummyColumn1() {
        return dummyColumn1;
    }

    public void setDummyColumn1(String dummyColumn1) {
        this.dummyColumn1 = dummyColumn1;
    }

    public String getDummyColumn2() {
        return dummyColumn2;
    }

    public void setDummyColumn2(String dummyColumn2) {
        this.dummyColumn2 = dummyColumn2;
    }

    public Integer getOriginalRecord() {
        return originalRecord;
    }

    public void setOriginalRecord(Integer originalRecord) {
        this.originalRecord = originalRecord;
    }

    public String getIsFirstSyncDone() {
        return isFirstSyncDone;
    }

    public void setIsFirstSyncDone(String isFirstSyncDone) {
        this.isFirstSyncDone = isFirstSyncDone;
    }

    public String getPsIpAddress() {
        return psIpAddress;
    }

    public void setPsIpAddress(String psIpAddress) {
        this.psIpAddress = psIpAddress;
    }

    public Integer getCircleCd() {
        return circleCd;
    }

    public void setCircleCd(Integer circleCd) {
        this.circleCd = circleCd;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

}