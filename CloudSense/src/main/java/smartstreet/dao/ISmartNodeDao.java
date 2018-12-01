package smartstreet.dao;

import java.util.List;

import smartstreet.model.Sensor;
import smartstreet.model.SmartNode;

public interface ISmartNodeDao {
	
	/**
	 * Add smartNode
	 * @param smartNode
	 */
	public void addSmartNode(SmartNode smartNode) ;
	
	/**
	 * Get List of smartNodes
	 * @return List of smartNodes
	 */
	public List<SmartNode> getAllSmartNodes();
	
	/**
	 * Get SmartNode by Id
	 * @param smartNodeId
	 * @return
	 */
	public SmartNode getSmartNodeById(int smartNodeId) ;
	
	/**
	 * Update smartNode
	 * @param smartNode
	 */
	public void updateSmartNode(SmartNode smartNode) ;
	
	/**
	 * Delete smartNode
	 * @param smartNode
	 */
	public void deleteSmartNode(int smartNodeId);
	/**
	 * 
	 * @param smartNodeId
	 */
	public void deleteSmartNodeMapping(int smartNodeId);
	
	/**
	 * Checks if the smartNode with same name exists or not
	 * @param smartNodename
	 * @return
	 */
	public boolean isExists(String smartNodename);
	/**
	 * 
	 * @param smartNodeId
	 * @param sensorids
	 */
	public void addSmartNodeSensorMapping(int smartNodeId, List<Integer> sensorids) ;
	/**
	 * 
	 * @param smartNodeId
	 * @return
	 */
	public List<Sensor> getMappedSensors(int smartNodeId) ;
	/**
	 * 
	 * @param smartNodeId
	 * @return
	 */
	public int getMappedSensorCount(int smartNodeId);

	/**
	 * 
	 * @param nodeid
	 * @return
	 */
	public List<Sensor> getUnMappedSensorNames(int nodeid);


}
