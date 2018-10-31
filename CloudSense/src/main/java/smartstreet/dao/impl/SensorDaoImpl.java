package smartstreet.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import smartstreet.dao.ISensorDao;

@Transactional
@Repository
public class SensorDaoImpl implements ISensorDao{
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

}
