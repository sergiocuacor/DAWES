package com.sergio.proyecto.utils;

import java.util.Scanner;

public class ScannerUtils {
	private static Scanner sc;

	private ScannerUtils() {

	}

	public static Scanner getScanner() {
		if (sc == null) {
			return new Scanner(System.in);
		} else {
			return sc;
		}
	}
}
