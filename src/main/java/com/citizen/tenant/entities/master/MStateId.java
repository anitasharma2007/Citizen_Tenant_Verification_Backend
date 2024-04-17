package com.citizen.tenant.entities.master;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MStateId implements Serializable {
    private static final long serialVersionUID = 3018199972479144719L;
    @NotNull
    @Column(name = "STATE_CD", nullable = false)
    private Integer stateCd;

    @NotNull
    @Column(name = "LANG_CD", nullable = false)
    private Integer langCd;

    public Integer getStateCd() {
        return stateCd;
    }

    public void setStateCd(Integer stateCd) {
        this.stateCd = stateCd;
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
        MStateId entity = (MStateId) o;
        return Objects.equals(this.stateCd, entity.stateCd) &&
                Objects.equals(this.langCd, entity.langCd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stateCd, langCd);
    }

}