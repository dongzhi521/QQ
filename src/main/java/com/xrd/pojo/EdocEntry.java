package com.xrd.pojo;

import java.util.Date;

public class EdocEntry {
    private Long id;

    private Long categoryid;

    private String title;

    private String summary;

    private String uploaduser;

    private Date createdate;
    public EdocCategory edoccategory;

    public EdocCategory getEdoccategory() {
        return edoccategory;
    }

    public void setEdoccategory(EdocCategory edoccategory) {
        this.edoccategory = edoccategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getUploaduser() {
        return uploaduser;
    }

    public void setUploaduser(String uploaduser) {
        this.uploaduser = uploaduser == null ? null : uploaduser.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}