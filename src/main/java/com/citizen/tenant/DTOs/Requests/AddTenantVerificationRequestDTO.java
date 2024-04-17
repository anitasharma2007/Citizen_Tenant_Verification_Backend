package com.citizen.tenant.DTOs.Requests;

import com.citizen.tenant.entities.transaction.TCsPersonInfo;
import com.citizen.tenant.entities.transaction.TCsTenantVerifyFile;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddTenantVerificationRequestDTO {

    private Integer stateCd;
    private Integer districtCd;
    private Integer psCd;
    private Integer srYear;
    private Integer runSrno;
    private Integer srTypeCd;
    private Long applicantNum;
    private Timestamp applicationDt;
    private Long tenantPersonCd;
    private Long previousAddrCd;
    private Long presentAddrCd;
    private Long permAddrCd;
    private Integer othContactNum;
    private Long ownerPersonCd;
    private Timestamp prevStayFrmDt;
    private Timestamp prevStayToDt;
    private String addrVerfDocType;
    private String addrVerfDocNum;
    private String addrOthrDocType;
    private String addrOthrDocNum;
    private String isPhotoUploaded;
    private String scanDocUpload;
    private String anyCriminalRecord;
    private String isAffadavit;
    private String affadavitDetails;
    private String crimeDetails;
    private String applicationStatus;
    private String recordStatus;
    private Timestamp recordCreatedOn;
    private String recordCreatedBy;
    private Timestamp recordUpdatedOn;
    private String recordUpdatedBy;
    private String recordSyncFrom;
    private String recordSyncTo;
    private Timestamp recordSyncOn;
    private String recordUpdatedFrom;
    private String dummyColumn1;
    private String dummyColumn2;
    private Integer originalRecord;
    private String isFirstSyncDone;
    private String isLinked;
    private Long linkedReqNum;
    private String tenancyPurpose;
    private String commercialPurposeDetails;
    private Integer tenantMembRelation;
    private Integer membAddrProof;
    private Long familyMemberCd;
    private String isInfoProvidedTrue;
    private String requestStatus;
    private String isSaveSubmit;
    private List<TCsTenantVerifyFile> tenantVerifyFiles = new ArrayList<>();
    //private List<AddressDTO> addressDTOList = new ArrayList<>();
    private List<PersonInfoDTO> personInfoDTOList = new ArrayList<>();

}



