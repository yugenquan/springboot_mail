package com.mail_register.model;

import java.util.Date;

public class ItripUserLinkUser {
    private Integer id;

    private String linkusername;

    private String linkidcard;

    private String linkphone;

    private Integer userid;

    private Date creationdate;

    private Integer createdby;

    private Date modifydate;

    private Integer modifiedby;

    private Integer linkidcardtype;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLinkusername() {
        return linkusername;
    }

    public void setLinkusername(String linkusername) {
        this.linkusername = linkusername == null ? null : linkusername.trim();
    }

    public String getLinkidcard() {
        return linkidcard;
    }

    public void setLinkidcard(String linkidcard) {
        this.linkidcard = linkidcard == null ? null : linkidcard.trim();
    }

    public String getLinkphone() {
        return linkphone;
    }

    public void setLinkphone(String linkphone) {
        this.linkphone = linkphone == null ? null : linkphone.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Integer getCreatedby() {
        return createdby;
    }

    public void setCreatedby(Integer createdby) {
        this.createdby = createdby;
    }

    public Date getModifydate() {
        return modifydate;
    }

    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }

    public Integer getModifiedby() {
        return modifiedby;
    }

    public void setModifiedby(Integer modifiedby) {
        this.modifiedby = modifiedby;
    }

    public Integer getLinkidcardtype() {
        return linkidcardtype;
    }

    public void setLinkidcardtype(Integer linkidcardtype) {
        this.linkidcardtype = linkidcardtype;
    }

    public ItripUserLinkUser(String linkusername, String linkidcard, String linkphone, Integer userid) {
        this.linkusername = linkusername;
        this.linkidcard = linkidcard;
        this.linkphone = linkphone;
        this.userid = userid;
    }

    public ItripUserLinkUser() {
    }
}