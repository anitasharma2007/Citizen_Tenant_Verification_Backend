package com.citizen.tenant.entities.master;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MNationalityId implements Serializable {
    private static final long serialVersionUID = 6259174784262939827L;
    @NotNull
    @Column(name = "NATIONALITY_CD", nullable = false)
    private Integer nationalityCd;

    @NotNull
    @Column(name = "LANG_CD", nullable = false)
    private Integer langCd;

    public Integer getNationalityCd() {
        return nationalityCd;
    }

    public void setNationalityCd(Integer nationalityCd) {
        this.nationalityCd = nationalityCd;
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
        MNationalityId entity = (MNationalityId) o;
        return Objects.equals(this.langCd, entity.langCd) &&
                Objects.equals(this.nationalityCd, entity.nationalityCd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(langCd, nationalityCd);
    }

}