package com.server.productionserver.DAO;

import com.server.productionserver.model.ExpressCompany;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@EntityScan
public interface ExpressCompanyDAO extends JpaRepository<ExpressCompany, String> {

}
