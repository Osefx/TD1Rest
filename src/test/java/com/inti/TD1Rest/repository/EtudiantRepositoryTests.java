package com.inti.TD1Rest.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.inti.TD1Rest.model.Etudiant;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class EtudiantRepositoryTests
{
	@Autowired
	EtudiantRepository etudiantRepository;
	
	Etudiant e1;
	
	@BeforeEach
	public void setUp() {
		e1 = new Etudiant("Toto", "Titi", "tototiti@test.fr", "070809", "2");
	}
	
	@Test
	public void testSaveStudent() {
		// Given
		
		// When
		Etudiant saveEtudiant = etudiantRepository.save(e1);
		
		// Then
		assertThat(saveEtudiant).isNotNull();
		
	}
	
	@Test
	public void testGetAllStudents() {
		// Given
		
		// When
		List<Etudiant> listeEtudiant = etudiantRepository.findAll();
		// Then
		assertThat(listeEtudiant).isNotEmpty();
		assertThat(listeEtudiant).hasSize((int) etudiantRepository.count());
	}
	
	@Test
	public void testGetAllStudentsInLyon() {
		// Given
		
		// When
		List<Etudiant> listeEtudiant = etudiantRepository.findByVille();
		
		// Then
		assertThat(listeEtudiant).isNotEmpty();
		assertThat(listeEtudiant.get(0).getEcole().getVille()).isEqualTo("Lyon");
	}
	
	

}
