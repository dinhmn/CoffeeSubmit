package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {

    User createUser(User user, MultipartFile userFile) throws Exception;

    List<User> getAllUsers ();
}
