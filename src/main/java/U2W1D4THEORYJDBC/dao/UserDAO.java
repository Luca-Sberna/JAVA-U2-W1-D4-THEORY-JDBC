package U2W1D4THEORYJDBC.dao;

import java.util.List;

import U2W1D4THEORYJDBC.entities.User;

public interface UserDAO {
	public List<User> findAll();

	public User findById(int id);

	public void save(User user);

	public int findByIdAndUpdate(int id, User user);

	public int findByIdAndDelete(int id);

	public int count();
}
