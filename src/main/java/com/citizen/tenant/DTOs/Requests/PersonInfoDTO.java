package com.citizen.tenant.DTOs.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
//add this class reference as list in AddTenantVerificationRequestDTO
public class PersonInfoDTO {

    private Integer stateCd;
    private Integer districtCd;
    private Integer psCd;
    private Integer regYear;
    private Integer runSrno;
    private Integer personTypeCd;
    private String firstName;
    private String middleName;
    private String lastName;
    private String alias1;
    private String alias2;
    private Integer relativeType;
    private String relativeName;
    private String relativeAlias;
    private Integer age;
    private Integer yob;
    private Integer gender;
    private Long mobile1;
    private Long mobile2;
    private String telephone;
    private String officePhone;
    private String maritalStatus;
    private String email;
    private Integer nationalityCd;
    private Integer religion;
    private Integer category;
    private Integer caste;
    private Integer eduQual;
    private Integer incomeGroup;
    private Integer occupation;
    private String dialects;
    private String speaksPetWords;
    private String languagesKnown;
    private Timestamp dob;
    private String livingStatus;
    private String ageProofReq;
    private String uidNum;
    private Integer nationalIdType;
    private String nationalIdNum;
    private String passportIssuePlc;
    private Timestamp passportIssueDt;
    private String otherIdName;
    private String otherIdNum;
    private Integer ageFromYrs;
    private Integer ageToYrs;
    private String heightFromCm;
    private String heightToCm;
    private Integer weightKg;
    private String othIdentityMarks;
    private Integer buildType;
    private Integer complexionType;
    private Integer faceType;
    private Integer cheekType;
    private Integer chinType;
    private Integer moustachesType;
    private Integer foreheadType;
    private Integer beardType;
    private Integer teethType;
    private Integer noseType;
    private Integer lipsType;
    private Integer isPoxpitted;
    private Integer voice;
    private Integer hairType;
    private Integer isUsingWig;
    private Integer hairStraightness;
    private Integer hairCut;
    private Integer hairStyle;
    private Integer hairColor;
    private Integer hairLength;
    private Integer hairDye;
    private Integer eyeType;
    private Integer eyeColor;
    private Integer eyeBlind;
    private Integer eyeUsingSpecs;
    private Integer eyeSpecsType;
    private Integer eyeBrowThickness;
    private Integer eyeBrowShape;
    private Integer eyeBlinking;
    private Integer eyeSquint;
    private Integer habitsCd;
    private Integer dressHabits;
    private Integer earsMissing;
    private Integer earsDeformed;
    private Integer deafDumb;
    private Integer armsMissing;
    private Integer fingerExtra;
    private Integer fingerMissing;
    private Integer hunchBack;
    private Integer legsMissing;
    private Integer bowLeg;
    private Integer limping;
    private Integer knockKnee;
    private Integer toeExtra;
    private Integer toeMissing;
    private Integer earLobes;
    private Integer isGoitre;
    private Integer dressOuterTopCd;
    private Integer dressOuterBotCd;
    private Integer dressInnerTopCd;
    private Integer dressInnerBotCd;
    private Integer dressAccessryTopCd;
    private Integer dressAccessoryBotCd;
    private Integer dressFootwearCd;
    private Integer dressUpperColorCd;
    private Integer dressLowerColorCd;
    private String placeOfBirth;
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
    private String fullName;
    private String isFirstSyncDone;
    private Integer bloodGroupCd;
    private Integer ageMonths;
    private List<AddressDTO> addressDTOList = new ArrayList<>();
    //flag to distinguish between owner, tenant and family member details
    //(owner =1,tenant =2,  family member=3)
    private int personType;

}