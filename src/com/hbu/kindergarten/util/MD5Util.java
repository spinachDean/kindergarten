package com.hbu.kindergarten.util;

import java.security.MessageDigest;

public class MD5Util {
	//md5算法
		public static  String MD5(String s) {
			    try {
			        MessageDigest md = MessageDigest.getInstance("MD5");
			        byte[] bytes = md.digest(s.getBytes("utf-8"));
			        final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
				    StringBuilder ret = new StringBuilder(bytes.length * 2);
				    for (int i=0; i<bytes.length; i++) {
				        ret.append(HEX_DIGITS[(bytes[i] >> 4) & 0x0f]);
				        ret.append(HEX_DIGITS[bytes[i] & 0x0f]);
				    }
				    return ret.toString();
			    }
			    catch (Exception e) {
			        throw new RuntimeException(e);
			    }
			}
		public static void main(String[] args) {
			System.out.println(MD5("admin"));
		}
}
