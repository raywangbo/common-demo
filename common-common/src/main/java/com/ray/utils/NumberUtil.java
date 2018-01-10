package com.ray.utils;/**
 * @auther qqjbest qqjbest
 * @create 2017/12/14
 */

import java.text.DecimalFormat;

/**
 *
 * @auther qqjbest qqjbest
 * @create 2017/12/14
 */
public class NumberUtil {
    private static DecimalFormat df = new DecimalFormat("######0.00");

    public static Double doubleFormat(double num)
    {
        return Double.parseDouble(df.format(num));
    }

    public static void main(String[] args) {
    }

}
