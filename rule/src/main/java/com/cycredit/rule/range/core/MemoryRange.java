package com.cycredit.rule.range.core;


import com.cycredit.base.utils.NumberValidationUtils;
import com.cycredit.rule.range.exception.UnknownRuleException;
import com.cycredit.rule.range.pojo.Condition;
import com.cycredit.rule.range.pojo.Range;

import com.google.common.collect.Maps;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * Created by qiyubin on 2017/8/30 0030.
 *
 * @author qiyubin
 */
public class MemoryRange {


    public static Map<String, Range> localRule;

    static {
        try {
            localRule = readRuleToMemory();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnknownRuleException e) {
            e.printStackTrace();
        }
    }

    /**
     * t@test|e@test|r@1,t@test|e@test1|r@2
     * t@ 表示类型
     * e@ 表示等于时的情况
     * r@ 表示 结果为
     * e@ 表示第二个等于的情况
     *
     * @return
     * @throws IOException
     * @throws UnknownRuleException
     */
    public static Map<String, Range> readRuleToMemory() throws IOException, UnknownRuleException {

        String rule = readRule();

        rule = rule.replaceAll("(\r\n|\r|\n|\n\r)", "");

        String[] rules = rule.split(",");

        Map<String, Range> map = Maps.newHashMap();
        for (String realRule : rules) {
            String[] ruleDetails = realRule.split("\\|");
            String type, eq, result;
            if (ruleDetails.length == 0) {
                throw new UnknownRuleException();
            }

            Condition condition = Condition.newInstance();
            String t = null;
            for (String ruleDetail : ruleDetails) {
                String[] items = ruleDetail.split("@");
                if (items.length < 2) {
                    throw new UnknownRuleException();
                }
                String key = items[0];
                String value = items[1];


                if ("t".equals(key)) {
                    t = value;
                } else {
                    Object val = null;
                    if (NumberValidationUtils.isPositiveInteger(value)) {
                        val = Integer.parseInt(value);
                    } else if (NumberValidationUtils.isPositiveDecimal(value)) {
                        val = Double.parseDouble(value);
                    } else {
                        val = value;
                    }


                    if ("e".equals(key)) {
                        condition.eq(val);
                    } else if ("r".equals(key)) {
                        condition.result(val);
                    } else if ("gt".equals(key)) {
                        condition.greatThan(val);
                    } else if ("get".equals(key)) {
                        condition.greatOrEqThan(val);
                    } else if ("lt".equals(key)) {
                        condition.lessThan(val);
                    } else if ("let".equals(key)) {
                        condition.lessOrEqThan(val);
                    } else if ("other".equals(key)) {
                        condition.other();
                    }
                }

            }

            if (t != null) {
                Range range;
                if (map.get(t) != null) {
                    range = map.get(t);
                } else {
                    range = new Range();
                }

                if (condition.getPoint() != null) {
                    range.addInputCondition(condition);
                }

                map.put(t, range);
            }

        }
        return map;


    }


    public static String readRule() throws IOException {
        //类路径，编译后classes目录下
        String filePath = "rule/p-rule";
        Resource resource1 = new ClassPathResource(filePath);
        StringBuffer str = new StringBuffer("");
        int len = 0;
        InputStream is = null;
        BufferedReader in = null;
        try {
            is = resource1.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, "UTF-8");
            in = new BufferedReader(isr);
            String line = null;
            while ((line = in.readLine()) != null) {
                // 处理换行符的问题
                if (len != 0) {
                    str.append("\r\n" + line);
                } else {
                    str.append(line);
                }
                len++;

            }
            return str.toString();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                is.close();
            }
            if (in != null) {
                in.close();
            }
        }
        return null;
    }

}
