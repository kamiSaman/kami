package httpclient;

//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.StringReader;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Properties;

//import org.apache.commons.httpclient.HttpClient;
//import org.apache.commons.httpclient.HttpStatus;
//import org.apache.commons.httpclient.methods.PostMethod;
//import org.apache.commons.httpclient.util.EncodingUtil;
//import org.apache.commons.httpclient.NameValuePair;
//import org.apache.http.message.BasicNameValuePair;

//import httpclient.utils.BatchResult;



public class HttpClientOld {
//	static String MANUAL_APSERVER_ENCODING = "manual.apserver.encoding";
//	
//	public static void main(String[] args) {
//		// リクエストパラメータ作成
////      String url = executeType.config.getString();
//		
//		
//		String url = "http://172.31.25.7:8080/AP.NGN/webif/contregpost.do";
//		
//		Properties properties = readInputFile("C:\\Users\\860119012\\Desktop\\111.properties");
//		
//		  PostMethod method = new PostMethod(url);
//		  method.getParams().setContentCharset("windows-31j");
//		  method.setRequestBody(createParameter(properties, "1"));
//
//      // リクエスト実行
//      try {
//          executeRequest(method);
//      } catch (IOException e) {
//          System.out.println("result=ERROR(HTTP通信　例外発生)");
//      }
//		
//		
//	}
//
//	
//	static Properties readInputFile(String filename) {
//
//
//        FileInputStream in = null;
//        InputStreamReader rd = null;
//        try {
//            in = new FileInputStream(filename);
//            rd = new InputStreamReader(in, "EUC-JP");
//            Properties properties = new Properties();
//            properties.load(rd);
//
//            if (isValidInputFile(properties)) {
//                System.out.println("　手動実行入力ファイルの読み込み　終了    (Properties：" + properties + ")");
//                return properties;
//            } else {
//                System.out.println(BatchResult.CONTUSER_BATCH_INVALID_PARAM+ "　手動実行入力ファイルの読み込み　異常終了(Properties："
//                        + properties + ")");
//                return null;
//            }
//        } catch (IOException e) {
//            System.out.println(BatchResult.CONTUSER_BATCH_INVALID_PARAM+"　手動実行入力ファイルの読み込み　例外発生(filenam：" + filename+ ")"+e);
//            return null;
//        } finally {
//        	try {
//				rd.close();
//				in.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//        }
//    }
//	
//	
//	static boolean isValidInputFile(Properties properties) {
//        boolean result = true;
//
//        // １文字以上の値が設定されているかのチェックを行う
//        String[] requiredValueFields = { "req.logid", "req.sendcount" };
//        for (String field : requiredValueFields) {
//            boolean value = properties.containsKey(field) && ((properties.getProperty(field)) != null);
//            if (!value) {
//                System.out.println("入力情報の設定内容異常    (" + field + "=" + properties.getProperty(field) + ")");
//            }
//            result &= value;
//        }
//
//        // プロパティが定義されているかのチェックを行う
//        String[] requiredFields = { "req.sendmsg", "req.recvmsg" };
//        for (String field : requiredFields) {
//            boolean value = properties.containsKey(field);
//            if (!value) {
//                System.out.println("入力情報の設定内容異常    (" + field + "=" + properties.getProperty(field) + ")");
//            }
//            result &= value;
//        }
//        return result;
//    }
//	
//	
//	static List<? extends NameValuePair> createParameter1(Properties properties, String manualType) {
//	    /*20190723 UPD Java環境のミドルウェア・ライブラリ更新 END*/
//	        
//	    	ArrayList<NameValuePair> list = new ArrayList<NameValuePair>();
//	        for (String key : new String[] { "logid", "sendresult", "sendcount", "sendurl", "sendmsg", "recvmsg" }) {
//	            
//	        	/*20190723 UPD Java環境のミドルウェア・ライブラリ更新 START*/
//	        	// list.add(new NameValuePair(key, properties.getProperty("req." + key)));
////	            list.add(new BasicNameValuePair(key, properties.getProperty("req." + key)));
//	            /*20190723 UPD Java環境のミドルウェア・ライブラリ更新 END*/
//	            
//	        }
//	        
//	        /*20190723 UPD Java環境のミドルウェア・ライブラリ更新 START*/
//	        // list.add(new NameValuePair("manualtype", manualType.getInteger().toString()));
//	        // return list.toArray(new NameValuePair[list.size()]);
////	        list.add(new BasicNameValuePair("manualtype", manualType));
//	        return list;
//	        /*20190723 UPD Java環境のミドルウェア・ライブラリ更新 END*/
//	        
//	    }
//	
//	 static NameValuePair[] createParameter(Properties properties, String manualType) {
//			ArrayList<NameValuePair> list = new ArrayList<NameValuePair>();
//			for (String key : new String[] { "logid", "sendresult", "sendcount", "sendurl", "sendmsg", "recvmsg" }) {
//			list.add(new NameValuePair(key, properties.getProperty("req." + key)));
//			}
//			list.add(new NameValuePair("manualtype", manualType));
//			return list.toArray(new NameValuePair[list.size()]);
//    }
//	 
//	 
//	 static void executeRequest(PostMethod method) throws IOException {
//
//	        String content = EncodingUtil
//	                .formUrlEncode(method.getParameters(), "windows-31j");
//
//	        System.out.println("HTTP通信　開始");
//	        System.out.println(" 通信先URL : " + method.getURI().toString());
//	        System.out.println(" 送信するリクエスト : " + content);
//
//	        HttpClient client = new HttpClient();
//	        client.getParams().setContentCharset("windows-31j");
//	        client.executeMethod(method);
//	        int statusCode = method.getStatusCode();
//	        if (statusCode != HttpStatus.SC_OK) {
//	            System.out.println(BatchResult.HTTP_COMMUNICATE_ERROR+ "　HTTPステータスコード異常　HttpStatus : " + statusCode
//	                    + "　ResponseBody : " + method.getResponseBodyAsString());
//	            System.out.println("result=ERROR(HTTPステータスコード異常)");
//	        } else {
//	            System.out.println("HTTPステータスコード正常");
//	            System.out.println("　HttpStatus : " + statusCode);
//	            System.out.println("　ResponseBody : " + method.getResponseBodyAsString());
//	            Properties response = getResponseMap(method.getResponseBodyAsString());
//
//	            System.out.println("応答情報 : " + response);
//
//	            String result = response.getProperty("result");
//
//	            if ("0".equals(result) || "39000".equals(result)) {
//	                System.out.println("処理結果正常  [result=" + result + "]");
//	            } else {
//	            	System.out.println(BatchResult.HTTP_COMMUNICATE_ERROR+"　処理結果異常  [result=" + result + "]");
//	                System.out.println("result=ERROR(HTTP通信   処理結果異常)");
//	            }
//	        }
//	        System.out.println("HTTP通信　終了 ");
//	    }
//
//	 static Properties getResponseMap(String s) throws IOException {
//	        Properties properties = new Properties();
//	        properties.load(new StringReader(s));
//	        return properties;
//	    }
}
