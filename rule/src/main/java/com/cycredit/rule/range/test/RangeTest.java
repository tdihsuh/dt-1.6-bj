package com.cycredit.rule.range.test;


import com.cycredit.rule.range.core.MemoryRange;
import com.cycredit.rule.range.pojo.Range;

import java.util.Map;

/**
 * Created by qiyubin on 2017/8/30 0030.
 *
 * @author qiyubin
 */
public class RangeTest {


    public static void main(String[] args) {
        try {

            Map<String, Range> map = MemoryRange.localRule;
//            System.out.print(map);
//            Range ageRange = map.get("age");
//            System.out.println(ageRange.outputResult(17));
//            System.out.println(ageRange.outputResult(28));
//            System.out.println(ageRange.outputResult(33));
//            System.out.println(ageRange.outputResult(47));
//            System.out.println(ageRange.outputResult(59));


            Range vocationalRange = map.get("vocational");
//            System.out.println(vocationalRange.outputResult("一级"));
//            System.out.println(vocationalRange.outputResult("二级"));
            System.out.println(vocationalRange.outputResult("三级"));
//            System.out.println(vocationalRange.outputResult("四级"));
//            System.out.println(vocationalRange.outputResult("五级"));
//            System.out.println(vocationalRange.outputResult(""));


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
