package smartstreet.model;
import java.sql.Date;
/**
 * Smart Node Model class
 * @author priyankasinghal
 *
 */
public class SmartNode {
	private String id;
	private String nodeName ;
	private String nodeDesc ;
	private int nodeStatus  ;
	private String nodeLatitude ;
	private String nodeLongitude ;
	private String nodeAddress ;
	private String nodeCity ;
	private String nodeState ;
	private String nodeCountry ;
	private String nodeZip ;
	private String installedBy ;
	private Date installationDate  ;
	private String lastMaintainedBy ;
	private Date lastMaintainedDate ;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	public String getNodeDesc() {
		return nodeDesc;
	}
	public void setNodeDesc(String nodeDesc) {
		this.nodeDesc = nodeDesc;
	}
	public int getNodeStatus() {
		return nodeStatus;
	}
	public void setNodeStatus(int nodeStatus) {
		this.nodeStatus = nodeStatus;
	}
	public String getNodeLatitude() {
		return nodeLatitude;
	}
	public void setNodeLatitude(String nodeLatitude) {
		this.nodeLatitude = nodeLatitude;
	}
	public String getNodeLongitude() {
		return nodeLongitude;
	}
	public void setNodeLongitude(String nodeLongitude) {
		this.nodeLongitude = nodeLongitude;
	}
	public String getNodeAddress() {
		return nodeAddress;
	}
	public void setNodeAddress(String nodeAddress) {
		this.nodeAddress = nodeAddress;
	}
	public String getNodeCity() {
		return nodeCity;
	}
	public void setNodeCity(String nodeCity) {
		this.nodeCity = nodeCity;
	}
	public String getNodeState() {
		return nodeState;
	}
	public void setNodeState(String nodeState) {
		this.nodeState = nodeState;
	}
	public String getNodeCountry() {
		return nodeCountry;
	}
	public void setNodeCountry(String nodeCountry) {
		this.nodeCountry = nodeCountry;
	}
	public String getNodeZip() {
		return nodeZip;
	}
	public void setNodeZip(String nodeZip) {
		this.nodeZip = nodeZip;
	}
	public String getInstalledBy() {
		return installedBy;
	}
	public void setInstalledBy(String installedBy) {
		this.installedBy = installedBy;
	}
	public Date getInstallationDate() {
		return installationDate;
	}
	public void setInstallationDate(Date installationDate) {
		this.installationDate = installationDate;
	}
	public String getLastMaintainedBy() {
		return lastMaintainedBy;
	}
	public void setLastMaintainedBy(String lastMaintainedBy) {
		this.lastMaintainedBy = lastMaintainedBy;
	}
	public Date getLastMaintainedDate() {
		return lastMaintainedDate;
	}
	public void setLastMaintainedDate(Date lastMaintainedDate) {
		this.lastMaintainedDate = lastMaintainedDate;
	}
	
	

}
