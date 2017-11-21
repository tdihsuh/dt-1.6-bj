package com.cycredit.rule.range.pojo;

import com.google.common.collect.Sets;

import java.util.Objects;
import java.util.Set;

/**
 * Created by qiyubin on 2017/8/30 0030.
 *
 * @author qiyubin
 */
public class Range {

    public static void main(String[] args) {
        Range range = new Range();

        range.addInputCondition(Condition.newInstance().greatOrEqThan(1).lessOrEqThan(3).result(1));
        range.addInputCondition(Condition.newInstance().greatOrEqThan(4).lessOrEqThan(9).result(100));

        System.out.print(range.outputResult(new Integer(8)));


    }


    private Boolean result = true;
    private Set<Condition> conditions = Sets.newLinkedHashSet();

    public Set<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(Set<Condition> conditions) {
        this.conditions = conditions;
    }

    public Range addInputCondition(Condition condition) {
        conditions.add(condition);
        return this;
    }


    public Object outputResult(Comparable realObj) {

        Condition otherCondition = null;
        for (Condition condition : conditions) {
            if (condition.isOther) {
                otherCondition = condition;
            }

            if (Objects.nonNull(condition.eqObj)) {
                if (condition.eqObj.equals(realObj)) {
                    return condition.point;
                }
                continue;
            }
            Boolean checkBetween = false;
            if (Objects.nonNull(condition.startObj)) {
                if (realObj.compareTo(condition.startObj) == 1) {
                    checkBetween = true;
                } else {
                    if (condition.isEqStart) {
                        if (realObj.compareTo(condition.startObj) == 0) {
                            checkBetween = true;
                        } else {
                            checkBetween = false;
                        }
                    } else {
                        checkBetween = false;
                    }
                }
                if (checkBetween) {
                    if (Objects.nonNull(condition.endObj)) {
                        if (realObj.compareTo(condition.endObj) == -1) {
                            checkBetween = true;
                        } else {
                            if (condition.isEqEnd) {
                                if (realObj.compareTo(condition.endObj) == 0) {
                                    checkBetween = true;
                                } else {
                                    checkBetween = false;
                                }
                            } else {
                                checkBetween = false;
                            }
                        }
                    }
                }
            } else {
                //<=某个值时候的判断
                if (Objects.nonNull(condition.endObj)) {

                    if (realObj.compareTo(condition.endObj) == -1) {
                        checkBetween = true;
                    } else {
                        if (condition.isEqEnd) {
                            if (realObj.compareTo(condition.endObj) == 0) {
                                checkBetween = true;
                            }

                        }
                    }
                }
            }

            if (checkBetween) {
                return condition.point;
            }

        }

        if (otherCondition != null) {
            return otherCondition.point;
        }

        return 0;

    }


}
