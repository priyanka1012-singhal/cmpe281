package smartstreet.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import smartstreet.model.Sensor;

/**
 * Row Mapper class for Sensor
 * Maps DB data to bean class
 * @author priyankasinghal
 *
 */

public class SensorRowMapper implements RowMapper<Sensor> {
	
		
		
		public Sensor mapRow(ResultSet row, int rowNum) throws SQLException {
		Sensor sensor = new Sensor();
		sensor.setId(row.getInt("sensor_id"));
		sensor.setSensorName(row.getString("sensor_name"));
		sensor.setSensorStatus(row.getString("sensor_status"));
		sensor.setSensorDesc(row.getString("sensor_desc"));
		sensor.setSensorType(row.getString("sensor_type"));
		sensor.setDeviceType(row.getString("device_type"));
		sensor.setDeviceid(row.getString("device_id"));
		sensor.setSensorLatitude(row.getString("sensor_latitude"));
		sensor.setSensorLongitude(row.getString("sensor_longitude"));
		sensor.setInstallationDate(row.getDate("installation_date"));
		sensor.setLastMaintainedDate(row.getDate("last_maintained_date"));
		sensor.setInstalledBy(row.getString("installed_by"));
		sensor.setLastMaintainedBy(row.getString("last_maintained_by"));
		sensor.setSensorAddress(row.getString("sensor_address"));
		sensor.setSensorCity(row.getString("sensor_city"));
		sensor.setSensorState(row.getString("sensor_state"));
		sensor.setSensorCountry(row.getString("sensor_country"));
		sensor.setSensorZip(row.getString("sensor_zip"));
		sensor.setSensorBlock(row.getString("sensor_block"));
		
		return sensor;
	   }
		
		
	}