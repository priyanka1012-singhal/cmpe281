package smartstreet.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import smartstreet.model.SensorData;
import smartstreet.service.ISensorReadingDataService;

@RestController
@RequestMapping(value="/sensordata")
public class SensorDataController {
	
	private final static Logger logger = Logger.getLogger(SensorDataController.class.getName());
	
	@Autowired
	ISensorReadingDataService sensorDataService;
	
	@GetMapping(value="/view")
	public ModelAndView  getAllSensorData(Model model) {
		logger.info("Enter getAllSensorData");
		List<SensorData> list = sensorDataService.getReadingData();
		
		logger.info("Exit getAllSensorData"+list);
		return new ModelAndView("viewsensordata","sensorDataList",list );
	}

}
