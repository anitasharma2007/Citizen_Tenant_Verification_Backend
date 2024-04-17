package com.citizen.tenant.entities.master;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MPoliceStationId implements Serializable {
    private static final long serialVersionUID = 7463536959420042260L;
    @NotNull
    @Column(name = "PS_CD", nullable = false)
    private Integer psCd;

    @NotNull
    @Column(name = "LANG_CD", nullable = false)
    private Integer langCd;

    public Integer getPsCd() {
        return psCd;
    }

    public void setPsCd(Integer psCd) {
        this.psCd = psCd;
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
        MPoliceStationId entity = (MPoliceStationId) o;
        return Objects.equals(this.psCd, entity.psCd) &&
                Objects.equals(this.langCd, entity.langCd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(psCd, langCd);
    }

}