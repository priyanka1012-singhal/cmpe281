package smartstreet.service;

import java.util.List;

import smartstreet.model.Sensor;
import smartstreet.model.SmartNode;

public interface ISmartNodeService {
	
	/**
	 * Add smartNode
	 * @param smartNode
	 */
	public boolean addSmartNode(SmartNode smartNode) ;
	
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
	 * @return 
	 */
	public boolean updateSmartNode(SmartNode smartNode) ;
	
	/**
	 * Delete smartNode
	 * @param smartNode
	 */
	public void deleteSmartNode(int smartNodeId);
	
	/**
	 * Checks if the smartNode with same name exists or not
	 * @param smartNodename
	 * @return
	 */
	public boolean isExists(String smartNodename);
	
	public void addSmartNodeSensorMapping(int smartNodeId, List<Integer> sensorids) ;	   
	public List<Sensor> getMappedSensors(int smartNodeId) ;

	public List<Sensor> getUnMappedSensorNames(int id);

	List<SmartNode> getAllSmartNodes(String streetname);

}
