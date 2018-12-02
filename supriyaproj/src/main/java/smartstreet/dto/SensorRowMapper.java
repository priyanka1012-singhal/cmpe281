package smartstreet.dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.RowMapper;

import smartstreet.model.Sensor;

/**
 * Row Mapper class for Sensor
 * Maps DB data to bean class
 */
@PropertySource("classpath:globalconstants.properties")
public class SensorRowMapper implements RowMapper<Sensor> {
	
		public Sensor mapRow(ResultSet row, int rowNum) throws SQLException {
		Sensor sensor = new Sensor();
		sensor.setId(row.getInt("sensorId"));
		sensor.setSensorName(row.getString("sensorName"));
		sensor.setSensorDesc(row.getString("sensorDesc"));
		sensor.setSensorStatus(row.getString("sensorStatus"));
		sensor.setSensorType(row.getString("sensorType"));
		sensor.setSensorFrequency(row.getString("sensorFrequency"));
		sensor.setSensorProviderName(row.getString("sensorProviderName"));
		sensor.setSensorStartTime(row.getDate("sensorStartTime"));
		sensor.setSensorEndTime(row.getDate("sensorEndTime"));
		sensor.setSensorLatitude(row.getString("sensorLatitude"));
		sensor.setSensorLongitude(row.getString("sensorLongitude"));
		sensor.setSensorAddress(row.getString("sensorAddress"));
		sensor.setSensorCity(row.getString("sensorCity"));
		sensor.setSensorState(row.getString("sensorState"));
		sensor.setSensorCountry(row.getString("sensorCountry"));
		sensor.setSensorZip(row.getString("sensorZip"));
		sensor.setInstalledBy(row.getString("installedBy"));
		sensor.setInstallationDate(row.getDate("installationDate"));
		sensor.setLastMaintainedBy(row.getString("lastMaintainedBy"));
		sensor.setLastMaintainedDate(row.getDate("lastMaintainedDate"));
		return sensor;
	   }
	}