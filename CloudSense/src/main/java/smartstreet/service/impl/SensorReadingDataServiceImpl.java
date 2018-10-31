package smartstreet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smartstreet.dao.ISensorReadingDataDao;
import smartstreet.model.SensorReadingData;
import smartstreet.service.ISensorReadingDataService;

@Service
public class SensorReadingDataServiceImpl implements ISensorReadingDataService {
	
	@Autowired
	public ISensorReadingDataDao sensorReadingDataDao;
	
	public List<SensorReadingData> getReadingData(String sensorId) {
		return sensorReadingDataDao.getReadingData(sensorId);
	}

}
