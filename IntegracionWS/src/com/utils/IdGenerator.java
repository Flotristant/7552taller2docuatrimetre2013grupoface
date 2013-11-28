package com.utils;

public class IdGenerator {

	public static Long generateTransactionId() {
		return Thread.currentThread().getId();
	}
}
