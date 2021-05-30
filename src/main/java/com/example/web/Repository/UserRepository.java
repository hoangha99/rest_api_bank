package com.example.web.Repository;


import com.example.web.entity.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users,Long> {
    @Query("select us from Users us where us.username = :name")
    Users findByUsername(String name);

}