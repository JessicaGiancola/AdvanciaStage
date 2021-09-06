package springbatch.example.util;


import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import springbatch.example.model.User;

@Component
public class MyReader extends JdbcCursorItemReader<User> implements ItemReader<User> {
	
	public MyReader(@Autowired DataSource ds) {
		
		setDataSource(ds);
		setSql("SELECT * FROM user");
		setFetchSize(100);
		setRowMapper(new Mapper());
	}

	public class Mapper implements RowMapper<User> {
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user  = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setDept(rs.getString("dept"));
			user.setSalary(rs.getInt("salary"));
			return user;
		}
	}

}
