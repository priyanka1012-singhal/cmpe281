package smartstreet.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import smartstreet.model.Cluster;

/**
 * Row Mapper class for Cluster
 * Maps DB data to bean class
 * @author priyankasinghal
 *
 */

public class ClusterRowMapper implements RowMapper<Cluster> {
	
		
		
		public Cluster mapRow(ResultSet row, int rowNum) throws SQLException {
		Cluster node = new Cluster();
		node.setId(row.getInt("cluster_id"));
		node.setClusterName(row.getString("cluster_name"));
		node.setClusterStatus(row.getInt("cluster_status"));
		node.setClusterLatitude(row.getString("cluster_latitude"));
		node.setClusterLongitude(row.getString("cluster_longitude"));
		node.setInstallationDate(row.getDate("installation_date"));
		node.setLastMaintainedDate(row.getDate("last_maintained_date"));
		node.setClusterAddress(row.getString("cluster_address"));
		node.setClusterCity(row.getString("cluster_city"));
		node.setClusterState(row.getString("cluster_state"));
		node.setClusterZip(row.getString("cluster_zip"));
		
		return node;
	   }
		
		
	}