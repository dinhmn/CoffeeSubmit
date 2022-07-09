package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.AvatarEntity;
import com.dev.product.Coffee.entity.UsersEntity;
import org.springframework.web.multipart.MultipartFile;

public interface AvatarService {
    AvatarEntity insert(MultipartFile file, UsersEntity usersEntity
    ) throws Exception;
    
    AvatarEntity selectByPrimaryKey(String id) throws Exception;
    
    AvatarEntity update(MultipartFile file, UsersEntity usersEntity) throws Exception;

    void delete(MultipartFile file, Long userId) throws Exception;
}
