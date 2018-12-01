package smartstreet.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import smartstreet.model.SensorData;

@Transactional(readOnly=true)
@Repository
public class SensorDataRepository  {
	/*@Autowired
    private MongoTemplate mongoTemplate;*/
	
	public List<SensorData> getReadingData() {
		
		          
		/*BasicQuery query = new BasicQuery("{ stationName : 'Oak Street Weather Station' }");
		List<SensorData> list = mongoTemplate.find(query,SensorData.class);
		return list;*/
		return new ArrayList<SensorData>();
	}
}
