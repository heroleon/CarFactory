package com.leon.carfixfactory.bean;

import android.app.Activity;
import android.text.TextUtils;

import com.leon.carfixfactory.R;
import com.leon.carfixfactory.utils.Utils;
import com.leon.carfixfactory.utils.ZToast;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

import java.io.Serializable;

@Entity
public class CarInfo implements Serializable {
    private static final long serialVersionUID = -2071565876962058344L;

    @Id(autoincrement = true)
    public Long carId;
    public String carCard;
    public String chassisNum;  //底盘号
    public String driverPhone;
    public String engineNum;
    public String driverName;
    public String driverIdcard;
    public String departmentName;
    public String departmentPhone;
    public String departmentAddr;
    public String maintenanceDetail;
    public double workTime = 0;
    public double workPrice = 0;
    public String dutyPerson;
    public int repairState;
    public String acceptTime;
    public String totalFee;

    @Generated(hash = 954049416)
    public CarInfo(Long carId, String carCard, String chassisNum, String driverPhone, String engineNum, String driverName,
            String driverIdcard, String departmentName, String departmentPhone, String departmentAddr,
            String maintenanceDetail, double workTime, double workPrice, String dutyPerson, int repairState,
            String acceptTime, String totalFee) {
        this.carId = carId;
        this.carCard = carCard;
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
        this.acceptTime = acceptTime;
        this.totalFee = totalFee;
    }


    @Generated(hash = 850322869)
    public CarInfo() {
    }

    public boolean checkData(Activity mActivity) {
        if (TextUtils.isEmpty(carCard)) {
            ZToast.makeText(mActivity, mActivity.getString(R.string.notify_empty_car_id), 1000).show();
            return true;
        }
        if (!Utils.checkPlateNumberFormat(carCard)) {
            ZToast.makeText(mActivity, mActivity.getString(R.string.notify_empty_car_id_error), 1000).show();
            return true;
        }
        if (TextUtils.isEmpty(chassisNum)) {
            ZToast.makeText(mActivity, mActivity.getString(R.string.notify_empty_chassis_num), 1000).show();
            return true;
        }
        if (TextUtils.isEmpty(engineNum)) {
            ZToast.makeText(mActivity, mActivity.getString(R.string.notify_empty_engine_num), 1000).show();
            return true;
        }
        if (TextUtils.isEmpty(driverName)) {
            ZToast.makeText(mActivity, mActivity.getString(R.string.notify_empty_driver_name), 1000).show();
            return true;
        }
        if (TextUtils.isEmpty(driverIdcard)) {
            ZToast.makeText(mActivity, mActivity.getString(R.string.notify_empty_driver_idcard), 1000).show();
            return true;
        }
        if (TextUtils.isEmpty(driverPhone)) {
            ZToast.makeText(mActivity, mActivity.getString(R.string.notify_empty_driver_phone), 1000).show();
            return true;
        }
        return false;
    }


    public boolean checkRepirData(Activity mActivity) {
        if (TextUtils.isEmpty(maintenanceDetail)) {
            ZToast.makeText(mActivity, mActivity.getString(R.string.notify_empty_maintenance_content), 1000).show();
            return true;
        }
        if (TextUtils.isEmpty(dutyPerson)) {
            ZToast.makeText(mActivity, mActivity.getString(R.string.notify_empty_duty_person), 1000).show();
            return true;
        }
        if (workTime == 0) {
            ZToast.makeText(mActivity, mActivity.getString(R.string.notify_empty_work_time), 1000).show();
            return true;
        }
        if (workPrice == 0) {
            ZToast.makeText(mActivity, mActivity.getString(R.string.notify_empty_work_price), 1000).show();
            return true;
        }

        return false;
    }


    public Long getCarId() {
        return this.carId;
    }


    public void setCarId(Long carId) {
        this.carId = carId;
    }


    public String getCarCard() {
        return this.carCard;
    }


    public void setCarCard(String carCard) {
        this.carCard = carCard;
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


    public String getAcceptTime() {
        return this.acceptTime;
    }


    public void setAcceptTime(String acceptTime) {
        this.acceptTime = acceptTime;
    }


    public String getTotalFee() {
        return this.totalFee;
    }


    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee;
    }

}
