package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.AvatarEntity;
import com.dev.product.Coffee.entity.UsersEntity;
import com.dev.product.Coffee.repository.AvatarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.springframework.util.StringUtils.cleanPath;

@RequiredArgsConstructor
@Service
public class AvatarServiceImpl implements AvatarService {
    
    @Autowired
    private final AvatarRepository avatarRepository;
    
    @Override
    public AvatarEntity insert(MultipartFile file, UsersEntity usersEntity) throws Exception {
        String fileName = cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        try {
            if (fileName.contains("..")) {
                throw new Exception("Filename contains invalid path sequence" + fileName);
            }
            AvatarEntity avatarEntity = new AvatarEntity(
                    fileName,
                    file.getContentType(),
                    file.getBytes()
            );
            avatarEntity.setUser(usersEntity);
            avatarEntity.setCreatedDate(new Date());
            return avatarRepository.save(avatarEntity);
        } catch (Exception e) {
            throw new Exception("Could not save File: " + fileName);
        }
    }
    
    @Override
    public AvatarEntity selectByPrimaryKey(String id) throws Exception {
        return avatarRepository.findById(id)
                .orElseThrow(() -> new Exception("File not found with id: " + id));
    }
    
    @Override
    public AvatarEntity update(MultipartFile file, UsersEntity usersEntity) throws Exception {
        String fileName = cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        List<AvatarEntity> avatarEntityList = avatarRepository.findAll();
        Optional<AvatarEntity> avatarEntity;
        try {
            if (fileName.contains("..")) {
                throw new Exception("Filename contains invalid path sequence" + fileName);
            }
            avatarEntity = avatarEntityList.stream()
                    .filter(e -> e.getUser().getId().equals(usersEntity.getId()))
                    .map(c -> toUpdateAvatarEntity(c, file, fileName))
                    .findFirst();
            return avatarEntity.orElse(null);
        } catch (Exception e) {
            throw new Exception("Could not save File: " + fileName);
        }
    }
    
    @Override
    public void delete(MultipartFile file, Long userId) throws Exception {
        String fileName = cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        try {
            List<AvatarEntity> avatarEntityList = avatarRepository.findAll();
            Optional<AvatarEntity> imageEntity =
                    avatarEntityList.stream()
                            .filter(e -> e.getUser().getId().equals(userId))
                            .findFirst();
            imageEntity.ifPresent(avatarRepository::delete);
            
        } catch (Exception e) {
            throw new Exception("Could not delete file: " + fileName);
        }
    }
    
    private AvatarEntity toUpdateAvatarEntity(AvatarEntity avatarEntity, MultipartFile inputFile, String fileName) {
        avatarEntity.setFileName(fileName);
        avatarEntity.setFileType(inputFile.getContentType());
        try {
            avatarEntity.setData(inputFile.getBytes());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        avatarEntity.setUpdatedDate(new Date());
        return avatarRepository.save(avatarEntity);
    }
}
