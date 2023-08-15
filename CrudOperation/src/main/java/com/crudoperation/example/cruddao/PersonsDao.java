package com.crudoperation.example.cruddao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudoperation.example.CrudEntity.PersonEntity;

@Repository
public interface PersonsDao extends JpaRepository<PersonEntity, Long>{

}
