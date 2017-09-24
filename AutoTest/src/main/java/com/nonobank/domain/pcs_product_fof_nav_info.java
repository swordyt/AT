package com.nonobank.domain;

import java.util.Date;

public class pcs_product_fof_nav_info {
    private Long id;

    private Long productId;

    private String productName;

    private String productType;

    private String fundType;

    private String fundCode;

    private Date navDate;

    private String nav;

    private String accumulatedNav;

    private String unitYield;

    private String yearlyRoe;

    private String dayReturn;

    private String oneWeekReturn;

    private String oneMonthReturn;

    private String quarterReturn;

    private String halfYearReturn;

    private String oneYearReturn;

    private String thisYearReturn;

    private Date createTime;

    private Date modifyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType == null ? null : productType.trim();
    }

    public String getFundType() {
        return fundType;
    }

    public void setFundType(String fundType) {
        this.fundType = fundType == null ? null : fundType.trim();
    }

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode == null ? null : fundCode.trim();
    }

    public Date getNavDate() {
        return navDate;
    }

    public void setNavDate(Date navDate) {
        this.navDate = navDate;
    }

    public String getNav() {
        return nav;
    }

    public void setNav(String nav) {
        this.nav = nav == null ? null : nav.trim();
    }

    public String getAccumulatedNav() {
        return accumulatedNav;
    }

    public void setAccumulatedNav(String accumulatedNav) {
        this.accumulatedNav = accumulatedNav == null ? null : accumulatedNav.trim();
    }

    public String getUnitYield() {
        return unitYield;
    }

    public void setUnitYield(String unitYield) {
        this.unitYield = unitYield == null ? null : unitYield.trim();
    }

    public String getYearlyRoe() {
        return yearlyRoe;
    }

    public void setYearlyRoe(String yearlyRoe) {
        this.yearlyRoe = yearlyRoe == null ? null : yearlyRoe.trim();
    }

    public String getDayReturn() {
        return dayReturn;
    }

    public void setDayReturn(String dayReturn) {
        this.dayReturn = dayReturn == null ? null : dayReturn.trim();
    }

    public String getOneWeekReturn() {
        return oneWeekReturn;
    }

    public void setOneWeekReturn(String oneWeekReturn) {
        this.oneWeekReturn = oneWeekReturn == null ? null : oneWeekReturn.trim();
    }

    public String getOneMonthReturn() {
        return oneMonthReturn;
    }

    public void setOneMonthReturn(String oneMonthReturn) {
        this.oneMonthReturn = oneMonthReturn == null ? null : oneMonthReturn.trim();
    }

    public String getQuarterReturn() {
        return quarterReturn;
    }

    public void setQuarterReturn(String quarterReturn) {
        this.quarterReturn = quarterReturn == null ? null : quarterReturn.trim();
    }

    public String getHalfYearReturn() {
        return halfYearReturn;
    }

    public void setHalfYearReturn(String halfYearReturn) {
        this.halfYearReturn = halfYearReturn == null ? null : halfYearReturn.trim();
    }

    public String getOneYearReturn() {
        return oneYearReturn;
    }

    public void setOneYearReturn(String oneYearReturn) {
        this.oneYearReturn = oneYearReturn == null ? null : oneYearReturn.trim();
    }

    public String getThisYearReturn() {
        return thisYearReturn;
    }

    public void setThisYearReturn(String thisYearReturn) {
        this.thisYearReturn = thisYearReturn == null ? null : thisYearReturn.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}