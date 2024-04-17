package com.citizen.tenant.entities.master;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MNationalIdDocTypeId implements Serializable {
    private static final long serialVersionUID = 5459190726764923845L;
    @NotNull
    @Column(name = "NATIONAL_ID_TYPE_CD", nullable = false)
    private Integer nationalIdTypeCd;

    @NotNull
    @Column(name = "LANG_CD", nullable = false)
    private Integer langCd;

    public Integer getNationalIdTypeCd() {
        return nationalIdTypeCd;
    }

    public void setNationalIdTypeCd(Integer nationalIdTypeCd) {
        this.nationalIdTypeCd = nationalIdTypeCd;
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
        MNationalIdDocTypeId entity = (MNationalIdDocTypeId) o;
        return Objects.equals(this.langCd, entity.langCd) &&
                Objects.equals(this.nationalIdTypeCd, entity.nationalIdTypeCd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(langCd, nationalIdTypeCd);
    }

}