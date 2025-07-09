package com.example.crudapi.repository;

import com.example.crudapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
//JPA AutoCreates CRUD methods
@Repository
public interface UserRepository extends JpaRepository<User, Long> {  //JpaRepository <Entity, Type of PrimaryKey>
    Optional<User> findByEmail(String email); // SELECT * FROM users WHERE = ?
}
