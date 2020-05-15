package com.fuji.test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;

public class Test {

		public static void main(String[] args) {



			System.out.println(LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE));
			System.out.println(DateTimeFormatter.BASIC_ISO_DATE);







			File zipFile = new File("C:\\share\\DT_csv_bak\\20200225180352.zip");
			System.out.println(zipFile.lastModified());

			LocalDate aa = LocalDate.parse("2020-02-18");
			System.out.println("+++++++++++++"+aa);
			System.out.println("+++++++++++++"+LocalDate.now());

			System.out.println("adsfds" + LocalDate.parse("2020-02-18"));


			String lastDay = new SimpleDateFormat("yyyyMMdd").format(new Date(zipFile.lastModified()));

			LocalDate today = LocalDate.now();
			System.out.println("Today's Local date : " + lastDay);

			if(today.isBefore(LocalDate.parse("2020-02-18"))) {

			}

			System.out.println("8天前 : " + today.minus(8, ChronoUnit.DAYS));


//			LocalDate dateOfBirth = LocalDate.of(2010, 01, 14);
//			System.out.println("Your Date of birth is : " + dateOfBirth);

			LocalDate previousYear = today.minus(5, ChronoUnit.YEARS);
			System.out.println("Date before 5 year : " + previousYear);
			LocalDate nextYear = today.plus(5, ChronoUnit.YEARS);
			System.out.println("Date after 5 year : " + nextYear);

			System.out.println(nextYear +"----"+ today);

//			String path = "C:\\tmp\\filePath";
//			ArrayList<String> fileNameList = new ArrayList<String>();
//			File file = new File(path);
//			File[] tempList = file.listFiles();
//
//			for (int i = 0; i < tempList.length; i++) {
//	            if (tempList[i].isFile()) {
//	              System.out.println("文     件：" + tempList[i]);
//	              System.out.println("最后一次修改日期" + tempList[i].lastModified());
//	                //fileNameList.add(tempList[i].toString());
//	                fileNameList.add(tempList[i].getName());
//	            }
//	            if (tempList[i].isDirectory()) {
//	              System.out.println("文件夹：" + tempList[i]);
////	                getAllFileName(tempList[i].getAbsolutePath(),fileNameList);
//	            }
//	        }
		}

//		public static void main(String[] args) {
//			//ArrayList<String> files = new ArrayList<String>();
//			String path = "C:\\tmp\\filePath";
//			ArrayList<String> fileNameList = new ArrayList<String>();
////	        boolean flag = false;
//	        File file = new File(path);
//	        File[] tempList = file.listFiles();
//
//	        for (int i = 0; i < tempList.length; i++) {
//	            if (tempList[i].isFile()) {
//	              System.out.println("文     件：" + tempList[i]);
//	                //fileNameList.add(tempList[i].toString());
//	                fileNameList.add(tempList[i].getName());
//	            }
//	            if (tempList[i].isDirectory()) {
//	              System.out.println("文件夹：" + tempList[i]);
////	                getAllFileName(tempList[i].getAbsolutePath(),fileNameList);
//	            }
//	        }
//		}

		/**
	     * 获取某个文件夹下的所有文件
	     *
	     * @param fileNameList 存放文件名称的list
	     * @param path 文件夹的路径
	     * @return
	     */
	    public static void getAllFileName(String path,ArrayList<String> fileNameList) {
	        //ArrayList<String> files = new ArrayList<String>();
//	        boolean flag = false;
	        File file = new File(path);
	        File[] tempList = file.listFiles();

	        for (int i = 0; i < tempList.length; i++) {
	            if (tempList[i].isFile()) {
	              System.out.println("文     件：" + tempList[i]);
	                //fileNameList.add(tempList[i].toString());
	                fileNameList.add(tempList[i].getName());
	            }
	            if (tempList[i].isDirectory()) {
	              System.out.println("文件夹：" + tempList[i]);
	                getAllFileName(tempList[i].getAbsolutePath(),fileNameList);
	            }
	        }
	        return;
	    }
}