package com.crudoperation.example.CrudController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crudoperation.example.CrudDto.request.PersonDTO;
import com.crudoperation.example.CrudDto.response.CommonResponse;
import com.crudoperation.example.CrudEntity.PersonEntity;
import com.crudoperation.example.crudservice.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	PersonService  service;

	@PostMapping("/")
	public ResponseEntity<CommonResponse> save(@RequestBody PersonDTO persondto) {
		if(service.savePersonInfo(persondto))

			return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("200","person datials  has been saved succefully"));

		return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("200","unable person datials  has been saved succefully"));
	}

	@GetMapping("/")
	public List<PersonEntity> fecth() {
	return	service.getAll();	
	}
	
	@PostMapping("/")
	public ResponseEntity<CommonResponse> update(@RequestBody PersonDTO persondto) {
		if(service.updatePersonInfo(persondto))

			return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("200","person datials  has been saved succefully"));

		return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("200","unable person datials  has been saved succefully"));
	}
	
	@DeleteMapping("/")
	public void delete(@RequestParam(name="id")long id) {
		 service.delete(id);
	}
	
	
}
