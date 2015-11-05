package com.pwr.tombKeeper.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pwr.tombKeeper.model.Grave;
import com.pwr.tombKeeper.repository.GraveRepo;
import com.pwr.tombKeeper.service.GraveService;

@Service
public class GraveServiceImpl implements GraveService {

	@Autowired
	private GraveRepo graveRepo;

	@Override
	public List<Grave> findGravesByLastname(String lastname) {
		return graveRepo.findByLastname(lastname);
	}

	@Override
	public List<Grave> findAll() {
		return (List<Grave>) graveRepo.findAll();
	}

	@Override
	public Grave save(Grave grave) {
		return graveRepo.save(grave);
	}

}
