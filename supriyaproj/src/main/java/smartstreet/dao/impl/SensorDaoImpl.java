package smartstreet.dao.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
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
	private final static Logger logger = Logger.getLogger(SensorDaoImpl.class.getName());
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	/**
	 * Add sensor
	 * @param sensor
	 */
	public void addSensor(Sensor sensor) throws Exception{
		GoogleMapHelper gMapHelper = new GoogleMapHelper();
		String city=sensor.getSensorCity();
		String Zip = sensor.getSensorZip();
		String address = sensor.getSensorAddress();	
		String response = gMapHelper.getGeoLocation(address + "," +city+","+Zip);
		String[] result = gMapHelper.parseLocationResponse(response);	
		sensor.setSensorLatitude(result[0]);
		sensor.setSensorLongitude(result[1]);
		sensor.setInstallationDate(new Date());
	   String sql = "INSERT INTO sensor (sensorId, sensorName, sensorStatus, sensorDesc, sensorType, "
	   		+ "sensorFrequency, sensorProviderName, sensorStartTime, sensorEndTime , "
	   		+ "sensorLatitude, sensorLongitude, sensorAddress, sensorCity, sensorState, "
	   		+ "sensorCountry, sensorZip, sensorBlock, installedBy, installationDate, lastmaintainedBy,"
	   		+ "lastMaintainedDate) values (?, ?, ? , ? ,? ,?, ?, ? , ? ,? ,?, ?, ? , ? ,? ,?, ?, ? , ? ,?,? )";
	   jdbcTemplate.update(sql, sensor.getId(), sensor.getSensorName(),sensor.getSensorStatus(),
			   sensor.getSensorDesc(), sensor.getSensorType(), sensor.getSensorFrequency(),
			   sensor.getSensorProviderName(), sensor.getSensorStartTime(), sensor.getSensorEndTime(),
			   sensor.getSensorLatitude(), sensor.getSensorLongitude(), sensor.getSensorAddress(),
			   sensor.getSensorCity(), sensor.getSensorState(), sensor.getSensorCountry(),
			   sensor.getSensorZip(),sensor.getSensorBlock(), sensor.getInstalledBy(), sensor.getInstallationDate(),
			   sensor.getLastMaintainedBy(), sensor.getLastMaintainedDate());
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
	
	/**
	 * Get Sensor by Id
	 * @param sensorId
	 * @return
	 */
	public Sensor getSensorById(int sensorId) {
		String sql = "SELECT * FROM sensor WHERE sensorId = ?";
		RowMapper<Sensor> rowMapper = new SensorRowMapper();		
		Sensor article = jdbcTemplate.queryForObject(sql, rowMapper, sensorId);
		return article;
	} 

	public  List<Sensor>  getSensorLongLat() {
	    String sql = "SELECT sensorLongitude, sensorLatitude FROM sensor";
	    List<Sensor> sensorList = jdbcTemplate.query(sql, new RowMapper<Sensor>() {
    	
        @Override
        public Sensor mapRow(ResultSet rs, int rowNum) throws SQLException {
            Sensor sensor = new Sensor();	    		
            sensor.setSensorLatitude(rs.getString("sensorLatitude"));
            sensor.setSensorLongitude(rs.getString("sensorLongitude"));
            return sensor;
        }
    });
 
    return sensorList;
	} 
	
	/**
	 * Update sensor
	 * @param sensor
	 */
	public void updateSensor(Sensor sensor) {
		GoogleMapHelper gMapHelper = new GoogleMapHelper();
		String response = gMapHelper.getGeoLocation(sensor.getSensorAddress() + "," +sensor.getSensorCity()+","+sensor.getSensorZip());
		String[] longlat = gMapHelper.parseLocationResponse(response);	
	
		String sql = "UPDATE sensor SET sensorName = ? , sensorFrequency=? ,"
	    		+ "sensorDesc=?, sensorStatus=?, sensorType=?,"
	    		+ "sensorAddress=?, sensorCity=?, sensorState=?,sensorCountry=?,"
	    		+ "sensorZip=? , lastmaintainedBy=? , lastMaintainedDate=? ,"
	    		+ "sensorLatitude=? , sensorLongitude=? WHERE sensorId=?";
	    jdbcTemplate.update(sql, sensor.getSensorName(),
	    		sensor.getSensorFrequency(), sensor.getSensorDesc(), sensor.getSensorStatus(),
	    		sensor.getSensorType(), sensor.getSensorAddress(), sensor.getSensorCity(),
	    		sensor.getSensorState(), sensor.getSensorCountry(), sensor.getSensorZip(),
	    		"XYZ", new Date(), longlat[0], longlat[1], sensor.getId());
	} 
	
	/**
	 * Delete sensor
	 * @param sensor
	 */
	public void deleteSensor(int sensorId) {
		String sql = "DELETE FROM sensor WHERE sensorId=?";
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

	public  List<Sensor>  getSensorLongLat( String latitude, String longitude) {
		
		String sql = "SELECT sensorName, sensorType , sensorStatus ,sensorLongitude, "
				+ "sensorLatitude, sensorAddress , sensorDesc FROM sensor where sensorLongitude =? and sensorLatitude=?";
		 List<Sensor> sensorList=  jdbcTemplate.query(sql,  new Object[] { longitude, latitude }, new RowMapper<Sensor>() {
		    	
		        @Override
		        public Sensor mapRow(ResultSet rs, int rowNum) throws SQLException {
		            Sensor sensor = new Sensor();	    		
		            sensor.setSensorName(rs.getString("sensorName"));
		            sensor.setSensorType(rs.getString("sensorType"));
		            sensor.setSensorStatus(rs.getString("sensorStatus"));
		            sensor.setSensorDesc(rs.getString("sensorDesc"));
		            sensor.setSensorLongitude(rs.getString("sensorLongitude"));
		            sensor.setSensorLatitude(rs.getString("sensorLatitude"));
		            sensor.setSensorAddress(rs.getString("sensorAddress"));		            
		            return sensor;
		        }
		    });
		 
		    return sensorList;  
	}
	public void updateNodeForSensor(String[]sensorList , int nodeId)
	{		
		for(int i = 0; i< sensorList.length; i++)
		{
			logger.info( sensorList[i]);
			String sql = "update sensor set node_id =? where sensorName=? ";
			 jdbcTemplate.update(sql, nodeId, sensorList[i]);
		}
	}
	public void deleteNodeForSensor(String[]sensorList , int nodeId)
	{		
		for(int i = 0; i< sensorList.length; i++)
		{
			logger.info( sensorList[i]);
			String sql = "update sensor set node_id =? where sensorName=? ";
			 jdbcTemplate.update(sql, 0, sensorList[i]);
		}
	}
	
	 public  List<Sensor> getSensorsForNode(int sNodeId)
	 {
		String sql = "SELECT sensorName, sensorDesc, sensorType, sensorStatus, sensorAddress from sensor where node_id=?";
		 List<Sensor> sensorList=  jdbcTemplate.query(sql,  new Object[] { sNodeId}, new RowMapper<Sensor>() {
		    	
		        @Override
		        public Sensor mapRow(ResultSet rs, int rowNum) throws SQLException {
		            Sensor sensor = new Sensor();	    		
		            sensor.setSensorName(rs.getString("sensorName"));
		            sensor.setSensorDesc(rs.getString("sensorDesc"));
		            sensor.setSensorType(rs.getString("sensorType"));
		            sensor.setSensorStatus(rs.getString("sensorStatus"));
		            sensor.setSensorAddress(rs.getString("sensorAddress"));
		            return sensor;
		        }
		    });			 
		 return sensorList; 		 
	 }

	@Override
	public void subscribeSensor(Sensor sensor) {
		String sql = "UPDATE sensor SET sensorStartTime = ? , sensorEndTime=? ,"
	    		+ "sensorFrequency=?  WHERE sensorId=?";
	    jdbcTemplate.update(sql, sensor.getSensorStartTime(), sensor.getSensorEndTime(), 
	    		sensor.getSensorFrequency(), sensor.getId());		
	}
}