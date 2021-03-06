package com.ray.entity;

public class Admin
{
    public Admin(String account, String password)
    {
        this.account = account;
        this.password = password;
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin.id
     *
     * @mbggenerated
     */
    private Integer id;

    // 头像
    private String avatar;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin.account
     *
     * @mbggenerated
     */
    private String account;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin.password
     *
     * @mbggenerated
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin.salt
     *
     * @mbggenerated
     */
    private String salt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin.locked
     *
     * @mbggenerated
     */
    private Boolean locked;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin.id
     *
     * @return the value of admin.id
     *
     * @mbggenerated
     */
    public Integer getId()
    {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin.id
     *
     * @param id the value for admin.id
     *
     * @mbggenerated
     */
    public void setId(Integer id)
    {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin.name
     *
     * @return the value of admin.name
     *
     * @mbggenerated
     */
    public String getName()
    {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin.name
     *
     * @param name the value for admin.name
     *
     * @mbggenerated
     */
    public void setName(String name)
    {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin.account
     *
     * @return the value of admin.account
     *
     * @mbggenerated
     */
    public String getAccount()
    {
        return account;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin.account
     *
     * @param account the value for admin.account
     *
     * @mbggenerated
     */
    public void setAccount(String account)
    {
        this.account = account == null ? null : account.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin.password
     *
     * @return the value of admin.password
     *
     * @mbggenerated
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin.password
     *
     * @param password the value for admin.password
     *
     * @mbggenerated
     */
    public void setPassword(String password)
    {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin.salt
     *
     * @return the value of admin.salt
     *
     * @mbggenerated
     */
    public String getSalt()
    {
        return salt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin.salt
     *
     * @param salt the value for admin.salt
     *
     * @mbggenerated
     */
    public void setSalt(String salt)
    {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin.locked
     *
     * @return the value of admin.locked
     *
     * @mbggenerated
     */
    public Boolean getLocked()
    {
        return locked;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin.locked
     *
     * @param locked the value for admin.locked
     *
     * @mbggenerated
     */
    public void setLocked(Boolean locked)
    {
        this.locked = locked;
    }

    public String getCredentialsSalt()
    {
        return account + salt;
    }

    public Admin()
    {
    }

    public String getAvatar()
    {
        return avatar;
    }

    public void setAvatar(String avatar)
    {
        this.avatar = avatar;
    }
}
