package com.citizen.tenant.entities.transaction;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TCsPersonInfoId implements Serializable {
    private static final long serialVersionUID = -232261653232159895L;
    @NotNull
    @Column(name = "PERSON_CODE", nullable = false)
    private Long personCode;

    @NotNull
    @Column(name = "LANG_CD", nullable = false)
    private Integer langCd;

    public Long getPersonCode() {
        return personCode;
    }

    public void setPersonCode(Long personCode) {
        this.personCode = personCode;
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
        TCsPersonInfoId entity = (TCsPersonInfoId) o;
        return Objects.equals(this.langCd, entity.langCd) &&
                Objects.equals(this.personCode, entity.personCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(langCd, personCode);
    }

}