package com.server.productionserver.DAO;

import com.server.productionserver.model.Item;
import com.server.productionserver.model.MotherBill;
import com.server.productionserver.model.Packing;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.transaction.Transactional;
import java.util.List;

@EnableJpaRepositories
@EntityScan
public interface PackingDAO extends JpaRepository<Packing, Long> {

        @Transactional
        @Modifying
        @Query("DELETE FROM Packing p WHERE p.workNum = :workNum")
        void deleteByWorkNum(String workNum);


        // 使用 @Query 注解执行精准匹配查询
        @Query("SELECT p FROM Packing p WHERE p.workNum = :workNum")
        List<Packing> findByWorkNum(String workNum);


}
