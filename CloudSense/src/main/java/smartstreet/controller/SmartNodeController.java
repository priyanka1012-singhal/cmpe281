package smartstreet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import smartstreet.service.ISmartNodeService;

@RestController
@RequestMapping(value="/nodes")
public class SmartNodeController {
	
	@Autowired
	ISmartNodeService smartNodeService;
	
	/* Constructor Injection */
	public SmartNodeController(ISmartNodeService smartNodeService) {
		super();
		this.smartNodeService = smartNodeService;
	}
}
