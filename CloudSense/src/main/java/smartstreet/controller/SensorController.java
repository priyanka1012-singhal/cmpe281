package smartstreet.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import smartstreet.model.Sensor;
import smartstreet.service.ISensorService;

/**
 * Sensor Controller
 * @author priyankasinghal
 *
 */
@RestController
@RequestMapping(value="/sensor")
public class SensorController {
	
	@Autowired
	ISensorService sensorService;
	
	private final static Logger logger = Logger.getLogger(SensorController.class.getName());
	
	@GetMapping("/{id}")
	public ResponseEntity<Sensor> getSensorById(@PathVariable("id") String id) {
		Sensor Sensor = sensorService.getSensorById(id);
		return new ResponseEntity<Sensor>(Sensor, HttpStatus.OK);
	}
	@GetMapping()
	public ResponseEntity<List<Sensor>> getAllSensors() {
		logger.info("Enter getAllSensors");
		List<Sensor> list = sensorService.getAllSensors();
		logger.info("Exit getAllSensors");
		return new ResponseEntity<List<Sensor>>(list, HttpStatus.OK);
	}
	@PostMapping()
	public ResponseEntity<Void> addSensor(@RequestBody Sensor Sensor, UriComponentsBuilder builder) {
            boolean flag = sensorService.addSensor(Sensor);
            if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
            }
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(builder.path("/sensor/{id}").buildAndExpand(Sensor.getId()).toUri());
            return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping()
	public ResponseEntity<Sensor> updateSensor(@RequestBody Sensor Sensor) {
		sensorService.updateSensor(Sensor);
		return new ResponseEntity<Sensor>(Sensor, HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteSensor(@PathVariable("id") String id) {
		sensorService.deleteSensor(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
