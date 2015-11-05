package com.pwr.tombKeeper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pwr.tombKeeper.model.Grave;
import com.pwr.tombKeeper.service.GraveService;

@Controller
public class GraveController {

	@Autowired
	private GraveService graveService;
	
	@ResponseBody
	@RequestMapping(value = "/grave/{lastname}", method = RequestMethod.GET)
	public ResponseEntity<?> getGraves(@PathVariable String lastname) {
		List<Grave> graves = graveService.findGravesByLastname(lastname);
		if (graves != null && !graves.isEmpty()) {
			return new ResponseEntity<>(graves, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Nie znaleziono grobu", HttpStatus.NOT_FOUND);
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/grave", method = RequestMethod.GET)
	public ResponseEntity<?> getAllGraves() {
		List<Grave> graves = graveService.findAll();
		if (graves != null && !graves.isEmpty()) {
			return new ResponseEntity<>(graves, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Nie znaleziono grobu", HttpStatus.NOT_FOUND);
		}
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/grave", method = RequestMethod.POST)
	public ResponseEntity<?> saveGrave(@RequestBody Grave grave) {
		Grave graves = graveService.save(grave);
		if (graves != null) {
			return new ResponseEntity<>(graves, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Nie zapisano grobu", HttpStatus.NOT_ACCEPTABLE);
		}
	}

}
