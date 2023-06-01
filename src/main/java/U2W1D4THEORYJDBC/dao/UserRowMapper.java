package U2W1D4THEORYJDBC.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import U2W1D4THEORYJDBC.entities.User;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException { // metodo usato ogni volta che vado a leggere
																		// righe dal DB per mappare ogni riga in un
																		// oggetto user
		User fromDb = User.builder().id(rs.getInt("id")).name(rs.getString("name")).surname(rs.getString("surname"))
				.email(rs.getString("email")).build();
		return null;
	}

}
