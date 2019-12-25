package com.as.usedcarservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.as.usedcarservice.entity.Login;

@Repository
public interface LoginRepo extends JpaRepository<Login, String> {

}
