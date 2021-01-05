package com.sandip.service;

import java.io.InputStream;
import java.util.List;

import com.sandip.entity.User;

public interface UserService {

	List<User> save(InputStream inputStream) throws Exception;
	
}
