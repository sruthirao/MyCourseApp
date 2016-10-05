package src.test.courseapp.service.stepdefinitions;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import src.main.courseapp.config.MyCourseAppApplication;
import src.main.courseapp.services.UserService;


public@ContextConfiguration(classes = MyCourseAppApplication.class)
@DataJpaTest
@RunWith(SpringRunner.class) abstract class AbstractServiceTestDefs {
	@Autowired
	protected UserService userService;
		
}