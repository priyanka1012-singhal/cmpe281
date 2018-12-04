package smartstreet.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
/**
 * Sensor Reading data - NoSQL MongoDb
 * @author priyankasinghal
 *
 */

@CompoundIndex(name = "measure_station_idx", def = "{'measurementTimestamp' : 1, 'stationName' : 1}")
@Document(collection="sensordata")
public class SensorData {
	
	@Id
	private ObjectId _id;
	
	@Field("Station Name")
	private String stationName;
	
	@Field("Measurement Timestamp")
	private String measurementTimestamp;
	
	@Field("Battery Life")
	private String batteryLife;
	
	@Field("Wet Bulb Temperature")
	private String wetBulbTemperature;
	
	@Field("Humidity")
	private String humidity;
	
	public String get_id() {
		return _id.toHexString();
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public String getMeasurementTimestamp() {
		return measurementTimestamp;
	}
	public void setMeasurementTimestamp(String measurementTimestamp) {
		this.measurementTimestamp = measurementTimestamp;
	}
	public String getBatteryLife() {
		return batteryLife;
	}
	public void setBatteryLife(String batteryLife) {
		this.batteryLife = batteryLife;
	}
	public String getWetBulbTemperature() {
		return wetBulbTemperature;
	}
	public void setWetBulbTemperature(String wetBulbTemperature) {
		this.wetBulbTemperature = wetBulbTemperature;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	
	

	
	

}
