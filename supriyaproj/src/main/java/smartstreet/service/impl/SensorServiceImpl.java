package smartstreet.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smartstreet.dao.ISensorDao;
import smartstreet.model.Sensor;
import smartstreet.service.ISensorService;

@Service
public class SensorServiceImpl implements ISensorService{
	
	@Autowired
	public ISensorDao sensorDao;
	
	public SensorServiceImpl() {
	}

	/**
	 * Add sensor
	 * @param sensor
	 */
	public synchronized boolean addSensor(Sensor sensor)throws Exception {
	    if (sensorDao.isExists(sensor.getSensorName())) {
  	      	return false;
        } else {
        	sensorDao.addSensor(sensor);
  	      	return true;
        }
	}
	
	/**
	 * Get List of sensors
	 * @return List of sensors
	 */
	public List<Sensor> getAllSensors() {
		   return sensorDao.getAllSensors();
	}
	
	/**
	 * Get Sensor by Id
	 * @param sensorId
	 * @return
	 */
	public Sensor getSensorById(int sensorId) {
		return sensorDao.getSensorById(sensorId);
	} 
	
	/**
	 * Update sensor
	 * @param sensor
	 */
	public void updateSensor(Sensor sensor) {
		sensorDao.updateSensor(sensor);
	} 
	
	/**
	 * Delete sensor
	 * @param sensor
	 */
	public void deleteSensor(int sensorId) {
		sensorDao.deleteSensor(sensorId);
	}

}
