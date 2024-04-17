package com.citizen.tenant.entities.transaction;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TCsTenantVerificationId implements Serializable {
    private static final long serialVersionUID = 8194190372839142660L;
    @NotNull
    @Column(name = "TENANT_SR_NUM", nullable = false)
    private Long tenantSrNum;

    @NotNull
    @Column(name = "LANG_CD", nullable = false)
    private Integer langCd;

}