package U2W1D4THEORYJDBC.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import U2W1D4THEORYJDBC.entities.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private JdbcTemplate jdbc;

//	public UserDAOImpl(JdbcTemplate jdbc) {
//		this.jdbc = jdbc;                     // con Autowired non è necessario
//	}

	@Override
	public List<User> findAll() {
		String sql = "SELECT * FROM user";
		return jdbc.query(sql, new UserRowMapper());
	}

	@Override
	public User findById(int id) {
		String sql = "SELECT * FROM user WHERE id = ?";
		return jdbc.queryForObject(sql, new UserRowMapper(), id);
	}

	@Override
	public void save(User user) {
		String sql = "INSERT INTO user (name,surname,email) VALUES (?,?,?)";
		jdbc.update(sql, user.getName(), user.getSurname(), user.getEmail());
	}

	@Override
	public int findByIdAndUpdate(int id, User user) {
		String sql = "UPDATE user SET name = ? , surname = ? , email = ? WHERE id = ?";
		return jdbc.update(sql, user.getName(), user.getSurname(), user.getEmail());
	}

	@Override
	public int findByIdAndDelete(int id) {
		String sql = "DELETE FROM user WHERE id=?";
		return jdbc.update(sql, id);
	}

	@Override
	public int count() {
		String sql = "SELECT COUNT(*) FROM user";
		return jdbc.queryForObject(sql, Integer.class);
	}

}
