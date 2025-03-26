package com.server.productionserver.DAO;

import com.server.productionserver.model.MotherBill;
import com.server.productionserver.model.ProductNotice;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.transaction.Transactional;
import java.util.List;

@EnableJpaRepositories
@EntityScan
public interface MotherBillDAO extends JpaRepository<MotherBill, String> {

    // 使用 @Query 注解执行子串模糊匹配查询
    @Query("SELECT m FROM MotherBill m WHERE m.mbNum LIKE %:id%")
    List<MotherBill> findByContaining(String id);

}
