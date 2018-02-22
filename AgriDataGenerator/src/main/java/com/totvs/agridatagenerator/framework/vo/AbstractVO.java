package com.totvs.agridatagenerator.framework.vo;

import java.security.SecureRandom;

public abstract class AbstractVO {

	private static final String SHA1PRNG = "SHA1PRNG";

	public long generateGUID() {
		long random = super.hashCode();

		try {
			random = SecureRandom.getInstance(SHA1PRNG).nextLong();
		} catch (Exception e) {
		}

		return Math.abs(random);
	}

}
