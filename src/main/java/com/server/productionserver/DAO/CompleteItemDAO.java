package com.server.productionserver.DAO;

import com.server.productionserver.model.CompleteItem;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.transaction.Transactional;
import java.util.List;


@EnableJpaRepositories
@EntityScan
public interface CompleteItemDAO extends JpaRepository<CompleteItem, Long> {
    // 使用 @Query 注解执行子串模糊匹配查询
    @Query("SELECT c FROM CompleteItem c WHERE c.workNum LIKE %:workNum%")
    List<CompleteItem> findByContaining(String workNum);


    // 自定义的删除方法,根据工workNum和staffJob删除记录
    @Transactional
    @Modifying
    @Query("DELETE FROM CompleteItem c WHERE c.workNum = :workNum and c.staffJob = :staffJob and c.planDate = :planDate")
    void deleteByWorkNumAndStaffJob(String workNum, String staffJob, String planDate);

}
