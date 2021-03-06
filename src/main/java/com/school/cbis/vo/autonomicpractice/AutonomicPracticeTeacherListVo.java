package com.school.cbis.vo.autonomicpractice;

/**
 * Created by Administrator on 2016/5/5.
 */
public class AutonomicPracticeTeacherListVo {
    private int autonomousPracticeInfoId;
    private String autonomousPracticeTitle;
    private int pageNum;
    private int pageSize = 5;
    private int totalData;
    private int autonomousPracticeHeadId;
    private String content;

    public int getAutonomousPracticeInfoId() {
        return autonomousPracticeInfoId;
    }

    public void setAutonomousPracticeInfoId(int autonomousPracticeInfoId) {
        this.autonomousPracticeInfoId = autonomousPracticeInfoId;
    }

    public String getAutonomousPracticeTitle() {
        return autonomousPracticeTitle;
    }

    public void setAutonomousPracticeTitle(String autonomousPracticeTitle) {
        this.autonomousPracticeTitle = autonomousPracticeTitle;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalData() {
        return totalData;
    }

    public void setTotalData(int totalData) {
        this.totalData = totalData;
    }

    public int getAutonomousPracticeHeadId() {
        return autonomousPracticeHeadId;
    }

    public void setAutonomousPracticeHeadId(int autonomousPracticeHeadId) {
        this.autonomousPracticeHeadId = autonomousPracticeHeadId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "AutonomicPracticeTeacherListVo{" +
                "autonomousPracticeInfoId=" + autonomousPracticeInfoId +
                ", autonomousPracticeTitle='" + autonomousPracticeTitle + '\'' +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", totalData=" + totalData +
                ", autonomousPracticeHeadId=" + autonomousPracticeHeadId +
                ", content='" + content + '\'' +
                '}';
    }
}
