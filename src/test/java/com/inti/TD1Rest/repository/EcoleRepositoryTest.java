package com.inti.TD1Rest.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.inti.TD1Rest.model.Ecole;
import com.inti.TD1Rest.model.Etudiant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class EcoleRepositoryTest 
{
	@Autowired
	EcoleRepository ecoleRepository;
	
	Ecole e1, e2;
	
	@BeforeEach
	public void setup() 
	{
		e1 = new Ecole("CNAM", "Rue Glo", "57000", "Metz");
	}
	
	@Test //question d
	public void testGetSchoolByNomandPrenom() {
		// Given
		
		// When
		Ecole ecole = ecoleRepository.findSchoolByNomandPrenom("Cinci", "Hasan");
		// Then
		assertThat(ecole).isNotNull();
		assertThat(ecole.getNom()).isEqualTo("formation");
	}
	
}
