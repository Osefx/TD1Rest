package com.inti.TD1Rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inti.TD1Rest.model.Ecole;
import com.inti.TD1Rest.repository.EcoleRepository;


@RestController
public class EcoleController
{
	
	@Autowired
	EcoleRepository ecoleRepository;
	
	@GetMapping("/schools")
	public ResponseEntity<List<Ecole>> getAllSchools()
	{
		return new ResponseEntity<List<Ecole>>(ecoleRepository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/saveSchool")
	public ResponseEntity<Ecole> saveSchool(@RequestBody Ecole ecole)
	{
		return new ResponseEntity<Ecole>(ecoleRepository.save(ecole), HttpStatus.CREATED);
	}
	
	@PutMapping("/updateSchool/{id}")
	public String updateEcole(@RequestBody Ecole ecole, @PathVariable int id)
	{
//		Ecole e1 = ecoleRepository.getReferenceById(id);
		ecoleRepository.save(ecole);
		
		return "The school : " + ecole + " has been updated";
	}
	
	@DeleteMapping("/deleteSchool")
	public String deleteSchool(@RequestParam("id") int id)
	{
		ecoleRepository.deleteById(id);
		return "School deleted";
	}
	
	@GetMapping("/schoolByEmail/{email}")
	public Ecole getSchoolByEmail(@PathVariable String email)
	{
		return ecoleRepository.findSchoolByEmail(email);
	}
	
	
	
	@GetMapping("/schoolByNomandPrenom/{nom}/{prenom}") //http://localhost:8080/schoolByNomandPrenom/Cinci/Hasan
	public Ecole getSchoolByNomandPrenom(@PathVariable String nom, @PathVariable String prenom)
	{
		return ecoleRepository.findSchoolByNomandPrenom(nom, prenom);
	}
}
