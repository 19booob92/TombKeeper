package com.pwr.tombKeeper.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;

@Component
public class MD5Generator {

	public String encode(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		byte[] bytesOfPassword = password.getBytes("UTF-8");

		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] thedigest = md.digest(bytesOfPassword);
		
		return new String(thedigest);
	}
}
