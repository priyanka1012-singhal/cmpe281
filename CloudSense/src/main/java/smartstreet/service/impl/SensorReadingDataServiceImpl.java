package smartstreet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smartstreet.dao.impl.SensorDataRepository;
import smartstreet.model.SensorData;
import smartstreet.service.ISensorReadingDataService;

@Service
public class SensorReadingDataServiceImpl implements ISensorReadingDataService {
	
	@Autowired
    private SensorDataRepository repository;
	
	public List<SensorData> getReadingData( ) {
		return repository.getReadingData();
	}

}
