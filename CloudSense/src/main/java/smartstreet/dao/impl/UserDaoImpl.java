package smartstreet.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import smartstreet.controller.AppController;
import smartstreet.model.Login;
import smartstreet.model.User;

@Transactional
@Repository
public class UserDaoImpl {
	@Autowired
    private JdbcTemplate jdbcTemplate;

	private final static Logger logger = Logger.getLogger(AppController.class.getName());
	/**
	 * Add user
	 * @param user
	 */
	public void addUser(User user) throws Exception{
		
		logger.info("2");
		user.setJoiningDate(new Date());
	   String sql = "INSERT INTO users (userid, first_name, last_name, username, password, "
	   		+ "email, address, user_city, user_state, "
	   		+ "user_zip, user_country, role, joining_date) values (?, ?, ? , ? ,? ,?, ?, ? , ? ,? ,?, ?, ? )";
	   jdbcTemplate.update(sql, user.getUserId(), user.getFirstName(),user.getLastName(),
			   user.getUserName(), user.getPassword(), user.getUserEmail(),user.getUserAddress(),
			   user.getUserCity(), user.getUserState(), user.getUserZip(),user.getUserCountry(),
			   user.getUserRole(), user.getJoiningDate());
	}
	public User validateUsers(Login userlogin) {
	 String sql = "select * from users where email='" + userlogin.getEmail()+ "' and password='" + userlogin.getUserPwd()
	+ "'";
	    List<User> userList = jdbcTemplate.query(sql, new RowMapper<User>() {	   	 
	        @Override
	        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
	            User user = new User();
	 
	            user.setUserEmail(rs.getString("email"));
	        user.setPassword(rs.getString("password"));
	
	            return user;
	        }
	    });   
	    return userList.size() > 0 ? userList.get(0) : null;
	}
}
