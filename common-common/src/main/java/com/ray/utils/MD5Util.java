package com.ray.utils;

import java.security.MessageDigest;

public class MD5Util {

	public static void main(String[] args) {
		//Long dateTime = 1513752643069L;
//		System.out.print(dateTime);
		//System.out.print(MD5Encode("{\"content\":\"{\"encryptId\":\"000600000000052\",\"apiVersion\":1,\"txnDate\":1513752643069,\"method\":\"fastpayQuery\",\"mid\":\"000600000000052\",\"bizOrderNumber\":\"123\"}\",\"key\":\"c2f744e2dfc4547ff71b675b54691fd2\"}"));

		System.out.print(MD5Encoder("123","utf-8"));
	}

	private static String byteArrayToHexString(byte b[]) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++)
			resultSb.append(byteToHexString(b[i]));

		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n += 256;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	public static String MD5Encode(String origin) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
				'B', 'C', 'D', 'E', 'F' };
		try {
			byte[] btInput =  origin.getBytes("UTF-8");
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };


	public final static String MD5Encoder(String s, String charset) {
		try {
			byte[] btInput = s.getBytes(charset);
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			mdInst.update(btInput);
			byte[] md = mdInst.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < md.length; i++) {
				int val = ((int) md[i]) & 0xff;
				if (val < 16){
					sb.append("0");
				}
				sb.append(Integer.toHexString(val));
			}
			return sb.toString();
		} catch (Exception e) {
			return null;
		}
	}

}
