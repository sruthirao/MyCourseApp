package src.main.courseapp.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.main.courseapp.domain.Course;
import src.main.courseapp.domain.Topic;
import src.main.courseapp.domain.User;
import src.main.courseapp.exception.UserNotFoundException;
import src.main.courseapp.repositories.CourseRepositry;
import src.main.courseapp.repositories.UserRepository;


@Service
public class CourseService {

	@Autowired
	private CourseRepositry courserepository;
	
	@Autowired
	private UserRepository userrepository;

	public Course saveCourse(Course course) throws Exception {
		return courserepository.save(course);
	}

	public Course getCourseById(Integer cId)throws Exception {
		return courserepository.findOne(cId);
	}
	

	public void delete(Integer cId) throws Exception {
		Course course = courserepository.findOne(cId);
		if (course == null) {
			throw new UserNotFoundException("User with " + cId + "Not found");
		} else {
			courserepository.delete(cId);
		}
	}
	public Course addTopicToCourse(int cId, Topic topic)throws Exception {
		Course course = getCourseById(cId);
		topic.setCourse(course);
		course.getTopics().add(topic);
		return courserepository.save(course);
	}
	public Course removeTopicFromCourse(int cId, Topic topic) throws Exception {
		Course course = getCourseById(cId);
		topic.setCourse(course);
		course.getTopics().remove(topic);
		return courserepository.save(course);
	}

	public Course addUserToCourse(int cId, int uId) throws Exception {
		Course course= getCourseById(cId);
		User user =userrepository.findOne(uId);
		course.getRegisteredUsers().add(user);
		return courserepository.save(course);
	}

	public  Course removeUserFromCourse(int cId, int uId) throws Exception{
		Course course= getCourseById(cId);
		User user =userrepository.findOne(uId);
		course.getRegisteredUsers().remove(user);
		return courserepository.save(course);
	}
}
