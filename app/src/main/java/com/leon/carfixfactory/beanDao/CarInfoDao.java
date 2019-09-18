package com.leon.carfixfactory.beanDao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.leon.carfixfactory.bean.CarInfo;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "CAR_INFO".
*/
public class CarInfoDao extends AbstractDao<CarInfo, Long> {

    public static final String TABLENAME = "CAR_INFO";

    /**
     * Properties of entity CarInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property CarId = new Property(0, Long.class, "carId", true, "_id");
        public final static Property CarID = new Property(1, String.class, "carID", false, "CAR_ID");
        public final static Property ChassisNum = new Property(2, String.class, "chassisNum", false, "CHASSIS_NUM");
        public final static Property DriverPhone = new Property(3, String.class, "driverPhone", false, "DRIVER_PHONE");
        public final static Property EngineNum = new Property(4, String.class, "engineNum", false, "ENGINE_NUM");
        public final static Property DriverName = new Property(5, String.class, "driverName", false, "DRIVER_NAME");
        public final static Property DriverIdcard = new Property(6, String.class, "driverIdcard", false, "DRIVER_IDCARD");
        public final static Property DepartmentName = new Property(7, String.class, "departmentName", false, "DEPARTMENT_NAME");
        public final static Property DepartmentPhone = new Property(8, String.class, "departmentPhone", false, "DEPARTMENT_PHONE");
        public final static Property DepartmentAddr = new Property(9, String.class, "departmentAddr", false, "DEPARTMENT_ADDR");
        public final static Property MaintenanceDetail = new Property(10, String.class, "maintenanceDetail", false, "MAINTENANCE_DETAIL");
        public final static Property WorkTime = new Property(11, double.class, "workTime", false, "WORK_TIME");
        public final static Property WorkPrice = new Property(12, double.class, "workPrice", false, "WORK_PRICE");
        public final static Property DutyPerson = new Property(13, String.class, "dutyPerson", false, "DUTY_PERSON");
        public final static Property RepairState = new Property(14, int.class, "repairState", false, "REPAIR_STATE");
    }


    public CarInfoDao(DaoConfig config) {
        super(config);
    }
    
    public CarInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"CAR_INFO\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: carId
                "\"CAR_ID\" TEXT," + // 1: carID
                "\"CHASSIS_NUM\" TEXT," + // 2: chassisNum
                "\"DRIVER_PHONE\" TEXT," + // 3: driverPhone
                "\"ENGINE_NUM\" TEXT," + // 4: engineNum
                "\"DRIVER_NAME\" TEXT," + // 5: driverName
                "\"DRIVER_IDCARD\" TEXT," + // 6: driverIdcard
                "\"DEPARTMENT_NAME\" TEXT," + // 7: departmentName
                "\"DEPARTMENT_PHONE\" TEXT," + // 8: departmentPhone
                "\"DEPARTMENT_ADDR\" TEXT," + // 9: departmentAddr
                "\"MAINTENANCE_DETAIL\" TEXT," + // 10: maintenanceDetail
                "\"WORK_TIME\" REAL NOT NULL ," + // 11: workTime
                "\"WORK_PRICE\" REAL NOT NULL ," + // 12: workPrice
                "\"DUTY_PERSON\" TEXT," + // 13: dutyPerson
                "\"REPAIR_STATE\" INTEGER NOT NULL );"); // 14: repairState
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"CAR_INFO\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, CarInfo entity) {
        stmt.clearBindings();
 
        Long carId = entity.getCarId();
        if (carId != null) {
            stmt.bindLong(1, carId);
        }
 
        String carID = entity.getCarID();
        if (carID != null) {
            stmt.bindString(2, carID);
        }
 
        String chassisNum = entity.getChassisNum();
        if (chassisNum != null) {
            stmt.bindString(3, chassisNum);
        }
 
        String driverPhone = entity.getDriverPhone();
        if (driverPhone != null) {
            stmt.bindString(4, driverPhone);
        }
 
        String engineNum = entity.getEngineNum();
        if (engineNum != null) {
            stmt.bindString(5, engineNum);
        }
 
        String driverName = entity.getDriverName();
        if (driverName != null) {
            stmt.bindString(6, driverName);
        }
 
        String driverIdcard = entity.getDriverIdcard();
        if (driverIdcard != null) {
            stmt.bindString(7, driverIdcard);
        }
 
        String departmentName = entity.getDepartmentName();
        if (departmentName != null) {
            stmt.bindString(8, departmentName);
        }
 
        String departmentPhone = entity.getDepartmentPhone();
        if (departmentPhone != null) {
            stmt.bindString(9, departmentPhone);
        }
 
        String departmentAddr = entity.getDepartmentAddr();
        if (departmentAddr != null) {
            stmt.bindString(10, departmentAddr);
        }
 
        String maintenanceDetail = entity.getMaintenanceDetail();
        if (maintenanceDetail != null) {
            stmt.bindString(11, maintenanceDetail);
        }
        stmt.bindDouble(12, entity.getWorkTime());
        stmt.bindDouble(13, entity.getWorkPrice());
 
        String dutyPerson = entity.getDutyPerson();
        if (dutyPerson != null) {
            stmt.bindString(14, dutyPerson);
        }
        stmt.bindLong(15, entity.getRepairState());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, CarInfo entity) {
        stmt.clearBindings();
 
        Long carId = entity.getCarId();
        if (carId != null) {
            stmt.bindLong(1, carId);
        }
 
        String carID = entity.getCarID();
        if (carID != null) {
            stmt.bindString(2, carID);
        }
 
        String chassisNum = entity.getChassisNum();
        if (chassisNum != null) {
            stmt.bindString(3, chassisNum);
        }
 
        String driverPhone = entity.getDriverPhone();
        if (driverPhone != null) {
            stmt.bindString(4, driverPhone);
        }
 
        String engineNum = entity.getEngineNum();
        if (engineNum != null) {
            stmt.bindString(5, engineNum);
        }
 
        String driverName = entity.getDriverName();
        if (driverName != null) {
            stmt.bindString(6, driverName);
        }
 
        String driverIdcard = entity.getDriverIdcard();
        if (driverIdcard != null) {
            stmt.bindString(7, driverIdcard);
        }
 
        String departmentName = entity.getDepartmentName();
        if (departmentName != null) {
            stmt.bindString(8, departmentName);
        }
 
        String departmentPhone = entity.getDepartmentPhone();
        if (departmentPhone != null) {
            stmt.bindString(9, departmentPhone);
        }
 
        String departmentAddr = entity.getDepartmentAddr();
        if (departmentAddr != null) {
            stmt.bindString(10, departmentAddr);
        }
 
        String maintenanceDetail = entity.getMaintenanceDetail();
        if (maintenanceDetail != null) {
            stmt.bindString(11, maintenanceDetail);
        }
        stmt.bindDouble(12, entity.getWorkTime());
        stmt.bindDouble(13, entity.getWorkPrice());
 
        String dutyPerson = entity.getDutyPerson();
        if (dutyPerson != null) {
            stmt.bindString(14, dutyPerson);
        }
        stmt.bindLong(15, entity.getRepairState());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public CarInfo readEntity(Cursor cursor, int offset) {
        CarInfo entity = new CarInfo( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // carId
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // carID
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // chassisNum
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // driverPhone
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // engineNum
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // driverName
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // driverIdcard
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // departmentName
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // departmentPhone
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // departmentAddr
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // maintenanceDetail
            cursor.getDouble(offset + 11), // workTime
            cursor.getDouble(offset + 12), // workPrice
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), // dutyPerson
            cursor.getInt(offset + 14) // repairState
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, CarInfo entity, int offset) {
        entity.setCarId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setCarID(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setChassisNum(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setDriverPhone(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setEngineNum(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setDriverName(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setDriverIdcard(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setDepartmentName(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setDepartmentPhone(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setDepartmentAddr(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setMaintenanceDetail(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setWorkTime(cursor.getDouble(offset + 11));
        entity.setWorkPrice(cursor.getDouble(offset + 12));
        entity.setDutyPerson(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setRepairState(cursor.getInt(offset + 14));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(CarInfo entity, long rowId) {
        entity.setCarId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(CarInfo entity) {
        if(entity != null) {
            return entity.getCarId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(CarInfo entity) {
        return entity.getCarId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
