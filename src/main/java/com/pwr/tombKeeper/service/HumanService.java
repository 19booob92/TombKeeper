package com.pwr.tombKeeper.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.pwr.tombKeeper.model.Human;

public interface HumanService {

	List<Human> getAll();

	Human checkAuth(String login, String password) throws NoSuchAlgorithmException, UnsupportedEncodingException;

	Human saveHuman(Human human) throws NoSuchAlgorithmException, UnsupportedEncodingException;

	Human findByLogin(String login);

	List<String> findLogins();
}
