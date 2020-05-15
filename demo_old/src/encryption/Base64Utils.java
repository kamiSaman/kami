package encryption;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Utils {
	
	public static void main(String[] args) {
		//Java 8 import java.util.Base64;
		final Base64.Decoder decoder = Base64.getDecoder();
		final Base64.Encoder encoder = Base64.getEncoder();
		
		String text = "这是一段明文";
		String encodedText = new String();
		String jiemi = new String();
		byte[] textByte;
		try {
			textByte = text.getBytes("UTF-8");
			//编码
			encodedText = encoder.encodeToString(textByte);
			//解码
			jiemi = new String(decoder.decode(encodedText), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		System.out.println("原文字："+text);
		System.out.println("加密字段："+encodedText);
		System.out.println("解密字段："+jiemi);
	}
	
	/**
	 * 获取Base64加密的值
	 * @param text
	 * @return
	 */
	public static String getBase64Str(String text) {
		final Base64.Encoder encoder = Base64.getEncoder();
		String encodedText = encoder.encodeToString(text.getBytes());
		return encodedText;
	}
}
