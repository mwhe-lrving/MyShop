package com.myshop.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderInfoExample() {
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

        public Criteria andOrderidIsNull() {
            addCriterion("orderid is null");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNotNull() {
            addCriterion("orderid is not null");
            return (Criteria) this;
        }

        public Criteria andOrderidEqualTo(Integer value) {
            addCriterion("orderid =", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotEqualTo(Integer value) {
            addCriterion("orderid <>", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThan(Integer value) {
            addCriterion("orderid >", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderid >=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThan(Integer value) {
            addCriterion("orderid <", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThanOrEqualTo(Integer value) {
            addCriterion("orderid <=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidIn(List<Integer> values) {
            addCriterion("orderid in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotIn(List<Integer> values) {
            addCriterion("orderid not in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidBetween(Integer value1, Integer value2) {
            addCriterion("orderid between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotBetween(Integer value1, Integer value2) {
            addCriterion("orderid not between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andGoodsidIsNull() {
            addCriterion("goodsid is null");
            return (Criteria) this;
        }

        public Criteria andGoodsidIsNotNull() {
            addCriterion("goodsid is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsidEqualTo(Integer value) {
            addCriterion("goodsid =", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidNotEqualTo(Integer value) {
            addCriterion("goodsid <>", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidGreaterThan(Integer value) {
            addCriterion("goodsid >", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("goodsid >=", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidLessThan(Integer value) {
            addCriterion("goodsid <", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidLessThanOrEqualTo(Integer value) {
            addCriterion("goodsid <=", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidIn(List<Integer> values) {
            addCriterion("goodsid in", values, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidNotIn(List<Integer> values) {
            addCriterion("goodsid not in", values, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidBetween(Integer value1, Integer value2) {
            addCriterion("goodsid between", value1, value2, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidNotBetween(Integer value1, Integer value2) {
            addCriterion("goodsid not between", value1, value2, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsnameIsNull() {
            addCriterion("goodsname is null");
            return (Criteria) this;
        }

        public Criteria andGoodsnameIsNotNull() {
            addCriterion("goodsname is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsnameEqualTo(String value) {
            addCriterion("goodsname =", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotEqualTo(String value) {
            addCriterion("goodsname <>", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameGreaterThan(String value) {
            addCriterion("goodsname >", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameGreaterThanOrEqualTo(String value) {
            addCriterion("goodsname >=", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameLessThan(String value) {
            addCriterion("goodsname <", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameLessThanOrEqualTo(String value) {
            addCriterion("goodsname <=", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameLike(String value) {
            addCriterion("goodsname like", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotLike(String value) {
            addCriterion("goodsname not like", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameIn(List<String> values) {
            addCriterion("goodsname in", values, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotIn(List<String> values) {
            addCriterion("goodsname not in", values, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameBetween(String value1, String value2) {
            addCriterion("goodsname between", value1, value2, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotBetween(String value1, String value2) {
            addCriterion("goodsname not between", value1, value2, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodscountIsNull() {
            addCriterion("goodscount is null");
            return (Criteria) this;
        }

        public Criteria andGoodscountIsNotNull() {
            addCriterion("goodscount is not null");
            return (Criteria) this;
        }

        public Criteria andGoodscountEqualTo(String value) {
            addCriterion("goodscount =", value, "goodscount");
            return (Criteria) this;
        }

        public Criteria andGoodscountNotEqualTo(String value) {
            addCriterion("goodscount <>", value, "goodscount");
            return (Criteria) this;
        }

        public Criteria andGoodscountGreaterThan(String value) {
            addCriterion("goodscount >", value, "goodscount");
            return (Criteria) this;
        }

        public Criteria andGoodscountGreaterThanOrEqualTo(String value) {
            addCriterion("goodscount >=", value, "goodscount");
            return (Criteria) this;
        }

        public Criteria andGoodscountLessThan(String value) {
            addCriterion("goodscount <", value, "goodscount");
            return (Criteria) this;
        }

        public Criteria andGoodscountLessThanOrEqualTo(String value) {
            addCriterion("goodscount <=", value, "goodscount");
            return (Criteria) this;
        }

        public Criteria andGoodscountLike(String value) {
            addCriterion("goodscount like", value, "goodscount");
            return (Criteria) this;
        }

        public Criteria andGoodscountNotLike(String value) {
            addCriterion("goodscount not like", value, "goodscount");
            return (Criteria) this;
        }

        public Criteria andGoodscountIn(List<String> values) {
            addCriterion("goodscount in", values, "goodscount");
            return (Criteria) this;
        }

        public Criteria andGoodscountNotIn(List<String> values) {
            addCriterion("goodscount not in", values, "goodscount");
            return (Criteria) this;
        }

        public Criteria andGoodscountBetween(String value1, String value2) {
            addCriterion("goodscount between", value1, value2, "goodscount");
            return (Criteria) this;
        }

        public Criteria andGoodscountNotBetween(String value1, String value2) {
            addCriterion("goodscount not between", value1, value2, "goodscount");
            return (Criteria) this;
        }

        public Criteria andGoodspriceIsNull() {
            addCriterion("goodsprice is null");
            return (Criteria) this;
        }

        public Criteria andGoodspriceIsNotNull() {
            addCriterion("goodsprice is not null");
            return (Criteria) this;
        }

        public Criteria andGoodspriceEqualTo(BigDecimal value) {
            addCriterion("goodsprice =", value, "goodsprice");
            return (Criteria) this;
        }

        public Criteria andGoodspriceNotEqualTo(BigDecimal value) {
            addCriterion("goodsprice <>", value, "goodsprice");
            return (Criteria) this;
        }

        public Criteria andGoodspriceGreaterThan(BigDecimal value) {
            addCriterion("goodsprice >", value, "goodsprice");
            return (Criteria) this;
        }

        public Criteria andGoodspriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("goodsprice >=", value, "goodsprice");
            return (Criteria) this;
        }

        public Criteria andGoodspriceLessThan(BigDecimal value) {
            addCriterion("goodsprice <", value, "goodsprice");
            return (Criteria) this;
        }

        public Criteria andGoodspriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("goodsprice <=", value, "goodsprice");
            return (Criteria) this;
        }

        public Criteria andGoodspriceIn(List<BigDecimal> values) {
            addCriterion("goodsprice in", values, "goodsprice");
            return (Criteria) this;
        }

        public Criteria andGoodspriceNotIn(List<BigDecimal> values) {
            addCriterion("goodsprice not in", values, "goodsprice");
            return (Criteria) this;
        }

        public Criteria andGoodspriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goodsprice between", value1, value2, "goodsprice");
            return (Criteria) this;
        }

        public Criteria andGoodspriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goodsprice not between", value1, value2, "goodsprice");
            return (Criteria) this;
        }

        public Criteria andOrderstatusIsNull() {
            addCriterion("orderstatus is null");
            return (Criteria) this;
        }

        public Criteria andOrderstatusIsNotNull() {
            addCriterion("orderstatus is not null");
            return (Criteria) this;
        }

        public Criteria andOrderstatusEqualTo(String value) {
            addCriterion("orderstatus =", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusNotEqualTo(String value) {
            addCriterion("orderstatus <>", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusGreaterThan(String value) {
            addCriterion("orderstatus >", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusGreaterThanOrEqualTo(String value) {
            addCriterion("orderstatus >=", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusLessThan(String value) {
            addCriterion("orderstatus <", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusLessThanOrEqualTo(String value) {
            addCriterion("orderstatus <=", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusLike(String value) {
            addCriterion("orderstatus like", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusNotLike(String value) {
            addCriterion("orderstatus not like", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusIn(List<String> values) {
            addCriterion("orderstatus in", values, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusNotIn(List<String> values) {
            addCriterion("orderstatus not in", values, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusBetween(String value1, String value2) {
            addCriterion("orderstatus between", value1, value2, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusNotBetween(String value1, String value2) {
            addCriterion("orderstatus not between", value1, value2, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNull() {
            addCriterion("createdate is null");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNotNull() {
            addCriterion("createdate is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedateEqualTo(Date value) {
            addCriterion("createdate =", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotEqualTo(Date value) {
            addCriterion("createdate <>", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThan(Date value) {
            addCriterion("createdate >", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("createdate >=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThan(Date value) {
            addCriterion("createdate <", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThanOrEqualTo(Date value) {
            addCriterion("createdate <=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateIn(List<Date> values) {
            addCriterion("createdate in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotIn(List<Date> values) {
            addCriterion("createdate not in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateBetween(Date value1, Date value2) {
            addCriterion("createdate between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotBetween(Date value1, Date value2) {
            addCriterion("createdate not between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andPaydateIsNull() {
            addCriterion("paydate is null");
            return (Criteria) this;
        }

        public Criteria andPaydateIsNotNull() {
            addCriterion("paydate is not null");
            return (Criteria) this;
        }

        public Criteria andPaydateEqualTo(Date value) {
            addCriterion("paydate =", value, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaydateNotEqualTo(Date value) {
            addCriterion("paydate <>", value, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaydateGreaterThan(Date value) {
            addCriterion("paydate >", value, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaydateGreaterThanOrEqualTo(Date value) {
            addCriterion("paydate >=", value, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaydateLessThan(Date value) {
            addCriterion("paydate <", value, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaydateLessThanOrEqualTo(Date value) {
            addCriterion("paydate <=", value, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaydateIn(List<Date> values) {
            addCriterion("paydate in", values, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaydateNotIn(List<Date> values) {
            addCriterion("paydate not in", values, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaydateBetween(Date value1, Date value2) {
            addCriterion("paydate between", value1, value2, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaydateNotBetween(Date value1, Date value2) {
            addCriterion("paydate not between", value1, value2, "paydate");
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