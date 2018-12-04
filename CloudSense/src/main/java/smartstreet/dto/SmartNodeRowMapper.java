package smartstreet.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import smartstreet.model.SmartNode;

/**
 * Row Mapper class for Node
 * Maps DB data to bean class
 * @author priyankasinghal
 *
 */

public class SmartNodeRowMapper implements RowMapper<SmartNode> {
	
		
		
		public SmartNode mapRow(ResultSet row, int rowNum) throws SQLException {
		SmartNode node = new SmartNode();
		node.setId(row.getInt("node_id"));
		//node.setSensorIdCount(row.getInt("sensoridcount"));
		node.setNodeName(row.getString("node_name"));
		node.setNodeStatus(row.getString("node_status"));
		node.setNodeLatitude(row.getString("node_latitude"));
		node.setNodeLongitude(row.getString("node_longitude"));
		node.setInstallationDate(row.getDate("installation_date"));
		node.setLastMaintainedDate(row.getDate("last_maintained_date"));
		node.setNodeAddress(row.getString("node_address"));
		node.setNodeCity(row.getString("node_city"));
		node.setNodeState(row.getString("node_state"));
		node.setNodeZip(row.getString("node_zip"));
		node.setInstalledBy(row.getString("installed_by"));
		node.setLastMaintainedBy(row.getString("last_maintained_by"));
		
		return node;
	   }
		
		
	}