package com.pwr.tombKeeper.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pwr.tombKeeper.model.Human;
import com.pwr.tombKeeper.repository.HumanRepo;
import com.pwr.tombKeeper.service.HumanService;
import com.pwr.tombKeeper.utils.MD5Generator;

@Service
public class HumanServiceImpl implements HumanService {

	@Autowired
	private HumanRepo humanRepo;

	@Autowired
	private MD5Generator md5Generator;

	@Override
	public List<Human> getAll() {
		return (List<Human>) humanRepo.findAll();
	}

	@Override
	public Human saveHuman(Human human) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String encodedPass = md5Generator.encode(human.getPassword());

		human.setPassword(encodedPass);

		return humanRepo.save(human);
	}

	@SuppressWarnings("unused")
	@Override
	public Human checkAuth(String login, String password)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String encodedPass = md5Generator.encode(password);

		return humanRepo.findByLoginAndPassword(login, encodedPass);
	}

	@Override
	public Human findByLogin(String login) {
		return humanRepo.findByLogin(login);
	}

	@Override
	public List<String> findLogins() {
		List<Human> humans = (List<Human>) humanRepo.findAll();
		return humans.stream().map(h -> h.getLogin()).collect(Collectors.toList());
	}

}
