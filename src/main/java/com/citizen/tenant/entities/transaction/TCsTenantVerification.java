package com.citizen.tenant.entities.transaction;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import java.sql.Timestamp;

@Entity
@Table(name = "t_cs_tenant_verification")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TCsTenantVerification {
    @EmbeddedId
    private TCsTenantVerificationId id;

    @Column(name = "STATE_CD")
    private Integer stateCd;

    @Column(name = "DISTRICT_CD")
    private Integer districtCd;

    @Column(name = "PS_CD")
    private Integer psCd;

    @Column(name = "SR_YEAR")
    private Integer srYear;

    @Column(name = "RUN_SRNO")
    private Integer runSrno;

    @Column(name = "SR_TYPE_CD")
    private Integer srTypeCd;

    @Column(name = "APPLICANT_NUM")
    private Long applicantNum;

    @Column(name = "APPLICATION_DT")
    private Timestamp applicationDt;

//    @OneToOne
//    @JoinColumns({
//            @JoinColumn(name = "TENANT_PERSON_CD", referencedColumnName = "PERSON_CODE"),
//            @JoinColumn(name = "TENANT_PERSON_LANG_CD", referencedColumnName = "LANG_CD")
//    })
//    private TCsPersonInfo tenantPersonCd;

    @Column(name = "TENANT_PERSON_CD")
    private Long tenantPersonCd;

    @Column(name = "PREVIOUS_ADDR_CD")
    private Long previousAddrCd;

    @Column(name = "PRESENT_ADDR_CD")
    private Long presentAddrCd;

    @Column(name = "PERM_ADDR_CD")
    private Long permAddrCd;

    @Column(name = "OTH_CONTACT_NUM")
    private Integer othContactNum;

    @Column(name = "OWNER_PERSON_CD")
    private Long ownerPersonCd;

    @Column(name = "PREV_STAY_FRM_DT")
    private Timestamp prevStayFrmDt;

    @Column(name = "PREV_STAY_TO_DT")
    private Timestamp prevStayToDt;

    @Size(max = 200)
    @Nationalized
    @Column(name = "ADDR_VERF_DOC_TYPE", length = 200)
    private String addrVerfDocType;

    @Size(max = 50)
    @Nationalized
    @Column(name = "ADDR_VERF_DOC_NUM", length = 50)
    private String addrVerfDocNum;

    @Size(max = 200)
    @Nationalized
    @Column(name = "ADDR_OTHR_DOC_TYPE", length = 200)
    private String addrOthrDocType;

    @Size(max = 20)
    @Nationalized
    @Column(name = "ADDR_OTHR_DOC_NUM", length = 20)
    private String addrOthrDocNum;

    @Size(max = 1)
    @Nationalized
    @Column(name = "IS_PHOTO_UPLOADED", length = 1)
    private String isPhotoUploaded;

    @Size(max = 1)
    @Nationalized
    @Column(name = "SCAN_DOC_UPLOAD", length = 1)
    private String scanDocUpload;

    @Size(max = 1)
    @Nationalized
    @Column(name = "ANY_CRIMINAL_RECORD", length = 1)
    private String anyCriminalRecord;

    @Size(max = 1)
    @Nationalized
    @Column(name = "IS_AFFADAVIT", length = 1)
    private String isAffadavit;

    @Size(max = 2000)
    @Nationalized
    @Column(name = "AFFADAVIT_DETAILS", length = 2000)
    private String affadavitDetails;

    @Size(max = 1000)
    @Nationalized
    @Column(name = "CRIME_DETAILS", length = 1000)
    private String crimeDetails;

    @Size(max = 200)
    @Nationalized
    @Column(name = "APPLICATION_STATUS", length = 200)
    private String applicationStatus;

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

    @Size(max = 1)
    @Nationalized
    @Column(name = "IS_LINKED", length = 1)
    private String isLinked;

    @Column(name = "LINKED_REQ_NUM")
    private Long linkedReqNum;

    @Size(max = 1)
    @Nationalized
    @Column(name = "TENANCY_PURPOSE", length = 1)
    private String tenancyPurpose;

    @Size(max = 2000)
    @Nationalized
    @Column(name = "COMMERCIAL_PURPOSE_DETAILS", length = 2000)
    private String commercialPurposeDetails;

    @Column(name = "TENANT_MEMB_RELATION")
    private Integer tenantMembRelation;

    @Column(name = "MEMB_ADDR_PROOF")
    private Integer membAddrProof;

//    @OneToOne
//    @JoinColumns({
//            @JoinColumn(name = "TENANT_FAMILY_CD", referencedColumnName = "PERSON_CODE"),
//            @JoinColumn(name = "TENANT_FAMILY_LANG_CD", referencedColumnName = "LANG_CD")
//    })
//    private TCsPersonInfo familyMemberCd;

    @Column(name = "FAMILY_MEMBER_CD")
    private Long familyMemberCd;

    @Size(max = 1)
    @Nationalized
    @Column(name = "IS_INFO_PROVIDED_TRUE", length = 1)
    private String isInfoProvidedTrue;

    @Size(max = 100)
    @Nationalized
    @Column(name = "REQUEST_STATUS", length = 100)
    private String requestStatus;

    @Size(max = 1)
    @Nationalized
    @Column(name = "IS_SAVE_SUBMIT", length = 1)
    private String isSaveSubmit;

//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "tenantVerification")
//    private List<TCsTenantVerifyFile> tenantVerifyFiles = new ArrayList<>();
}