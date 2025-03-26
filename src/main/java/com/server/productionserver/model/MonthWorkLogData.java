package com.server.productionserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


public class MonthWorkLogData {
    @JsonProperty("plan_date")
    private String planDate;

    @JsonProperty("staff_name")
    private String staffName;

    @JsonProperty("job1_sum_num")
    private String job1SumNum;

    @JsonProperty("job1_sum_productarea")
    private String job1SumProductarea;

    @JsonProperty("job2_sum_num")
    private String job2SumNum;

    @JsonProperty("job2_sum_productarea")
    private String job2SumProductarea;

    @JsonProperty("job3_sum_num")
    private String job3SumNum;

    @JsonProperty("job3_sum_productarea")
    private String job3SumProductarea;

    @JsonProperty("other")
    private String other;

    public String getPlanDate() {
        return planDate;
    }

    public void setPlanDate(String planDate) {
        this.planDate = planDate;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getJob1SumNum() {
        return job1SumNum;
    }

    public void setJob1SumNum(String job1SumNum) {
        this.job1SumNum = job1SumNum;
    }

    public String getJob1SumProductarea() {
        return job1SumProductarea;
    }

    public void setJob1SumProductarea(String job1SumProductarea) {
        this.job1SumProductarea = job1SumProductarea;
    }

    public String getJob2SumNum() {
        return job2SumNum;
    }

    public void setJob2SumNum(String job2SumNum) {
        this.job2SumNum = job2SumNum;
    }

    public String getJob2SumProductarea() {
        return job2SumProductarea;
    }

    public void setJob2SumProductarea(String job2SumProductarea) {
        this.job2SumProductarea = job2SumProductarea;
    }

    public String getJob3SumNum() {
        return job3SumNum;
    }

    public void setJob3SumNum(String job3SumNum) {
        this.job3SumNum = job3SumNum;
    }

    public String getJob3SumProductarea() {
        return job3SumProductarea;
    }

    public void setJob3SumProductarea(String job3SumProductarea) {
        this.job3SumProductarea = job3SumProductarea;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MonthWorkLogData monthWorkLogData = (MonthWorkLogData) o;
        return Objects.equals(this.planDate, monthWorkLogData.planDate) &&
                Objects.equals(this.staffName, monthWorkLogData.staffName) &&
                Objects.equals(this.job1SumNum, monthWorkLogData.job1SumNum) &&
                Objects.equals(this.job1SumProductarea, monthWorkLogData.job1SumProductarea) &&
                Objects.equals(this.job2SumNum, monthWorkLogData.job2SumNum) &&
                Objects.equals(this.job2SumProductarea, monthWorkLogData.job2SumProductarea) &&
                Objects.equals(this.job3SumNum, monthWorkLogData.job3SumNum) &&
                Objects.equals(this.job3SumProductarea, monthWorkLogData.job3SumProductarea) &&
                Objects.equals(this.other, monthWorkLogData.other);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planDate, staffName, job1SumNum, job1SumProductarea, job2SumNum, job2SumProductarea, job3SumNum, job3SumProductarea, other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MonthWorkLogData {\n");

        sb.append("    planDate: ").append(toIndentedString(planDate)).append("\n");
        sb.append("    staffName: ").append(toIndentedString(staffName)).append("\n");
        sb.append("    job1SumNum: ").append(toIndentedString(job1SumNum)).append("\n");
        sb.append("    job1SumProductarea: ").append(toIndentedString(job1SumProductarea)).append("\n");
        sb.append("    job2SumNum: ").append(toIndentedString(job2SumNum)).append("\n");
        sb.append("    job2SumProductarea: ").append(toIndentedString(job2SumProductarea)).append("\n");
        sb.append("    job3SumNum: ").append(toIndentedString(job3SumNum)).append("\n");
        sb.append("    job3SumProductarea: ").append(toIndentedString(job3SumProductarea)).append("\n");
        sb.append("    other: ").append(toIndentedString(other)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
