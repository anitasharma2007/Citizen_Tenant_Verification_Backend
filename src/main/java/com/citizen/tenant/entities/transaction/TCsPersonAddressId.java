package com.citizen.tenant.entities.transaction;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TCsPersonAddressId implements Serializable {
    private static final long serialVersionUID = 642061480185831065L;
    @NotNull
    @Column(name = "ADDRESS_CD", nullable = false)
    private Long addressCd;

    @NotNull
    @Column(name = "LANG_CD", nullable = false)
    private Integer langCd;

    public Long getAddressCd() {
        return addressCd;
    }

    public void setAddressCd(Long addressCd) {
        this.addressCd = addressCd;
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
        TCsPersonAddressId entity = (TCsPersonAddressId) o;
        return Objects.equals(this.addressCd, entity.addressCd) &&
                Objects.equals(this.langCd, entity.langCd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressCd, langCd);
    }

}