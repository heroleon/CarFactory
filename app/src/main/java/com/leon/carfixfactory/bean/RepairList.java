package com.leon.carfixfactory.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class RepairList {
    public Long carId;
    public String accessoryName;
    public double accessoryPrice;
    @Generated(hash = 105786550)
    public RepairList(Long carId, String accessoryName, double accessoryPrice) {
        this.carId = carId;
        this.accessoryName = accessoryName;
        this.accessoryPrice = accessoryPrice;
    }
    @Generated(hash = 1802658495)
    public RepairList() {
    }
    public Long getCarId() {
        return this.carId;
    }
    public void setCarId(Long carId) {
        this.carId = carId;
    }
    public String getAccessoryName() {
        return this.accessoryName;
    }
    public void setAccessoryName(String accessoryName) {
        this.accessoryName = accessoryName;
    }
    public double getAccessoryPrice() {
        return this.accessoryPrice;
    }
    public void setAccessoryPrice(double accessoryPrice) {
        this.accessoryPrice = accessoryPrice;
    }
}
