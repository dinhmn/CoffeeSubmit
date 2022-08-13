package com.dev.product.Coffee.repository;

import com.dev.product.Coffee.entity.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author DinhMN
 */
@Repository
public interface RolesRepository extends JpaRepository<RolesEntity, Long> {
    RolesEntity findByName(String name);
}
