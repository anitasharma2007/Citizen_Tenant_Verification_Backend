package com.citizen.tenant.entities.master;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MOccupationId implements Serializable {
    private static final long serialVersionUID = 1202759369611742725L;
    @NotNull
    @Column(name = "OCCUPATION_CD", nullable = false)
    private Integer occupationCd;

    @NotNull
    @Column(name = "LANG_CD", nullable = false)
    private Integer langCd;

    public Integer getOccupationCd() {
        return occupationCd;
    }

    public void setOccupationCd(Integer occupationCd) {
        this.occupationCd = occupationCd;
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
        MOccupationId entity = (MOccupationId) o;
        return Objects.equals(this.langCd, entity.langCd) &&
                Objects.equals(this.occupationCd, entity.occupationCd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(langCd, occupationCd);
    }

}