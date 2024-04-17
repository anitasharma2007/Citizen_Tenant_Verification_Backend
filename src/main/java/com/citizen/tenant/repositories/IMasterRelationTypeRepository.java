package com.citizen.tenant.repositories;

import com.citizen.tenant.entities.master.MRelationType;
import com.citizen.tenant.entities.master.MRelationTypeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMasterRelationTypeRepository extends JpaRepository<MRelationType, MRelationTypeId> {

    @Query("SELECT rt FROM MRelationType rt " +
            "WHERE rt.id.relationTypeCd <> 0 " +
            "AND rt.id.langCd = :langCd " +
            "AND rt.id.relationTypeCd IN (5, 6, 7, 8, 9) " +
            "AND rt.recordStatus <> :recordStatus")
    List<MRelationType> findFilteredRelationTypes(@Param("langCd") Integer langCd, @Param("recordStatus") String recordStatus);

}
