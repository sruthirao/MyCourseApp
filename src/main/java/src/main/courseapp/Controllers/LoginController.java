package src.main.courseapp.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import src.main.courseapp.domain.User;
import src.main.courseapp.services.UserService;

@RestController
@RequestMapping("authenticate")
public class LoginController {

	final static Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UserService userservice;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> login(@RequestBody User user) throws Exception {
		logger.info(user.getUserName());
		User NUser = userservice.findUserByName(user.getUserName());
		if (NUser != null) {
			if (NUser.getPassword().equals(user.getPassword())) {
				logger.info(user.getUserName());
				return new ResponseEntity<User>(NUser, HttpStatus.OK);
			} else {
				logger.error(user.getUserName());
				return new ResponseEntity<User>(user, HttpStatus.FORBIDDEN);
			}
		}
		logger.error(user.getUserName());
		return new ResponseEntity<User>(user, HttpStatus.FORBIDDEN);

	}

}
