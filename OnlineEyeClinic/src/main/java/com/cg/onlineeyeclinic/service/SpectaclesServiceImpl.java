package com.cg.onlineeyeclinic.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineeyeclinic.exception.SpectaclesIdNotFoundException;
import com.cg.onlineeyeclinic.model.Spectacles;
import com.cg.onlineeyeclinic.repository.ISpectaclesRepository;

@Service("name= SpectaclesService")

@Transactional
public class SpectaclesServiceImpl implements ISpectaclesService {

	@Autowired
	ISpectaclesRepository repository;
	
	@Override
	public Spectacles addSpectacles(Spectacles spectacles) {
		
		spectacles=repository.save(spectacles);
		return spectacles;
	}

	@Override
	public Spectacles updateSpectacles(Spectacles spectacles) {
		spectacles=repository.save(spectacles);
		return spectacles;
	}
	
	@Override
	public Spectacles deleteSpectacles(Integer id) throws SpectaclesIdNotFoundException{
		Optional<Spectacles> specs= repository.findById(id);
			if(specs==null)
				throw new SpectaclesIdNotFoundException("spectacles id not found");
			else {
			repository.deleteById(id);}
		return null;
	}

	@Override
	public Optional<Spectacles> viewSpectacles(Integer id) throws SpectaclesIdNotFoundException{
		Optional<Spectacles> specs = repository.findById(id);
		if(specs==null)
			throw new SpectaclesIdNotFoundException("spectacles id not found");
		return specs;

	}

	@Override
	public List<Spectacles> viewSpectaclesList() {
		List<Spectacles> allSpectacles= repository.findAll();
		return allSpectacles;
	}

	
}