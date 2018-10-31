package smartstreet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smartstreet.dao.ISensorDao;
import smartstreet.service.ISensorService;

@Service
public class SensorServiceImpl implements ISensorService{
	
	@Autowired
	public ISensorDao sensorDao;

}
