package com.server.productionserver.DAO;

import com.server.productionserver.model.CurlDirection;
import com.server.productionserver.model.OrganizationRequirements;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
@EntityScan
public interface CurlDirectionDAO extends JpaRepository<CurlDirection, String> {

    @Query("SELECT c FROM CurlDirection c WHERE c.id = :cusId")
    List<CurlDirection> findByCusId(String cusId);

    // 使用 @Query 注解执行精准匹配查询
    @Query("SELECT c FROM CurlDirection c WHERE c.num = :num")
    List<CurlDirection> findByNum(String num);

    //根据id和num查询
    @Query("SELECT c FROM CurlDirection c WHERE c.id = :cusId AND c.num = :num")
    Optional<CurlDirection> findInfoByIdAndNum(String cusId, String num);

    //根据id和num删除
    @Transactional
    @Modifying
    @Query("DELETE FROM CurlDirection c WHERE c.id = :cusId AND c.num = :num")
    void deleteInfoByIdAndNum(String cusId, String num);
}
