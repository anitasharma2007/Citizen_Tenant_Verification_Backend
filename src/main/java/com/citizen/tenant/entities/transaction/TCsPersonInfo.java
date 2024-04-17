package com.citizen.tenant.entities.transaction;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_cs_person_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TCsPersonInfo {
    @EmbeddedId
    private TCsPersonInfoId id;

    @Column(name = "STATE_CD")
    private Integer stateCd;

    @Column(name = "DISTRICT_CD")
    private Integer districtCd;

    @Column(name = "PS_ID")
    private Integer psCd;

    @Column(name = "REG_YEAR")
    private Integer regYear;

    @Column(name = "RUN_SRNO")
    private Integer runSrno;

    @Column(name = "PERSON_TYPE_CD")
    private Integer personTypeCd;

    @Size(max = 120)
    @Nationalized
    @Column(name = "FIRST_NAME", length = 120)
    private String firstName;

    @Size(max = 120)
    @Nationalized
    @Column(name = "MIDDLE_NAME", length = 120)
    private String middleName;

    @Size(max = 120)
    @Nationalized
    @Column(name = "LAST_NAME", length = 120)
    private String lastName;

    @Size(max = 100)
    @Nationalized
    @Column(name = "ALIAS1", length = 100)
    private String alias1;

    @Size(max = 100)
    @Nationalized
    @Column(name = "ALIAS2", length = 100)
    private String alias2;

    @Column(name = "RELATIVE_TYPE")
    private Integer relativeType;

    @Size(max = 250)
    @Nationalized
    @Column(name = "RELATIVE_NAME", length = 250)
    private String relativeName;

    @Size(max = 100)
    @Nationalized
    @Column(name = "RELATIVE_ALIAS", length = 100)
    private String relativeAlias;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "YOB")
    private Integer yob;

    @Column(name = "GENDER")
    private Integer gender;

    @Column(name = "MOBILE_1")
    private Long mobile1;

    @Column(name = "MOBILE_2")
    private Long mobile2;

    @Size(max = 20)
    @Nationalized
    @Column(name = "TELEPHONE", length = 20)
    private String telephone;

    @Size(max = 20)
    @Nationalized
    @Column(name = "OFFICE_PHONE", length = 20)
    private String officePhone;

    @Size(max = 30)
    @Nationalized
    @Column(name = "MARITAL_STATUS", length = 30)
    private String maritalStatus;

    @Size(max = 100)
    @Nationalized
    @Column(name = "EMAIL", length = 100)
    private String email;

    @Column(name = "NATIONALITY_CD")
    private Integer nationalityCd;

    @Column(name = "RELIGION")
    private Integer religion;

    @Column(name = "CATEGORY")
    private Integer category;

    @Column(name = "CASTE")
    private Integer caste;

    @Column(name = "EDU_QUAL")
    private Integer eduQual;

    @Column(name = "INCOME_GROUP")
    private Integer incomeGroup;

    @Column(name = "OCCUPATION")
    private Integer occupation;

    @Size(max = 50)
    @Nationalized
    @Column(name = "DIALECTS", length = 50)
    private String dialects;

    @Size(max = 200)
    @Nationalized
    @Column(name = "SPEAKS_PET_WORDS", length = 200)
    private String speaksPetWords;

    @Size(max = 200)
    @Nationalized
    @Column(name = "LANGUAGES_KNOWN", length = 200)
    private String languagesKnown;

    @Column(name = "DOB")
    private Timestamp dob;

    @Size(max = 200)
    @Nationalized
    @Column(name = "LIVING_STATUS", length = 200)
    private String livingStatus;

    @Size(max = 1)
    @Nationalized
    @Column(name = "AGE_PROOF_REQ", length = 1)
    private String ageProofReq;

    @Size(max = 20)
    @Nationalized
    @Column(name = "UID_NUM", length = 20)
    private String uidNum;

    @Column(name = "NATIONAL_ID_TYPE")
    private Integer nationalIdType;

    @Size(max = 25)
    @Nationalized
    @Column(name = "NATIONAL_ID_NUM", length = 25)
    private String nationalIdNum;

    @Size(max = 200)
    @Nationalized
    @Column(name = "PASSPORT_ISSUE_PLC", length = 200)
    private String passportIssuePlc;

    @Column(name = "PASSPORT_ISSUE_DT")
    private Timestamp passportIssueDt;

    @Size(max = 200)
    @Nationalized
    @Column(name = "OTHER_ID_NAME", length = 200)
    private String otherIdName;

    @Size(max = 200)
    @Nationalized
    @Column(name = "OTHER_ID_NUM", length = 200)
    private String otherIdNum;

    @Column(name = "AGE_FROM_YRS")
    private Integer ageFromYrs;

    @Column(name = "AGE_TO_YRS")
    private Integer ageToYrs;

    @Size(max = 100)
    @Nationalized
    @Column(name = "HEIGHT_FROM_CM", length = 100)
    private String heightFromCm;

    @Size(max = 100)
    @Nationalized
    @Column(name = "HEIGHT_TO_CM", length = 100)
    private String heightToCm;

    @Column(name = "WEIGHT_KG")
    private Integer weightKg;

    @Size(max = 200)
    @Nationalized
    @Column(name = "OTH_IDENTITY_MARKS", length = 200)
    private String othIdentityMarks;

    @Column(name = "BUILD_TYPE")
    private Integer buildType;

    @Column(name = "COMPLEXION_TYPE")
    private Integer complexionType;

    @Column(name = "FACE_TYPE")
    private Integer faceType;

    @Column(name = "CHEEK_TYPE")
    private Integer cheekType;

    @Column(name = "CHIN_TYPE")
    private Integer chinType;

    @Column(name = "MOUSTACHES_TYPE")
    private Integer moustachesType;

    @Column(name = "FOREHEAD_TYPE")
    private Integer foreheadType;

    @Column(name = "BEARD_TYPE")
    private Integer beardType;

    @Column(name = "TEETH_TYPE")
    private Integer teethType;

    @Column(name = "NOSE_TYPE")
    private Integer noseType;

    @Column(name = "LIPS_TYPE")
    private Integer lipsType;

    @Column(name = "IS_POXPITTED")
    private Integer isPoxpitted;

    @Column(name = "VOICE")
    private Integer voice;

    @Column(name = "HAIR_TYPE")
    private Integer hairType;

    @Column(name = "IS_USING_WIG")
    private Integer isUsingWig;

    @Column(name = "HAIR_STRAIGHTNESS")
    private Integer hairStraightness;

    @Column(name = "HAIR_CUT")
    private Integer hairCut;

    @Column(name = "HAIR_STYLE")
    private Integer hairStyle;

    @Column(name = "HAIR_COLOR")
    private Integer hairColor;

    @Column(name = "HAIR_LENGTH")
    private Integer hairLength;

    @Column(name = "HAIR_DYE")
    private Integer hairDye;

    @Column(name = "EYE_TYPE")
    private Integer eyeType;

    @Column(name = "EYE_COLOR")
    private Integer eyeColor;

    @Column(name = "EYE_BLIND")
    private Integer eyeBlind;

    @Column(name = "EYE_USING_SPECS")
    private Integer eyeUsingSpecs;

    @Column(name = "EYE_SPECS_TYPE")
    private Integer eyeSpecsType;

    @Column(name = "EYE_BROW_THICKNESS")
    private Integer eyeBrowThickness;

    @Column(name = "EYE_BROW_SHAPE")
    private Integer eyeBrowShape;

    @Column(name = "EYE_BLINKING")
    private Integer eyeBlinking;

    @Column(name = "EYE_SQUINT")
    private Integer eyeSquint;

    @Column(name = "HABITS_CD")
    private Integer habitsCd;

    @Column(name = "DRESS_HABITS")
    private Integer dressHabits;

    @Column(name = "EARS_MISSING")
    private Integer earsMissing;

    @Column(name = "EARS_DEFORMED")
    private Integer earsDeformed;

    @Column(name = "DEAF_DUMB")
    private Integer deafDumb;

    @Column(name = "ARMS_MISSING")
    private Integer armsMissing;

    @Column(name = "FINGER_EXTRA")
    private Integer fingerExtra;

    @Column(name = "FINGER_MISSING")
    private Integer fingerMissing;

    @Column(name = "HUNCH_BACK")
    private Integer hunchBack;

    @Column(name = "LEGS_MISSING")
    private Integer legsMissing;

    @Column(name = "BOW_LEG")
    private Integer bowLeg;

    @Column(name = "LIMPING")
    private Integer limping;

    @Column(name = "KNOCK_KNEE")
    private Integer knockKnee;

    @Column(name = "TOE_EXTRA")
    private Integer toeExtra;

    @Column(name = "TOE_MISSING")
    private Integer toeMissing;

    @Column(name = "EAR_LOBES")
    private Integer earLobes;

    @Column(name = "IS_GOITRE")
    private Integer isGoitre;

    @Column(name = "DRESS_OUTER_TOP_CD")
    private Integer dressOuterTopCd;

    @Column(name = "DRESS_OUTER_BOT_CD")
    private Integer dressOuterBotCd;

    @Column(name = "DRESS_INNER_TOP_CD")
    private Integer dressInnerTopCd;

    @Column(name = "DRESS_INNER_BOT_CD")
    private Integer dressInnerBotCd;

    @Column(name = "DRESS_ACCESSRY_TOP_CD")
    private Integer dressAccessryTopCd;

    @Column(name = "DRESS_ACCESSORY_BOT_CD")
    private Integer dressAccessoryBotCd;

    @Column(name = "DRESS_FOOTWEAR_CD")
    private Integer dressFootwearCd;

    @Column(name = "DRESS_UPPER_COLOR_CD")
    private Integer dressUpperColorCd;

    @Column(name = "DRESS_LOWER_COLOR_CD")
    private Integer dressLowerColorCd;

    @Size(max = 200)
    @Nationalized
    @Column(name = "PLACE_OF_BIRTH", length = 200)
    private String placeOfBirth;

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

    @Size(max = 350)
    @Nationalized
    @Column(name = "FULL_NAME", length = 350)
    private String fullName;

    @Size(max = 1)
    @Nationalized
    @Column(name = "IS_FIRST_SYNC_DONE", length = 1)
    private String isFirstSyncDone;

    @Column(name = "BLOOD_GROUP_CD")
    private Integer bloodGroupCd;

    @Column(name = "AGE_MONTHS")
    private Integer ageMonths;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<TCsPersonAddress> addresses = new ArrayList<>();

//    @OneToOne(mappedBy = "tenantPersonCd",cascade = CascadeType.ALL)
//    private TCsTenantVerification tenantVerification;

}