package com.dev.product.Coffee.entity;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "tbl_article")
public class ArticleEntity extends BaseEntity{
    
    private String title;
    private String description;
    
}
