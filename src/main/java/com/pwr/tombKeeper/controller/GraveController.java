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

import com.pwr.tombKeeper.dto.GraveDTO;
import com.pwr.tombKeeper.model.Grave;
import com.pwr.tombKeeper.model.Human;
import com.pwr.tombKeeper.service.GraveService;

@Controller
public class GraveController {

	@Autowired
	private GraveService graveService;

	@ResponseBody
	@RequestMapping(value = "/grave/{login}", method = RequestMethod.GET)
	public ResponseEntity<?> getGravesForUser(@PathVariable String login) {
		List<Grave> graves = graveService.findByLogin(login);
		if (graves != null && !graves.isEmpty()) {
			return new ResponseEntity<>(graves, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Nie znaleziono grobu", HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/grave/delete/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> deleteGrave(@PathVariable String id) {
		Grave grave = graveService.findById(id);
		if (grave != null)
			graveService.delete(grave);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = "/grave", method = RequestMethod.POST)
	public ResponseEntity<?> saveGrave(@RequestBody GraveDTO graveDTO) {
		String lattitude = graveDTO.getLattitude();
		String longtitude = graveDTO.getLongtitude();
		Grave graves = null;
		Grave graveFromDB = graveService.findByLocation(lattitude, longtitude);
		if (graveFromDB == null) {
			graves = new Grave();
			graves.setFirstname(graveDTO.getFirstname());
			graves.setLastname(graveDTO.getLastname());
			graves.setLongtitude(graveDTO.getLongtitude());
			graves.setLattitude(graveDTO.getLattitude());

			Human human = new Human();
			graves.setOwners(graveDTO.getOwners());
			graves = graveService.save(graves);
		} else {
			graves = new Grave();
			graves.setFirstname(graveDTO.getFirstname());
			graves.setLastname(graveDTO.getLastname());
			graves.setLongtitude(graveDTO.getLongtitude());
			graves.setLattitude(graveDTO.getLattitude());
			graves.setOwners(graveDTO.getOwners());
			graves.setId(graveDTO.getId());
			graveService.save(graves);
		}

		if (graves != null) {
			return new ResponseEntity<>(graves, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Nie zapisano grobu", HttpStatus.NOT_ACCEPTABLE);
		}
	}

}
