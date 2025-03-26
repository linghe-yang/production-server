package com.server.productionserver.DAO;

import com.server.productionserver.model.Image;
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
public interface ImageDAO extends JpaRepository<Image, Long>{

    // 自定义的查找方法
    @Query("SELECT i FROM Image i WHERE i.path = :url")
    Image getFilePathByUrl(String url);


    @Transactional
    @Modifying
    @Query("DELETE FROM Image i WHERE i.path = :url")
    void deleteImageByUrl(String url);
}
