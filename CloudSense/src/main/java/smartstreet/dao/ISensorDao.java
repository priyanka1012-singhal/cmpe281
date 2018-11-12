package smartstreet.dao;

import java.util.List;

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

}
