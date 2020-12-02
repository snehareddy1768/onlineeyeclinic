package com.cg.onlineeyeclinic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.onlineeyeclinic.model.Spectacles;
@Repository
public interface ISpectaclesRepository extends JpaRepository<Spectacles, Integer>{

	@Query("select specs from Spectacles specs")
	List<Spectacles> viewSpectaclesList();
	
	
}