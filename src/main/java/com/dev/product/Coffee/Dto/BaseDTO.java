package com.dev.product.Coffee.dto;

import lombok.*;

import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * @author DinhMN
 */

@MappedSuperclass
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public abstract class BaseDTO {
    private Long id;
    private Boolean status;
    private Integer createdBy;
    private Integer updatedBy;
    private Date createdDate;
    private Date updatedDate;
}
