package com.sandip.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sandip.entity.User;

@Transactional
public interface UserReporsitory extends JpaRepository<User, Long>, JpaSpecificationExecutor<User>{

}
