package com.kanexon.ngo.controller;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kanexon.ngo.model.NgoBaseModel;
import com.kanexon.ngo.service.NgoService;

@Controller
@RestController
public class NgoController {

	private final static Logger LOGGER = LoggerFactory.getLogger(NgoController.class);

	@Autowired
	NgoService ngoService;

	@PostMapping("/saveNgoDetails")
	public ResponseEntity<String> saveNgoDetails(@RequestBody NgoBaseModel ngoData) {
		LOGGER.info("saveNgoDetails entry");
		try {
			ngoService.saveNgoDetails(ngoData);
			LOGGER.info("saveNgoDetails success");
			return new ResponseEntity<String>("Succcess", HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("saveNgoDetails fail at NgoController", e);
			return new ResponseEntity<String>("Failure", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getNgoDetails")
	public ResponseEntity<NgoBaseModel> getNgoDetails(@PathParam("ngoUniqueId") String ngoUniqueId) {
		LOGGER.info("getNgoDetails entry");
		NgoBaseModel ngo = null;
		try {
			ngo = ngoService.getNgoDetails(ngoUniqueId);
			LOGGER.info("getNgoDetails success");
			return new ResponseEntity<NgoBaseModel>(ngo, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("getNgoDetails fail at NgoController", e);
			return new ResponseEntity<NgoBaseModel>(ngo, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/updateNgoDetails")
	public ResponseEntity<String> updateNgoDetails(@RequestBody NgoBaseModel ngoData) {
		LOGGER.info("updateNgoDetails entry");
		try {
			ngoService.updateNgoDetails(ngoData);
			LOGGER.info("updateNgoDetails success");
			return new ResponseEntity<String>("Succcess", HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("updateNgoDetails fail at NgoController", e);
			return new ResponseEntity<String>("Failure", HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/deleteNgoDetails")
	public ResponseEntity<String> deleteNgoDetails(@PathParam("ngoUniqueId") String ngoUniqueId) {
		LOGGER.info("deleteNgoDetails entry");
		try {
			ngoService.deleteNgoDetails(ngoUniqueId);
			LOGGER.info("deleteNgoDetails success");
			return new ResponseEntity<String>("Succcess", HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("deleteNgoDetails fail at NgoController", e);
			return new ResponseEntity<String>("Failure", HttpStatus.BAD_REQUEST);
		}
	}

}
