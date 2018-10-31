package smartstreet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smartstreet.dao.IClusterDao;
import smartstreet.service.IClusterService;

@Service
public class ClusterServiceImpl implements IClusterService {
	
	@Autowired
	public IClusterDao clusterDao;
}
