package com.server.productionserver.DAO;

import com.server.productionserver.model.OrganizationRequirements;
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
public interface OrganizationRequirementsDAO extends JpaRepository<OrganizationRequirements, String> {

    @Query("SELECT o FROM OrganizationRequirements o WHERE o.id = :cusId")
    List<OrganizationRequirements> findByCusId(String cusId);

    // 使用 @Query 注解执行精准匹配查询
    @Query("SELECT o FROM OrganizationRequirements o WHERE o.num = :num")
    List<OrganizationRequirements> findByNum(String num);

    //根据id和num查询
    @Query("SELECT o FROM OrganizationRequirements o WHERE o.id = :cusId AND o.num = :num")
    Optional<OrganizationRequirements> findInfoByIdAndNum(String cusId, String num);

    //根据id和num删除
    @Transactional
    @Modifying
    @Query("DELETE FROM OrganizationRequirements o WHERE o.id = :cusId AND o.num = :num")
    void deleteInfoByIdAndNum(String cusId, String num);
}
