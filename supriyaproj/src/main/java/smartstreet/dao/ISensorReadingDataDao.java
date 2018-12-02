package smartstreet.dao;

import java.util.List;

import smartstreet.model.SensorData;

public interface ISensorReadingDataDao {
	
	public List<SensorData> getReadingData(String sensorId);
	
}
