package com.xing.module.quality.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.chad.library.adapter.base.entity.SectionEntity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "Plan")
public class Plan {

    @Id(autoincrement = true)
    private Long id;
    /**
     * monthId：：用于标记孩子归属哪一个父亲
     */
    @NotNull
    private Long monthId;
    /**
     * 图片
     */
    private String pic;

    /**
     * 工厂
     */
    private String factoryCode;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 类别
     */
    private String classes;

    /**
     * 系列
     */
    private String series;

    /**
     * 系列号
     */
    private String prodSeries;

    /**
     * 销售订单号
     */
    private String saleorderNo;

    /**
     * 行项目
     */
    private String saleorderLine;

    /**
     * 生产订单号
     */
    private String sapmoCode;

    /**
     * 生产订单号-行项目
     */
    private String sapmoCodeline;

    /**
     * SAP订单下发日期
     */
    private Date sendDate;

    /**
     * SAP订单完成日期
     */
    private Date finishDate;

    /**
     * 色号
     */
    private String tsCode;

    /**
     * 客户交期
     */
    private Date customerDelivery;

    /**
     * 出货时间
     */
    private Date shippingDate;

    /**
     * 成品编码
     */
    private String sapCode;

    /**
     * 客户品号
     */
    private String customprodNo;

    /**
     * 成品描述
     */
    private String prodName;

    /**
     * 内外销标志
     */
    private String inoutType;

    /**
     * 规格
     */
    private String spec;

    /**
     * 总工时
     */
    private Integer totalTime;

    /**
     * 数量
     */
    private Integer qty;

    /**
     * 绿色通道数量
     */
    private Integer fastPass;

    /**
     * 单价
     */
    private Integer price;

    /**
     * 产值
     */
    private Integer productionValue;

    /**
     * 机加工派工
     */
    private String jjAssigning;

    /**
     * 成品派工
     */
    private String tsAssigning;

    /**
     * 基准时间0
     */
    private Date finishDate0;

    /**
     * 完成时间1
     */
    private Date finishDate1;

    /**
     * 完成时间2
     */
    private Date finishDate2;

    /**
     * 完成时间3
     */
    private Date finishDate3;

    /**
     * 完成时间4
     */
    private Date finishDate4;

    /**
     * 完成时间5
     */
    private Date finishDate5;

    /**
     * 完成时间6
     */
    private Date finishDate6;

    /**
     * 完成时间7
     */
    private Date finishDate7;

    /**
     * 完成时间8
     */
    private Date finishDate8;

    /**
     * 完成时间9
     */
    private Date finishDate9;

    /**
     * 完成时间10
     */
    private Date finishDate10;

    /**
     * 完成时间11
     */
    private Date finishDate11;

    /**
     * 完成时间12
     */
    private Date finishDate12;

    /**
     * 完成时间13
     */
    private Date finishDate13;

    /**
     * 完成时间14
     */
    private Date finishDate14;

    /**
     * 完成时间15
     */
    private Date finishDate15;

    /**
     * 完成时间16
     */
    private Date finishDate16;

    /**
     * 完成时间17
     */
    private Date finishDate17;

    /**
     * 完成时间18
     */
    private Date finishDate18;

    /**
     * 完成时间19
     */
    private Date finishDate19;

    /**
     * 完成时间20
     */
    private Date finishDate20;

    /**
     * 备注1
     */
    private String remakes;

    /**
     * 生产月
     */
    private String monthly;

    /**
     * 周次
     */
    private String week;

    /**
     * 锁定
     */
    private String lockFlag;

    /**
     * 操作人
     */
    private String fCreatorruserid;

    /**
     * 操作时间
     */
    private Date fCreatortime;

    /**
     * 锁定操作人
     */
    private String fLockcreatorruserid;

    /**
     * 锁定操作时间
     */
    private Date fLockcreatortime;

    /**
     * 备注2
     */
    private String remark2;

    /**
     * 备用2
     */
    private String field02;

    /**
     * 备用3
     */
    private String field03;

    /**
     * 备用4
     */
    private String field04;

    /**
     * 备用5
     */
    private String field05;

    /**
     * 删除标记
     */
    private String fDeletemark;

    /**
     * 最后修改时间
     */
    private Date fLastmodifytime;

    /**
     * 最后修改人ID
     */
    private String fLastmodifyuserid;

