package com.server.productionserver.DAO;

import com.server.productionserver.model.BackUpCom;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

public interface BackUpComDAO extends JpaRepository<BackUpCom, String> {
}
