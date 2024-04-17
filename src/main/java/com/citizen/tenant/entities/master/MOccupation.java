package com.citizen.tenant.entities.master;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Nationalized;

import java.time.Instant;

@Entity
@Table(name = "m_occupation")
public class MOccupation {
    @EmbeddedId
    private MOccupationId id;

    @Size(max = 100)
    @Nationalized
    @Column(name = "OCCUPATION", length = 100)
    private String occupation;

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

    @Size(max = 1)
    @Nationalized
    @Column(name = "IS_FIRST_SYNC_DONE", length = 1)
    private String isFirstSyncDone;

    public MOccupationId getId() {
        return id;
    }

    public void setId(MOccupationId id) {
        this.id = id;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
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

    public String getIsFirstSyncDone() {
        return isFirstSyncDone;
    }

    public void setIsFirstSyncDone(String isFirstSyncDone) {
        this.isFirstSyncDone = isFirstSyncDone;
    }

}