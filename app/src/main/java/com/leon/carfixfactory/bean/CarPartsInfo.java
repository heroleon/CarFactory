package com.leon.carfixfactory.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by leon
 * Date: 2019/9/20
 * Time: 14:41
 * Desc:车辆维修配件信息
 */
@Entity
public class CarPartsInfo {
    @Id(autoincrement = true)
    public Long partId;
    public Long carId;
    public String partName;
    public String partPrice;
    public int partCount;

    @Generated(hash = 1578039802)
    public CarPartsInfo(Long partId, Long carId, String partName, String partPrice,
                        int partCount) {
        this.partId = partId;
        this.carId = carId;
        this.partName = partName;
        this.partPrice = partPrice;
        this.partCount = partCount;
    }

    @Generated(hash = 382406483)
    public CarPartsInfo() {
    }

    public Long getPartId() {
        return this.partId;
    }

    public void setPartId(Long partId) {
        this.partId = partId;
    }

    public Long getCarId() {
        return this.carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getPartName() {
        return this.partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getPartPrice() {
        return this.partPrice;
    }

    public void setPartPrice(String partPrice) {
        this.partPrice = partPrice;
    }

    public int getPartCount() {
        return this.partCount;
    }

    public void setPartCount(int partCount) {
        this.partCount = partCount;
    }
}
