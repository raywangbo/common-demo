package com.ray.entity;

import java.util.Date;

public class Strategy
{
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column strategy.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column strategy.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column strategy.remark
     *
     * @mbggenerated
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column strategy.permission
     *
     * @mbggenerated
     */
    private Byte permission;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column strategy.type
     *
     * @mbggenerated
     */
    private Boolean type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column strategy.status
     *
     * @mbggenerated
     */
    private Byte status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column strategy.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column strategy.update_time
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column strategy.id
     *
     * @return the value of strategy.id
     *
     * @mbggenerated
     */
    public Integer getId()
    {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column strategy.id
     *
     * @param id the value for strategy.id
     *
     * @mbggenerated
     */
    public void setId(Integer id)
    {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column strategy.name
     *
     * @return the value of strategy.name
     *
     * @mbggenerated
     */
    public String getName()
    {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column strategy.name
     *
     * @param name the value for strategy.name
     *
     * @mbggenerated
     */
    public void setName(String name)
    {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column strategy.remark
     *
     * @return the value of strategy.remark
     *
     * @mbggenerated
     */
    public String getRemark()
    {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column strategy.remark
     *
     * @param remark the value for strategy.remark
     *
     * @mbggenerated
     */
    public void setRemark(String remark)
    {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column strategy.permission
     *
     * @return the value of strategy.permission
     *
     * @mbggenerated
     */
    public Byte getPermission()
    {
        return permission;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column strategy.permission
     *
     * @param permission the value for strategy.permission
     *
     * @mbggenerated
     */
    public void setPermission(Byte permission)
    {
        this.permission = permission;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column strategy.type
     *
     * @return the value of strategy.type
     *
     * @mbggenerated
     */
    public Boolean getType()
    {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column strategy.type
     *
     * @param type the value for strategy.type
     *
     * @mbggenerated
     */
    public void setType(Boolean type)
    {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column strategy.status
     *
     * @return the value of strategy.status
     *
     * @mbggenerated
     */
    public Byte getStatus()
    {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column strategy.status
     *
     * @param status the value for strategy.status
     *
     * @mbggenerated
     */
    public void setStatus(Byte status)
    {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column strategy.create_time
     *
     * @return the value of strategy.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime()
    {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column strategy.create_time
     *
     * @param createTime the value for strategy.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column strategy.update_time
     *
     * @return the value of strategy.update_time
     *
     * @mbggenerated
     */
    public Date getUpdateTime()
    {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column strategy.update_time
     *
     * @param updateTime the value for strategy.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime)
    {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Strategy strategy = (Strategy) o;

        return id.equals(strategy.id);
    }
}
