package smartstreet.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smartstreet.dao.IClusterDao;
import smartstreet.model.Cluster;
import smartstreet.model.SmartNode;
import smartstreet.service.IClusterService;
import smartstreet.utiliy.GoogleMapHelper;

@Service
public class ClusterServiceImpl implements IClusterService {
	
	@Autowired
	public IClusterDao clusterDao;
	private final static Logger logger = Logger.getLogger(ClusterServiceImpl.class.getName());


	@Override
	public boolean addCluster(Cluster cluster) {
    		String[] location;
				try {
					String response = GoogleMapHelper.getGeoLocation(cluster.getClusterAddress()+ ","+cluster.getClusterCity()+","
										+cluster.getClusterZip());
					location = GoogleMapHelper.getLatLongPositions(response);
					if(location!=null) {
						cluster.setClusterLatitude(location[0]);
						cluster.setClusterLongitude(location[1]);
	    			}
				} catch (Exception e) {
					logger.error("cannot find address::::");
				}
    		
				clusterDao.addCluster(cluster);
  	      	return true;
	}

	@Override
	public List<Cluster> getAllClusters() {
		List<Cluster> list = clusterDao.getAllClusters();
		for(Cluster cluster:list) {
			cluster.setSmartnodecount(clusterDao.getMappedSmartNodeCount(cluster.getId())) ;
		}
		return list;
	}
	
	@Override
	public List<Cluster> getAllClusters(String streetname) {
		List<Cluster> list = clusterDao.getAllClusters(streetname);
		for(Cluster cluster:list) {
			cluster.setSmartnodecount(clusterDao.getMappedSmartNodeCount(cluster.getId())) ;
		}
		return list;
	}

	@Override
	public Cluster getClusterById(int clusterId) {
		Cluster cluster =  clusterDao.getClusterById(clusterId);
		cluster.setSmartnodecount(clusterDao.getMappedSmartNodeCount(cluster.getId()));
		return cluster;
	}

	@Override
	public void updateCluster(Cluster cluster) {
		clusterDao.updateCluster(cluster);
		
	}

	@Override
	public void deleteCluster(int clusterId) {
		try {
			clusterDao.deleteClusterMapping(clusterId);
			clusterDao.deleteCluster(clusterId);
		}catch(Exception e) {
			
		}
		
	}

	@Override
	public boolean isExists(String clustername) {
		return clusterDao.isExists(clustername);
	}

	@Override
	public void addClusterSmartNodeMapping(int clusterId, List<Integer> sensorids) {
		clusterDao.addClusterSmartNodeMapping(clusterId, sensorids);
		
	}

	@Override
	public List<SmartNode> getMappedSmartNodes(int clusterId) {
		return clusterDao.getMappedSmartNodes(clusterId);
	}
	
	public List<SmartNode> getUnmappedSmartNodeNames(int clusterId){
		return clusterDao.getUnmappedSmartNodeNames(clusterId);
	}
}
