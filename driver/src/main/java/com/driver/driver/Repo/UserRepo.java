package com.driver.driver.Repo;
import com.driver.driver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    @Query(value = "select d from User d where d.email= :email")
    Optional<User> findByEmail(@Param("email") String email);


}

