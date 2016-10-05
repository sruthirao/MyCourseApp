package src.main.courseapp.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import src.main.courseapp.domain.Course;
import src.main.courseapp.domain.User;
import src.main.courseapp.services.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	final static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userservice;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> create(@Valid @RequestBody User user) throws Exception {
		logger.info("Received request to create the user "+user);
		return new ResponseEntity<User>(userservice.save(user), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<User> update(@RequestBody User user) throws Exception {
		logger.info("Received request to update the user "+user);
		return new ResponseEntity<User>(userservice.save(user), HttpStatus.OK);
	}

	@RequestMapping(value = "{uId}", method = RequestMethod.GET)
	public ResponseEntity<User> getByUserId(@PathVariable("uId") Integer uId) throws Exception {
		logger.info("Received request to get the user with uId "+uId);
		return new ResponseEntity<User>(userservice.findByUserId(uId), HttpStatus.OK);
	}

	@RequestMapping(value = "{uId}", method = RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> delete(@PathVariable("uId") int uId) throws Exception {
		logger.info("Received request to delete the user with uId "+uId);
		userservice.delete(uId);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@RequestMapping(value = "{userName}", method = RequestMethod.GET)
	public ResponseEntity<User> getByUserName(@PathVariable("userName") String userName) throws Exception {
		logger.info("Received request to find the user with username "+userName);
		if (!userName.contains(".com")) {
			userName += ".com";
		}

		return new ResponseEntity<User>(userservice.findUserByName(userName), HttpStatus.OK);
	}

	@RequestMapping(value = "course/{uId}", method = RequestMethod.GET)
	public ResponseEntity<List<Course>> getAllCoursesForaUser(@PathVariable("uId") int uId) throws Exception {
		logger.info("Received request to get all the courses for the user with userId "+uId);
		return new ResponseEntity<List<Course>>(userservice.findByUserId(uId).getCourses(), HttpStatus.OK);
	}
}
