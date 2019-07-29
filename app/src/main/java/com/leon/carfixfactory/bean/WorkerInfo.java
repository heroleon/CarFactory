package com.leon.carfixfactory.bean;

import android.content.Context;
import android.text.TextUtils;

import com.leon.carfixfactory.R;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class WorkerInfo {
    @Id(autoincrement = true)
    public long workerId;
    public String avatarPath;
    public String workerName;
    public String workerBirthDay;
    public String workerPhone;
    public String workerAddress;

    @Generated(hash = 1793834727)
    public WorkerInfo(long workerId, String avatarPath, String workerName,
            String workerBirthDay, String workerPhone, String workerAddress) {
        this.workerId = workerId;
        this.avatarPath = avatarPath;
        this.workerName = workerName;
        this.workerBirthDay = workerBirthDay;
        this.workerPhone = workerPhone;
        this.workerAddress = workerAddress;
    }

    @Generated(hash = 1000580303)
    public WorkerInfo() {
    }

    public String getWorkerName() {
        return this.workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public String getWorkerBirthDay() {
        return this.workerBirthDay;
    }

    public void setWorkerBirthDay(String workerBirthDay) {
        this.workerBirthDay = workerBirthDay;
    }

    public String getWorkerPhone() {
        return this.workerPhone;
    }

    public void setWorkerPhone(String workerPhone) {
        this.workerPhone = workerPhone;
    }

    public String getWorkerAddress() {
        return this.workerAddress;
    }

    public void setWorkerAddress(String workerAddress) {
        this.workerAddress = workerAddress;
    }

    public long getWorkerId() {
        return this.workerId;
    }

    public void setWorkerId(long workerId) {
        this.workerId = workerId;
    }

    public String checkData(Context context) {
        if (TextUtils.isEmpty(avatarPath)) {
            return context.getString(R.string.please_take_avatar);
        }
        if (TextUtils.isEmpty(workerName)) {
            return context.getString(R.string.input_worker_name);
        }
        if (TextUtils.isEmpty(workerBirthDay)) {
            return context.getString(R.string.input_worker_birthday);
        }
        if (TextUtils.isEmpty(workerPhone)) {
            return context.getString(R.string.input_worker_phone);
        }
        if (TextUtils.isEmpty(workerAddress)) {
            return context.getString(R.string.input_worker_address);
        }
        return null;
    }

    public String getAvatarPath() {
        return this.avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }
}
