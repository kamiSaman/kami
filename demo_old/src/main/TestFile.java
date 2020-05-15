package main;

import java.io.File;
import java.io.IOException;

public class TestFile {
	public static void main(String[] args) {
		createDirectory();
	}

	public static void createDirectory() {
		String disName = "/var/log/webapps/";
		File file = new File(disName);
		if (file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
	}

}
