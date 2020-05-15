package httpclient.utils;

import java.math.BigDecimal;

/**
 * コード列挙型のインターフェース
 * 
 */
public interface CodeEnum {
    /**
     * コード値を取得する.
     * 
     * @return コード値
     */
    BigDecimal getCode();

    /**
     * コード値を取得する.
     * 
     * @return コード値
     */
    Integer getInteger();

    /**
     * メッセージを取得する.
     * 
     * @return メッセージ
     */
    String getValue();
}
