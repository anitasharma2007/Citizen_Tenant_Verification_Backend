package com.citizen.tenant.entities.master;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MGenderId implements Serializable {
    private static final long serialVersionUID = -5854452805379759976L;
    @NotNull
    @Column(name = "GENDER_CD", nullable = false)
    private Integer genderCd;

    @NotNull
    @Column(name = "LANG_CD", nullable = false)
    private Integer langCd;

    public Integer getGenderCd() {
        return genderCd;
    }

    public void setGenderCd(Integer genderCd) {
        this.genderCd = genderCd;
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
        MGenderId entity = (MGenderId) o;
        return Objects.equals(this.genderCd, entity.genderCd) &&
                Objects.equals(this.langCd, entity.langCd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genderCd, langCd);
    }

}