package smartstreet.dao.impl;

import java.time.Instant;
import java.util.Date;
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
	@Autowired
    private MongoTemplate mongoTemplate;
	
	public List<SensorData> getReadingData() {     
		
		
		//BasicQuery query = new BasicQuery("{ measurementTimestamp : { $gte: ISODate('2018-05-23T00:00:00.000Z'), "
		//		+ "$lt: ISODate('2018-05-25T00:00:00.000Z')}, stationName: 'Oak Street Weather Station' }");
		BasicQuery query = new BasicQuery("{ stationName : 'Oak Street Weather Station' },{blockName: 'Oak and South Street'}");
		//Instant instant = Instant.parse("2014s-01-25T09:28:04.041Z"); //Pass your date.
		//Date timestamp = Date.from(instant);
		//BasicQuery query = 
		//new BasicQuery("{ measurementTimestamp : {$gte: \"05/22/2017 07:00:00 PM\" }}");
		//BasicQuery query = new BasicQuery("{ measurementTimestamp : new ISODate(\"2014-01-12T20:15:31Z\") }");
		List<SensorData> list = mongoTemplate.find(query,SensorData.class);
		return list;
	}
}


