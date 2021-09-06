package springbatch.example.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import springbatch.example.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
