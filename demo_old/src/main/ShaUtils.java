package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ShaUtils {
	public static void main(String[] args) throws Exception {
		// 字符串加密
		String strSHA1 = ""; 
		String strSHA2 = ""; 
		
		String SHA1 = getSHA(strSHA1);
		String SHA2 = getSHA(strSHA2);
		
		System.out.println("strSHA1	：" + SHA1);
		System.out.println("strSHA2	：" + SHA2);
		System.out.println(SHA1.equals(SHA2));
		
		// 文件加密
		String pathFirst = "C:\\下载\\httpclient-4.5.jar";
		String pathSecond = "C:\\Users\\860119012\\Desktop\\ライブラリ\\javax.mail.jar";

		String firstSHA = getSHA(new File(pathFirst));
		String secondSHA = getSHA(new File(pathSecond));

		System.out.println("firstSHA	：" + firstSHA);
		System.out.println("secondSHA	：" + secondSHA);
		System.out.println(firstSHA.equals(secondSHA));
		
		
		
		
	}

	/***
	 * SHA加密 
	 * 生成40位SHA码 加密速度比md5慢 性能比md5低 安全强度比md5高
	 * @param 待加密字符串
	 * @return 返回40位SHA码
	 */
	public static String getSHA(String inStr) throws Exception {
		MessageDigest sha = null;
		try {
			sha = MessageDigest.getInstance("SHA");
		} catch (Exception e) {
			e.printStackTrace();
			return "转换异常！！！";
		}
 
		byte[] byteArray = inStr.getBytes("UTF-8");
		byte[] md5Bytes = sha.digest(byteArray);
		StringBuffer hexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16) {
				hexValue.append("0");
			}
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
	}
	
	/***
	 * SHA加密 
	 * 生成40位SHA码 加密速度比md5慢 性能比md5低 安全强度比md5高
	 * @param 待加密文件
	 * @return 返回40位SHA码
	 */
	public static String getSHA(File file) {
		FileInputStream fis = null;
		try {
			MessageDigest md;
			md = MessageDigest.getInstance("SHA");
			fis = new FileInputStream(file);
			byte[] buffer = new byte[8192];
			int length = -1;
			
			System.out.println("开始算");
			while((length = fis.read(buffer)) != -1) {
				md.update(buffer, 0, length);
			}
			System.out.println("算完了");
				
			return bytesToString(md.digest());
		}catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (IOException ex) {
			//Logger.getLogger(ShaUtils.class.getName()).log(Level.ERROR, null, ex);
			System.out.println(ex);
			return null;
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}
		
		return null;
	}

	private static String bytesToString(byte[] digest) {
		// TODO Auto-generated method stub
		return null;
	}
}