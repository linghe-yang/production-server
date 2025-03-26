package com.server.productionserver.DAO;

import com.server.productionserver.model.OddJobs;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.transaction.Transactional;

@EnableJpaRepositories
@EntityScan
public interface OddJobsDAO extends JpaRepository<OddJobs, Long> {


    @Transactional
    @Modifying
    @Query("DELETE FROM OddJobs o WHERE o.stuffName = :stuffName and o.date = :date")
    void deleteByDateAndStuffName(String date, String stuffName);

}
