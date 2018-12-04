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

import smartstreet.dao.IClusterDao;
import smartstreet.dto.ClusterRowMapper;
import smartstreet.dto.SmartNodeRowMapper;
import smartstreet.model.Cluster;
import smartstreet.model.SmartNode;
/**
 * Cluster Dao Class
 * @author priyankasinghal
 *
 */
@Transactional
@Repository
public class ClusterDaoImpl implements IClusterDao{
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Override
	public void addCluster(Cluster cluster) {
		String sql = "INSERT INTO cluster_node ("
				+ "cluster_name, "
		   		+ "cluster_status,"
		   		+ "cluster_latitude,"
		   		+ "cluster_longitude,"
		   		+ "cluster_address,"
		   		+ "cluster_city,"
		   		+ "cluster_state,"
		   		+ "cluster_zip,"
		   		+ "installed_by,"
		   		+ "installation_date,"
		   		+ "last_maintained_by,"
		   		+ "last_maintained_date"
		   		+ ") values (?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?)";
		   jdbcTemplate.update(sql,  
				   cluster.getClusterName(),
				   cluster.getClusterStatus(),
				   cluster.getClusterLatitude(),
				   cluster.getClusterLongitude(),
				   cluster.getClusterAddress(),
				   cluster.getClusterCity(),
				   cluster.getClusterState(),
				   cluster.getClusterZip(),
				   cluster.getInstalledBy(),
				   cluster.getInstallationDate(),
				   cluster.getLastMaintainedBy(),
				   cluster.getLastMaintainedDate()
				   );
		
	}

	@Override
	public List<Cluster> getAllClusters() {
		String sql = "SELECT *"
   		+ " FROM cluster_node cluster";
   RowMapper<Cluster> rowMapper = new ClusterRowMapper();		
   return this.jdbcTemplate.query(sql, rowMapper);
	}
	
	@Override
	public List<Cluster> getAllClusters(String streetname) {
		String sql = "SELECT *"
   		+ " FROM cluster_node cluster where cluster_address like ? OR cluster_zip like ? OR cluster_block like ?";
   RowMapper<Cluster> rowMapper = new ClusterRowMapper();		
   return this.jdbcTemplate.query(sql, rowMapper,"%"+streetname+"%","%"+streetname+"%","%"+streetname+"%");
	}

	@Override
	public Cluster getClusterById(int clusterId) {
		String sql = "SELECT *" 
   		+ " FROM cluster_node cluster where  cluster.cluster_id = ? ";
	RowMapper<Cluster> rowMapper = new ClusterRowMapper();		
	Cluster smartNode = jdbcTemplate.queryForObject(sql, rowMapper, clusterId);
	return smartNode;
	}

	/*@Override
	public void updateCluster(Cluster cluster) {
		String sql = "UPDATE cluster_node SET cluster_status=? WHERE cluster_id=?";
	    jdbcTemplate.update(sql, cluster.getClusterStatus(), cluster.getId());
		
	}*/
	@Override
	public void updateCluster(Cluster cluster) {
		MapHelper gMapHelper = new MapHelper();
		String response = gMapHelper.getGeoLocation(cluster.getClusterAddress() + "," +cluster.getClusterCity()+","+cluster.getClusterZip());
		String[] longlat = gMapHelper.parseLocationResponse(response);	
	
		String sql = "UPDATE cluster_node SET cluster_name = ?,cluster_desc=?, cluster_status=?, cluster_latitude=?,"
				+ "cluster_longitude=? , cluster_address=?, cluster_city=?, cluster_state=?,cluster_country=?,"
	    		+ "cluster_zip=? , last_maintained_by=? , last_maintained_date=? WHERE cluster_id=?";
	    jdbcTemplate.update(sql, cluster.getClusterName(), cluster.getClusterDesc(), cluster.getClusterStatus(),
	    		longlat[0],  longlat[1], cluster.getClusterAddress(), 
	    		cluster.getClusterCity(),cluster.getClusterState(), cluster.getClusterCountry(), cluster.getClusterZip(),
	    		"XYZ", cluster.getLastMaintainedDate(),  cluster.getId());		
		
	}

	@Override
	public void deleteCluster(int clusterId) {
		String sql = "DELETE FROM cluster_node WHERE cluster_id=?";
		jdbcTemplate.update(sql, clusterId);
		
	}

	@Override
	public boolean isExists(String clustername) {
		String sql = "SELECT count(*) FROM cluster_node WHERE cluster_name = ? ";
		int count = jdbcTemplate.queryForObject(sql, Integer.class, clustername);
		if(count == 0) 
    		 return false;
		else 
			return true;
	}

	@Override
	public void addClusterSmartNodeMapping(int clusterId, List<Integer> nodeids) {
		String sql = "INSERT INTO cluster_node_mapping (cluster_id, "
		   		+ "node_id,"
		   		+ "created_date,"
		   		+ "created_by"
		   		+ ") values (?, ?, ?,?)";
		   jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
				
				@Override
				public void setValues(PreparedStatement ps, int i) throws SQLException {
					int nodeid = nodeids.get(i);
					ps.setInt(1, clusterId);
					ps.setInt(2, nodeid);
					ps.setDate(3, new java.sql.Date(Calendar.getInstance().getTime().getTime()) );
					ps.setInt(4, 1 );
				}
						
				@Override
				public int getBatchSize() {
					return nodeids.size();
				}
			  });	
		
	}

	@Override
	public List<SmartNode> getMappedSmartNodes(int clusterId) {
		 String sql = "SELECT map.node_id, node.node_name, "
			   		+ "node.node_status,"
			   		+ "node.node_latitude,"
			   		+ "node.node_longitude,"
			   		+ "node.node_address,"
			   		+ "node.node_city,"
			   		+ "node.node_state,"
			   		+ "node.node_zip,"
			   		+ "node.installed_by,"
			   		+ "node.installation_date,"
			   		+ "node.last_maintained_by,"
			   		+ "node.last_maintained_date"
			   		+ " FROM smart_node node,cluster_node_mapping map  where  map.cluster_id = ? AND map.node_id=node.node_id ";
		  RowMapper<SmartNode> rowMapper = new SmartNodeRowMapper();		
		   return this.jdbcTemplate.query(sql, rowMapper, clusterId);
	}
	
	public int getMappedSmartNodeCount(int clusterId) {
		String sql = "SELECT count(node_id) FROM cluster_node_mapping WHERE cluster_id =  ?";
		return jdbcTemplate.queryForObject(sql, Integer.class, clusterId);
	}
	
	
	
		
	public List<SmartNode> getUnmappedSmartNodeNames(int clusterId) {
					
		String sql = "SELECT * FROM smart_node node WHERE node.node_id NOT IN (SELECT map.node_id FROM cluster_node_mapping map"+
				   " WHERE map.cluster_id=?)";
				   RowMapper<SmartNode> rowMapper = new SmartNodeRowMapper();		
				   return this.jdbcTemplate.query(sql, rowMapper, clusterId);
	}
	
	@Override
	public void deleteClusterMapping(int clusterId) {
		//Delete from smart node - cluster mapping
		String sql = "DELETE FROM cluster_node_mapping WHERE cluster_id=?";
		jdbcTemplate.update(sql, clusterId);
		
	}

}
