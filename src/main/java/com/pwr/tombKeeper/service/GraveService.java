package com.pwr.tombKeeper.service;

import java.util.List;

import com.pwr.tombKeeper.model.Grave;

public interface GraveService {

	List<Grave> findAll();

	Grave save(Grave grave);

	List<Grave> findByLogin(String login);
	
	Grave findById(String id);

	Grave findByLocation(String x, String y);
	
	void delete(Grave grave);
}
