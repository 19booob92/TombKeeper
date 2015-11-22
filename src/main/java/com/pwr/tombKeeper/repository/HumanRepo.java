package com.pwr.tombKeeper.repository;

import org.springframework.data.repository.CrudRepository;

import com.pwr.tombKeeper.model.Human;

public interface HumanRepo extends CrudRepository<Human, Long>{

	Human findByLoginAndPassword(String login, String password);

	Human findByLogin(String login);
}
