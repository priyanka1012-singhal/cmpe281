package smartstreet.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import smartstreet.dao.IClusterDao;
import smartstreet.dao.ISensorDao;
import smartstreet.dao.ISmartNodeDao;
import smartstreet.dao.impl.ClusterDaoImpl;
import smartstreet.dao.impl.SensorDaoImpl;
import smartstreet.dao.impl.SmartNodeDaoImpl;
import smartstreet.dao.impl.UserDaoImpl;
import smartstreet.model.Cluster;
import smartstreet.model.Login;
import smartstreet.model.Sensor;
import smartstreet.model.SmartNode;
import smartstreet.model.User;

@Controller
@RequestMapping("/")
public class AppController {
 
	private final static Logger logger = Logger.getLogger(AppController.class.getName());
	private int editSensorId;
	private int editnodeId;
	private int editClusterId;
	@Autowired
	ISensorDao sensorDao = new SensorDaoImpl();
	@Autowired
	ISmartNodeDao smNodeDao = new SmartNodeDaoImpl();
	@Autowired
	UserDaoImpl uDaoImpl = new UserDaoImpl();
	@Autowired
	IClusterDao clusterDao = new ClusterDaoImpl();
	//main page
    @RequestMapping(value = { "/"}, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        return "signin";
    }
    //dashboard
    @RequestMapping(value = { "/dashboard"}, method = RequestMethod.GET)
    public String mainPage(ModelMap model) {
        return "iotmanagerdashboard";
    }
    @RequestMapping(value = { "/mainpage"}, method = RequestMethod.POST)
    public ModelAndView mainPage(ModelAndView model) {
    	List<Sensor> listSensors = sensorDao.getSensorLongLat();
    	logger.info(listSensors.size());
		model.addObject("listSensors", listSensors);
		model.setViewName("iotmanagerdashboard");
		return model;    	
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
    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("user") User user) throws Exception {
    	uDaoImpl.addUser(user);
        return new ModelAndView("signin");        
    }
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("login") Login login) {
		logger.info(login.getEmail());
		logger.info(login.getUserPwd());
		ModelAndView mav = new ModelAndView();
	    User user = uDaoImpl.validateUsers(login);
	    if (null != user) 
	    {	    	
	    	List<Sensor> listSensors = sensorDao.getSensorLongLat();
	    	logger.info(listSensors.size());
	    	mav.addObject("listSensors", listSensors);
	    	mav.setViewName("iotmanagerdashboard");
	    } 
	    else 
	    {
	    	List<Sensor> listSensors = sensorDao.getSensorLongLat();
	    	logger.info(listSensors.size());
	    	mav.addObject("listSensors", listSensors);
		    mav = new ModelAndView("signin");
		    mav.addObject("message", "Invalid credentials..!!! Try again...");
	    }
	    return mav;
	  }

	@RequestMapping(value = { "/addsensors"}, method = RequestMethod.GET)
    public String addSensor(ModelMap model) {
        return "addsensor";
    }
	@RequestMapping(value = { "/subscribesensor"}, method = RequestMethod.GET)
    public ModelAndView subscribeSensor(ModelAndView model) {
		List<Sensor> listSensors = sensorDao.getAllSensors();
		model.addObject("listSensors", listSensors);
		model.setViewName("subscribesensor");
		return model;
    }
    @RequestMapping(value="/editsensor/{id}",  method = RequestMethod.GET)  
    public ModelAndView edit(@PathVariable int id){  
    	editSensorId = id;
        return new ModelAndView("editsensor","sensor",this.sensorDao.getSensorById(id) );  
    } 
    @RequestMapping(value = "/addsensor", method = RequestMethod.POST)
    public ModelAndView addSensor(@ModelAttribute("sensor") Sensor sensor) throws Exception {
    	ModelAndView mView = new ModelAndView();
    	logger.info(sensor.getId());
		if(sensor.getId() == 0){
			sensorDao.addSensor(sensor);
			mView.setViewName("redirect:/addsensors");
		}
		return mView;
    }
    @RequestMapping(value="/editsave/",method = RequestMethod.POST)  
    public ModelAndView editsave( @ModelAttribute("sensor") Sensor sensor){ 
    	sensor.setId(editSensorId);
    	sensorDao.updateSensor(sensor);  
        return new ModelAndView("redirect:/viewsensor");  
    }  
    @RequestMapping(value = { "/viewsensor"}, method = RequestMethod.GET)
    public ModelAndView viewSensor(ModelAndView model) {
		List<Sensor> listSensors = sensorDao.getAllSensors();
		model.addObject("listSensors", listSensors);
		model.setViewName("viewsensor");

		return model;
    }
	@RequestMapping(value = "/sensordetails/{id}", method = RequestMethod.GET)
    public ModelAndView viewSensorDetails(@PathVariable("id") int id){
		ModelAndView mView = new ModelAndView();
        mView.addObject("sensor",  this.sensorDao.getSensorById(id));
        mView.setViewName("viewsensorinfo");
        return mView;
    }
	@RequestMapping(value = "/subscribe/{id}", method = RequestMethod.GET)
    public ModelAndView subscribeSensor(@PathVariable("id") int id){
		editSensorId = id;
		ModelAndView mView = new ModelAndView();
        mView.addObject("sensor",  this.sensorDao.getSensorById(id));
        mView.setViewName("subscribe");
        return mView;
    }
	@RequestMapping(value = "/activatesensor", method = RequestMethod.POST)
    public ModelAndView activateSensor(@PathVariable("starttime") Date startTime ){
        return new ModelAndView("subscribesensor");  
    }

	@RequestMapping(value = "/deletesensor/{id}", method = RequestMethod.GET)
    public String deleteSensor(@PathVariable("id") int id){
		
        this.sensorDao.deleteSensor(id);
        return "redirect:/viewsensor";
    }
	@RequestMapping(value = "/deletesmartnode/{id}", method = RequestMethod.GET)
    public String deleteSNode(@PathVariable("id") int snodeId){
		
        this.smNodeDao.deleteSmartNode(snodeId);
        return "redirect:/viewsmartnodes";
    }
	//node
	//add node page
	@RequestMapping(value = { "/addsmartnode"}, method = RequestMethod.GET)
    public String addNode(ModelMap model) {
        return "addsmartnode";
    }
	//add node post mapping
    @RequestMapping(value = "/addnode", method = RequestMethod.POST)
    public ModelAndView addNode(@ModelAttribute("node") SmartNode sNode) throws Exception {
    	smNodeDao.addSmartNode(sNode);
        return new ModelAndView("redirect:addsmartnode/");
        
    }
    @RequestMapping(value = { "/viewsmartnodes"}, method = RequestMethod.GET)
    public ModelAndView view(ModelAndView model) {
		List<SmartNode> snodeList = smNodeDao.getAllSmartNodes();
		model.addObject("snodeList", snodeList);
		model.setViewName("viewsmartnodes");
		return model;
    }
	@RequestMapping(value = { "/subscribesmartnode"}, method = RequestMethod.GET)
    public ModelAndView subscribeNodePage(ModelAndView model) {
		List<SmartNode> snodeList = smNodeDao.getAllSmartNodes();
		model.addObject("snodeList", snodeList);
		model.setViewName("subscribesmartnode");
		return model;
    }
    @RequestMapping(value="/editsmartnode/{id}",  method = RequestMethod.GET)  
    public ModelAndView editNodePage(@PathVariable("id") int snodeId){ 
    	editnodeId = snodeId;
    	ModelAndView moView = new ModelAndView();
    	moView.addObject("node",  this.smNodeDao.getSmartNodeById(snodeId));
    	moView.setViewName("editsmartnode");
		return moView;      
    } 
    @RequestMapping(value="/editnode",method = RequestMethod.POST)  
    public ModelAndView editsave( @ModelAttribute("snode") SmartNode smNode){ 
    	smNode.setId(editnodeId);
    	smNodeDao.updateSmartNode(smNode);
        return new ModelAndView("redirect:/viewsmartnodes");  
    } 
    @RequestMapping(value="/addsensortonode",method = RequestMethod.POST)  
    public ModelAndView addsensortonode( @ModelAttribute("snode") SmartNode smNode){ 
    	smNode.setId(editnodeId);
    	smNodeDao.updateSmartNode(smNode);
        return new ModelAndView("redirect:/viewsmartnodes");  
    } 
    @RequestMapping(value="/searchsensor/{id}",  method = RequestMethod.GET)  
    public ModelAndView searchSensor(@PathVariable("id") int snodeId){ 
    	editnodeId = snodeId;
    	ModelAndView moView = new ModelAndView();
    	SmartNode sNode = this.smNodeDao.getSmartNodeById(snodeId);
    	List<Sensor> sensorlist =sensorDao.getSensorLongLat(sNode.getNodeLatitude(), sNode.getNodeLongitude());
    	moView.addObject("sensorlist", sensorlist);
    	moView.addObject("node",  this.smNodeDao.getSmartNodeById(snodeId));
    	moView.setViewName("addsensortonode");
		return moView;      
    }
    @RequestMapping(value="/searchfordel/{id}",  method = RequestMethod.GET)  
    public ModelAndView searchSensorForDel(@PathVariable("id") int snodeId){ 
    	editnodeId = snodeId;
    	ModelAndView moView = new ModelAndView();
    	List<Sensor> sensorlist =sensorDao.getSensorsForNode(snodeId);
    	moView.addObject("sensorlist", sensorlist);
    	moView.addObject("node",  this.smNodeDao.getSmartNodeById(snodeId));
    	moView.setViewName("delsensorfromnode");
		return moView;      
    } 
    @RequestMapping(value="/addtonode",  method = RequestMethod.POST)  
    public ModelAndView addToNode(@RequestParam("selectsensor")String[] checkboxValue){ 
    	
    	sensorDao.updateNodeForSensor(checkboxValue, editnodeId);
		return new ModelAndView("redirect:/subscribesmartnode");
    	
    } 
    @RequestMapping(value="/delfromnode",  method = RequestMethod.POST)  
    public ModelAndView delfromnode(@RequestParam("selectsensor")String[] checkboxValue){ 
    	
    	sensorDao.deleteNodeForSensor(checkboxValue, editnodeId);
		return new ModelAndView("redirect:/subscribesmartnode");
    	
    }   
    @RequestMapping(value="/viewsensors/{id}",  method = RequestMethod.GET)  
    public ModelAndView viewSensors(@PathVariable("id") int snodeId){ 
    	editnodeId = snodeId;			
    	ModelAndView moView = new ModelAndView();
    	List<Sensor> sensorlist =sensorDao.getSensorsForNode(snodeId);
    	moView.addObject("sensorlist", sensorlist);
    	moView.addObject("node",  this.smNodeDao.getSmartNodeById(snodeId));
    	List<SmartNode> snodeList = smNodeDao.getAllSmartNodes();	
    	moView.addObject("snodeList", snodeList);
    	moView.setViewName("nodeswithsensor");
		return moView;      
    } 
	@RequestMapping(value = { "/addcluster"}, method = RequestMethod.GET)
    public String addCluster(ModelMap model) {
        return "addcluster";
    }
	
	//add node post mapping
    @RequestMapping(value = "/savecluster", method = RequestMethod.POST)
    public ModelAndView addCluster(@ModelAttribute("cluster") Cluster cluster) throws Exception {
    	clusterDao.addCluster(cluster);
        return new ModelAndView("redirect:addcluster/");     
    }
    @RequestMapping(value = { "/viewcluster"}, method = RequestMethod.GET)
    public ModelAndView viewcluster(ModelAndView model) {
		List<Cluster> clusterList = clusterDao.getAllClusters();
		model.addObject("clusterList", clusterList);
		model.setViewName("viewcluster");
		return model;
    }
	@RequestMapping(value = { "/subscribecluster"}, method = RequestMethod.GET)
    public ModelAndView subscribeCluster(ModelAndView model) {
		List<Cluster> clusterList = clusterDao.getAllClusters();	
		model.addObject("clusterList", clusterList);
		model.setViewName("subscribecluster");
		return model;
    }
    @RequestMapping(value="/searchnodes/{id}",  method = RequestMethod.GET)  
    public ModelAndView searchNodes(@PathVariable("id") int clusterId){ 
    	editClusterId = clusterId;
    	ModelAndView moView = new ModelAndView();
    	List<SmartNode> snodeList = smNodeDao.getAllSmartNodes();
    	moView.addObject("snodeList", snodeList);
    	moView.addObject("cluster",  this.clusterDao.getClusterById(clusterId));
    	moView.setViewName("addnodetocluster");
		return moView;      
    }	
    @RequestMapping(value="/addtocluster",  method = RequestMethod.POST)  
    public ModelAndView addToCluster(@RequestParam("selectnode")String[] checkboxValue){     	
    	sensorDao.updateNodeForSensor(checkboxValue, editnodeId);
		return new ModelAndView("redirect:/subscribecluster");
    	
    } 
    @RequestMapping(value="/editcluster/{id}",  method = RequestMethod.GET)  
    public ModelAndView editClusterPage(@PathVariable("id") int clusterId){ 
    	editClusterId = clusterId;
    	ModelAndView moView = new ModelAndView();
    	moView.addObject("cluster",  this.clusterDao.getClusterById(clusterId));
    	moView.setViewName("editcluster");
		return moView;      
    } 
    
    @RequestMapping(value="/updatecluster",method = RequestMethod.POST)  
    public ModelAndView updateCluster( @ModelAttribute("cluster") Cluster cluster){ 
    	cluster.setId(editClusterId);
    	clusterDao.updateCluster(cluster);
        return new ModelAndView("redirect:/viewcluster");  
    } 
	@RequestMapping(value = "/deletecluster/{id}", method = RequestMethod.GET)
    public String deleteCluster(@PathVariable("id") int clusterId){	
        this.clusterDao.deleteCluster(clusterId);
        return "redirect:/viewcluster";
    }    
}