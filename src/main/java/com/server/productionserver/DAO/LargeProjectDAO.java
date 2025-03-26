package com.server.productionserver.DAO;

import com.server.productionserver.model.LargeProject;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @version 1.0
 * @auther Ethan
 */
@EnableJpaRepositories
@EntityScan
public interface LargeProjectDAO  extends JpaRepository<LargeProject, String> {


}
