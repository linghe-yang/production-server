package com.server.productionserver.DAO;

import com.server.productionserver.model.Customer;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.transaction.Transactional;
import java.util.Optional;

@EnableJpaRepositories
@EntityScan
public interface CustomerDAO extends JpaRepository<Customer, String> {

    // 自定义的查询方法
    @Query("SELECT c FROM Customer c WHERE c.name = :name")
    Optional<Customer> findByName(String name);
}
