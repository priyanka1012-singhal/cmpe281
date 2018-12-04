package smartstreet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smartstreet.dao.ISmartNodeDao;
import smartstreet.service.ISmartNodeService;

@Service
public class SmartNodeServiceImpl implements ISmartNodeService{
	
	@Autowired
	public ISmartNodeDao smartNodeDao;
}
