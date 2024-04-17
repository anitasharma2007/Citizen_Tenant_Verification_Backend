package com.citizen.tenant.repositories;

import com.citizen.tenant.entities.master.MNationalIdDocType;
import com.citizen.tenant.entities.master.MNationalIdDocTypeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMNationalIdDocTypeRepository extends JpaRepository<MNationalIdDocType, MNationalIdDocTypeId> {
    //findByIdLangCdAndIdNationalIdTypeCdNotAndOrderByNationalIdTypeAsc
    List<MNationalIdDocType> findByIdLangCdAndIdNationalIdTypeCdNotOrderByNationalIdTypeAsc (Integer langCd, Integer nationalIdTypeCd);
}
