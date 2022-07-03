package com.dev.product.Coffee.implement;

import com.dev.product.Coffee.entity.User;
import com.dev.product.Coffee.repository.UserRepository;
import com.dev.product.Coffee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;

import static org.springframework.util.StringUtils.cleanPath;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user, MultipartFile userFile) throws Exception {
        String fileName = cleanPath(Objects.requireNonNull(userFile.getOriginalFilename()));
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
