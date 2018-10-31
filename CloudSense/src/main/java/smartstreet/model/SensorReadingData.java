package smartstreet.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * Sensor Reading data - NoSQL MongoDb
 * @author priyankasinghal
 *
 */
@Document
public class SensorReadingData {
	
	@Id
	private String id;

}
