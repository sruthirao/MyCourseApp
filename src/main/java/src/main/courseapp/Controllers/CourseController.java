package src.main.courseapp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import src.main.courseapp.domain.Course;
import src.main.courseapp.domain.Topic;
import src.main.courseapp.services.CourseService;

@RestController
@RequestMapping("course")
public class CourseController {
	@Autowired
	private CourseService courseservice;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Course> create(@RequestBody Course course) throws Exception {
		return new ResponseEntity<Course>(courseservice.saveCourse(course), HttpStatus.CREATED);
	}
	@RequestMapping(value="{cId}",method = RequestMethod.GET)
	public ResponseEntity<Course> update(@PathVariable("cId") Integer cId) throws Exception {
		return new ResponseEntity<Course>(courseservice.getCourseById(cId), HttpStatus.OK);
		
	}
	@RequestMapping(value = "{cId}", method = RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> delete(@PathVariable("cId") int cId)throws Exception{
		courseservice.delete(cId);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
}
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Course> update(@RequestBody Course course) throws Exception {
		return new ResponseEntity<Course>(courseservice.saveCourse(course), HttpStatus.OK);
	}

	@RequestMapping(value="{cId}/user/{uId}",method = RequestMethod.PUT)
	public ResponseEntity<Course> addUserToCourse(@PathVariable("cId")int cId, @PathVariable("uId")int uId) throws Exception {
		return new ResponseEntity<Course>(courseservice.addUserToCourse(cId, uId), HttpStatus.OK);
	}
	@RequestMapping(value="{cId}/user/{uId}",method = RequestMethod.DELETE)
	public ResponseEntity<Course> removeUserFromCourse(@PathVariable("cId")int cId, @PathVariable("uId")int uId) throws Exception {
		return new ResponseEntity<Course>(courseservice.removeUserFromCourse(cId, uId), HttpStatus.OK);
	}
	@RequestMapping(value="{cId}/topic",method = RequestMethod.PUT)
	public ResponseEntity<Course> addTopicToCourse(@PathVariable("cId")int cId, @RequestBody Topic topic) throws Exception {
		
		return new ResponseEntity<Course>(courseservice.addTopicToCourse(cId, topic), HttpStatus.OK);
	}
	@RequestMapping(value="{cId}/topic", method = RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> removeTopicFromCourse(@PathVariable("cId")int cId,Topic topic) throws Exception {
		courseservice.removeTopicFromCourse(cId, topic);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
}
