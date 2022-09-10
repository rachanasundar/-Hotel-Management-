package com.surabi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.surabi.bean.User;

@Repository
public interface UserDao extends JpaRepository<User, String> {

}
