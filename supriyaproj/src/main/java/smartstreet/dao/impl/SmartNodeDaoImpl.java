package smartstreet.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import smartstreet.dao.ISmartNodeDao;
import smartstreet.dto.SensorRowMapper;
import smartstreet.dto.SmartNodeRowMapper;
import smartstreet.model.Sensor;
import smartstreet.model.SmartNode;
import smartstreet.model.SmartNode;

@Transactional
@Repository
public class SmartNodeDaoImpl implements ISmartNodeDao{
	
	@Autowired
    private JdbcTemplate jdbcTemplate;


	public void addSmartNode(SmartNode snode) throws Exception {
		GoogleMapHelper gMapHelper = new GoogleMapHelper();
		String city=snode.getNodeCity();
		String Zip = snode.getNodeZip();
		String address = snode.getNodeAddress();	
		String response = gMapHelper.getGeoLocation(address + "," +city+","+Zip);
		String[] result = gMapHelper.parseLocationResponse(response);	
		snode.setNodeLatitude(result[0]);
		snode.setNodeLongitude(result[1]);
		snode.setInstallationDate(new Date());
		snode.setInstalledBy("xyz");
	   snode.setInstalledBy("supriyajain");
	   String sql = "INSERT INTO smart_node (node_id, node_name, node_desc , "   		
	   		+ "node_latitude, node_longitude, node_address,node_city, node_state, "
	   		+ "node_country, node_zip, installed_by, installation_date, last_maintained_by,"
	   		+ "last_maintainance_date) values (?, ?, ? , ? ,? ,?, ?, ? , ? ,? ,?, ?, ? , ? )";
	   jdbcTemplate.update(sql, snode.getId(), snode.getNodeName(),
		   snode.getNodeDesc(), snode.getNodeLatitude(), snode.getNodeLongitude(), snode.getNodeAddress(),
		   snode.getNodeCity(), snode.getNodeState(), snode.getNodeCountry(),
		   snode.getNodeZip(),snode.getInstalledBy(), snode.getInstallationDate(),
		   snode.getLastMaintainedBy(), snode.getLastMaintainedDate());		
		
	}
	public List<SmartNode> getAllSmartNodes() {
	    String sql = "SELECT * FROM smart_node";
	    List<SmartNode> nodeList = jdbcTemplate.query(sql, new RowMapper<SmartNode>() {
	 
	        @Override
	        public SmartNode mapRow(ResultSet rs, int rowNum) throws SQLException {
	            SmartNode snode = new SmartNode();
	 
	            snode.setId(rs.getInt("node_id"));
	            snode.setNodeName(rs.getString("node_name"));
	            snode.setNodeDesc(rs.getString("node_desc"));
	            snode.setNodeAddress(rs.getString("node_address"));
	            snode.setNodeLatitude(rs.getString("node_latitude"));
	            snode.setNodeLongitude(rs.getString("node_longitude"));
	            snode.setInstallationDate(rs.getDate("installation_date"));
	            return snode;
	        }
	 
	    });
	 
	    return nodeList;
	}	
	public SmartNode getSmartNodeById(int snodeId) {
		String sql = "SELECT * FROM smart_node WHERE node_id = ?";
		RowMapper<SmartNode> rowMapper = new SmartNodeRowMapper();		
		SmartNode article = jdbcTemplate.queryForObject(sql, rowMapper, snodeId);
		return article;		
		
	}	
	public void updateSmartNode(SmartNode snode) {
		GoogleMapHelper gMapHelper = new GoogleMapHelper();
		String response = gMapHelper.getGeoLocation(snode.getNodeAddress() + "," +snode.getNodeCity()+","+snode.getNodeZip());
		String[] longlat = gMapHelper.parseLocationResponse(response);	
	
		String sql = "UPDATE smart_node SET node_name = ?,node_desc=?, node_status=?, node_latitude=?,"
				+ "node_longitude=? , node_address=?, node_city=?, node_state=?,node_country=?,"
	    		+ "node_zip=? , last_maintained_by=? , last_maintainance_date=? WHERE node_id=?";
	    jdbcTemplate.update(sql, snode.getNodeName(), snode.getNodeDesc(), snode.getNodeStatus(),
	    		longlat[0],  longlat[1], snode.getNodeAddress(), 
	    		snode.getNodeCity(),snode.getNodeState(), snode.getNodeCountry(), snode.getNodeZip(),
	    		"XYZ", new Date(),  snode.getId());		
		
	}
	public void deleteSmartNode(int snodeId) {
		String sql = "DELETE FROM smart_node WHERE node_id=?";
		jdbcTemplate.update(sql, snodeId);
		
	}	
	public boolean isExists(String snodename) {
		
		return false;
	}
	
	
	
}
