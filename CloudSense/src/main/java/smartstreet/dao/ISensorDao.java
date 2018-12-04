package smartstreet.dao;

import java.util.List;

import smartstreet.dto.Report;
import org.springframework.jdbc.core.RowMapper;

import smartstreet.dto.SensorRowMapper;
import smartstreet.model.Sensor;

public interface ISensorDao {
	
	/**
	 * Add sensor
	 * @param sensor
	 */
	public void addSensor(Sensor sensor);
	
	/**
	 * Get List of sensors
	 * @return List of sensors
	 */
	public List<Sensor> getAllSensors() ;
	
	/**
	 * Get Sensor by Id
	 * @param sensorId
	 * @return
	 */
	public Sensor getSensorById(String sensorId);
	
	/**
	 * Update sensor
	 * @param sensor
	 */
	public void updateSensor(Sensor sensor);
	
	/**
	 * Delete sensor
	 * @param sensor
	 */
	public void deleteSensor(String sensorId);

	/**
	 * Checks if the sensor with same name exists or not
	 * @param sensorname
	 * @return
	 */
	boolean isExists(String sensorname);
	/**
	 * Get List of sensors by street name
	 * @param streetname
	 * @return List of sensors
	 */
	public List<Sensor> getAllSensors(String streetname);

	List<Report> getreportbysensortype();

	List<Report> getreportbysensorstatus();

	List<Report> getreportbyblockname();
	
	/**
	 * Get Sensor by Id
	 * @param sensorId
	 * @return
	 */
	public Sensor getSensorById(int sensorId);
	public  List<Sensor>  getSensorLongLat(String latitude, String longitude) ; 
	public void updateNodeForSensor(String[]sensorList , int nodeId);
	public  List<Sensor> getSensorsForNode(int sNodeId);
	public void deleteNodeForSensor(String[]sensorList , int nodeId);
}
