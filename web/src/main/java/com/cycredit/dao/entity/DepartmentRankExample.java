package com.cycredit.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DepartmentRankExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public DepartmentRankExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDepartmentCodeIsNull() {
            addCriterion("department_code is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentCodeIsNotNull() {
            addCriterion("department_code is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentCodeEqualTo(String value) {
            addCriterion("department_code =", value, "departmentCode");
            return (Criteria) this;
        }

        public Criteria andDepartmentCodeNotEqualTo(String value) {
            addCriterion("department_code <>", value, "departmentCode");
            return (Criteria) this;
        }

        public Criteria andDepartmentCodeGreaterThan(String value) {
            addCriterion("department_code >", value, "departmentCode");
            return (Criteria) this;
        }

        public Criteria andDepartmentCodeGreaterThanOrEqualTo(String value) {
            addCriterion("department_code >=", value, "departmentCode");
            return (Criteria) this;
        }

        public Criteria andDepartmentCodeLessThan(String value) {
            addCriterion("department_code <", value, "departmentCode");
            return (Criteria) this;
        }

        public Criteria andDepartmentCodeLessThanOrEqualTo(String value) {
            addCriterion("department_code <=", value, "departmentCode");
            return (Criteria) this;
        }

        public Criteria andDepartmentCodeLike(String value) {
            addCriterion("department_code like", value, "departmentCode");
            return (Criteria) this;
        }

        public Criteria andDepartmentCodeNotLike(String value) {
            addCriterion("department_code not like", value, "departmentCode");
            return (Criteria) this;
        }

        public Criteria andDepartmentCodeIn(List<String> values) {
            addCriterion("department_code in", values, "departmentCode");
            return (Criteria) this;
        }

        public Criteria andDepartmentCodeNotIn(List<String> values) {
            addCriterion("department_code not in", values, "departmentCode");
            return (Criteria) this;
        }

        public Criteria andDepartmentCodeBetween(String value1, String value2) {
            addCriterion("department_code between", value1, value2, "departmentCode");
            return (Criteria) this;
        }

        public Criteria andDepartmentCodeNotBetween(String value1, String value2) {
            addCriterion("department_code not between", value1, value2, "departmentCode");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIsNull() {
            addCriterion("department_name is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIsNotNull() {
            addCriterion("department_name is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameEqualTo(String value) {
            addCriterion("department_name =", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotEqualTo(String value) {
            addCriterion("department_name <>", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameGreaterThan(String value) {
            addCriterion("department_name >", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameGreaterThanOrEqualTo(String value) {
            addCriterion("department_name >=", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLessThan(String value) {
            addCriterion("department_name <", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLessThanOrEqualTo(String value) {
            addCriterion("department_name <=", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLike(String value) {
            addCriterion("department_name like", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotLike(String value) {
            addCriterion("department_name not like", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIn(List<String> values) {
            addCriterion("department_name in", values, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotIn(List<String> values) {
            addCriterion("department_name not in", values, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameBetween(String value1, String value2) {
            addCriterion("department_name between", value1, value2, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotBetween(String value1, String value2) {
            addCriterion("department_name not between", value1, value2, "departmentName");
            return (Criteria) this;
        }

        public Criteria andRankIsNull() {
            addCriterion("rank is null");
            return (Criteria) this;
        }

        public Criteria andRankIsNotNull() {
            addCriterion("rank is not null");
            return (Criteria) this;
        }

        public Criteria andRankEqualTo(Integer value) {
            addCriterion("rank =", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotEqualTo(Integer value) {
            addCriterion("rank <>", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankGreaterThan(Integer value) {
            addCriterion("rank >", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankGreaterThanOrEqualTo(Integer value) {
            addCriterion("rank >=", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLessThan(Integer value) {
            addCriterion("rank <", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLessThanOrEqualTo(Integer value) {
            addCriterion("rank <=", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankIn(List<Integer> values) {
            addCriterion("rank in", values, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotIn(List<Integer> values) {
            addCriterion("rank not in", values, "rank");
            return (Criteria) this;
        }

        public Criteria andRankBetween(Integer value1, Integer value2) {
            addCriterion("rank between", value1, value2, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotBetween(Integer value1, Integer value2) {
            addCriterion("rank not between", value1, value2, "rank");
            return (Criteria) this;
        }

        public Criteria andJoinCountIsNull() {
            addCriterion("join_count is null");
            return (Criteria) this;
        }

        public Criteria andJoinCountIsNotNull() {
            addCriterion("join_count is not null");
            return (Criteria) this;
        }

        public Criteria andJoinCountEqualTo(Integer value) {
            addCriterion("join_count =", value, "joinCount");
            return (Criteria) this;
        }

        public Criteria andJoinCountNotEqualTo(Integer value) {
            addCriterion("join_count <>", value, "joinCount");
            return (Criteria) this;
        }

        public Criteria andJoinCountGreaterThan(Integer value) {
            addCriterion("join_count >", value, "joinCount");
            return (Criteria) this;
        }

        public Criteria andJoinCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("join_count >=", value, "joinCount");
            return (Criteria) this;
        }

        public Criteria andJoinCountLessThan(Integer value) {
            addCriterion("join_count <", value, "joinCount");
            return (Criteria) this;
        }

        public Criteria andJoinCountLessThanOrEqualTo(Integer value) {
            addCriterion("join_count <=", value, "joinCount");
            return (Criteria) this;
        }

        public Criteria andJoinCountIn(List<Integer> values) {
            addCriterion("join_count in", values, "joinCount");
            return (Criteria) this;
        }

        public Criteria andJoinCountNotIn(List<Integer> values) {
            addCriterion("join_count not in", values, "joinCount");
            return (Criteria) this;
        }

        public Criteria andJoinCountBetween(Integer value1, Integer value2) {
            addCriterion("join_count between", value1, value2, "joinCount");
            return (Criteria) this;
        }

        public Criteria andJoinCountNotBetween(Integer value1, Integer value2) {
            addCriterion("join_count not between", value1, value2, "joinCount");
            return (Criteria) this;
        }

        public Criteria andUniCountIsNull() {
            addCriterion("uni_count is null");
            return (Criteria) this;
        }

        public Criteria andUniCountIsNotNull() {
            addCriterion("uni_count is not null");
            return (Criteria) this;
        }

        public Criteria andUniCountEqualTo(Integer value) {
            addCriterion("uni_count =", value, "uniCount");
            return (Criteria) this;
        }

        public Criteria andUniCountNotEqualTo(Integer value) {
            addCriterion("uni_count <>", value, "uniCount");
            return (Criteria) this;
        }

        public Criteria andUniCountGreaterThan(Integer value) {
            addCriterion("uni_count >", value, "uniCount");
            return (Criteria) this;
        }

        public Criteria andUniCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("uni_count >=", value, "uniCount");
            return (Criteria) this;
        }

        public Criteria andUniCountLessThan(Integer value) {
            addCriterion("uni_count <", value, "uniCount");
            return (Criteria) this;
        }

        public Criteria andUniCountLessThanOrEqualTo(Integer value) {
            addCriterion("uni_count <=", value, "uniCount");
            return (Criteria) this;
        }

        public Criteria andUniCountIn(List<Integer> values) {
            addCriterion("uni_count in", values, "uniCount");
            return (Criteria) this;
        }

        public Criteria andUniCountNotIn(List<Integer> values) {
            addCriterion("uni_count not in", values, "uniCount");
            return (Criteria) this;
        }

        public Criteria andUniCountBetween(Integer value1, Integer value2) {
            addCriterion("uni_count between", value1, value2, "uniCount");
            return (Criteria) this;
        }

        public Criteria andUniCountNotBetween(Integer value1, Integer value2) {
            addCriterion("uni_count not between", value1, value2, "uniCount");
            return (Criteria) this;
        }

        public Criteria andUniPunishCountIsNull() {
            addCriterion("uni_punish_count is null");
            return (Criteria) this;
        }

        public Criteria andUniPunishCountIsNotNull() {
            addCriterion("uni_punish_count is not null");
            return (Criteria) this;
        }

        public Criteria andUniPunishCountEqualTo(Integer value) {
            addCriterion("uni_punish_count =", value, "uniPunishCount");
            return (Criteria) this;
        }

        public Criteria andUniPunishCountNotEqualTo(Integer value) {
            addCriterion("uni_punish_count <>", value, "uniPunishCount");
            return (Criteria) this;
        }

        public Criteria andUniPunishCountGreaterThan(Integer value) {
            addCriterion("uni_punish_count >", value, "uniPunishCount");
            return (Criteria) this;
        }

        public Criteria andUniPunishCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("uni_punish_count >=", value, "uniPunishCount");
            return (Criteria) this;
        }

        public Criteria andUniPunishCountLessThan(Integer value) {
            addCriterion("uni_punish_count <", value, "uniPunishCount");
            return (Criteria) this;
        }

        public Criteria andUniPunishCountLessThanOrEqualTo(Integer value) {
            addCriterion("uni_punish_count <=", value, "uniPunishCount");
            return (Criteria) this;
        }

        public Criteria andUniPunishCountIn(List<Integer> values) {
            addCriterion("uni_punish_count in", values, "uniPunishCount");
            return (Criteria) this;
        }

        public Criteria andUniPunishCountNotIn(List<Integer> values) {
            addCriterion("uni_punish_count not in", values, "uniPunishCount");
            return (Criteria) this;
        }

        public Criteria andUniPunishCountBetween(Integer value1, Integer value2) {
            addCriterion("uni_punish_count between", value1, value2, "uniPunishCount");
            return (Criteria) this;
        }

        public Criteria andUniPunishCountNotBetween(Integer value1, Integer value2) {
            addCriterion("uni_punish_count not between", value1, value2, "uniPunishCount");
            return (Criteria) this;
        }

        public Criteria andUniBonusCountIsNull() {
            addCriterion("uni_bonus_count is null");
            return (Criteria) this;
        }

        public Criteria andUniBonusCountIsNotNull() {
            addCriterion("uni_bonus_count is not null");
            return (Criteria) this;
        }

        public Criteria andUniBonusCountEqualTo(Integer value) {
            addCriterion("uni_bonus_count =", value, "uniBonusCount");
            return (Criteria) this;
        }

        public Criteria andUniBonusCountNotEqualTo(Integer value) {
            addCriterion("uni_bonus_count <>", value, "uniBonusCount");
            return (Criteria) this;
        }

        public Criteria andUniBonusCountGreaterThan(Integer value) {
            addCriterion("uni_bonus_count >", value, "uniBonusCount");
            return (Criteria) this;
        }

        public Criteria andUniBonusCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("uni_bonus_count >=", value, "uniBonusCount");
            return (Criteria) this;
        }

        public Criteria andUniBonusCountLessThan(Integer value) {
            addCriterion("uni_bonus_count <", value, "uniBonusCount");
            return (Criteria) this;
        }

        public Criteria andUniBonusCountLessThanOrEqualTo(Integer value) {
            addCriterion("uni_bonus_count <=", value, "uniBonusCount");
            return (Criteria) this;
        }

        public Criteria andUniBonusCountIn(List<Integer> values) {
            addCriterion("uni_bonus_count in", values, "uniBonusCount");
            return (Criteria) this;
        }

        public Criteria andUniBonusCountNotIn(List<Integer> values) {
            addCriterion("uni_bonus_count not in", values, "uniBonusCount");
            return (Criteria) this;
        }

        public Criteria andUniBonusCountBetween(Integer value1, Integer value2) {
            addCriterion("uni_bonus_count between", value1, value2, "uniBonusCount");
            return (Criteria) this;
        }

        public Criteria andUniBonusCountNotBetween(Integer value1, Integer value2) {
            addCriterion("uni_bonus_count not between", value1, value2, "uniBonusCount");
            return (Criteria) this;
        }

        public Criteria andSelectCountIsNull() {
            addCriterion("select_count is null");
            return (Criteria) this;
        }

        public Criteria andSelectCountIsNotNull() {
            addCriterion("select_count is not null");
            return (Criteria) this;
        }

        public Criteria andSelectCountEqualTo(Integer value) {
            addCriterion("select_count =", value, "selectCount");
            return (Criteria) this;
        }

        public Criteria andSelectCountNotEqualTo(Integer value) {
            addCriterion("select_count <>", value, "selectCount");
            return (Criteria) this;
        }

        public Criteria andSelectCountGreaterThan(Integer value) {
            addCriterion("select_count >", value, "selectCount");
            return (Criteria) this;
        }

        public Criteria andSelectCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("select_count >=", value, "selectCount");
            return (Criteria) this;
        }

        public Criteria andSelectCountLessThan(Integer value) {
            addCriterion("select_count <", value, "selectCount");
            return (Criteria) this;
        }

        public Criteria andSelectCountLessThanOrEqualTo(Integer value) {
            addCriterion("select_count <=", value, "selectCount");
            return (Criteria) this;
        }

        public Criteria andSelectCountIn(List<Integer> values) {
            addCriterion("select_count in", values, "selectCount");
            return (Criteria) this;
        }

        public Criteria andSelectCountNotIn(List<Integer> values) {
            addCriterion("select_count not in", values, "selectCount");
            return (Criteria) this;
        }

        public Criteria andSelectCountBetween(Integer value1, Integer value2) {
            addCriterion("select_count between", value1, value2, "selectCount");
            return (Criteria) this;
        }

        public Criteria andSelectCountNotBetween(Integer value1, Integer value2) {
            addCriterion("select_count not between", value1, value2, "selectCount");
            return (Criteria) this;
        }

        public Criteria andActiveCountIsNull() {
            addCriterion("active_count is null");
            return (Criteria) this;
        }

        public Criteria andActiveCountIsNotNull() {
            addCriterion("active_count is not null");
            return (Criteria) this;
        }

        public Criteria andActiveCountEqualTo(Integer value) {
            addCriterion("active_count =", value, "activeCount");
            return (Criteria) this;
        }

        public Criteria andActiveCountNotEqualTo(Integer value) {
            addCriterion("active_count <>", value, "activeCount");
            return (Criteria) this;
        }

        public Criteria andActiveCountGreaterThan(Integer value) {
            addCriterion("active_count >", value, "activeCount");
            return (Criteria) this;
        }

        public Criteria andActiveCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("active_count >=", value, "activeCount");
            return (Criteria) this;
        }

        public Criteria andActiveCountLessThan(Integer value) {
            addCriterion("active_count <", value, "activeCount");
            return (Criteria) this;
        }

        public Criteria andActiveCountLessThanOrEqualTo(Integer value) {
            addCriterion("active_count <=", value, "activeCount");
            return (Criteria) this;
        }

        public Criteria andActiveCountIn(List<Integer> values) {
            addCriterion("active_count in", values, "activeCount");
            return (Criteria) this;
        }

        public Criteria andActiveCountNotIn(List<Integer> values) {
            addCriterion("active_count not in", values, "activeCount");
            return (Criteria) this;
        }

        public Criteria andActiveCountBetween(Integer value1, Integer value2) {
            addCriterion("active_count between", value1, value2, "activeCount");
            return (Criteria) this;
        }

        public Criteria andActiveCountNotBetween(Integer value1, Integer value2) {
            addCriterion("active_count not between", value1, value2, "activeCount");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}