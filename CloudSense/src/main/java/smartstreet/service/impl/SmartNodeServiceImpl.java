package smartstreet.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smartstreet.dao.ISmartNodeDao;
import smartstreet.model.Sensor;
import smartstreet.model.SmartNode;
import smartstreet.service.ISmartNodeService;
import smartstreet.utiliy.GoogleMapHelper;

@Service
public class SmartNodeServiceImpl implements ISmartNodeService{
	
	@Autowired
	public ISmartNodeDao smartNodeDao;
	private final static Logger logger = Logger.getLogger(SmartNodeServiceImpl.class.getName());

	@Override
	public synchronized boolean addSmartNode(SmartNode smartNode) {
    			String[] location;
				try {
					String response = GoogleMapHelper.getGeoLocation(smartNode.getNodeAddress()+ ","+smartNode.getNodeCity()+","
										+smartNode.getNodeZip());
					location = GoogleMapHelper.getLatLongPositions(response);
					if(location!=null) {
						smartNode.setNodeLatitude(location[0]);
						smartNode.setNodeLongitude(location[1]);
	    			}
				} catch (Exception e) {
					logger.error("cannot find address::::");
				}
    		
				smartNodeDao.addSmartNode(smartNode);
  	      	return true;
        
		
	}

	@Override
	public List<SmartNode> getAllSmartNodes() {
		List<SmartNode> list = smartNodeDao.getAllSmartNodes();
		for(SmartNode node:list) {
			node.setSensorIdCount(smartNodeDao.getMappedSensorCount(node.getId())) ;
		}
		return list;
	}

	@Override
	public SmartNode getSmartNodeById(int smartNodeId) {
		
		SmartNode node = smartNodeDao.getSmartNodeById(smartNodeId);
		node.setSensorIdCount(smartNodeDao.getMappedSensorCount(node.getId())) ;
		return node;
	}

	@Override
	public synchronized boolean updateSmartNode(SmartNode smartNode) {
		String[] location;
		try {
			if(smartNode.getId()!=0) {
				SmartNode persistedNode = smartNodeDao.getSmartNodeById(smartNode.getId());
				if(persistedNode!=null) {
					persistedNode.setNodeAddress(smartNode.getNodeAddress());
					persistedNode.setNodeCity(smartNode.getNodeCity());
					persistedNode.setNodeState(smartNode.getNodeState());
					persistedNode.setNodeStatus(smartNode.getNodeStatus());
					persistedNode.setNodeZip(smartNode.getNodeZip());
					String response = GoogleMapHelper.getGeoLocation(smartNode.getNodeAddress()+ ","+smartNode.getNodeCity()+","
							+smartNode.getNodeZip());
						location = GoogleMapHelper.getLatLongPositions(response);
						if(location!=null) {
							persistedNode.setNodeLatitude(location[0]);
							persistedNode.setNodeLongitude(location[1]);
						}
					smartNodeDao.updateSmartNode(persistedNode);
					return true;
				}
			}
		}catch (Exception e) {
			logger.error("cannot find address::::");
		}
		
		return false;
	}

	@Override
	public void deleteSmartNode(int smartNodeId) {
		try {
			smartNodeDao.deleteSmartNodeMapping(smartNodeId);
			smartNodeDao.deleteSmartNode(smartNodeId);
		}catch(Exception e) {
			
		}
		
		
	}

	@Override
	public boolean isExists(String smartNodename) {
		return smartNodeDao.isExists(smartNodename);
	}

	@Override
	public void addSmartNodeSensorMapping(int smartNodeId, List<Integer> sensorids) {
		smartNodeDao.addSmartNodeSensorMapping(smartNodeId, sensorids);
		
	}

	@Override
	public List<Sensor> getMappedSensors(int smartNodeId) {
		return smartNodeDao.getMappedSensors(smartNodeId);
	}
	
	public List<Sensor> getUnMappedSensorNames(int nodeid){
		return smartNodeDao.getUnMappedSensorNames(nodeid);
	}
}
