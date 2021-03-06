package com.school.cbis.vo.eadmin;

/**
 * Created by lenovo on 2016-06-04.
 */
public class TeachingMaterialTemplateListVo {
    private int id;
    private String realName;
    private String title;
    private String teachTaskTitle;
    private String createTime;
    private int pageNum;
    private int pageSize;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTeachTaskTitle() {
        return teachTaskTitle;
    }

    public void setTeachTaskTitle(String teachTaskTitle) {
        this.teachTaskTitle = teachTaskTitle;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
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

    @Override
    public String toString() {
        return "TeachingMaterialTemplateListVo{" +
                "id=" + id +
                ", realName='" + realName + '\'' +
                ", title='" + title + '\'' +
                ", teachTaskTitle='" + teachTaskTitle + '\'' +
                ", createTime='" + createTime + '\'' +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
