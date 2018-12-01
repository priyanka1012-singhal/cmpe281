package smartstreet.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import smartstreet.dto.ResponseDto;
import smartstreet.model.Cluster;
import smartstreet.model.Sensor;
import smartstreet.model.SmartNode;
import smartstreet.service.IClusterService;
import smartstreet.service.ISensorService;
import smartstreet.service.ISmartNodeService;
 
 
 
@Controller
@RequestMapping("/")
public class AppController {
	@Autowired
	ISensorService sensorService;
	@Autowired
	ISmartNodeService smartNodeService;
	@Autowired
	IClusterService clusterService;
	
	private final static Logger logger = Logger.getLogger(AppController.class.getName());
	
    @RequestMapping(value = { "/"}, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        return "iotmanagerdashboard";
    }
    
    @RequestMapping(value = { "/getMapNodes"}, method = RequestMethod.GET)
    public ResponseEntity<ResponseDto> getMapNodes(ModelMap model) {
    	logger.info("Enter getMapNodes");
    	ResponseDto response = new ResponseDto();
    	List<Sensor> sensorList = sensorService.getAllSensors();
    	List<SmartNode> nodeList = smartNodeService.getAllSmartNodes();
    	List<Cluster> clusterList = clusterService.getAllClusters();
    	
    	response.setSensors(sensorList);
    	response.setSmartnodes(nodeList);
    	response.setClusters(clusterList);
    	logger.info("Exit getMapNodes");
        return new ResponseEntity<ResponseDto> (response,HttpStatus.OK);
    }
   
    @RequestMapping(value = { "/addsensor"}, method = RequestMethod.GET)
    public String addSensor(ModelMap model) {
    	model.addAttribute("sensor",new Sensor());
        return "addsensor";
    }
    
    @RequestMapping(value = { "/addsmartnode"}, method = RequestMethod.GET)
    public String addSmartNode(ModelMap model) {
    	model.addAttribute("node",new SmartNode());
        return "addsmartnode";
    }
    
    @RequestMapping(value = { "/addcluster"}, method = RequestMethod.GET)
    public String addCluster(ModelMap model) {
    	model.addAttribute("cluster",new Cluster());
        return "addcluster";
    }
    
    
    @RequestMapping(value = { "/viewenergyusage"}, method = RequestMethod.GET)
    public String viewEnergyUsageReports(ModelMap model) {
        return "viewenergyusagereports";
    }
    
    @RequestMapping(value = { "/generatenergyusagereports"}, method = RequestMethod.GET)
    public String generatenergyusagereports() {
        return "generatenergyusagereports";
    }


    
}