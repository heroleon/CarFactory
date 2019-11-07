package com.leon.carfixfactory.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by leon
 * Date: 2019/11/5
 * Time: 19:50
 * Desc:维修记录
 */
@Entity
public class RepairRecord {
    @Id(autoincrement = true)
    public Long repairId;
    public Long driverId;
    public String repairOrderId;

    public long arrivalTime;        //进场时间
    public long deliveryTime;      //交车时间
    public String repairMileage;   //维修里程
    public String repairTotalFee;
    public String repairDesc;

    public String totalPartFee;
    public String totalAccessoryFee;

    public int repairState = 0;        //0未维修 1已维修 2已交车


    public String dutyPersonName;
    public String dutyPersonId;


    @Generated(hash = 1280592811)
    public RepairRecord() {
    }

    @Generated(hash = 1834564341)
    public RepairRecord(Long repairId, Long driverId, String repairOrderId,
                        long arrivalTime, long deliveryTime, String repairMileage,
                        String repairTotalFee, String repairDesc, String totalPartFee,
                        String totalAccessoryFee, int repairState, String dutyPersonName,
                        String dutyPersonId) {
        this.repairId = repairId;
        this.driverId = driverId;
        this.repairOrderId = repairOrderId;
        this.arrivalTime = arrivalTime;
        this.deliveryTime = deliveryTime;
        this.repairMileage = repairMileage;
        this.repairTotalFee = repairTotalFee;
        this.repairDesc = repairDesc;
        this.totalPartFee = totalPartFee;
        this.totalAccessoryFee = totalAccessoryFee;
        this.repairState = repairState;
        this.dutyPersonName = dutyPersonName;
        this.dutyPersonId = dutyPersonId;
    }

    public Long getRepairId() {
        return this.repairId;
    }

    public void setRepairId(Long repairId) {
        this.repairId = repairId;
    }

    public Long getDriverId() {
        return this.driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public String getRepairOrderId() {
        return this.repairOrderId;
    }

    public void setRepairOrderId(String repairOrderId) {
        this.repairOrderId = repairOrderId;
    }

    public long getArrivalTime() {
        return this.arrivalTime;
    }

    public void setArrivalTime(long arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public long getDeliveryTime() {
        return this.deliveryTime;
    }

    public void setDeliveryTime(long deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getRepairMileage() {
        return this.repairMileage;
    }

    public void setRepairMileage(String repairMileage) {
        this.repairMileage = repairMileage;
    }

    public String getRepairDesc() {
        return this.repairDesc;
    }

    public void setRepairDesc(String repairDesc) {
        this.repairDesc = repairDesc;
    }

    public int getRepairState() {
        return this.repairState;
    }

    public void setRepairState(int repairState) {
        this.repairState = repairState;
    }

    public String getDutyPersonName() {
        return this.dutyPersonName;
    }

    public void setDutyPersonName(String dutyPersonName) {
        this.dutyPersonName = dutyPersonName;
    }

    public String getDutyPersonId() {
        return this.dutyPersonId;
    }

    public void setDutyPersonId(String dutyPersonId) {
        this.dutyPersonId = dutyPersonId;
    }

    public String getRepairTotalFee() {
        return this.repairTotalFee;
    }

    public void setRepairTotalFee(String repairTotalFee) {
        this.repairTotalFee = repairTotalFee;
    }

    public String getTotalPartFee() {
        return this.totalPartFee;
    }

    public void setTotalPartFee(String totalPartFee) {
        this.totalPartFee = totalPartFee;
    }

    public String getTotalAccessoryFee() {
        return this.totalAccessoryFee;
    }

    public void setTotalAccessoryFee(String totalAccessoryFee) {
        this.totalAccessoryFee = totalAccessoryFee;
    }


}