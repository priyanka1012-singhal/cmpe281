package smartstreet.service;

import java.util.List;

import smartstreet.dto.Report;
import smartstreet.model.Sensor;

public interface ISensorService {
	
	/**
	 * Add sensor
	 * @param sensor
	 * @throws Exception 
	 */
	public boolean addSensor(Sensor sensor) ;
	
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
	public void updateSensor(Sensor sensor) ;
	
	/**
	 * Delete sensor
	 * @param sensor
	 */
	public void deleteSensor(String sensorId);
	/**
	 * Get List of sensors by street name
	 * @param streetname
	 * @return List of sensors
	 */
	public List<Sensor> getAllSensors(String streetname);

	List<Report> getreportbysensortype();

	List<Report> getreportbyblockname();

	List<Report> getreportbysensorstatus();
	

}
