package smartstreet.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import smartstreet.model.Cluster;
import smartstreet.model.Sensor;
import smartstreet.model.SmartNode;
import smartstreet.service.IClusterService;


@RestController
@RequestMapping()
public class ClusterController {
	
	@Autowired
	IClusterService clusterService;
	
private final static Logger logger = Logger.getLogger(SensorController.class.getName());
	
	@GetMapping("/cluster/{id}")
	public ModelAndView getClusterById(@PathVariable("id") int id) {
		Cluster cluster= clusterService.getClusterById(id);
		return new ModelAndView("viewclusterinfo", "cluster",cluster);
	}
	@GetMapping("/viewcluster")
	public ModelAndView getAllClusters() {
		logger.info("Enter getAllClusters");
		List<Cluster> clusterList = clusterService.getAllClusters();
		logger.info("Exit getAllClusters:::"+clusterList.size());
		return new ModelAndView("viewcluster","clusterList",clusterList);
	}
	
	@PostMapping("/cluster/addnodes")
	public ModelAndView addSmartNodes(@RequestBody Cluster cluster)  {
		logger.info("Enter addSmartNodes");
		clusterService.addClusterSmartNodeMapping(cluster.getId(), cluster.getNodeIdList());
		List<Cluster> clusterList = clusterService.getAllClusters();
        logger.info("Exit addSmartNodes:::");
        return new ModelAndView("viewcluster","clusterList",clusterList);
	}
	
	
	@PostMapping("/cluster/add")
	public ModelAndView addCluster(@ModelAttribute("cluster") Cluster cluster, BindingResult result)  {
		logger.info("Enter addCluster");
            clusterService.addCluster(cluster);
            List<Cluster> clusterList = clusterService.getAllClusters();
        logger.info("Exit addCluster");
            return new ModelAndView("viewcluster","clusterList",clusterList);
	}
	@PostMapping("/cluster/update")
	public ModelAndView updateCluster(@ModelAttribute("cluster") Cluster cluster, BindingResult result) {
		clusterService.updateCluster(cluster);
		List<Cluster> clusterList = clusterService.getAllClusters();
		return new ModelAndView("viewcluster","clusterList",clusterList);
	}
	@GetMapping("/cluster/{id}/delete")
	public ModelAndView deleteCluster(@PathVariable("id") int id) {
		logger.info("Enter deleteCluster");
		clusterService.deleteCluster(id);
		List<Cluster> clusterList = clusterService.getAllClusters();
		logger.info("Exit deleteCluster");
		return new ModelAndView("viewcluster","clusterList",clusterList);
	}
	
	@GetMapping("/cluster/{id}/getunmappednodes")
	public ResponseEntity<Cluster> getunmappedSmartNodes(@PathVariable("id") int id) {
		logger.info("Enter getunmappedSmartNodes");
		Cluster cluster = clusterService.getClusterById(id);
		List<SmartNode> nodeList = clusterService.getUnmappedSmartNodeNames(id);
		cluster.setId(id);
		cluster.setNodes(nodeList);
		logger.info("Exit getunmappedSmartNodes:::"+nodeList.size());
		return new ResponseEntity<Cluster> (cluster,HttpStatus.OK);
	}
	
	@GetMapping("/editcluster/{id}")
	public ModelAndView edit(@PathVariable("id") int id) {
		Cluster cluster= clusterService.getClusterById(id);
		return new ModelAndView("updatecluster", "cluster",cluster);
	}
	
	@GetMapping("/cluster/{id}/getmappednodes")
	public ResponseEntity<List<SmartNode>> getmappedSmartNodes(@PathVariable("id") int id) {
		logger.info("Enter getmappedSmartNodes");
		List<SmartNode> nodeList = clusterService.getMappedSmartNodes(id);
		logger.info("Exit getmappedSmartNodes:::"+nodeList.size());
		return new ResponseEntity<List<SmartNode>> (nodeList,HttpStatus.OK);
	}
	
	@GetMapping("/viewcluster/cluster/{id}/getmappednodes")
	public ModelAndView getmappedNodesview(@PathVariable("id") int id) {
		logger.info("Enter getmappedNodesview");
		List<SmartNode> nodeList = clusterService.getMappedSmartNodes(id);
		//node.setSensors(sensorList);
		logger.info("Exit getmappedNodesview:::"+nodeList.size());
		return new ModelAndView ("viewsmartnode","nodeList",nodeList);
	}

}
