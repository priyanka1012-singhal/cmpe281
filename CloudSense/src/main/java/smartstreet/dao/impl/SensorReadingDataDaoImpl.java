package smartstreet.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import smartstreet.dao.ISensorReadingDataDao;
import smartstreet.model.SensorReadingData;

@Repository
public class SensorReadingDataDaoImpl implements ISensorReadingDataDao{

	/*@Autowired
	public MongoTemplate mongoTemplate;*/


	public List<SensorReadingData> getReadingData(String sensorId) {
		// TODO Auto-generated method stub
		return null;
	}

}
