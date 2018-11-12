package smartstreet.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import smartstreet.dao.ISensorDao;
import smartstreet.dto.SensorRowMapper;
import smartstreet.model.Sensor;

/**
 * Sensor Dao class
 * @author priyankasinghal
 *
 */
@Transactional
@Repository
public class SensorDaoImpl implements ISensorDao{
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	/**
	 * Add sensor
	 * @param sensor
	 */
	public void addSensor(Sensor sensor) {
		   String sql = "INSERT INTO sensor (sensor_id, sensor_name, sensor_status) values (?, ?, ?)";
		   jdbcTemplate.update(sql, sensor.getId(), sensor.getSensorName(),sensor.getSensorStatus());
	}
	
	/**
	 * Get List of sensors
	 * @return List of sensors
	 */
	public List<Sensor> getAllSensors() {
		   String sql = "SELECT sensor_id, sensor_name, sensor_status FROM sensor";
		   RowMapper<Sensor> rowMapper = new SensorRowMapper();		
		   return this.jdbcTemplate.query(sql, rowMapper);
	}
	
	/**
	 * Get Sensor by Id
	 * @param sensorId
	 * @return
	 */
	public Sensor getSensorById(String sensorId) {
		String sql = "SELECT sensor_id, sensor_name, sensor_status FROM sensor WHERE sensor_id = ?";
		RowMapper<Sensor> rowMapper = new SensorRowMapper();		
		Sensor article = jdbcTemplate.queryForObject(sql, rowMapper, sensorId);
		return article;
	} 
	
	/**
	 * Update sensor
	 * @param sensor
	 */
	public void updateSensor(Sensor sensor) {
	    String sql = "UPDATE sensor SET sensor_status=? WHERE sensor_id=?";
	    jdbcTemplate.update(sql, sensor.getSensorStatus(), sensor.getId());
	} 
	
	/**
	 * Delete sensor
	 * @param sensor
	 */
	public void deleteSensor(String sensorId) {
		String sql = "DELETE FROM sensor WHERE sensor_id=?";
		jdbcTemplate.update(sql, sensorId);
	}
	
	/**
	 * Checks if the sensor with same name exists or not
	 * @param sensorname
	 * @return
	 */
	public boolean isExists(String sensorname) {
		String sql = "SELECT count(*) FROM sensor WHERE sensor_name = ? ";
		int count = jdbcTemplate.queryForObject(sql, Integer.class, sensorname);
		if(count == 0) 
    		 return false;
		else 
			return true;
	}

}
