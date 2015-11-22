package com.pwr.tombKeeper.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pwr.tombKeeper.model.Human;
import com.pwr.tombKeeper.service.HumanService;

@Controller
public class HumanController {

	@Autowired
	private HumanService humanService;

	@RequestMapping(value = "/human", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody Human human) {
		Human returnedHuman = null;
		try {
			if (humanService.findByLogin(human.getLogin()) == null) {
				returnedHuman = humanService.saveHuman(human);
			} else {
				return new ResponseEntity<>("Nie zapisano", HttpStatus.CONFLICT);
			}
			if (returnedHuman != null) {
				return new ResponseEntity<>(returnedHuman, HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Nie zapisano", HttpStatus.BAD_REQUEST);
			}
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
			return new ResponseEntity<>("Nie zapisano", HttpStatus.EXPECTATION_FAILED);
		}

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody Map<String, String> payload) {
		Human returnedHuman;
		try {
			returnedHuman = humanService.checkAuth(payload.get("login"), payload.get("password"));
			if (returnedHuman != null) {
				return new ResponseEntity<>(returnedHuman, HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Nie zapisano", HttpStatus.UNAUTHORIZED);
			}
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
			return new ResponseEntity<>("Nie zapisano", HttpStatus.EXPECTATION_FAILED);
		}
	}

	@RequestMapping(value = "/human", method = RequestMethod.GET)
	public ResponseEntity<?> getLoginsList() {
		List<String> returnedLogins;

		returnedLogins = humanService.findLogins();
		if (returnedLogins != null && !returnedLogins.isEmpty()) {
			return new ResponseEntity<>(returnedLogins, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Nie znaleziono", HttpStatus.NOT_FOUND);
		}
	}
	

	@RequestMapping(value = "/human/{login}", method = RequestMethod.GET)
	public ResponseEntity<?> getUser(@PathVariable String login) {
		Human returnedUser;

		returnedUser = humanService.findByLogin(login);
		if (returnedUser != null) {
			return new ResponseEntity<>(returnedUser, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Nie znaleziono", HttpStatus.NOT_FOUND);
		}
	}
		

}
