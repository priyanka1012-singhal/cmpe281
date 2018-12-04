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
import smartstreet.dao.IClusterDao;
import smartstreet.dto.ClusterRowMapper;
import smartstreet.model.Cluster;



@Transactional
@Repository
public class ClusterDaoImpl implements IClusterDao{
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	public void addCluster(Cluster cluster) throws Exception {
		GoogleMapHelper gMapHelper = new GoogleMapHelper();
		String city=cluster.getClusterCity();
		String Zip = cluster.getClusterZip();
		String address = cluster.getClusterAddress();	
		String response = gMapHelper.getGeoLocation(address + "," +city+","+Zip);
		String[] result = gMapHelper.parseLocationResponse(response);	
		cluster.setClusterLatitude(result[0]);
		cluster.setClusterLongitude(result[1]);
		cluster.setInstallationDate(new Date());
		cluster.setInstalledBy("xyz");
	   cluster.setInstalledBy("supriyajain");
	   String sql = "INSERT INTO cluster_node (cluster_id, cluster_name, cluster_desc , "   		
	   		+ "cluster_latitude, cluster_longitude, cluster_address,cluster_city, cluster_state, "
	   		+ "cluster_country, cluster_zip, installed_by, installation_date, last_maintained_by,"
	   		+ "last_maintained_date) values (?, ?, ? , ? ,? ,?, ?, ? , ? ,? ,?, ?, ? , ? )";
	   jdbcTemplate.update(sql, cluster.getId(), cluster.getClusterName(),
		   cluster.getClusterDesc(), cluster.getClusterLatitude(), cluster.getClusterLongitude(), cluster.getClusterAddress(),
		   cluster.getClusterCity(), cluster.getClusterState(), cluster.getClusterCountry(),
		   cluster.getClusterZip(),cluster.getInstalledBy(), cluster.getInstallationDate(),
		   cluster.getLastMaintainedBy(), cluster.getLastMaintainedDate());				
	}
	public List<Cluster> getAllClusters() {
	    String sql = "SELECT * FROM cluster_node";
	    List<Cluster> clusterList = jdbcTemplate.query(sql, new RowMapper<Cluster>() {
	 
	        @Override
	        public Cluster mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Cluster scluster = new Cluster();
	 
	            scluster.setId(rs.getInt("cluster_id"));
	            scluster.setClusterName(rs.getString("cluster_name"));
	            scluster.setClusterDesc(rs.getString("cluster_desc"));
	            scluster.setClusterAddress(rs.getString("cluster_address"));
	            scluster.setClusterLatitude(rs.getString("cluster_latitude"));
	            scluster.setClusterLongitude(rs.getString("cluster_longitude"));
	            scluster.setInstallationDate(rs.getDate("installation_date"));
	            return scluster;
	        }
	 
	    });
	 
	    return clusterList;
	}
	@Override
	public Cluster getClusterById(int clusterId) {
		String sql = "SELECT * FROM cluster_node WHERE cluster_id = ?";
		RowMapper<Cluster> rowMapper = new ClusterRowMapper();		
		Cluster article = jdbcTemplate.queryForObject(sql, rowMapper, clusterId);
		return article;		
	}
	@Override
	public void updateCluster(Cluster cluster) {
		GoogleMapHelper gMapHelper = new GoogleMapHelper();
		String response = gMapHelper.getGeoLocation(cluster.getClusterAddress() + "," +cluster.getClusterCity()+","+cluster.getClusterZip());
		String[] longlat = gMapHelper.parseLocationResponse(response);	
	
		String sql = "UPDATE cluster_node SET cluster_name = ?,cluster_desc=?, cluster_status=?, cluster_latitude=?,"
				+ "cluster_longitude=? , cluster_address=?, cluster_city=?, cluster_state=?,cluster_country=?,"
	    		+ "cluster_zip=? , last_maintained_by=? , last_maintained_date=? WHERE cluster_id=?";
	    jdbcTemplate.update(sql, cluster.getClusterName(), cluster.getClusterDesc(), cluster.getClusterStatus(),
	    		longlat[0],  longlat[1], cluster.getClusterAddress(), 
	    		cluster.getClusterCity(),cluster.getClusterState(), cluster.getClusterCountry(), cluster.getClusterZip(),
	    		"XYZ", new Date(),  cluster.getId());		
		
	}
	@Override
	public void deleteCluster(int cluster_node) {
		String sql = "DELETE FROM cluster_node WHERE cluster_id=?";
		jdbcTemplate.update(sql, cluster_node);
		
	}	

}
