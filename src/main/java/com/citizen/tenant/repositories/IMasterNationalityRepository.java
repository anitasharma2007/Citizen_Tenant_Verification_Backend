package com.citizen.tenant.repositories;

import com.citizen.tenant.entities.master.MNationality;
import com.citizen.tenant.entities.master.MNationalityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMasterNationalityRepository extends JpaRepository<MNationality, MNationalityId> {

    //list of nationality on the basis of langCd

//    @Override
//    List<MNationality> findAll  (Iterable<MNationalityId> mNationalityIds);

    List<MNationality> findByIdLangCdAndIdNationalityCdNotAndRecordStatusNotOrderByNationalityAsc (Integer langCd, Integer nationalityCd , String recordStatus);
}
