package com.crudoperation.example.crudservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudoperation.example.CrudDto.request.PersonDTO;
import com.crudoperation.example.CrudEntity.PersonEntity;
import com.crudoperation.example.cruddao.PersonsDao;

@Service
public class PersonserviceImp implements PersonService{
	@Autowired
	private PersonsDao persondao;

	@Override
	public boolean savePersonInfo(PersonDTO persondto) {
		PersonEntity personEntity= InitializePerson(persondto);
		PersonEntity per=persondao.save(personEntity);
		if(per!=null)
			return true;
		return false;
	}

	private PersonEntity InitializePerson(PersonDTO persondto) {
		PersonEntity personEntity =new PersonEntity();
		personEntity.setName(persondto.getName());
		personEntity.setMobile(persondto.getMobile());
		personEntity.setDob(persondto.getDob());

		return personEntity;


	}

	@Override
	public List<PersonEntity> getAll() {
		return persondao.findAll();
	}

	@Override
	public boolean updatePersonInfo(PersonDTO persondto) {
		long id=persondto.getId();
		Optional<PersonEntity> find=persondao.findById(id);
		if(find.isPresent()) {
			PersonEntity person=find.get();
			person.setName(persondto.getName());
			person.setMobile(persondto.getMobile());
			person.setDob(persondto.getDob());

			persondao.save(person);
			return true;
		}
		return false;
	}

	@Override
	public void delete(long id) {
		Optional<PersonEntity> find=persondao.findById(id);
		if(find.isPresent()) {
			PersonEntity person	 =find.get();
			persondao.delete(person);
		}

	}


}
