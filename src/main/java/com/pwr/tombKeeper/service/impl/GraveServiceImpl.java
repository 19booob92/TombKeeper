package com.pwr.tombKeeper.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pwr.tombKeeper.model.Grave;
import com.pwr.tombKeeper.model.Human;
import com.pwr.tombKeeper.repository.GraveRepo;
import com.pwr.tombKeeper.service.GraveService;
import com.pwr.tombKeeper.service.HumanService;

@Service
public class GraveServiceImpl implements GraveService {

	@Autowired
	private GraveRepo graveRepo;

	@Autowired
	private HumanService humanService;
	
	
	@Override
	public List<Grave> findAll() {
		return (List<Grave>) graveRepo.findAll();
	}

	@Override
	public Grave save(Grave grave) {
		String lastnamePK = grave.getLastname();
		String firstnamePK = grave.getFirstname();
		List<Human> updatedOwnersList = grave.getOwners();
		
		Grave existsGrave = graveRepo.findByLastnameAndFirstname(lastnamePK, firstnamePK);
		
		if (existsGrave == null) {
			return graveRepo.save(grave);
		} else {
			existsGrave.setOwnres(updatedOwnersList);
			return graveRepo.save(existsGrave);
		}
		
	}

	@Override
	public List<Grave> findByLogin(String login) {
		return graveRepo.findByOwnersLogin(login);
	}

	@Override
	public Grave findById(String id) {
		return graveRepo.findById(id);
	}

	@Override
	public Grave findByLocation(String x, String y) {
		return graveRepo.findByLattitudeAndLongtitude(x, y);
	}

	@Override
	public void delete(Grave grave) {
		graveRepo.delete(grave);
	}

}
