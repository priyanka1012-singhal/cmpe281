package smartstreet.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.RowMapper;
import smartstreet.model.SmartNode;

@PropertySource("classpath:globalconstants.properties")
public class SmartNodeRowMapper implements RowMapper<SmartNode> {

	@Override
	public SmartNode mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		SmartNode smNode = new SmartNode();
		smNode.setId(rs.getInt("node_id"));
		smNode.setNodeName(rs.getString("node_name"));
		smNode.setNodeDesc(rs.getString("node_desc"));
		smNode.setNodeStatus(rs.getInt("node_status"));
		smNode.setNodeLongitude(rs.getString("node_longitude"));
		smNode.setNodeLatitude(rs.getString("node_latitude"));
		smNode.setNodeAddress(rs.getString("node_address"));
		smNode.setNodeCity(rs.getString("node_city"));
		smNode.setNodeState(rs.getString("node_state"));
		smNode.setNodeZip(rs.getString("node_zip"));
		smNode.setNodeCountry(rs.getString("node_country"));
		smNode.setInstalledBy(rs.getString("installed_by"));
		smNode.setInstallationDate(rs.getDate("installation_date"));
		smNode.setLastMaintainedBy(rs.getString("last_maintained_by"));
		smNode.setInstallationDate(rs.getDate("last_maintainance_date"));
		
		return smNode;
	
	}

}
