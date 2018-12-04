package smartstreet.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smartstreet.dao.ISensorDao;
import smartstreet.dto.Report;
import smartstreet.model.Sensor;
import smartstreet.service.ISensorService;
import smartstreet.utiliy.GoogleMapHelper;

@Service
public class SensorServiceImpl implements ISensorService{
	
	@Autowired
	public ISensorDao sensorDao;
	
	private final static Logger logger = Logger.getLogger(SensorServiceImpl.class.getName());
	
	/**
	 * Add sensor
	 * @param sensor
	 * @throws Exception 
	 */
	public synchronized boolean addSensor(Sensor sensor)  {
	   
    			String[] location;
				try {
					String response = GoogleMapHelper.getGeoLocation(sensor.getSensorAddress()+ ","+sensor.getSensorCity()+","
										+sensor.getSensorZip());
					location = GoogleMapHelper.getLatLongPositions(response);
					if(location!=null) {
	    				sensor.setSensorLatitude(location[0]);
	    				sensor.setSensorLongitude(location[1]);
	    			}
				} catch (Exception e) {
					logger.error("cannot find address::::");
				}
    		
        	sensorDao.addSensor(sensor);
  	      	return true;
        
	}
	
	/**
	 * Get List of sensors
	 * @return List of sensors
	 */
	public List<Sensor> getAllSensors() {
		   return sensorDao.getAllSensors();
	}
	
	/**
	 * Get List of sensors by street name
	 * @param streetname
	 * @return List of sensors
	 */
	public List<Sensor> getAllSensors(String streetname) {
		   return sensorDao.getAllSensors(streetname);
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
		sensorDao.deleteMapping(sensorId);
		sensorDao.deleteSensor(sensorId);
	}
	
	public List<Report> getreportbysensortype() {
		   return sensorDao.getreportbysensortype();
	}
	
	public List<Report> getreportbysensorstatus() {
		   return sensorDao.getreportbysensorstatus();
	}
	
	public List<Report> getreportbyblockname() {
		   return sensorDao.getreportbyblockname();
	}

}
