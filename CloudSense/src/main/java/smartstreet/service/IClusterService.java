package smartstreet.service;

import java.util.List;

import smartstreet.model.Cluster;
import smartstreet.model.SmartNode;

public interface IClusterService {
	
	/**
	 * Add cluster
	 * @param cluster
	 */
	public boolean addCluster(Cluster cluster) ;
	
	/**
	 * Get List of clusters
	 * @return List of clusters
	 */
	public List<Cluster> getAllClusters();
	
	/**
	 * Get Cluster by Id
	 * @param id
	 * @return
	 */
	public Cluster getClusterById(int id) ;
	
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
	public List<SmartNode> getUnmappedSmartNodeNames(int clusterId);

	List<Cluster> getAllClusters(String streetname);

}
