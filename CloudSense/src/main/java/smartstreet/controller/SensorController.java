package smartstreet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import smartstreet.service.ISensorService;

@RestController
@RequestMapping(value="/sensors")
public class SensorController {
	
	@Autowired
	ISensorService sensorService;
	
	/* Constructor Injection */
	public SensorController(ISensorService sensorService) {
		super();
		this.sensorService = sensorService;
	}

}
