package com.surabi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.surabi.bean.Menu;

@Repository
public interface MenuDao extends JpaRepository<Menu, Integer> {

}
