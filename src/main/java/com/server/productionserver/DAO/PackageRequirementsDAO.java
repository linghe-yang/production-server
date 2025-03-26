package com.server.productionserver.DAO;

import com.server.productionserver.model.Item;
import com.server.productionserver.model.PackageRequirements;
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
public interface PackageRequirementsDAO extends JpaRepository<PackageRequirements, String> {

    @Query("SELECT p FROM PackageRequirements p WHERE p.id = :cusId")
    List<PackageRequirements> findByCusId(String cusId);

    // 使用 @Query 注解执行精准匹配查询
    @Query("SELECT p FROM PackageRequirements p WHERE p.num = :num")
    List<PackageRequirements> findByNum(String num);

    //根据id和num查询
    @Query("SELECT p FROM PackageRequirements p WHERE p.id = :cusId AND p.num = :num")
    Optional<PackageRequirements> findInfoByIdAndNum(String cusId, String num);

    //根据id和num删除
    @Transactional
    @Modifying
    @Query("DELETE FROM PackageRequirements p WHERE p.id = :cusId AND p.num = :num")
    void deleteInfoByIdAndNum(String cusId, String num);
}
