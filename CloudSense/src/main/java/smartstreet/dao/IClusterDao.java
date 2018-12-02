package smartstreet.dao;

import java.util.List;

import smartstreet.model.Cluster;
import smartstreet.model.SmartNode;

public interface IClusterDao {
	
	/**
	 * Add cluster
	 * @param cluster
	 */
	public void addCluster(Cluster cluster) ;
	
	/**
	 * Get List of clusters
	 * @return List of clusters
	 */
	public List<Cluster> getAllClusters();
	
	/**
	 * Get Cluster by Id
	 * @param clusterId
	 * @return
	 */
	public Cluster getClusterById(int clusterId) ;
	
	/**
	 * Update cluster
	 * @param cluster
	 */
	public void updateCluster(Cluster cluster) ;
	
	/**
	 * Delete cluster
	 * @param cluster
	 */
	public void deleteCluster(int clusterId);
	
	/**
	 * Checks if the cluster with same name exists or not
	 * @param clustername
	 * @return
	 */
	public boolean isExists(String clustername);
	
	public void addClusterSmartNodeMapping(int clusterId, List<Integer> sensorids) ;	   
	public List<SmartNode> getMappedSmartNodes(int clusterId) ;
	public int getMappedSmartNodeCount(int clusterId) ;
	public List<SmartNode> getUnmappedSmartNodeNames(int clusterId) ;

	public void deleteClusterMapping(int clusterId);


}
