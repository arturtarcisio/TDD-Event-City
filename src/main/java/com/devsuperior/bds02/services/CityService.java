package com.devsuperior.bds02.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.repositories.CityRepository;

@Service
public class CityService {
	
	private final CityRepository cityRepository;	
	
	@Autowired
	public CityService(CityRepository cityRepository) {
		super();
		this.cityRepository = cityRepository;
	}


	public Page<CityDTO> findAllPaged(Pageable pageable) {
		return cityRepository.findAll(pageable).map(CityDTO::new);
	}

}
