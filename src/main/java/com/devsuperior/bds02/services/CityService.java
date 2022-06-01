package com.devsuperior.bds02.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.repositories.CityRepository;

@Service
public class CityService {
	
	private final CityRepository cityRepository;	
	
	@Autowired
	public CityService(CityRepository cityRepository) {
		super();
		this.cityRepository = cityRepository;
	}


//	public List<CityDTO> findAllOrderByName() {
//		return cityRepository.findAll().sort();
//	}
	
	public CityDTO insert(CityDTO dto) {
		City city = new City();
		city.setName(dto.getName());
		
		city = cityRepository.save(city);
		
		return new CityDTO(city);
	}

}
