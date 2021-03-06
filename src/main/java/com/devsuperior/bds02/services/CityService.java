package com.devsuperior.bds02.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Transactional(readOnly = true)
	public List<CityDTO> findAll() {
		return cityRepository.findAll(Sort.by("name"))
				.stream()
				.map(CityDTO::new)
				.collect(Collectors.toList());		
	}
	
	@Transactional
	public CityDTO insert(CityDTO dto) {
		City city = new City();
		city.setName(dto.getName());
		
		city = cityRepository.save(city);
		
		return new CityDTO(city);
	}
	
	@Transactional
	public void deleteById(Long id) {
		
			cityRepository.deleteById(id);    
	}

}
