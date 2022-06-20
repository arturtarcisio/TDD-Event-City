package com.devsuperior.bds02.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.repositories.EventRepository;

@Service
public class EventService {
	
	private final EventRepository repository;

	@Autowired
	public EventService(EventRepository repository) {
		this.repository = repository;
	}
	
	@Transactional
	public EventDTO update (Long id, EventDTO dto) {
		var event = repository.findById(id).orElseThrow();	
		
		event.setName(dto.getName());
		event.setDate(dto.getDate());
		event.setUrl(dto.getUrl());
		event.setCity(new City(dto.getCityId(), null));
		
		event = repository.save(event);
		
		return new EventDTO(event);
	}

}
