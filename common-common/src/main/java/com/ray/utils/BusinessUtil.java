package com.ray.utils;

import com.quantuStar.core.constanst.Constants;
import com.quantuStar.redis.cache.Redis;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.subject.Subject;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by qqjbest on 2017/10/11.
 */
public class BusinessUtil
{
    static Redis redis = Redis.getInstance();

    /**
     * 退出登录
     * 
     * @param account
     */
    public static void logout(String account)
    {
        DefaultSecurityManager securityManager = (DefaultSecurityManager) SecurityUtils.getSecurityManager();
        DefaultSessionManager sessionManager = (DefaultSessionManager) securityManager.getSessionManager();
        Collection<Session> activeSessions = sessionManager.getSessionDAO().getActiveSessions();
        for (Session session : activeSessions)
        {
            if (account.equals("" + session.getAttribute("org.apache.shiro.subject.support.DefaultSubjectContext_PRINCIPALS_SESSION_KEY")))
            {
                Subject.Builder builder = new Subject.Builder(securityManager);
                builder.sessionId(session.getId());
                Subject subject = builder.buildSubject();
                if (null != subject)
                {
                    try
                    {
                        subject.logout();
                    }
                    catch (SessionException e)
                    {
                    }
                }
            }
        }
    }
    /**
     * 获取图片地址
     *
     * @author qqjbest
     * @since 2016年5月16日 下午5:42:36
     * @param picUrl
     * @return
     */
    public static String genPicUrl(String picUrl)
    {
        /*if (ValidatorUtil.isNull(picUrl))
        {
            return "";
        }
        else if (picUrl.startsWith("http"))
        {
            return picUrl;
        }
        else if (valiPicUrl(picUrl))
        {
            if (valildGifPic(picUrl))
            {
                return getGiniuClouddn() + picUrl.split("#")[0] + "?imageMogr2/format/webp";
            }
            else if (valildSuperGifPic(picUrl))
            {
                return getGiniuClouddn() + picUrl.split("#")[0] + "?imageMogr2/thumbnail/200x|imageMogr2/format/webp";
            }
            else if (valildWebpPic(picUrl))
            {
                return getGiniuClouddn() + picUrl.split("#")[0];
            }
            return getGiniuClouddn() + picUrl.split("#")[0] + "?imageMogr2/thumbnail/!100p";
        }
        else
        {
            return getGiniuClouddn() + picUrl;
        }*/
        return getWebsite()+"upload/img/"+picUrl;
    }

    public static String getWebsite()
    {
        return PropertiesUtil.get("website");
    }

    public static boolean valiPicUrl(String body)
    {
        Pattern p = Pattern.compile("#");
        Matcher m = p.matcher(body);
        return m.find();
    }

    private static boolean valildGifPic(String picUrl)
    {
        if (picUrl.split("#").length == 5)
        {
            return picUrl.split("#")[4].equals(Constants.UPLOAD_PIC_TYPE.GIF + "");
        }
        return false;
    }

    private static boolean valildSuperGifPic(String picUrl)
    {
        if (picUrl.split("#").length == 5)
        {
            return picUrl.split("#")[4].equals(Constants.UPLOAD_PIC_TYPE.SUPER_GIF + "");
        }
        return false;
    }

    private static boolean valildWebpPic(String picUrl)
    {
        if (picUrl.split("#").length == 5)
        {
            return picUrl.split("#")[4].equals(Constants.UPLOAD_PIC_TYPE.WEBP + "");
        }
        return false;
    }

    /**
     * 获取七牛ACCESS KEY
     *
     * @author qqjbest
     * @since 2016年10月21日 下午7:03:35
     * @return
     */
    public static String getQiniuAccessKey()
    {
        return PropertiesUtil.get("qiniuAccessKey");
    }

    /**
     * 获取七牛SECRET KEY
     *
     * @author qqjbest
     * @since 2016年10月21日 下午7:04:46
     * @return
     */
    public static String getQiniuSecretKey()
    {
        return PropertiesUtil.get("qiniuSecretKey");
    }


    /**
     * 判断手机格式是否正确
     * true：正确 ；false：错误
     *
     * @author qqjbest
     * @since 2016年4月11日 下午7:41:03
     * @param tel
     * @return
     */
    public static boolean valiTelFormat(String tel)
    {
        return (tel.startsWith("1") && tel.length() == 11);
    }

    /**
     * 生成4位随机验证码
     *
     *
     * @author qqjbest
     * @since 2016年4月11日 下午7:46:02
     * @return
     */
    public static String generateCode()
    {
        Random random = new Random();
        int x = random.nextInt(8999);
        x = x + 1000;
        return String.valueOf(x);
    }

