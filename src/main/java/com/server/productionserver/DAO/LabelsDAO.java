package com.server.productionserver.DAO;

import com.server.productionserver.model.Labels;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@EnableJpaRepositories
@EntityScan
public interface LabelsDAO extends JpaRepository<Labels, Long> {

        @Transactional
        @Modifying
        @Query("DELETE FROM Labels l WHERE l.workNum = :workNum")
        void deleteByWorkNum(String workNum);
//
//        //调用存储过程,把获取的数据重复set_num遍
//        @Query(value = "CALL repeat_labels(:inputWorkNum)", nativeQuery = true)
//        List<Labels> getRepeatedLabelsByWorkNum(@Param("inputWorkNum") String inputWorkNum);

}
