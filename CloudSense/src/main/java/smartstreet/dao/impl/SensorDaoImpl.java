package smartstreet.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import smartstreet.dao.ISensorDao;
import smartstreet.dto.Report;
import smartstreet.dto.ReportRowMapper;
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
		   String sql = "INSERT INTO sensor (sensor_name, "
		   		+ "device_id,"
		   		+ "sensor_status,"
		   		+ "sensor_desc,"
		   		+ "device_type,"
		   		+ "sensor_type,"
		   		+ "sensor_frequency,"
		   		+ "sensor_latitude,"
		   		+ "sensor_longitude,"
		   		+ "sensor_address,"
		   		+ "sensor_city,"
		   		+ "sensor_state,"
		   		+ "sensor_country,"
		   		+ "sensor_zip,"
		   		+ "sensor_block,"
		   		+ "installed_by,"
		   		+ "installation_date,"
		   		+ "last_maintained_by,"
		   		+ "last_maintained_date,"
		   		+ "sensor_provider_name"
		   		+ ") values (?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?,?,?, ?,?,?,?)";
		   jdbcTemplate.update(sql,  
				   sensor.getSensorName(),
				   sensor.getDeviceid(),
				   sensor.getSensorStatus(),
				   sensor.getSensorDesc(),
				   sensor.getDeviceType(),
				   sensor.getSensorType(),
				   sensor.getSensorFrequency(),
				   sensor.getSensorLatitude(),
				   sensor.getSensorLongitude(),
				   sensor.getSensorAddress(),
				   sensor.getSensorCity(),
				   sensor.getSensorState(),
				   sensor.getSensorCountry(),
				   sensor.getSensorZip(),
				   sensor.getSensorBlock(),
				   sensor.getInstalledBy(),
				   sensor.getInstallationDate(),
				   sensor.getLastMaintainedBy(),
				   sensor.getLastMaintainedDate(),
				   sensor.getSensorProviderName()
				   );
	}
	
	/**
	 * Get List of sensors
	 * @return List of sensors
	 */
	public List<Sensor> getAllSensors() {
		   String sql = "SELECT * FROM sensor";
		   RowMapper<Sensor> rowMapper = new SensorRowMapper();		
		   return this.jdbcTemplate.query(sql, rowMapper);
	}
	
	 /* Get List of sensors by street name
	 * @param streetname
	 * @return List of sensors
	 */
	public List<Sensor> getAllSensors(String streetname) {

	    String sql = "SELECT * FROM sensor where sensor_address like ? OR sensor_zip like ? OR sensor_block like ?";
	    RowMapper<Sensor> rowMapper = new SensorRowMapper();
	    return this.jdbcTemplate.query(sql, rowMapper, "%"+streetname+"%", "%"+streetname+"%", "%"+streetname+"%");
	}
	
	public List<Report> getreportbysensortype() {
		    String sql = "SELECT COUNT(*) as count, sensor_type FROM sensor GROUP BY sensor_type";
		    RowMapper<Report> rowMapper = new ReportRowMapper();
		    return this.jdbcTemplate.query(sql, rowMapper);
	}
	
	public List<Report> getreportbysensorstatus() {
	    String sql = "SELECT COUNT(*) as count, sensor_status as sensor_type FROM sensor GROUP BY sensor_status";
	    RowMapper<Report> rowMapper = new ReportRowMapper();
	    return this.jdbcTemplate.query(sql, rowMapper);
	}
	
	public List<Report> getreportbyblockname() {
	    String sql = "SELECT COUNT(*) as count, sensor_block as sensor_type FROM sensor GROUP BY sensor_block";
	    RowMapper<Report> rowMapper = new ReportRowMapper();
	    return this.jdbcTemplate.query(sql, rowMapper);
	}
	
	
	/**
	 * Get Sensor by Id
	 * @param sensorId
	 * @return
	 */
	public Sensor getSensorById(String sensorId) {
		String sql = "SELECT * FROM sensor WHERE sensor_id = ?";
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
	/**
	 * Get Sensor by Id
	 * @param sensorId
	 * @return
	 */
	public Sensor getSensorById(int sensorId) {
		String sql = "SELECT * FROM sensor WHERE sensor_id = ?";
		RowMapper<Sensor> rowMapper = new SensorRowMapper();		
		Sensor article = jdbcTemplate.queryForObject(sql, rowMapper, sensorId);
		return article;
	} 

	public  List<Sensor>  getSensorLongLat( String latitude, String longitude) {
		
		String sql = "SELECT sensor_name, sensor_type , sensor_status ,sensor_longitude, "
		+ "sensor_latitude, sensor_address , sensor_desc FROM sensor where sensor_longitude =? and sensor_latitude=?";
		 List<Sensor> sensorList=  jdbcTemplate.query(sql,  new Object[] { longitude, latitude }, new RowMapper<Sensor>() {
		    	
		        @Override
		        public Sensor mapRow(ResultSet rs, int rowNum) throws SQLException {
		            Sensor sensor = new Sensor();	    		
		            sensor.setSensorName(rs.getString("sensor_name"));
					sensor.setSensorType(rs.getString("sensor_type"));
					sensor.setSensorStatus(rs.getString("sensor_status"));
					sensor.setSensorDesc(rs.getString("sensor_desc"));
					sensor.setSensorLongitude(rs.getString("sensor_longitude"));
					sensor.setSensorLatitude(rs.getString("sensor_latitude"));
					sensor.setSensorAddress(rs.getString("sensor_address"));		            
		            return sensor;
		        }
		    });
		 
		    return sensorList;  
	}	
	
	
	public void updateNodeForSensor(String[]sensorList , int nodeId)
	{		
		for(int i = 0; i< sensorList.length; i++)
		{
			String sql = "update sensor set node_id =? where sensor_name=? ";
			 jdbcTemplate.update(sql, nodeId, sensorList[i]);
		}
	}
	
	 public  List<Sensor> getSensorsForNode(int sNodeId)
	 {
		String sql = "SELECT sensor_name, sensor_desc, sensor_type, sensor_status, sensor_address ,sensor_longitude,"
				+ "sensor_latitude from sensor where node_id=?";
		 List<Sensor> sensorList=  jdbcTemplate.query(sql,  new Object[] { sNodeId}, new RowMapper<Sensor>() {
		    	
		        @Override
		        public Sensor mapRow(ResultSet rs, int rowNum) throws SQLException {
		            Sensor sensor = new Sensor();	    		
		            sensor.setSensorName(rs.getString("sensor_name"));
		            sensor.setSensorDesc(rs.getString("sensor_desc"));
		            sensor.setSensorType(rs.getString("sensor_type"));
		            sensor.setSensorStatus(rs.getString("sensor_status"));            
		            sensor.setSensorAddress(rs.getString("sensor_address"));
					sensor.setSensorLongitude(rs.getString("sensor_longitude"));
					sensor.setSensorLatitude(rs.getString("sensor_latitude"));		
		            return sensor;
		        }
		    });			 
		 return sensorList; 		 
	 }
		public void deleteNodeForSensor(String[]sensorList , int nodeId)
		{		
			for(int i = 0; i< sensorList.length; i++)
			{
				String sql = "update sensor set node_id =? where sensor_name=? ";
				 jdbcTemplate.update(sql, 0, sensorList[i]);
			}
		}	
}
