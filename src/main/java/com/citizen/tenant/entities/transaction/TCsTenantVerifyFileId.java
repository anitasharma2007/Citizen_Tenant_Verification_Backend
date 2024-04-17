package com.citizen.tenant.entities.transaction;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TCsTenantVerifyFileId implements Serializable {
    private static final long serialVersionUID = -3331864794317575223L;
    @NotNull
    @Column(name = "FILE_UPLOAD_SRNO", nullable = false)
    private Long fileUploadSrno;

    @NotNull
    @Column(name = "LANG_CD", nullable = false)
    private Integer langCd;

    public Long getFileUploadSrno() {
        return fileUploadSrno;
    }

    public void setFileUploadSrno(Long fileUploadSrno) {
        this.fileUploadSrno = fileUploadSrno;
    }

    public Integer getLangCd() {
        return langCd;
    }

    public void setLangCd(Integer langCd) {
        this.langCd = langCd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TCsTenantVerifyFileId entity = (TCsTenantVerifyFileId) o;
        return Objects.equals(this.fileUploadSrno, entity.fileUploadSrno) &&
                Objects.equals(this.langCd, entity.langCd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileUploadSrno, langCd);
    }

}