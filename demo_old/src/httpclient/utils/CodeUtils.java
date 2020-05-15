package httpclient.utils;

import org.apache.commons.lang3.ObjectUtils;
/*20190719 UPD Java環境のミドルウェア・ライブラリ更新 START*/
//import org.apache.commons.lang.ObjectUtils;
//import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.math.NumberUtils;
/*20190719 UPD Java環境のミドルウェア・ライブラリ更新 END*/

/**
 * コードに関するユーティリティクラス.
 * 
 */
public final class CodeUtils {

    /**
     * コンストラクタ.
     */
    private CodeUtils() {
    }

    /**
     * コードに対応するCodeEnumを取得する.
     * 
     * @param <T> CodeEnumの型
     * @param code コード値
     * @param enums enum一覧
     * @return コードに対応するCodeEnum
     */
    public static <T extends CodeEnum> T findCode(Number code, T[] enums) {
        Integer codeValue = code == null ? null : code.intValue();
        for (T lineType : enums) {
            if (ObjectUtils.equals(lineType.getInteger(), codeValue)) {
                return lineType;
            }
        }
        return null;
    }

    /**
     * コードが示すコード値と数値が等しいか調べる.
     * 
     * @param e コード
     * @param n コード値
     * @return コードが示すコード値と数値が等しいか
     */
    public static boolean codeEquals(CodeEnum e, Number n) {
        Integer code = e.getInteger();
        if (n == null) {
            return (code == null);
        } else {
            return code.intValue() == n.intValue();
        }
    }

    /**
     * コードが示すコード値と数値が等しいか調べる.
     * 
     * @param e コード
     * @param s コード値
     * @return コードが示すコード値と数値が等しいか
     */
    public static boolean codeEquals(CodeEnum e, String s) {
        Integer code = e.getInteger();
        if (s == null) {
            return (code == null);
        } else {
            if (!NumberUtils.isNumber(s)) {
                return false;
            }
            return code.intValue() == Integer.parseInt(s);
        }
    }
}