    /**
     * c级别用户提成奖励利率
     * @Auther qqjbest  qqjbest@sina.com
     * @Date 2017/12/13 9:56
     */
    public static Double  getCLevelSaleRate()
    {
        String saleRate = redis.get("cLevelSaleRate");
        return Double.parseDouble(saleRate) * 0.01;
    }


    /**
     * b级别用户提成奖励利率
     * @Auther qqjbest  qqjbest@sina.com
     * @Date 2017/12/13 9:56
     */
    public static Double getBLevelSaleRate() {
        String saleRate = redis.get("bLevelSaleRate");
        return Double.parseDouble(saleRate) * 0.01;
    }

    /**
     * A级别用户提成奖励利率
     * @Auther qqjbest  qqjbest@sina.com
     * @Date 2017/12/13 9:58
     */
    public static Double getALevelSaleRate() {
        String saleRate = redis.get("aLevelSaleRate");
        return Double.parseDouble(saleRate) * 0.01;
    }


    /**
     * c级用户建点奖励费率
     * @Auther qqjbest  qqjbest@sina.com
     * @Date 2017/12/13 10:01
     */
    public static Double getCLevelBuildRate()
    {
        String buildRate = redis.get("cLevelBuildRate");
        return Double.parseDouble(buildRate) * 0.01;
    }

    /**
     * b级用户建点奖励费率
     * @Auther qqjbest  qqjbest@sina.com
     * @Date 2017/12/13 10:01
     */
    public static Double getBLevelBuildRate()
    {
        String buildRate = redis.get("bLevelBuildRate");
        return Double.parseDouble(buildRate) * 0.01;
    }

    /**
     * a级用户建点奖励费率
     * @Auther qqjbest  qqjbest@sina.com
     * @Date 2017/12/13 10:01
     */
    public static Double getALevelBuildRate()
    {
        String buildRate = redis.get("aLevelBuildRate");
        return Double.parseDouble(buildRate) * 0.01;
    }

    /**
     * a级用户管理奖励费率
     * @Auther qqjbest  qqjbest@sina.com
     * @Date 2017/12/13 10:02
     */
    public static Double getALevelMgrRate()
    {
        String mgrRate = redis.get("aLevelMgrRate");
        return Double.parseDouble(mgrRate) * 0.01;
    }

    /**
     * b级用户管理奖励费率
     * @Auther qqjbest  qqjbest@sina.com
     * @Date 2017/12/13 10:03
     */
    public static Double getBLevelMgrRate()
    {
        String mgrRate = redis.get("bLevelMgrRate");
        return Double.parseDouble(mgrRate) * 0.01;
    }

    /**
     * c级用户管理奖励费率
     * @Auther qqjbest  qqjbest@sina.com
     * @Date 2017/12/13 10:03
     */
    public static Double getCLevelMgrRate()
    {
        String mgrRate = redis.get("cLevelMgrRate");
        return Double.parseDouble(mgrRate) * 0.01;
    }

    /**
     * 获取每月分红比例
     * @Auther qqjbest  qqjbest@sina.com
     * @Date 2017/12/11 9:50
     */
    public static Double getMonthShareRate()
    {
        String monthShareRate = redis.get("monthShareRate");
        return Double.parseDouble(monthShareRate) * 0.01;
    }

    /**
     * 获取增值奖励利率
     * @Auther qqjbest  qqjbest@sina.com
     * @Date 2017/12/11 15:55
     */
    public static Double getIncrementBonusRate() {
        String incrementBonusRate = redis.get("incrementBonusRate");
        return Double.parseDouble(incrementBonusRate) * 0.01;
    }

    /**
     * 获取每月归属地提成利率
     * @Auther qqjbest  qqjbest@sina.com
     * @Date 2017/12/13 10:12
     */
    public static double getMonthAreaBonusRate() {
        String monthAreaBonusRate = redis.get("monthAreaBonusRate");
        return Double.parseDouble(monthAreaBonusRate) * 0.01;
    }

    /**
     * 获取量子贝转化率
     * @Auther qqjbest  qqjbest@sina.com
     * @Date 2017/12/21 22:05
     */
    public static double getCoinRate()
    {
        String coinRate = redis.get("coinRate");
        return Double.parseDouble(coinRate) * 0.01;
    }

    /**
     * 获取量子贝增加倍率
     * @Auther qqjbest  qqjbest@sina.com
     * @Date 2017/12/21 22:17
     */
    public static double getCoinIncreaseRate()
    {
        String coinIncreaseRate = redis.get("coinIncreaseRate");
        return Double.parseDouble(coinIncreaseRate) * 0.01;
    }

