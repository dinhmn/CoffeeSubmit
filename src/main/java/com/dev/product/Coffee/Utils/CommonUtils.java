package com.dev.product.Coffee.Utils;

import com.dev.product.Coffee.entity.BaseEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class CommonUtils<E extends BaseEntity> {
    
    @PersistenceContext
    protected EntityManager entityManager;
    
    /**
     * thực thi câu lệnh cập nhật cơ sở dữ liệu
     *
     * @param sql -> ví dụ chạy câu lệnh [DELETE FROM tbl_category;] hoặc [UPDATE tbl_category SET Name = 'Alfred Schmidt' WHERE Id = 1;]
     * @return
     */
    public int executeUpdateOrDeleteByNativeSQL(String sql) {
        try {
            return entityManager.createNativeQuery(sql).executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
}