    /**
     * 删除时间
     */
    private Date fDeletetime;

    /**
     * 删除人ID
     */
    private String fDeleteuserid;

    @Generated(hash = 1845130444)
    public Plan(Long id, @NotNull Long monthId, String pic, String factoryCode,
            String brand, String classes, String series, String prodSeries,
            String saleorderNo, String saleorderLine, String sapmoCode,
            String sapmoCodeline, Date sendDate, Date finishDate, String tsCode,
            Date customerDelivery, Date shippingDate, String sapCode,
            String customprodNo, String prodName, String inoutType, String spec,
            Integer totalTime, Integer qty, Integer fastPass, Integer price,
            Integer productionValue, String jjAssigning, String tsAssigning,
            Date finishDate0, Date finishDate1, Date finishDate2, Date finishDate3,
            Date finishDate4, Date finishDate5, Date finishDate6, Date finishDate7,
            Date finishDate8, Date finishDate9, Date finishDate10,
            Date finishDate11, Date finishDate12, Date finishDate13,
            Date finishDate14, Date finishDate15, Date finishDate16,
            Date finishDate17, Date finishDate18, Date finishDate19,
            Date finishDate20, String remakes, String monthly, String week,
            String lockFlag, String fCreatorruserid, Date fCreatortime,
            String fLockcreatorruserid, Date fLockcreatortime, String remark2,
            String field02, String field03, String field04, String field05,
            String fDeletemark, Date fLastmodifytime, String fLastmodifyuserid,
            Date fDeletetime, String fDeleteuserid) {
        this.id = id;
        this.monthId = monthId;
        this.pic = pic;
        this.factoryCode = factoryCode;
        this.brand = brand;
        this.classes = classes;
        this.series = series;
        this.prodSeries = prodSeries;
        this.saleorderNo = saleorderNo;
        this.saleorderLine = saleorderLine;
        this.sapmoCode = sapmoCode;
        this.sapmoCodeline = sapmoCodeline;
        this.sendDate = sendDate;
        this.finishDate = finishDate;
        this.tsCode = tsCode;
        this.customerDelivery = customerDelivery;
        this.shippingDate = shippingDate;
        this.sapCode = sapCode;
        this.customprodNo = customprodNo;
        this.prodName = prodName;
        this.inoutType = inoutType;
        this.spec = spec;
        this.totalTime = totalTime;
        this.qty = qty;
        this.fastPass = fastPass;
        this.price = price;
        this.productionValue = productionValue;
        this.jjAssigning = jjAssigning;
        this.tsAssigning = tsAssigning;
        this.finishDate0 = finishDate0;
        this.finishDate1 = finishDate1;
        this.finishDate2 = finishDate2;
        this.finishDate3 = finishDate3;
        this.finishDate4 = finishDate4;
        this.finishDate5 = finishDate5;
        this.finishDate6 = finishDate6;
        this.finishDate7 = finishDate7;
        this.finishDate8 = finishDate8;
        this.finishDate9 = finishDate9;
        this.finishDate10 = finishDate10;
        this.finishDate11 = finishDate11;
        this.finishDate12 = finishDate12;
        this.finishDate13 = finishDate13;
        this.finishDate14 = finishDate14;
        this.finishDate15 = finishDate15;
        this.finishDate16 = finishDate16;
        this.finishDate17 = finishDate17;
        this.finishDate18 = finishDate18;
        this.finishDate19 = finishDate19;
        this.finishDate20 = finishDate20;
        this.remakes = remakes;
        this.monthly = monthly;
        this.week = week;
        this.lockFlag = lockFlag;
        this.fCreatorruserid = fCreatorruserid;
        this.fCreatortime = fCreatortime;
        this.fLockcreatorruserid = fLockcreatorruserid;
        this.fLockcreatortime = fLockcreatortime;
        this.remark2 = remark2;
        this.field02 = field02;
        this.field03 = field03;
        this.field04 = field04;
        this.field05 = field05;
        this.fDeletemark = fDeletemark;
        this.fLastmodifytime = fLastmodifytime;
        this.fLastmodifyuserid = fLastmodifyuserid;
        this.fDeletetime = fDeletetime;
        this.fDeleteuserid = fDeleteuserid;
    }

    @Generated(hash = 592612124)
    public Plan() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMonthId() {
        return this.monthId;
    }

