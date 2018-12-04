package smartstreet.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping()
public class SensorController {
	
	@Autowired
	ISensorService sensorService;
	
	private final static Logger logger = Logger.getLogger(SensorController.class.getName());
	
	@GetMapping("/sensor/{id}")
	public ModelAndView getSensorById(@PathVariable("id") int id) {
		Sensor sensor= sensorService.getSensorById(id);
		return new ModelAndView("viewsensorinfo", "sensor",sensor);
	}
	@GetMapping("/viewsensor")
	public ModelAndView getAllSensors() {
		logger.info("Enter getAllSensors");
		List<Sensor> sensorList = sensorService.getAllSensors();
		logger.info("Exit getAllSensors:::"+sensorList.size());
		return new ModelAndView("viewsensor","sensorList",sensorList);
	}
	@PostMapping("/sensor/add")
	public ModelAndView addSensor(@ModelAttribute("sensor") Sensor sensor, BindingResult result)  {
		logger.info("Enter addSensor");
            sensorService.addSensor(sensor);
            List<Sensor> sensorList = sensorService.getAllSensors();
        logger.info("Exit addSensor");
            return new ModelAndView("viewsensor","sensorList",sensorList);
	}
	@PostMapping("/sensor/update")
	public ModelAndView updateSensor(@ModelAttribute("sensor") Sensor sensor, BindingResult result) {
		sensorService.updateSensor(sensor);
		List<Sensor> sensorList = sensorService.getAllSensors();
		return new ModelAndView("viewsensor","sensorList",sensorList);
	}
	
	/*@GetMapping("/editsensor/{id}")
	public ModelAndView edit(@PathVariable("id") String id) {
		Sensor sensor= sensorService.getSensorById(id);
		return new ModelAndView("updatesensor", "sensor",sensor);
	}*/
	
	@GetMapping("/sensor/{id}/delete")
	public ModelAndView deleteSensor(@PathVariable("id") int id) {
		logger.info("Enter deleteSensor");
		sensorService.deleteSensor(id);
		List<Sensor> sensorList = sensorService.getAllSensors();
		logger.info("Exit deleteSensor");
		return new ModelAndView("viewsensor","sensorList",sensorList);
	}
	
}
