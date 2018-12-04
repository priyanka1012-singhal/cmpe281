package smartstreet.dao;

import java.util.List;

import smartstreet.model.Sensor;

public interface ISensorDao {
	
	/**
	 * Add sensor
	 * @param sensor
	 * @throws Exception 
	 */
	public void addSensor(Sensor sensor) throws Exception;
	
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
	public Sensor getSensorById(int sensorId);
	
	/**
	 * Update sensor
	 * @param sensor
	 */
	public void updateSensor(Sensor sensor);
	
	/**
	 * Delete sensor
	 * @param sensor
	 */
	public void deleteSensor(int sensorId);

	/**
	 * Checks if the sensor with same name exists or not
	 * @param sensorname
	 * @return
	 */
	boolean isExists(String sensorname);
	public  List<Sensor>  getSensorLongLat() ;
	public  List<Sensor>  getSensorLongLat(String latitude, String longitude) ; 
	public void updateNodeForSensor(String[]sensorList , int nodeId);
	public  List<Sensor> getSensorsForNode(int sNodeId);
	public void deleteNodeForSensor(String[]sensorList , int nodeId);
	public void subscribeSensor(Sensor sensor);
}
