package com.citizen.tenant.entities.transaction;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import java.sql.Timestamp;

@Entity
@Table(name = "t_cs_tenant_verify_files")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TCsTenantVerifyFile {
    @EmbeddedId
    private TCsTenantVerifyFileId id;

    @Column(name = "TENANT_SR_NUM")
    private Long tenantSrNum;

    @Column(name = "FILE_SRNO")
    private Long fileSrno;

    @Column(name = "FILE_TYPE_CD")
    private Integer fileTypeCd;

    @Column(name = "UPLOADED_FILE")
    private byte[] uploadedFile;

    @Size(max = 100)
    @Nationalized
    @Column(name = "FILE_NAME", length = 100)
    private String fileName;

    @Size(max = 200)
    @Nationalized
    @Column(name = "FILE_PATH", length = 200)
    private String filePath;

    @Size(max = 100)
    @Nationalized
    @Column(name = "FILE_DESC", length = 100)
    private String fileDesc;

    @Column(name = "FILE_SIZE")
    private Integer fileSize;

    @Size(max = 50)
    @Nationalized
    @Column(name = "FILE_BELONGS_TO", length = 50)
    private String fileBelongsTo;

    @Size(max = 1)
    @Nationalized
    @Column(name = "STATUS_FLAG", length = 1)
    private String statusFlag;

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

    @Column(name = "FILE_SUBTYPE_CD")
    private Integer fileSubtypeCd;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "TENANT_VERIFCATION_ID", referencedColumnName = "TENANT_SR_NUM"),
            @JoinColumn(name = "TENANT_VERF_FILES_LANG_CD", referencedColumnName = "LANG_CD")
    })
    private TCsTenantVerification tenantVerification;

}