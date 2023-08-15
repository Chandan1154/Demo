package com.crudoperation.example.crudservice;

import java.util.List;

import com.crudoperation.example.CrudDto.request.PersonDTO;
import com.crudoperation.example.CrudEntity.PersonEntity;

public interface PersonService {

	boolean savePersonInfo(PersonDTO persondto);

	List<PersonEntity> getAll();

	boolean updatePersonInfo(PersonDTO persondto);

	void delete(long id);

}
