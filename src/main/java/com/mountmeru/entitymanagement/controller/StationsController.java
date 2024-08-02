package com.mountmeru.entitymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mountmeru.entitymanagement.dto.StationsDTO;
import com.mountmeru.entitymanagement.service.StationsService;

@RestController
@RequestMapping("/api/stations")
public class StationsController {


	@Autowired
	private StationsService stationsService;

	public StationsController(StationsService stationsService)
	{
		this.stationsService = stationsService;
	}

	// Add New stations REST API.
	@PostMapping(value = "/createstation", produces ="application/json")
	public ResponseEntity<StationsDTO> addNewStation(@RequestBody StationsDTO stationsDTO, @RequestHeader long loginUserId)
	{
		return new ResponseEntity<>(stationsService.createStation(stationsDTO, loginUserId), HttpStatus.CREATED);
	}

	// Get the Station by ID
	@GetMapping( value = "/getstationbyid", produces ="application/json")
	public ResponseEntity<StationsDTO> getStationByStationCode(@RequestHeader String stationCode)
	{
		StationsDTO stationsDTO = stationsService.getStationsById(stationCode);
		return  ResponseEntity.ok(stationsDTO);
	}

	// Get the Station by ID
	@GetMapping(value ="/getallstations", produces ="application/json")
	public ResponseEntity<List<StationsDTO>> getAllstations()
	{
		List<StationsDTO> liststationsDTO = stationsService.getAllStations();
		return new ResponseEntity<>(liststationsDTO, HttpStatus.OK);
	}
	// Update Existing  stations REST API.
	@PutMapping(value = "/updateStation", produces ="application/json")
	public ResponseEntity<StationsDTO> updateStation(@RequestBody StationsDTO stationsDTO, @RequestHeader long loginUserId)
	{	
		try {
			return new ResponseEntity<>(stationsService.updateStation(stationsDTO, loginUserId), HttpStatus.CREATED);
		}
		catch( Exception e)
		{
			return new ResponseEntity<>(stationsDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	@PutMapping(value = "/deleteStation", produces ="application/json")
	public ResponseEntity<String> deleteStation(@RequestBody StationsDTO stationsDTO) {
		String StationId = stationsDTO.getStationcode();
		if("Success".equals(stationsService.deleteStation(StationId)))
			return  ResponseEntity.status(HttpStatus.OK).body("Station record deleted successfully");
		else
			return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Station record deleted un-successfully");
	}
}
