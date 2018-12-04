package smartstreet.model;

import java.util.Date;
/**
 * Sensor Model class
 * @author priyankasinghal
 *
 */
public class Sensor {
	
	private int id;
	private String deviceid;
	private String sensorName ;
	private String sensorDesc ;
	private String sensorStatus  ;
	private String sensorType ;
	private String sensorFrequency ;
	private String sensorProviderName ;
	private Date sensorStartTime ;
	private Date sensorEndTime  ;
	private String sensorDataQueueName ;
	private String sensorDataFormat ;
	private String sensorLatitude ;
	private String sensorLongitude ;
	private String sensorAddress ;
	private String sensorCity ;
	private String sensorState ;
	private String sensorCountry ;
	private String sensorZip ;
	private String sensorBlock;
	public String getSensorBlock() {
		return sensorBlock;
	}
	public void setSensorBlock(String sensorBlock) {
		this.sensorBlock = sensorBlock;
	}
	private String installedBy ;
	private Date installationDate  ;
	private String lastMaintainedBy ;
	private Date lastMaintainedDate ;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeviceid() {
		return deviceid;
	}
	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}
	public String getSensorName() {
		return sensorName;
	}
	public void setSensorName(String sensorName) {
		this.sensorName = sensorName;
	}
	public String getSensorDesc() {
		return sensorDesc;
	}
	public void setSensorDesc(String sensorDesc) {
		this.sensorDesc = sensorDesc;
	}

	public String getSensorStatus() {
		return sensorStatus;
	}
	public void setSensorStatus(String sensorStatus) {
		this.sensorStatus = sensorStatus;
	}
	public String getSensorType() {
		return sensorType;
	}
	public void setSensorType(String sensorType) {
		this.sensorType = sensorType;
	}
	public String getSensorFrequency() {
		return sensorFrequency;
	}
	public void setSensorFrequency(String sensorFrequency) {
		this.sensorFrequency = sensorFrequency;
	}
	public String getSensorProviderName() {
		return sensorProviderName;
	}
	public void setSensorProviderName(String sensorProviderName) {
		this.sensorProviderName = sensorProviderName;
	}
	public Date getSensorStartTime() {
		return sensorStartTime;
	}
	public void setSensorStartTime(Date sensorStartTime) {
		this.sensorStartTime = sensorStartTime;
	}
	public Date getSensorEndTime() {
		return sensorEndTime;
	}
	public void setSensorEndTime(Date sensorEndTime) {
		this.sensorEndTime = sensorEndTime;
	}
	public String getSensorDataQueueName() {
		return sensorDataQueueName;
	}
	public void setSensorDataQueueName(String sensorDataQueueName) {
		this.sensorDataQueueName = sensorDataQueueName;
	}
	public String getSensorDataFormat() {
		return sensorDataFormat;
	}
	public void setSensorDataFormat(String sensorDataFormat) {
		this.sensorDataFormat = sensorDataFormat;
	}
	public String getSensorLatitude() {
		return sensorLatitude;
	}
	public void setSensorLatitude(String sensorLatitude) {
		this.sensorLatitude = sensorLatitude;
	}
	public String getSensorLongitude() {
		return sensorLongitude;
	}
	public void setSensorLongitude(String sensorLongitude) {
		this.sensorLongitude = sensorLongitude;
	}
	public String getSensorAddress() {
		return sensorAddress;
	}
	public void setSensorAddress(String sensorAddress) {
		this.sensorAddress = sensorAddress;
	}
	public String getSensorCity() {
		return sensorCity;
	}
	public void setSensorCity(String sensorCity) {
		this.sensorCity = sensorCity;
	}
	public String getSensorState() {
		return sensorState;
	}
	public void setSensorState(String sensorState) {
		this.sensorState = sensorState;
	}
	public String getSensorCountry() {
		return sensorCountry;
	}
	public void setSensorCountry(String sensorCountry) {
		this.sensorCountry = sensorCountry;
	}
	public String getSensorZip() {
		return sensorZip;
	}
	public void setSensorZip(String sensorZip) {
		this.sensorZip = sensorZip;
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
