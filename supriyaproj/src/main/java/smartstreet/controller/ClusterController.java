package smartstreet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import smartstreet.service.IClusterService;


@RestController
@RequestMapping(value="/clusters")
public class ClusterController {
	
	@Autowired
	IClusterService clusterService;
	
	/* Constructor Injection */
	public ClusterController(IClusterService clusterService) {
		super();
		this.clusterService = clusterService;
	}

}
