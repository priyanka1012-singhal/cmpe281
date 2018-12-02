package smartstreet.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import smartstreet.dao.ISensorDao;
import smartstreet.dao.ISmartNodeDao;
import smartstreet.dao.impl.SensorDaoImpl;
import smartstreet.dao.impl.SmartNodeDaoImpl;
import smartstreet.dao.impl.UserDaoImpl;
import smartstreet.dto.ResponseDto;
import smartstreet.model.Cluster;
import smartstreet.model.Login;
import smartstreet.model.Sensor;
import smartstreet.model.SmartNode;
import smartstreet.model.User;
import smartstreet.service.IClusterService;
import smartstreet.service.ISensorService;
import smartstreet.service.ISmartNodeService;
 
 
 
@Controller
public class AppController {
	private int editSensorId;
	private int editnodeId;
	private int editClusterId;	
	@Autowired
	ISensorService sensorService;
	@Autowired
	ISmartNodeService smartNodeService;
	@Autowired
	IClusterService clusterService;
	@Autowired
	UserDaoImpl uDaoImpl = new UserDaoImpl();	
	@Autowired
	ISensorDao sensorDao = new SensorDaoImpl();
	@Autowired
	ISmartNodeDao smNodeDao = new SmartNodeDaoImpl();
	@Autowired	
	private final static Logger logger = Logger.getLogger(AppController.class.getName());
	
	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        return "signin";
    }
	
    @RequestMapping(value = { "/dashboard"}, method = RequestMethod.GET)
    public String sensorstationmainPage(ModelMap model) {
        return "sensorstationdashboard";
    }
	
    @RequestMapping(value = { "/iotdashboard"}, method = RequestMethod.GET)
    public String iotmanagermainPage(ModelMap model) {
        return "iotmanagerdashboard";
    }
    
  //sign in page
    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String signinpage() {
      return "signin";
    }
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
      return "register";
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

    //to register user
    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("user") User user) throws Exception {
    	uDaoImpl.addUser(user);
        return new ModelAndView("signin");        
    }
    
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
	@ModelAttribute("login") Login login) 
	{
		logger.info(login.getEmail());
		logger.info(login.getUserPwd());
		ModelAndView mav = new ModelAndView();
		User user = uDaoImpl.validateUsers(login);
		if (null != user) 
		{	    	
			mav.setViewName("sensorstationdashboard");
		} 
		else 
		{
			mav = new ModelAndView("signin");
			mav.addObject("message", "Invalid credentials..!!! Try again...");
		}
	    return mav;
	}

    
}