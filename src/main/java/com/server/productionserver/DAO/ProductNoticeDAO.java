package com.server.productionserver.DAO;

import com.server.productionserver.model.ProductNotice;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import java.util.List;

@EnableJpaRepositories
@EntityScan
public interface ProductNoticeDAO extends JpaRepository<ProductNotice, String>{

    // 使用 @Query 注解执行子串模糊匹配查询
    @Query("SELECT p FROM ProductNotice p WHERE p.workNum LIKE %:id%")
    List<ProductNotice> findByContaining(String id);
}
