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
		//先执行tensor命令
		System.out.println("start");
		String[] args = new String[]{"zsh", "/home/cmh/train.sh"};
		Process pr = Runtime.getRuntime().exec(args);
		BufferedReader in = new BufferedReader(new InputStreamReader(pr.getErrorStream()));
		String line;
		while ((line = in.readLine()) != null) {
			System.out.println(line);
		}
		in.close();
		pr.waitFor();
		
		System.out.println("end");
	}
}
