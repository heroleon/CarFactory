package com.leon.carfixfactory.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class CarInfo {
    @Id(autoincrement = true)
    public Long carId;
    public String carID;
    public String chassisNum;  //底盘号
    public String driverPhone;
    public String engineNum;
    public String driverName;
    public String driverIdcard;
    public String departmentName;
    public String departmentPhone;
    public String departmentAddr;
    public String maintenanceDetail;
    public double workTime;
    public double workPrice;
    public String dutyPerson;
    public int repairState;
    @Generated(hash = 1247926795)
    public CarInfo(Long carId, String carID, String chassisNum, String driverPhone,
            String engineNum, String driverName, String driverIdcard,
            String departmentName, String departmentPhone, String departmentAddr,
            String maintenanceDetail, double workTime, double workPrice,
            String dutyPerson, int repairState) {
        this.carId = carId;
        this.carID = carID;
        this.chassisNum = chassisNum;
        this.driverPhone = driverPhone;
        this.engineNum = engineNum;
        this.driverName = driverName;
        this.driverIdcard = driverIdcard;
        this.departmentName = departmentName;
        this.departmentPhone = departmentPhone;
        this.departmentAddr = departmentAddr;
        this.maintenanceDetail = maintenanceDetail;
        this.workTime = workTime;
        this.workPrice = workPrice;
        this.dutyPerson = dutyPerson;
        this.repairState = repairState;
    }
    @Generated(hash = 850322869)
    public CarInfo() {
    }
    public Long getCarId() {
        return this.carId;
    }
    public void setCarId(Long carId) {
        this.carId = carId;
    }
    public String getCarID() {
        return this.carID;
    }
    public void setCarID(String carID) {
        this.carID = carID;
    }
    public String getChassisNum() {
        return this.chassisNum;
    }
    public void setChassisNum(String chassisNum) {
        this.chassisNum = chassisNum;
    }
    public String getDriverPhone() {
        return this.driverPhone;
    }
    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }
    public String getEngineNum() {
        return this.engineNum;
    }
    public void setEngineNum(String engineNum) {
        this.engineNum = engineNum;
    }
    public String getDriverName() {
        return this.driverName;
    }
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
    public String getDriverIdcard() {
        return this.driverIdcard;
    }
    public void setDriverIdcard(String driverIdcard) {
        this.driverIdcard = driverIdcard;
    }
    public String getDepartmentName() {
        return this.departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    public String getDepartmentPhone() {
        return this.departmentPhone;
    }
    public void setDepartmentPhone(String departmentPhone) {
        this.departmentPhone = departmentPhone;
    }
    public String getDepartmentAddr() {
        return this.departmentAddr;
    }
    public void setDepartmentAddr(String departmentAddr) {
        this.departmentAddr = departmentAddr;
    }
    public String getMaintenanceDetail() {
        return this.maintenanceDetail;
    }
    public void setMaintenanceDetail(String maintenanceDetail) {
        this.maintenanceDetail = maintenanceDetail;
    }
    public double getWorkTime() {
        return this.workTime;
    }
    public void setWorkTime(double workTime) {
        this.workTime = workTime;
    }
    public double getWorkPrice() {
        return this.workPrice;
    }
    public void setWorkPrice(double workPrice) {
        this.workPrice = workPrice;
    }
    public String getDutyPerson() {
        return this.dutyPerson;
    }
    public void setDutyPerson(String dutyPerson) {
        this.dutyPerson = dutyPerson;
    }
    public int getRepairState() {
        return this.repairState;
    }
    public void setRepairState(int repairState) {
        this.repairState = repairState;
    }
 
}
