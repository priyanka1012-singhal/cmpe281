package smartstreet.dto;

import java.util.List;

import smartstreet.model.Cluster;
import smartstreet.model.Sensor;
import smartstreet.model.SmartNode;
/**
 * 
 * @author priyankasinghal
 *
 */
public class ResponseDto {
	
	List<SmartNode> smartnodes ;
	List<Sensor> sensors;
	List<Cluster> clusters;
	String name;
	
	public List<SmartNode> getSmartnodes() {
		return smartnodes;
	}
	public void setSmartnodes(List<SmartNode> smartnodes) {
		this.smartnodes = smartnodes;
	}
	public List<Sensor> getSensors() {
		return sensors;
	}
	public void setSensors(List<Sensor> sensors) {
		this.sensors = sensors;
	}
	public List<Cluster> getClusters() {
		return clusters;
	}
	public void setClusters(List<Cluster> clusters) {
		this.clusters = clusters;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
