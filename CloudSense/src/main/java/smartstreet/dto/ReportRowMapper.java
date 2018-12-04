package smartstreet.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * Row Mapper class for Report
 * Maps DB data to bean class
 * @author priyankasinghal
 *
 */

public class ReportRowMapper implements RowMapper<Report> {
	
		
		
		public Report mapRow(ResultSet row, int rowNum) throws SQLException {
		Report report = new Report();
		report.setValue(String.valueOf(row.getInt("count")));
		report.setLabel(row.getString("sensor_type"));
		
		return report;
	   }
		
		
	}