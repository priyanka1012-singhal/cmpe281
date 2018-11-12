package smartstreet.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.RowMapper;
import smartstreet.model.Sensor;

/**
 * Row Mapper class for Sensor
 * Maps DB data to bean class
 * @author priyankasinghal
 *
 */
@PropertySource("classpath:globalconstants.properties")
public class SensorRowMapper implements RowMapper<Sensor> {
	
		@Autowired
		private Environment env;
		
		public Sensor mapRow(ResultSet row, int rowNum) throws SQLException {
		Sensor sensor = new Sensor();
		sensor.setId(row.getString(env.getProperty("sensor.id")));
		sensor.setSensorName(row.getString(env.getProperty("sensor.name")));
		sensor.setSensorStatus(row.getInt(env.getProperty("sensor.status")));
		return sensor;
	   }
	}