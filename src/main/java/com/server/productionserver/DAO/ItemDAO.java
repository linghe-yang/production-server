package com.server.productionserver.DAO;

import com.server.productionserver.model.CompleteItem;
import com.server.productionserver.model.Item;
import com.server.productionserver.model.Labels;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
@EntityScan
public interface ItemDAO extends JpaRepository<Item, Long> {

    // 自定义的删除方法，transactional和modifying注解是为了做事务修改注解
    @Transactional
    @Modifying
    @Query("DELETE FROM Item i WHERE i.workNum = :workNum")
    void deleteByWorkNum(String workNum);

    // 使用 @Query 注解执行子串模糊匹配查询
    @Query("SELECT i FROM Item i WHERE i.workNum LIKE %:workNum%")
    List<Item> findByContaining(String workNum);

    // 使用 @Query 注解执行精准匹配查询
    @Query("SELECT i FROM Item i WHERE i.workNum = :workNum AND i.comOrder = :comOrder")
    List<Item> findByWorkNumAndComOrder(String workNum, String comOrder);

    // 使用 @Query 注解执行精准匹配查询
    @Query("SELECT i FROM Item i WHERE i.workNum = :workNum AND i.formType = :formType")
    List<Item> findByWorkNumAndFormType(String workNum, Integer formType);

    // 使用 @Query 注解执行精准匹配查询
    @Query("SELECT i FROM Item i WHERE i.workNum = :workNum AND i.comOrder = :comOrder AND i.formType = :formType")
    List<Item> findByWorkNumAndComOrderAndFormType(String workNum, String comOrder, Integer formType);


}