package smartstreet.dao;

import java.util.List;

import smartstreet.model.Cluster;


public interface IClusterDao {

	/**
	 * Add Cluster
	 * @param cluster
	 * @throws Exception 
	 */
	public void addCluster(Cluster cluster) throws Exception;
	
	/**
	 * Get List of clusters
	 * @return List of clusters
	 */
	public List<Cluster> getAllClusters() ;
	
	/**
	 * Get Cluster by Id
	 * @param clusterId
	 * @return
	 */
	public Cluster getClusterById(int clusterId);
	
	/**
	 * Update cluster
	 * @param cluster
	 */
	public void updateCluster(Cluster cluster);
	
	/**
	 * Delete cluster
	 * @param cluster
	 */
	public void deleteCluster(int clusterId);

}
