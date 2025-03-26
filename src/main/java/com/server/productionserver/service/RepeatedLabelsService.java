package com.server.productionserver.service;

import com.server.productionserver.model.Labels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


@Service
public class RepeatedLabelsService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //调用存储过程,把获取的数据重复set_num遍
    public List<Labels> callRepeatedLabelsByWorkNum(String workNum) {
        String sql = "CALL repeat_labels(?)";
        List<Map<String, Object>> labelList = jdbcTemplate.queryForList(sql, workNum);


        //将result转换为Labels对象
        List<Labels> result = new ArrayList<>();
        for (Map<String, Object> row : labelList) {
            Labels label = new Labels();
            label.setBox((String) row.get("box"));
            label.setLength((String) row.get("length"));
            label.setPosition((String) row.get("position"));
            label.setType((String) row.get("type"));
            label.setWorkNum((String) row.get("work_num"));
            label.setWidth((String) row.get("width"));
            result.add(label);
        }

        return result;
    }
}
