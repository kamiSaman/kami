package httpclient.utils;

import java.math.BigDecimal;

import httpclient.utils.CodeEnum;
import httpclient.utils.CodeUtils;

/**
 * バッチ処理結果のコード.
 *
 */
public enum BatchResult implements CodeEnum {
    /** DBクエリエラー */
    DB_QUERY_ERROR(80001, "DBクエリエラー"),
    /** 引数チェック異常 */
    PARAMETER_ERROR(81000, "引数チェック異常"),
    /** 初期化処理異常 */
    INITIAL_ERROR(81001, "初期化処理異常"),
    /** 利用登録/解約予約解除の手動実行バッチパラメータ異常 */
    CONTUSER_BATCH_INVALID_PARAM(82100, "利用登録/解約予約解除の手動実行バッチパラメータ異常"),
    /** コンテンツ利用登録/利用解約バッチパラメータ異常 */
    FUTURE_CONTENTS_ACCOUNT_BATCH_INVALID_PARAM(82300, "コンテンツ利用登録/利用解約バッチパラメータ異常"),
    /** 利用登録/解約キュー登録バッチパラメータ異常 */
    REGIST_QUEUE_BATCH_INVALID_PARAM(82500, "利用登録/解約キュー登録バッチパラメータ異常"),
    /** 事業者解約情報通知メールバッチパラメータ異常 */
    PROV_CANCEL_INFO_BATCH_INVALID_PARAM(82700, "事業者解約情報通知メールバッチパラメータ異常"),
    /** HTTP通信異常 */
    HTTP_COMMUNICATE_ERROR(83100, "HTTP通信異常"),
    /** SOAP通信異常 */
    SOAP_COMMUNICATE_ERROR(83200, "SOAP通信異常"),
    /** メールサーバ接続異常 */
    SMTP_CONNECTION_ERROR(83300, "メールサーバ接続異常"),
    /** メール送信失敗（SMTPプロトコル異常） */
    MAIL_SEND_ERROR(83301, "メール送信失敗（SMTPプロトコル異常）"),
    /** メール抑止. */
    REJECT_MAILADDR_INFO(83302,"メール送信抑止"),
    /** メール送信抑止アドレス定義ファイルのフォーマット異常. */
    REJECT_MAILADDR_PRP_WARN(83303, "送信抑止対象アドレス条件の設定ファイル異常"),
    /** メールアドレス形式の異常. */
    REJECT_MAILADDR_FORM_WARN(83304, "メールアドレス形式の異常"),
    /** 再送できないメール送信エラー. */
    MAIL_SEND_NORETRY_ERROR(83306, "再送できないメール送信エラー"),
    /** メール送信リトライ警告. */
    MAIL_SEND_RETRY(83307, "メール送信リトライ警告"),
    /** メール送信リトライ回数超過. */
    MAIL_SEND_RETRY_OVER(83308, "メール送信リトライ回数超過"),
    /* STEP5 Phase2 start */
    /** 予約データ削除バッチ：予約データ削除失敗. */
    RESERVE_CONTENT_DELETE_ERROR(83400, "予約データ削除バッチ：予約データ削除失敗"),
    /* STEP5 Phase2 end */
    /** その他エラー */
    UNKNOWN(99999, "その他エラー");

    /** コード値 */
    private final Integer code;
    /** BigDecimalの値 */
    private final BigDecimal bigDecimalCode;
    /** コード名称 */
    private final String value;

    /**
     * コンストラクタ.
     *
     * @param code コード値
     */
    private BatchResult(Integer code, String label) {
        this.code = code;
        this.bigDecimalCode = code == null ? null : new BigDecimal(code);
        this.value = label;
    }

    /**
     * code を取得する.
     *
     * @return code
     */
    public BigDecimal getCode() {
        return bigDecimalCode;
    }

    /**
     * code を取得する.
     *
     * @return code
     */
    public Integer getInteger() {
        return code;
    }

    /**
     * value を取得する.
     *
     * @return value
     */
    public String getValue() {
        return value;
    }

    /**
     * コード値からenumを探す.
     *
     * @param code コード値
     * @return enum
     */
    public static BatchResult findCode(Number code) {
        return CodeUtils.findCode(code, values());
    }

    /**
     * コード値から値を取得する.
     *
     * @param code コード値
     * @return 値
     */
    public static String codeToValue(Number code) {
        BatchResult obj = findCode(code);
        return obj == null ? null : obj.getValue();
    }

    /**
     * コードオブジェクトとコード値が等しいか調べる.
     *
     * @param n コード値
     * @return コードオブジェクトとコード値が等しいか
     */
    public boolean codeEquals(Number n) {
        return CodeUtils.codeEquals(this, n);
    }

    /**
     * コードオブジェクトとコード値が等しいか調べる.
     *
     * @param s コード値
     * @return コードオブジェクトとコード値が等しいか
     */
    public boolean codeEquals(String s) {
        return CodeUtils.codeEquals(this, s);
    }
}
