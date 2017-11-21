package com.cycredit.base.utils;

import org.junit.Ignore;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Ignore
public class MD5Utils {

    // 小写的字符串
    private static char[] DigitLower = {'0', '1', '2', '3', '4', '5', '6',
            '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    // 大写的字符串
    private static char[] DigitUpper = {'0', '1', '2', '3', '4', '5', '6',
            '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};


    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }

        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    public static String MD5Encode(String origin, String charsetname) {
        String resultString = null;
        try {
            resultString = origin;
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetname == null || "".equals(charsetname)) {
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes("utf-8")));
            } else {
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes(charsetname)));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return resultString;
    }

    private static final String hexDigits[] = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    /**
     * 加密之后的字符串全为小写
     *
     * @param srcStr
     * @return
     * @throws NoSuchAlgorithmException
     * @throws NullPointerException
     */
    public static String getMD5Lower(String srcStr)
            throws NoSuchAlgorithmException {
        String sign = "lower";
        return processStr(srcStr, sign);
    }

    /**
     * 加密之后的字符串全为大写
     *
     * @param srcStr
     * @return
     * @throws NoSuchAlgorithmException
     * @throws NullPointerException
     */
    public static String getMD5Upper(String srcStr)
            throws NoSuchAlgorithmException {
        String sign = "upper";
        return processStr(srcStr, sign);
    }

    private static String processStr(String srcStr, String sign)
            throws NoSuchAlgorithmException, NullPointerException {
        MessageDigest digest;
        // 定义调用的方法
        String algorithm = "MD5";
        // 结果字符串
        StringBuffer result = new StringBuffer();
        // 初始化并开始进行计算
        digest = MessageDigest.getInstance(algorithm);
        try {
            digest.update(srcStr.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] byteRes = digest.digest();

        // 计算byte数组的长度
        int length = byteRes.length;

        // 将byte数组转换成字符串
        for (int i = 0; i < length; i++) {
            result.append(byteHEX(byteRes[i], sign));
        }

        return result.toString();
    }

    /**
     * 将btye数组转换成字符串
     *
     * @param bt
     * @return
     */
    private static String byteHEX(byte bt, String sign) {

        char[] temp = null;
        if ("lower".equalsIgnoreCase(sign)) {
            temp = DigitLower;
        } else if ("upper".equalsIgnoreCase(sign)) {
            temp = DigitUpper;
        } else {
            throw new RuntimeException("加密缺少必要的条件");
        }
        char[] ob = new char[2];

        ob[0] = temp[(bt >>> 4) & 0X0F];

        ob[1] = temp[bt & 0X0F];

        return new String(ob);
    }

    public static String getMD5(String content) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(content.getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (messageDigest == null) {
            return null;
        }
        byte[] byteArray = messageDigest.digest();

        StringBuffer md5StrBuff = new StringBuffer();

        for (int i = 0; i < byteArray.length; i++) {
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1) {
                md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
            } else {
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
            }
        }

        return md5StrBuff.toString();
    }

    public static void main(String[] args) {
        String content = getMD5("24358");
        System.out.println(content);
    }

}
