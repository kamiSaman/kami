package mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class Mail {
	public static void main(String[] args) throws EmailException {

		sendMailFromJavaMail();

		Email mail = new SimpleEmail();

		//
		mail.setHostName("smtp.partner.outlook.cn");
		mail.setSmtpPort(Integer.parseInt("587"));

		mail.setCharset("UTF-8"); // 设定字符集
		mail.setStartTLSEnabled(true);
		//mail.setAuthentication("kong.lingying@fujisoft-china.com", "king123.");
		mail.setAuthentication("wang.tao@fujisoft-china.com", "753.wangtao");


		mail.addHeader("Errors-To", "imakoto@fsi.co.jp");
		mail.addHeader("Envelope-From", "imakoto@fsi.co.jp");

		mail.setFrom("wang.tao@fujisoft-china.com"); // メール情報FromにfromAddressを設定
		//mail.setFrom("kong.lingying@fujisoft-china.com"); // メール情報FromにfromAddressを設定
		mail.addTo("kong.lingying@fujisoft-china.com"); // メール情報のTo に toAddressesを設定
		System.out.println("发送完毕。。。。。");


		mail.setSubject("国内宿泊利用前リマインド（非会員）メール"); // メール情報の件名 に subjectを設定
		mail.setMsg("-----------------------------------------------------------------------\n※本メールは、自動的に配信しています。\nこちらのメールは送信専用のため、直接ご返信いただいてもお問い合わせには\nお答えできませんので、あらかじめご了承ください。\n宿泊施設へのご連絡は、下記の電話番号をご利用ください。\n-----------------------------------------------------------------------\n井上　貴宏 様\nマイナビトラベルをご利用いただき、ありがとうございます。\n\nご出発が近づいております。\nお気をつけて行ってらっしゃいませ。\n\n▼今回ご宿泊の宿・ホテル\n疎通用 品川シーサイド外部結合ホテル\n茨城県水戸市8-7-9\n電話番号：0120-44-8888\nチェックイン日：2016年7月22日（金）～　1泊\nチェックイン時間：15:00\n食事：朝食あり、昼食あり、夕食あり\n予約番号：mtttwmuy\n宿の詳細情報：\nhttps://travel.mynavi.jp/yado/S000001/index.html\nMAP・アクセス：\nhttps://travel.mynavi.jp/yado/S000001/access.html\n\n▼予約内容確認\nhttps://travel.mynavi.jp/nonmbr/booking/index.html\n\n━━━━━━━━━━━━━━━━━━━━━━━━━\n※本メールは送信専用アドレスより自動送信しております。\n※ご不明な点などございましたら、下記ページをご確認ください。\n　解決されない場合はページ内のお問い合わせフォームよりご連絡ください。\n\n▼マイナビトラベル ヘルプ\nhttps://travel.mynavi.jp/\n\n--------------------------------------------------\n株式会社マイナビ\nマイナビトラベル\n\n(C) Mynavi Corporation\n━━━━━━━━━━━━━━━━━━━━━━━━━\n一般サイトPC\n\n予約番号　mtttwmuy\n予約受付日時　2016年1月6日（水） 16:09\nチェックイン日　2016年7月22日（金）\nチェックイン予定時刻　15:00\n泊数　1泊\n部屋数　1室\n決済方法　現地決済\n代表宿泊者名　井上　貴宏\n代表宿泊者名フリガナ　イノウエ　タカヒロ\n連絡先郵便番号　〒133-0002\n代表宿泊者住所　東京都品川区東品川１－２－３日立ソフトタワーＡ\n連絡先電話番号　0357801111\n代表宿泊者メールアドレス　kong.lingying@fujisoft-china.com\n宿泊料金合計　18,000円\n法人割引額　なし\n調整金額　0円\n差引支払金額　18,000円\n現地支払金額　18,000円\nキャンセルチャージ額　0円\n付与予定ポイント数/今回発生ポイント　666ポイント\n利用ポイント数　なし\nクーポン割引額　なし\n変更受付日時　2016年1月6日（水） 16:23\nキャンセル受付日時　\n施設ID　S000001\n施設名　疎通用 品川シーサイド外部結合ホテル\n施設郵便番号　〒319-0315\n施設住所　茨城県水戸市8-7-9\n施設電話番号　0120-44-8888\nチェックイン可能時間　10:00～25:00\nチェックアウト時間　10:00\nプランID　P00000003\nプラン名　一人あたり料金プランA\nプラン説明　このプランは一人あたりの料金で精算されます。\n部屋タイプID　R0000003\n部屋タイプ名　部屋タイプA　説明なし\nお食事（食事条件）　朝食あり、昼食あり、夕食あり\nクーポン名　－\n予約者氏名　井上　貴宏\n予約者連絡先　0357801111\n予約者メールアドレス　kong.lingying@fujisoft-china.com\n過去宿泊実績　有\n予約金要否　あり\n予約金情報（サブテンプレート）　・予約金金額　　　　　　　　：宿泊料金の20％\n・予約金支払期限　　　　　　：宿泊の5日前まで\n・予約金支払方法　　　　　　：振込\n・予約金振込口座番号　　　　：富士ソフト銀行　秋葉原支店\n・予約金現金書類送付先住所　：－\n・予約金入金確認方法　　　　：メール\r\n宿泊施設からの連絡事項（サブテンプレート）　設問1：このホテルをどこで知りましたか？\n回答1：Web\r\n設問2：当ホテルの料金はどう思いますか?\n回答2：普通\r\n部屋別宿泊者リスト（サブテンプレート）　・1室目　 大人女性 2名  \r\n宿泊日リスト（サブテンプレート）　　1泊目：(2016年1月11日（月））\n　1部屋目） 9,000円（大人） × 2名　　\r\n　小計：18,000円\r\nキャンセルポリシー（サブテンプレート）　　 - 5日前：宿泊料金の10％\r\n　 - 4日前：宿泊料金の20％\r\n　 - 3日前：宿泊料金の30％\r\n　 - 2日前：宿泊料金の40％\r\n　 - 1日前：宿泊料金の50％\r\n　 - 当日：宿泊料金の100％\r\n　 - 連絡なしの不泊：宿泊料金の100％\r\n料金特記　料金特記事項です\nキャンセルポリシー補足　5日前からキャンセルされる場合、キャンセル料がかかりますのでご注意ください\n人数合計　2人（内幼児0人を含む）\n大人合計人数（男女計）　大人 2人\n子供合計人数　"); // メール情報の本文 に messageを設定
		mail.send();


	}

	// javaMail API
	public static void sendMailFromJavaMail() {
		  // 收件人电子邮箱
	      String to = "kong.lingying@fujisoft-china.com";

	      // 发件人电子邮箱
	      String from = "kong.lingying@fujisoft-china.com";

	      // 指定发送邮件的主机为 localhost
	      String host = "localhost";

	      // 获取系统属性
	      Properties properties = System.getProperties();

	      // 设置邮件服务器
	      properties.setProperty("mail.smtp.host", host);

	      // 获取默认session对象
	      Session session = Session.getDefaultInstance(properties);

	      try{
	         // 创建默认的 MimeMessage 对象
	         MimeMessage message = new MimeMessage(session);

	         // Set From: 头部头字段
	         message.setFrom(new InternetAddress(from));

	         // Set To: 头部头字段
	         message.addRecipient(Message.RecipientType.TO,
	                                  new InternetAddress(to));

	         // Set Subject: 头部头字段
	         message.setSubject("This is the Subject Line!");

	         // 设置消息体
	         message.setText("This is actual message");

	         // 发送消息
	         Transport.send(message);
	         System.out.println("Sent message successfully....");
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	}
}
