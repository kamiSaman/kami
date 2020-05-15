package main;

import java.util.ArrayList;
import java.util.List;

public class TestArraylist {
	public static void main(String[] args) {
		arraylistContains();
	}

	/*
	 * ArrayList 中元素是否包含【11】
	 */
	public static void  arraylistContains() {
		List<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		list.add("nnn");
		list.add("ccc");
		list.add("ddd");

		// false
		System.out.println(list.contains("11"));
	}
}
