package com.dev.product.Coffee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tbl_profile")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileEntity extends BaseEntity{

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String nation;
    private String phoneNumber;
    private String fileNameAvatar;
    private String fileTypeAvatar;

    @Lob
    private byte[] data;

    private String birthday;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UsersEntity user;


}
