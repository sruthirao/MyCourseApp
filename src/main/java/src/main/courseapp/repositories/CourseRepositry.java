package src.main.courseapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import src.main.courseapp.domain.Course;

public interface CourseRepositry extends JpaRepository<Course, Integer>{

}
