package com.furuize.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author WuJie
 * @date 2018年4月21日下午9:46:04
 * @version 1.0
 **/
public class Util {
	public static void call() throws IOException, InterruptedException {
		System.out.println("start");
		String[] arg1 = new String[] { "python", "E:\\pydemo\\demo.py" };
		Process pr = Runtime.getRuntime().exec(arg1);
		BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
		String line;
		while ((line = in.readLine()) != null) {
			System.out.println(line);
		}
		in.close();
		pr.waitFor();
		System.out.println("end");
	}
}
