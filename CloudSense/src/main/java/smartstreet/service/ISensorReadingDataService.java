package smartstreet.service;

import java.util.List;
import smartstreet.model.SensorReadingData;

public interface ISensorReadingDataService {
	public List<SensorReadingData> getReadingData(String sensorId);
}
