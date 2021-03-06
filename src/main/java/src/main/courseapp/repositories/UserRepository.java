package src.main.courseapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import src.main.courseapp.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUserName(@Param("userName")String userName);


}
