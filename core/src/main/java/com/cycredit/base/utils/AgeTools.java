package com.cycredit.base.utils;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by qiyubin on 2017/9/25 0025.
 */
public class AgeTools {

    public static void main(String[] args) {

        System.out.println("210102196205290027".substring(6,10));
        System.out.println("210102196205290027".substring(16,17));

        try {
            System.out.print(getAgeByBirthYear("1987"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static int getAgeByBirthYear(String birthday) throws ParseException {
        Date date = DateUtils.parseDate(birthday, "yyyy");
        return getAgeByBirth(date);
    }


    private static int getAgeByBirth(Date birthday) {
        int age = 0;
        try {
            Calendar now = Calendar.getInstance();
            now.setTime(new Date());// 当前时间

            Calendar birth = Calendar.getInstance();
            birth.setTime(birthday);

            if (birth.after(now)) {//如果传入的时间，在当前时间的后面，返回0岁
                age = 0;
            } else {
                age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
//                if (now.get(Calendar.DAY_OF_YEAR) > birth.get(Calendar.DAY_OF_YEAR)) {
//                    age += 1;
//                }
            }
            return age;
        } catch (Exception e) {//兼容性更强,异常后返回数据
            return 0;
        }
    }
}
