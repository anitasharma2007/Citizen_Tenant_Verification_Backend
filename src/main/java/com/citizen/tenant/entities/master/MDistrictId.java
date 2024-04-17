package com.citizen.tenant.entities.master;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MDistrictId implements Serializable {
    private static final long serialVersionUID = 4698688706016657464L;
    @NotNull
    @Column(name = "DISTRICT_CD", nullable = false)
    private Integer districtCd;

    @NotNull
    @Column(name = "LANG_CD", nullable = false)
    private Integer langCd;

    public Integer getDistrictCd() {
        return districtCd;
    }

    public void setDistrictCd(Integer districtCd) {
        this.districtCd = districtCd;
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
        MDistrictId entity = (MDistrictId) o;
        return Objects.equals(this.districtCd, entity.districtCd) &&
                Objects.equals(this.langCd, entity.langCd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(districtCd, langCd);
    }

}