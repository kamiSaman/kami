package encryption;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * MD5的全称是Message-Digest Algorithm 5
 * 特点：
 *  1、不可逆
 *  2、高度的离散性、没有规律可循，点点变化就会导致MD5的巨大变化
 *  3、128位，可重复性极低
 * 作用：
 *  1、通常用于密码的加密存储，数字签名，文件完整性验证等
 *  不可逆向解析，但可通过查询MD5库进行解密
 * @author kami
 */
public class MD5Utils{
	public static void main(String[] args){
//		String pathFirst="C:\\下载\\httpclient-4.5.jar";
//		String pathSecond="C:\\Users\\860119012\\Desktop\\ライブラリ\\javax.mail.jar";
//		File fileFirst=new File(pathFirst);
//		File fileSecond=new File(pathSecond);
//		
//		String firstMD5=getFileMD5(fileFirst);
//		String secondMD5=getFileMD5(fileSecond);
//		
//		System.out.println("firstMD5	："+firstMD5);
//		System.out.println("secondMD5	："+secondMD5);
//		System.out.println(firstMD5.equals(secondMD5));
		
		
		String text = "accd";
		String goal = getMD5(text);
		System.out.println("firstMD5	："+goal);
	}
	
	// 获取字符串的MD5
	private static String getMD5(String content){
		MessageDigest digest;
		StringBuilder builder = new StringBuilder();
		
		try {
			digest = MessageDigest.getInstance("MD5");
			digest.update(content.getBytes());
			
			// 字符串生成hash值 
			
			for (byte b : digest.digest()) {
				builder.append(Integer.toHexString((b >> 4) & 0xf));
				builder.append(Integer.toHexString(b & 0xf));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return builder.toString();
    }
	
	// 获取文件的MD5
	@SuppressWarnings("unused")
	private static String getFileMD5(File file){
		if (!file.isFile()) {
	        return "文件不存在！";
	    }
	    MessageDigest digest = null;
	    FileInputStream in = null;
	    byte buffer[] = new byte[8192];
	    int len;
	    try {
	        digest =MessageDigest.getInstance("MD5");
	        in = new FileInputStream(file);
	        while ((len = in.read(buffer)) != -1) {
	            digest.update(buffer, 0, len);
	        }
	        BigInteger bigInt = new BigInteger(1, digest.digest());
	        return bigInt.toString(16);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    } finally {
	        try {
	            in.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
}
