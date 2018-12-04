package smartstreet.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import smartstreet.dao.ISmartNodeDao;
import smartstreet.dto.SensorRowMapper;
import smartstreet.dto.SmartNodeRowMapper;
import smartstreet.model.Sensor;
import smartstreet.model.SmartNode;
/**
 * Smart Node Dao Class
 * @author priyankasinghal
 *
 */
@Transactional
@Repository
public class SmartNodeDaoImpl implements ISmartNodeDao{
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	/**
	 * Add smartNode
	 * @param smartNode
	 */
	public void addSmartNode(SmartNode smartNode) {
		   String sql = "INSERT INTO smart_node (node_name, "
		   		+ "node_status,"
		   		+ "node_latitude,"
		   		+ "node_longitude,"
		   		+ "node_address,"
		   		+ "node_city,"
		   		+ "node_state,"
		   		+ "node_zip,"
		   		+ "installed_by,"
		   		+ "installation_date,"
		   		+ "last_maintained_by,"
		   		+ "last_maintained_date"
		   		+ ") values (?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?)";
		   jdbcTemplate.update(sql,  
				   smartNode.getNodeName(),
				   smartNode.getNodeStatus(),
				   smartNode.getNodeLatitude(),
				   smartNode.getNodeLongitude(),
				   smartNode.getNodeAddress(),
				   smartNode.getNodeCity(),
				   smartNode.getNodeState(),
				   smartNode.getNodeZip(),
				   smartNode.getInstalledBy(),
				   smartNode.getInstallationDate(),
				   smartNode.getLastMaintainedBy(),
				   smartNode.getLastMaintainedDate()
				   );
	}
	
	/**
	 * Get List of smartNodes
	 * @return List of smartNodes
	 */
	public List<SmartNode> getAllSmartNodes() {
		   String sql = "SELECT *"
		   		+ " FROM smart_node node";
		   RowMapper<SmartNode> rowMapper = new SmartNodeRowMapper();		
		   return this.jdbcTemplate.query(sql, rowMapper);
	}
	
	/**
	 * Get SmartNode by Id
	 * @param smartNodeId
	 * @return
	 */
	public SmartNode getSmartNodeById(int smartNodeId) {
		 String sql = "SELECT *"
	   		+ " FROM smart_node node where  node.node_id = ? ";
		RowMapper<SmartNode> rowMapper = new SmartNodeRowMapper();		
		SmartNode smartNode = jdbcTemplate.queryForObject(sql, rowMapper, smartNodeId);
		return smartNode;
	} 
	
	/**
	 * Update smartNode
	 * @param smartNode
	 */
	public void updateSmartNode(SmartNode smartNode) {
	    String sql = "UPDATE smart_node SET node_status=? WHERE node_id=?";
	    jdbcTemplate.update(sql, smartNode.getNodeStatus(), smartNode.getId());
	} 
	
	/**
	 * Delete smartNode
	 * @param smartNode
	 */
	public void deleteSmartNode(int smartNodeId) {
		String sql = "DELETE FROM smart_node WHERE node_id=?";
		jdbcTemplate.update(sql, smartNodeId);
	}
	
	/**
	 * Checks if the smartNode with same name exists or not
	 * @param smartNodename
	 * @return
	 */
	public boolean isExists(String smartNodename) {
		String sql = "SELECT count(*) FROM smart_node WHERE node_name = ? ";
		int count = jdbcTemplate.queryForObject(sql, Integer.class, smartNodename);
		if(count == 0) 
    		 return false;
		else 
			return true;
	}
	
	
	public void addSmartNodeSensorMapping(int smartNodeId, List<Integer> sensorids) {
		   String sql = "INSERT INTO node_sensor_mapping (node_id, "
		   		+ "sensor_id,"
		   		+ "created_date,"
		   		+ "created_by"
		   		+ ") values (?, ?, ?,?)";
		   jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
				
				@Override
				public void setValues(PreparedStatement ps, int i) throws SQLException {
					int sensorid = sensorids.get(i);
					ps.setInt(1, smartNodeId);
					ps.setInt(2, sensorid);
					ps.setDate(3, new java.sql.Date(Calendar.getInstance().getTime().getTime()) );
					ps.setInt(4, 1 );
				}
						
				@Override
				public int getBatchSize() {
					return sensorids.size();
				}
			  });	
	}		   
	public List<Sensor> getMappedSensors(int smartNodeId) {
		  
			  String sql = "SELECT map.sensor_id, s.sensor_name, "
				   		+ "s.device_id,"
				   		+ "s.sensor_status,"
				   		+ "s.sensor_desc,"
				   		+ "s.device_type,"
				   		+ "s.sensor_type,"
				   		+ "s.sensor_latitude,"
				   		+ "s.sensor_country,"
				   		+ "s.sensor_longitude,"
				   		+ "s.sensor_address,"
				   		+ "s.sensor_city,"
				   		+ "s.sensor_state,"
				   		+ "s.sensor_zip,"
				   		+ "s.sensor_block,"
				   		+ "s.installed_by,"
				   		+ "s.installation_date,"
				   		+ "s.last_maintained_by,"
				   		+ "s.last_maintained_date"
		   		+ " FROM node_sensor_mapping map, sensor s WHERE map.node_id = ? AND s.sensor_id="
		   		+ "map.sensor_id";
			  RowMapper<Sensor> rowMapper = new SensorRowMapper();		
			   return this.jdbcTemplate.query(sql, rowMapper, smartNodeId);
				  
	}
	
	public int getMappedSensorCount(int smartNodeId) {
		String sql = "SELECT count(sensor_id) FROM node_sensor_mapping WHERE node_id =  ?";
		return jdbcTemplate.queryForObject(sql, Integer.class, smartNodeId);
	}
	
	
	
		
	public List<Sensor> getUnMappedSensorNames(int nodeid) {
				   String sql = "SELECT * FROM sensor s WHERE s.sensor_id NOT IN (SELECT map.sensor_id FROM node_sensor_mapping map"+
				   " WHERE map.node_id=?)";
				   RowMapper<Sensor> rowMapper = new SensorRowMapper();		
				   return this.jdbcTemplate.query(sql, rowMapper, nodeid);
	}
	/**
	 * 
	 */
	@Override
	public void deleteSmartNodeMapping(int smartNodeId) {
		//Delete from smart node - sensor mapping
		String sql = "DELETE FROM node_sensor_mapping WHERE node_id=?";
		jdbcTemplate.update(sql, smartNodeId);
		//Delete from smart node - cluster mapping
		sql = "DELETE FROM cluster_node_mapping WHERE node_id=?";
		jdbcTemplate.update(sql, smartNodeId);
		
	}
			
		  
		  

}
