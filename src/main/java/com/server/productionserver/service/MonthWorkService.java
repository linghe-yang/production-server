package com.server.productionserver.service;

import com.server.productionserver.model.MonthWorkLogData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


@Service
public class MonthWorkService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //调用存储过程
    public List<MonthWorkLogData> callMonthWork(String date, String name) {
        String sql = "CALL month_work(?, ?)";
        List<Map<String, Object>> monthWork = jdbcTemplate.queryForList(sql, date, name);

        List<MonthWorkLogData> result = new ArrayList<>();
        //monthWork转化为MonthWorkLogData对象
        for (Map<String, Object> m : monthWork) {
            MonthWorkLogData monthWorkLogData = new MonthWorkLogData();
            monthWorkLogData.setPlanDate((String) m.get("plan_date"));
            monthWorkLogData.setStaffName((String) m.get("staff_name"));
            monthWorkLogData.setJob1SumNum(m.get("job1_sum_num").toString());
            monthWorkLogData.setJob1SumProductarea(m.get("job1_sum_productarea").toString());
            monthWorkLogData.setJob2SumNum(m.get("job2_sum_num").toString());
            monthWorkLogData.setJob2SumProductarea(m.get("job2_sum_productarea").toString());
            monthWorkLogData.setJob3SumNum(m.get("job3_sum_num").toString());
            monthWorkLogData.setJob3SumProductarea(m.get("job3_sum_productarea").toString());
            monthWorkLogData.setOther((String) m.get("other"));
            result.add(monthWorkLogData);
        }

        return result;
    }

}
