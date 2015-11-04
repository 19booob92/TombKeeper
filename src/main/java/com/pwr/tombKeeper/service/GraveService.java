package com.pwr.tombKeeper.service;

import java.util.List;

import com.pwr.tombKeeper.model.Grave;

public interface GraveService {

	List<Grave> findGravesByLastname(String lastname);

	List<Grave> findAll();

	Grave save(Grave grave);
}
