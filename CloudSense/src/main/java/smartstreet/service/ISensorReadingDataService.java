package smartstreet.service;

import java.util.List;

import smartstreet.model.SensorData;

public interface ISensorReadingDataService {
	public List<SensorData> getReadingData( );
}
