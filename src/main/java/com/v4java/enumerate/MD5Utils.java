package com.v4java.enumerate;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {

	public static String md5SaltMd5(String pwd, String salt) {
		if (salt == null) {
			return null;
		}
		return md5(md5(pwd)+salt);

	}

	public static String md5(String pwd) {
		String md5Pwd= null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update( pwd.getBytes());
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			md5Pwd = buf.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return md5Pwd;
	}
}
