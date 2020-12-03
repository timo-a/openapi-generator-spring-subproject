package com.example.petstore.app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.petstore.backend.api.PetApi;
import com.example.petstore.backend.api.model.Pet;

@RestController
public class PetController implements PetApi {

	@Override
	public ResponseEntity<Pet> getPetById(Long petId) {
		return new ResponseEntity<Pet>(new Pet().id(42L), HttpStatus.OK);
	}
}
