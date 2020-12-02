package com.cg.onlineeyeclinic.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineeyeclinic.exception.SpectaclesIdNotFoundException;
import com.cg.onlineeyeclinic.model.Spectacles;
import com.cg.onlineeyeclinic.service.ISpectaclesService;

@RestController
@RequestMapping("/api/spectacles")
@Validated
public class SpectaclesController {

	@Autowired
	ISpectaclesService service;
	
	@PostMapping("/addSpectacles")
	public ResponseEntity<Spectacles> addSpectacles(@Valid @RequestBody Spectacles spectacles){
		spectacles = service.addSpectacles(spectacles);
		return new ResponseEntity<Spectacles>(spectacles, HttpStatus.OK);
	}
	
	@PutMapping("/updateSpectacles")
	public ResponseEntity<Spectacles> updateSpectacles(@Valid 
			@RequestBody Spectacles spectacles){
		spectacles = service.updateSpectacles(spectacles);
		return new ResponseEntity<Spectacles>(spectacles, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteSpectaclesById/{id}")
	public ResponseEntity<String> deleteSpectaclesById(@PathVariable("id") Integer id){
		Optional<Spectacles> specs=service.viewSpectacles(id);
	if(specs.isEmpty())
		throw new SpectaclesIdNotFoundException("spectacles id not found:(");
		service.deleteSpectacles(id);
		return new ResponseEntity<String>("spectacles Deleted Successfully", HttpStatus.OK);
	}
	
	@GetMapping("/viewSpectaclesById/{id}")
	public ResponseEntity<Optional<Spectacles>> viewSpectaclesById(@PathVariable("id") Integer id){
		Optional<Spectacles> specs = service.viewSpectacles(id);
		if(specs.isEmpty())
			throw new SpectaclesIdNotFoundException("spectacles id not found:(");
		return new ResponseEntity<Optional<Spectacles>>(specs, HttpStatus.OK);
	}
	
	@GetMapping("/viewSpectaclesList")
	public ResponseEntity<List<Spectacles>> viewAllSpectacles(){
		return new ResponseEntity<List<Spectacles>>(service.viewSpectaclesList(), HttpStatus.OK);
	}
}