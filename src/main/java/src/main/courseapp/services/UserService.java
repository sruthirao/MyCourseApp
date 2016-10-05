package src.main.courseapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.main.courseapp.domain.User;
import src.main.courseapp.exception.UserNotFoundException;
import src.main.courseapp.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userrepository;

	public User save(User user) throws Exception 
	{
		return userrepository.save(user);
	}

	public void delete(int uId) throws Exception {
		User user = userrepository.findOne(uId);
		if (user == null) {
			throw new UserNotFoundException("User with " + uId + "Not found");
		} else {
			userrepository.delete(uId);
		}
	}

	public User findUserByName(String userName) throws Exception {
		return userrepository.findByUserName(userName);
	}

	public User findByUserId(int uId) throws Exception {
		return userrepository.findOne(uId);
	}

	public List<User> findAll() throws Exception {
		return userrepository.findAll();
	}
}