    public void setMonthId(Long monthId) {
        this.monthId = monthId;
    }

    public String getPic() {
        return this.pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getFactoryCode() {
        return this.factoryCode;
    }

    public void setFactoryCode(String factoryCode) {
        this.factoryCode = factoryCode;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getClasses() {
        return this.classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getSeries() {
        return this.series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getProdSeries() {
        return this.prodSeries;
    }

    public void setProdSeries(String prodSeries) {
        this.prodSeries = prodSeries;
    }

    public String getSaleorderNo() {
        return this.saleorderNo;
    }

    public void setSaleorderNo(String saleorderNo) {
        this.saleorderNo = saleorderNo;
    }

    public String getSaleorderLine() {
        return this.saleorderLine;
    }

    public void setSaleorderLine(String saleorderLine) {
        this.saleorderLine = saleorderLine;
    }

    public String getSapmoCode() {
        return this.sapmoCode;
    }

    public void setSapmoCode(String sapmoCode) {
        this.sapmoCode = sapmoCode;
    }

    public String getSapmoCodeline() {
        return this.sapmoCodeline;
    }

    public void setSapmoCodeline(String sapmoCodeline) {
        this.sapmoCodeline = sapmoCodeline;
    }

    public Date getSendDate() {
        return this.sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public Date getFinishDate() {
        return this.finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public String getTsCode() {
        return this.tsCode;
    }

    public void setTsCode(String tsCode) {
        this.tsCode = tsCode;
    }

    public Date getCustomerDelivery() {
        return this.customerDelivery;
    }

    public void setCustomerDelivery(Date customerDelivery) {
        this.customerDelivery = customerDelivery;
    }

    public Date getShippingDate() {
        return this.shippingDate;
    }

    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }

    public String getSapCode() {
        return this.sapCode;
    }

    public void setSapCode(String sapCode) {
        this.sapCode = sapCode;
    }

    public String getCustomprodNo() {
        return this.customprodNo;
    }

    public void setCustomprodNo(String customprodNo) {
        this.customprodNo = customprodNo;
    }

    public String getProdName() {
        return this.prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getInoutType() {
        return this.inoutType;
    }

    public void setInoutType(String inoutType) {
        this.inoutType = inoutType;
    }

    public String getSpec() {
        return this.spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public Integer getTotalTime() {
        return this.totalTime;
    }

    public void setTotalTime(Integer totalTime) {
        this.totalTime = totalTime;
    }

    public Integer getQty() {
        return this.qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getFastPass() {
        return this.fastPass;
    }

    public void setFastPass(Integer fastPass) {
        this.fastPass = fastPass;
    }

    public Integer getPrice() {
        return this.price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getProductionValue() {
        return this.productionValue;
    }

    public void setProductionValue(Integer productionValue) {
        this.productionValue = productionValue;
    }

    public String getJjAssigning() {
        return this.jjAssigning;
    }

    public void setJjAssigning(String jjAssigning) {
        this.jjAssigning = jjAssigning;
    }

    public String getTsAssigning() {
        return this.tsAssigning;
    }

    public void setTsAssigning(String tsAssigning) {
        this.tsAssigning = tsAssigning;
    }

    public Date getFinishDate0() {
        return this.finishDate0;
    }

    public void setFinishDate0(Date finishDate0) {
        this.finishDate0 = finishDate0;
    }

    public Date getFinishDate1() {
        return this.finishDate1;
    }

    public void setFinishDate1(Date finishDate1) {
        this.finishDate1 = finishDate1;
    }

    public Date getFinishDate2() {
        return this.finishDate2;
    }

    public void setFinishDate2(Date finishDate2) {
        this.finishDate2 = finishDate2;
    }

    public Date getFinishDate3() {
        return this.finishDate3;
    }

    public void setFinishDate3(Date finishDate3) {
        this.finishDate3 = finishDate3;
    }

    public Date getFinishDate4() {
        return this.finishDate4;
    }

    public void setFinishDate4(Date finishDate4) {
        this.finishDate4 = finishDate4;
    }

    public Date getFinishDate5() {
        return this.finishDate5;
    }

    public void setFinishDate5(Date finishDate5) {
        this.finishDate5 = finishDate5;
    }

    public Date getFinishDate6() {
        return this.finishDate6;
    }

    public void setFinishDate6(Date finishDate6) {
        this.finishDate6 = finishDate6;
    }

    public Date getFinishDate7() {
        return this.finishDate7;
    }

    public void setFinishDate7(Date finishDate7) {
        this.finishDate7 = finishDate7;
    }

    public Date getFinishDate8() {
        return this.finishDate8;
    }

    public void setFinishDate8(Date finishDate8) {
        this.finishDate8 = finishDate8;
    }

    public Date getFinishDate9() {
        return this.finishDate9;
    }

    public void setFinishDate9(Date finishDate9) {
        this.finishDate9 = finishDate9;
    }

    public Date getFinishDate10() {
        return this.finishDate10;
    }

    public void setFinishDate10(Date finishDate10) {
        this.finishDate10 = finishDate10;
    }

    public Date getFinishDate11() {
        return this.finishDate11;
    }

    public void setFinishDate11(Date finishDate11) {
        this.finishDate11 = finishDate11;
    }

    public Date getFinishDate12() {
        return this.finishDate12;
    }

    public void setFinishDate12(Date finishDate12) {
        this.finishDate12 = finishDate12;
    }

    public Date getFinishDate13() {
        return this.finishDate13;
    }

    public void setFinishDate13(Date finishDate13) {
        this.finishDate13 = finishDate13;
    }

    public Date getFinishDate14() {
        return this.finishDate14;
    }

    public void setFinishDate14(Date finishDate14) {
        this.finishDate14 = finishDate14;
    }

    public Date getFinishDate15() {
        return this.finishDate15;
    }

    public void setFinishDate15(Date finishDate15) {
        this.finishDate15 = finishDate15;
    }

    public Date getFinishDate16() {
        return this.finishDate16;
    }

    public void setFinishDate16(Date finishDate16) {
        this.finishDate16 = finishDate16;
    }

    public Date getFinishDate17() {
        return this.finishDate17;
    }

    public void setFinishDate17(Date finishDate17) {
        this.finishDate17 = finishDate17;
    }

    public Date getFinishDate18() {
        return this.finishDate18;
    }

    public void setFinishDate18(Date finishDate18) {
        this.finishDate18 = finishDate18;
    }

    public Date getFinishDate19() {
        return this.finishDate19;
    }

    public void setFinishDate19(Date finishDate19) {
        this.finishDate19 = finishDate19;
    }

    public Date getFinishDate20() {
        return this.finishDate20;
    }

    public void setFinishDate20(Date finishDate20) {
        this.finishDate20 = finishDate20;
    }

    public String getRemakes() {
        return this.remakes;
    }

    public void setRemakes(String remakes) {
        this.remakes = remakes;
    }

    public String getMonthly() {
        return this.monthly;
    }

    public void setMonthly(String monthly) {
        this.monthly = monthly;
    }

    public String getWeek() {
        return this.week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getLockFlag() {
        return this.lockFlag;
    }

    public void setLockFlag(String lockFlag) {
        this.lockFlag = lockFlag;
    }

    public String getFCreatorruserid() {
        return this.fCreatorruserid;
    }

    public void setFCreatorruserid(String fCreatorruserid) {
        this.fCreatorruserid = fCreatorruserid;
    }

    public Date getFCreatortime() {
        return this.fCreatortime;
    }

    public void setFCreatortime(Date fCreatortime) {
        this.fCreatortime = fCreatortime;
    }

    public String getFLockcreatorruserid() {
        return this.fLockcreatorruserid;
    }

    public void setFLockcreatorruserid(String fLockcreatorruserid) {
        this.fLockcreatorruserid = fLockcreatorruserid;
    }

    public Date getFLockcreatortime() {
        return this.fLockcreatortime;
    }

    public void setFLockcreatortime(Date fLockcreatortime) {
        this.fLockcreatortime = fLockcreatortime;
    }

    public String getRemark2() {
        return this.remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getField02() {
        return this.field02;
    }

    public void setField02(String field02) {
        this.field02 = field02;
    }

    public String getField03() {
        return this.field03;
    }

    public void setField03(String field03) {
        this.field03 = field03;
    }

    public String getField04() {
        return this.field04;
    }

    public void setField04(String field04) {
        this.field04 = field04;
    }

    public String getField05() {
        return this.field05;
    }

    public void setField05(String field05) {
        this.field05 = field05;
    }

    public String getFDeletemark() {
        return this.fDeletemark;
    }

    public void setFDeletemark(String fDeletemark) {
        this.fDeletemark = fDeletemark;
    }

    public Date getFLastmodifytime() {
        return this.fLastmodifytime;
    }

    public void setFLastmodifytime(Date fLastmodifytime) {
        this.fLastmodifytime = fLastmodifytime;
    }

    public String getFLastmodifyuserid() {
        return this.fLastmodifyuserid;
    }

    public void setFLastmodifyuserid(String fLastmodifyuserid) {
        this.fLastmodifyuserid = fLastmodifyuserid;
    }

    public Date getFDeletetime() {
        return this.fDeletetime;
    }

    public void setFDeletetime(Date fDeletetime) {
        this.fDeletetime = fDeletetime;
    }

    public String getFDeleteuserid() {
        return this.fDeleteuserid;
    }

    public void setFDeleteuserid(String fDeleteuserid) {
        this.fDeleteuserid = fDeleteuserid;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "id=" + id +
                ", monthId=" + monthId +
                ", pic='" + pic + '\'' +
                ", factoryCode='" + factoryCode + '\'' +
                ", brand='" + brand + '\'' +
                ", classes='" + classes + '\'' +
                ", series='" + series + '\'' +
                ", prodSeries='" + prodSeries + '\'' +
                ", saleorderNo='" + saleorderNo + '\'' +
                ", saleorderLine='" + saleorderLine + '\'' +
                ", sapmoCode='" + sapmoCode + '\'' +
                ", sapmoCodeline='" + sapmoCodeline + '\'' +
                ", sendDate=" + sendDate +
                ", finishDate=" + finishDate +
                ", tsCode='" + tsCode + '\'' +
                ", customerDelivery=" + customerDelivery +
                ", shippingDate=" + shippingDate +
                ", sapCode='" + sapCode + '\'' +
                ", customprodNo='" + customprodNo + '\'' +
                ", prodName='" + prodName + '\'' +
                ", inoutType='" + inoutType + '\'' +
                ", spec='" + spec + '\'' +
                ", totalTime=" + totalTime +
                ", qty=" + qty +
                ", fastPass=" + fastPass +
                ", price=" + price +
                ", productionValue=" + productionValue +
                ", jjAssigning='" + jjAssigning + '\'' +
                ", tsAssigning='" + tsAssigning + '\'' +
                ", finishDate0=" + finishDate0 +
                ", finishDate1=" + finishDate1 +
                ", finishDate2=" + finishDate2 +
                ", finishDate3=" + finishDate3 +
                ", finishDate4=" + finishDate4 +
                ", finishDate5=" + finishDate5 +
                ", finishDate6=" + finishDate6 +
                ", finishDate7=" + finishDate7 +
                ", finishDate8=" + finishDate8 +
                ", finishDate9=" + finishDate9 +
                ", finishDate10=" + finishDate10 +
                ", finishDate11=" + finishDate11 +
                ", finishDate12=" + finishDate12 +
                ", finishDate13=" + finishDate13 +
                ", finishDate14=" + finishDate14 +
                ", finishDate15=" + finishDate15 +
                ", finishDate16=" + finishDate16 +
                ", finishDate17=" + finishDate17 +
                ", finishDate18=" + finishDate18 +
                ", finishDate19=" + finishDate19 +
                ", finishDate20=" + finishDate20 +
                ", remakes='" + remakes + '\'' +
                ", monthly='" + monthly + '\'' +
                ", week='" + week + '\'' +
                ", lockFlag='" + lockFlag + '\'' +
                ", fCreatorruserid='" + fCreatorruserid + '\'' +
                ", fCreatortime=" + fCreatortime +
                ", fLockcreatorruserid='" + fLockcreatorruserid + '\'' +
                ", fLockcreatortime=" + fLockcreatortime +
                ", remark2='" + remark2 + '\'' +
                ", field02='" + field02 + '\'' +
                ", field03='" + field03 + '\'' +
                ", field04='" + field04 + '\'' +
                ", field05='" + field05 + '\'' +
                ", fDeletemark='" + fDeletemark + '\'' +
                ", fLastmodifytime=" + fLastmodifytime +
                ", fLastmodifyuserid='" + fLastmodifyuserid + '\'' +
                ", fDeletetime=" + fDeletetime +
                ", fDeleteuserid='" + fDeleteuserid + '\'' +
                '}';
    }
}
