package smartstreet.dao;

import java.util.List;
import smartstreet.model.SmartNode;

public interface ISmartNodeDao {
	/**
	 * Add snode
	 * @param snode
	 * @throws Exception 
	 */
	public void addSmartNode(SmartNode snode) throws Exception;
	
	/**
	 * Get List of snodes
	 * @return List of snodes
	 */
	public List<SmartNode> getAllSmartNodes() ;
	
	/**
	 * Get SmartNode by Id
	 * @param snodeId
	 * @return
	 */
	public SmartNode getSmartNodeById(int snodeId);
	
	/**
	 * Update snode
	 * @param snode
	 */
	public void updateSmartNode(SmartNode snode);
	
	/**
	 * Delete snode
	 * @param snode
	 */
	public void deleteSmartNode(int snodeId);

	/**
	 * Checks if the snode with same name exists or not
	 * @param snodename
	 * @return
	 */
	boolean isExists(String snodename);

}
