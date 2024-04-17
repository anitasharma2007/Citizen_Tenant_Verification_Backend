package com.citizen.tenant.entities.master;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MRelationTypeId implements Serializable {
    private static final long serialVersionUID = -2588381288846329790L;
    @NotNull
    @Column(name = "RELATION_TYPE_CD", nullable = false)
    private Integer relationTypeCd;

    @NotNull
    @Column(name = "LANG_CD", nullable = false)
    private Integer langCd;

    public Integer getRelationTypeCd() {
        return relationTypeCd;
    }

    public void setRelationTypeCd(Integer relationTypeCd) {
        this.relationTypeCd = relationTypeCd;
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
        MRelationTypeId entity = (MRelationTypeId) o;
        return Objects.equals(this.langCd, entity.langCd) &&
                Objects.equals(this.relationTypeCd, entity.relationTypeCd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(langCd, relationTypeCd);
    }

}