package com.baymax.baymax.db.model;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: EricQiu
 * Date: 5/25/15
 * Time: 11:27 AM
 */
public abstract class BaseModel {
    protected Date createTime;
    protected Date modifyTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
