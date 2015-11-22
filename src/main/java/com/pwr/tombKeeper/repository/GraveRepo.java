package com.pwr.tombKeeper.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pwr.tombKeeper.model.Grave;

public interface GraveRepo extends CrudRepository<Grave, Long> {

	List<Grave> findByLastname(String lastname);

	List<Grave> findByOwnersLogin(String login);

	Grave findByLastnameAndFirstname(String lastnamePK, String firstnamePK);

}
