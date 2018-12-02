package smartstreet.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
	public ResponseEntity<Sensor> getSensorById(@PathVariable("id") String id, Model model) {
		return null;
		//Sensor Sensor = sensorService.getSensorById(id);
		//return new ResponseEntity<Sensor>(Sensor, HttpStatus.OK);
	}
	@GetMapping()
	public String getAllSensors(Model model) {
		logger.info("Enter 	");
		model.addAttribute("sensorList",sensorService.getAllSensors());
		logger.info("Exit getAllSensors");
		return "viewsensor";
	}
    
	@PutMapping("/update")
	public String updateSensor(@RequestBody Sensor Sensor) {
		sensorService.updateSensor(Sensor);
		return "redirect:/viewsensor";
	}
	@DeleteMapping("/{id}")
	public String deleteSensor(@PathVariable("id") int id) {
		sensorService.deleteSensor(id);
		return  "redirect:/viewsensor";
	}
	
}
