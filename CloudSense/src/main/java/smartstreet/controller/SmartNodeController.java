package smartstreet.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import smartstreet.model.Sensor;
import smartstreet.model.SmartNode;
import smartstreet.service.ISmartNodeService;

@RestController
@RequestMapping()
public class SmartNodeController {
	
	@Autowired
	ISmartNodeService smartNodeService;
	
private final static Logger logger = Logger.getLogger(SmartNodeController.class.getName());
	
	@GetMapping("/node/{id}")
	public ModelAndView getSmartNodeById(@PathVariable("id") int id) {
		SmartNode node= smartNodeService.getSmartNodeById(id);
		return new ModelAndView("viewsmartnodeinfo", "node",node);
	}
	
	@GetMapping("/viewsmartnode/node/{id}")
	public ResponseEntity<SmartNode> getNodeById(@PathVariable("id") int id, Model model) {
		SmartNode node= smartNodeService.getSmartNodeById(id);
		return new ResponseEntity<SmartNode> (node,HttpStatus.OK);
	}
	
	@GetMapping("/viewsmartnode")
	public ModelAndView getAllSmartNodes() {
		logger.info("Enter getAllSmartNodes");
		List<SmartNode> nodeList = smartNodeService.getAllSmartNodes();
		logger.info("Exit getAllSmartNodes:::"+nodeList.size());
		return new ModelAndView("viewsmartnode","nodeList",nodeList);
	}
	
	@GetMapping("/viewsmartnode/node/{id}/getunmappedsensors")
	public ResponseEntity<SmartNode> getunmappedsensors(@PathVariable("id") int id) {
		logger.info("Enter getunmappedsensors");
		SmartNode node = smartNodeService.getSmartNodeById(id);
		List<Sensor> sensorList = smartNodeService.getUnMappedSensorNames(id);
		node.setId(id);
		node.setSensors(sensorList);
		logger.info("Exit getunmappedsensors:::"+sensorList.size());
		return new ResponseEntity<SmartNode> (node,HttpStatus.OK);
	}
	
	@GetMapping("/viewsmartnode/node/{id}/getmappedsensors")
	public ModelAndView getmappedsensorsview(@PathVariable("id") int id) {
		logger.info("Enter getmappedsensorsview");
		List<Sensor> sensorList = smartNodeService.getMappedSensors(id);
		//node.setSensors(sensorList);
		logger.info("Exit getmappedsensorsview:::"+sensorList.size());
		return new ModelAndView ("viewsensor","sensorList",sensorList);
	}
	
	@GetMapping("/node/{id}/getmappedsensors")
	public ResponseEntity<List<Sensor>> getmappedsensors(@PathVariable("id") int id) {
		logger.info("Enter getmappedsensors");
		List<Sensor> sensorList = smartNodeService.getMappedSensors(id);
		//node.setSensors(sensorList);
		logger.info("Exit getmappedsensors:::"+sensorList.size());
		return new ResponseEntity<List<Sensor>> (sensorList,HttpStatus.OK);
	}
	
	@PostMapping("/node/addsensors")
	public ModelAndView addSmartNodeSensors(@RequestBody SmartNode node)  {
		logger.info("Enter addSmartNodeSensors");
            smartNodeService.addSmartNodeSensorMapping(node.getId(), node.getSensorList());
            List<SmartNode> nodeList = smartNodeService.getAllSmartNodes();
        logger.info("Exit addSmartNodeSensors:::");
            return new ModelAndView("viewsensor","nodeList",nodeList);
	}
	
	@PostMapping("/node/add")
	public ModelAndView addSmartNode(@ModelAttribute("node") SmartNode node, BindingResult result)  {
		logger.info("Enter addSmartNode");
            smartNodeService.addSmartNode(node);
            List<SmartNode> nodeList = smartNodeService.getAllSmartNodes();
        logger.info("Exit addSmartNode");
            return new ModelAndView("viewsmartnode","nodeList",nodeList);
	}
	@PostMapping("/node/update")
	public ModelAndView updateSmartNode(@ModelAttribute("node") SmartNode node, BindingResult result) {
		logger.info("Enter updateSmartNode");
		smartNodeService.updateSmartNode(node);
		List<SmartNode> nodeList = smartNodeService.getAllSmartNodes();
		logger.info("Exit updateSmartNode");
		return new ModelAndView("viewsmartnode","nodeList",nodeList);
	}
	
	@GetMapping("/editnode/{id}")
	public ModelAndView edit(@PathVariable("id") int id) {
		SmartNode node= smartNodeService.getSmartNodeById(id);
		return new ModelAndView("updatesmartnode", "node",node);
	}
	
	@GetMapping("/node/{id}/delete")
	public ModelAndView deleteSmartNode(@PathVariable("id") int id) {
		logger.info("Enter deleteSmartNode");
		smartNodeService.deleteSmartNode(id);
		List<SmartNode> nodeList = smartNodeService.getAllSmartNodes();
		logger.info("Exit deleteSmartNode");
		return new ModelAndView("viewsmartnode","nodeList",nodeList);
	}
	
}
