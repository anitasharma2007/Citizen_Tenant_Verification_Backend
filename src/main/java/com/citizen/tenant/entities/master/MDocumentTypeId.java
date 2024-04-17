package com.citizen.tenant.entities.master;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MDocumentTypeId implements Serializable {
    private static final long serialVersionUID = 645875344895132770L;
    @NotNull
    @Column(name = "DOCUMENT_TYPE_CD", nullable = false)
    private Integer documentTypeCd;

    @NotNull
    @Column(name = "LANG_CD", nullable = false)
    private Integer langCd;

    public Integer getDocumentTypeCd() {
        return documentTypeCd;
    }

    public void setDocumentTypeCd(Integer documentTypeCd) {
        this.documentTypeCd = documentTypeCd;
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
        MDocumentTypeId entity = (MDocumentTypeId) o;
        return Objects.equals(this.langCd, entity.langCd) &&
                Objects.equals(this.documentTypeCd, entity.documentTypeCd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(langCd, documentTypeCd);
    }

}