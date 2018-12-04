package smartstreet.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.RowMapper;
import smartstreet.model.Cluster;

@PropertySource("classpath:globalconstants.properties")
public class ClusterRowMapper implements RowMapper<Cluster> {

	@Override
	public Cluster mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Cluster smCluster = new Cluster();
		smCluster.setId(rs.getInt("cluster_id"));
		smCluster.setClusterName(rs.getString("cluster_name"));
		smCluster.setClusterDesc(rs.getString("cluster_desc"));
		smCluster.setClusterStatus(rs.getInt("cluster_status"));
		smCluster.setClusterLongitude(rs.getString("cluster_longitude"));
		smCluster.setClusterLatitude(rs.getString("cluster_latitude"));
		smCluster.setClusterAddress(rs.getString("cluster_address"));
		smCluster.setClusterCity(rs.getString("cluster_city"));
		smCluster.setClusterState(rs.getString("cluster_state"));
		smCluster.setClusterZip(rs.getString("cluster_zip"));
		smCluster.setClusterCountry(rs.getString("cluster_country"));
		smCluster.setInstalledBy(rs.getString("installed_by"));
		smCluster.setInstallationDate(rs.getDate("installation_date"));
		smCluster.setLastMaintainedBy(rs.getString("last_maintained_by"));
		smCluster.setInstallationDate(rs.getDate("last_maintained_date"));
		
		return smCluster;
	
	}

}