    /**
     * 设置量子贝增加倍率
     * @Auther qqjbest  qqjbest@sina.com
     * @Date 2017/12/21 22:18
     */
    public static void setCoinIncreaseRate(Double coinIncreaseRate)
    {
        redis.set("coinIncreaseRate", coinIncreaseRate.toString());
    }

    /**
     * 设置量子贝转化率
     * @Auther qqjbest  qqjbest@sina.com
     * @Date 2017/12/21 22:06
     * @param coinRate
     */
    public static void setCoinRate(Double coinRate)
    {
        redis.set("coinRate", coinRate.toString());
    }

    /**
     * 设置c级别用户提成奖励利率
     * @Auther qqjbest  qqjbest@sina.com
     * @Date 2017/12/13 9:56
     */
    public  static void setCLevelSaleRate(Double cLevelSaleRate)
    {
        redis.set("cLevelSaleRate", cLevelSaleRate.toString());
    }


    /**
     * 设置b级别用户提成奖励利率
     * @Auther qqjbest  qqjbest@sina.com
     * @Date 2017/12/13 9:56
     */
    public static void setBLevelSaleRate (Double bLevelSaleRate) {
        redis.set("bLevelSaleRate", bLevelSaleRate.toString());
    }

    /**
     * 设置A级别用户提成奖励利率
     * @Auther qqjbest  qqjbest@sina.com
     * @Date 2017/12/13 9:58
     */
    public static void setALevelSaleRate (Double aLevelSaleRate) {
        redis.set("aLevelSaleRate", aLevelSaleRate.toString());
    }

    /**
     * 设置c级用户建点奖励费率
     * @Auther qqjbest  qqjbest@sina.com
     * @Date 2017/12/13 10:01
     */
    public  static void setCLevelBuildRate(Double cLevelBuildRate)
    {
        redis.set("cLevelBuildRate", cLevelBuildRate.toString());
    }

    /**
     * 设置b级用户建点奖励费率
     * @Auther qqjbest  qqjbest@sina.com
     * @Date 2017/12/13 10:01
     */
    public  static void setBLevelBuildRate(Double bLevelBuildRate)
    {
        redis.set("bLevelBuildRate", bLevelBuildRate.toString());
    }

    /**
     * 设置a级用户建点奖励费率
     * @Auther qqjbest  qqjbest@sina.com
     * @Date 2017/12/13 10:01
     */
    public  static void setALevelBuildRate(Double aLevelBuildRate)
    {
        redis.set("aLevelBuildRate", aLevelBuildRate.toString());
    }



    /**
     * 设置a级用户管理奖励费率
     * @Auther qqjbest  qqjbest@sina.com
     * @Date 2017/12/13 10:02
     */
    public  static void setALevelMgrRate(Double aLevelMgrRate)
    {
        redis.set("aLevelMgrRate", aLevelMgrRate.toString());
    }

    /**
     * 设置b级用户管理奖励费率
     * @Auther qqjbest  qqjbest@sina.com
     * @Date 2017/12/13 10:03
     */
    public  static void setBLevelMgrRate(Double bLevelMgrRate)
    {
        redis.set("bLevelMgrRate", bLevelMgrRate.toString());
    }

    /**
     * 设置c级用户管理奖励费率
     * @Auther qqjbest  qqjbest@sina.com
     * @Date 2017/12/13 10:03
     */
    public  static void setCLevelMgrRate(Double cLevelMgrRate)
    {
        redis.set("cLevelMgrRate", cLevelMgrRate.toString());
    }

    /**
     * 设置每月分红比例
     * @Auther qqjbest  qqjbest@sina.com
     * @Date 2017/12/11 9:50
     */
    public  static void setMonthShareRate(Double monthShareRate)
    {
        redis.set("monthShareRate", monthShareRate.toString());
    }

    /**
     * 设置增值奖励利率
     * @Auther qqjbest  qqjbest@sina.com
     * @Date 2017/12/11 15:55
     */
    public static void setIncrementBonusRate(Double  incrementBonusRate) {
        redis.set("incrementBonusRate", incrementBonusRate.toString());
    }

    /**
     * 设置每月归属地提成利率
     * @Auther qqjbest  qqjbest@sina.com
     * @Date 2017/12/13 10:12
     */
    public static void setMonthAreaBonusRate(Double  monthAreaBonusRate) {
        redis.set("monthAreaBonusRate", monthAreaBonusRate.toString());
    }


    /**
     * 获取随机文件名
     * @Auther qqjbest  qqjbest@sina.com
     * @Date 2017/12/19 9:57
     */
    public static String getRandomFileName() {
        SimpleDateFormat simpleDateFormat;

        simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

        Date date = new Date();

        String str = simpleDateFormat.format(date);

        Random random = new Random();

        int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数

        return rannum + str;// 当前时间
    }
}
