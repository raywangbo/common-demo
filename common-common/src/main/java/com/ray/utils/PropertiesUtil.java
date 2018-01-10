package com.ray.utils;

import org.apache.log4j.Logger;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

public final class PropertiesUtil
{
    private static Logger log = Logger.getLogger(PropertiesUtil.class);

    private static String path;
    static Properties props;
    static
    {// 静态块 初始化
        props = new Properties();
        path = PropertiesUtil.class.getClassLoader().getResource("") + "/resource.properties";
        File file;
        try
        {
            file = new File(new URI(path));
            if (!file.exists())
            {// 配置文件找不到，就创建
                try
                {
                    file.createNewFile();
                }
                catch (IOException e)
                {
                    log.error("创建文件错误", e);
                }
            }
        }
        catch (URISyntaxException e1)
        {
            log.error("初始化文件错误", e1);
        }
    }

    /**
     * 获取配置文件对应key的值
     * 
     * @author qqjbest
     * @since 2016年4月13日 下午4:19:54
     * @param key
     * @return
     */
    public static String get(String key)
    {
        try
        {
            InputStream in = new BufferedInputStream(new FileInputStream(new File(new URI(path))));
            props.load(in);
            String value = props.getProperty(key);
            return value;
        }
        catch (Exception e)
        {
            log.error("获取配置文件错误", e);
            return null;
        }
    }

    /**
     * 写入配置文件
     * 
     * @author qqjbest
     * @since 2016年4月13日 下午4:19:30
     * @param key
     * @param value
     */
    public static void set(String key, String value)
    {
        try
        {
            OutputStream ops = new FileOutputStream(new File(new URI(path)));
            props.setProperty(key, value);
            props.store(ops, "set");
        }
        catch (Exception e)
        {
            log.error("设置" + key + " 出错", e);
        }
    }

    // 测试
    public static void main(String[] args) throws IOException
    {
        System.out.println(get("apnsProduction"));
        // set("f", "22");
        // set("f2", "22");
        set("aaaa", "bb");
        log.info("OK");
    }
}
