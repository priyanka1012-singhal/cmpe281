package smartstreet.dao;

import java.util.List;
import smartstreet.model.SensorReadingData;

public interface ISensorReadingDataDao {
	
	public List<SensorReadingData> getReadingData(String sensorId);
	
}
