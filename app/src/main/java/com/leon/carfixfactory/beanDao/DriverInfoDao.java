package com.leon.carfixfactory.beanDao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.leon.carfixfactory.bean.DriverInfo;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DRIVER_INFO".
*/
public class DriverInfoDao extends AbstractDao<DriverInfo, Long> {

    public static final String TABLENAME = "DRIVER_INFO";

    /**
     * Properties of entity DriverInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property DriverId = new Property(0, Long.class, "driverId", true, "_id");
        public final static Property DriverName = new Property(1, String.class, "driverName", false, "DRIVER_NAME");
        public final static Property DriverPhone = new Property(2, String.class, "driverPhone", false, "DRIVER_PHONE");
        public final static Property DriverAddress = new Property(3, String.class, "driverAddress", false, "DRIVER_ADDRESS");
        public final static Property NumberPlate = new Property(4, String.class, "numberPlate", false, "NUMBER_PLATE");
        public final static Property CarModel = new Property(5, String.class, "carModel", false, "CAR_MODEL");
        public final static Property FrameNum = new Property(6, String.class, "frameNum", false, "FRAME_NUM");
        public final static Property EngineNum = new Property(7, String.class, "engineNum", false, "ENGINE_NUM");
        public final static Property DepartmentName = new Property(8, String.class, "departmentName", false, "DEPARTMENT_NAME");
        public final static Property DepartmentPhone = new Property(9, String.class, "departmentPhone", false, "DEPARTMENT_PHONE");
        public final static Property DepartmentAddr = new Property(10, String.class, "departmentAddr", false, "DEPARTMENT_ADDR");
    }


    public DriverInfoDao(DaoConfig config) {
        super(config);
    }
    
    public DriverInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DRIVER_INFO\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: driverId
                "\"DRIVER_NAME\" TEXT," + // 1: driverName
                "\"DRIVER_PHONE\" TEXT," + // 2: driverPhone
                "\"DRIVER_ADDRESS\" TEXT," + // 3: driverAddress
                "\"NUMBER_PLATE\" TEXT," + // 4: numberPlate
                "\"CAR_MODEL\" TEXT," + // 5: carModel
                "\"FRAME_NUM\" TEXT," + // 6: frameNum
                "\"ENGINE_NUM\" TEXT," + // 7: engineNum
                "\"DEPARTMENT_NAME\" TEXT," + // 8: departmentName
                "\"DEPARTMENT_PHONE\" TEXT," + // 9: departmentPhone
                "\"DEPARTMENT_ADDR\" TEXT);"); // 10: departmentAddr
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DRIVER_INFO\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, DriverInfo entity) {
        stmt.clearBindings();
 
        Long driverId = entity.getDriverId();
        if (driverId != null) {
            stmt.bindLong(1, driverId);
        }
 
        String driverName = entity.getDriverName();
        if (driverName != null) {
            stmt.bindString(2, driverName);
        }
 
        String driverPhone = entity.getDriverPhone();
        if (driverPhone != null) {
            stmt.bindString(3, driverPhone);
        }
 
        String driverAddress = entity.getDriverAddress();
        if (driverAddress != null) {
            stmt.bindString(4, driverAddress);
        }
 
        String numberPlate = entity.getNumberPlate();
        if (numberPlate != null) {
            stmt.bindString(5, numberPlate);
        }
 
        String carModel = entity.getCarModel();
        if (carModel != null) {
            stmt.bindString(6, carModel);
        }
 
        String frameNum = entity.getFrameNum();
        if (frameNum != null) {
            stmt.bindString(7, frameNum);
        }
 
        String engineNum = entity.getEngineNum();
        if (engineNum != null) {
            stmt.bindString(8, engineNum);
        }
 
        String departmentName = entity.getDepartmentName();
        if (departmentName != null) {
            stmt.bindString(9, departmentName);
        }
 
        String departmentPhone = entity.getDepartmentPhone();
        if (departmentPhone != null) {
            stmt.bindString(10, departmentPhone);
        }
 
        String departmentAddr = entity.getDepartmentAddr();
        if (departmentAddr != null) {
            stmt.bindString(11, departmentAddr);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, DriverInfo entity) {
        stmt.clearBindings();
 
        Long driverId = entity.getDriverId();
        if (driverId != null) {
            stmt.bindLong(1, driverId);
        }
 
        String driverName = entity.getDriverName();
        if (driverName != null) {
            stmt.bindString(2, driverName);
        }
 
        String driverPhone = entity.getDriverPhone();
        if (driverPhone != null) {
            stmt.bindString(3, driverPhone);
        }
 
        String driverAddress = entity.getDriverAddress();
        if (driverAddress != null) {
            stmt.bindString(4, driverAddress);
        }
 
        String numberPlate = entity.getNumberPlate();
        if (numberPlate != null) {
            stmt.bindString(5, numberPlate);
        }
 
        String carModel = entity.getCarModel();
        if (carModel != null) {
            stmt.bindString(6, carModel);
        }
 
        String frameNum = entity.getFrameNum();
        if (frameNum != null) {
            stmt.bindString(7, frameNum);
        }
 
        String engineNum = entity.getEngineNum();
        if (engineNum != null) {
            stmt.bindString(8, engineNum);
        }
 
        String departmentName = entity.getDepartmentName();
        if (departmentName != null) {
            stmt.bindString(9, departmentName);
        }
 
        String departmentPhone = entity.getDepartmentPhone();
        if (departmentPhone != null) {
            stmt.bindString(10, departmentPhone);
        }
 
        String departmentAddr = entity.getDepartmentAddr();
        if (departmentAddr != null) {
            stmt.bindString(11, departmentAddr);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public DriverInfo readEntity(Cursor cursor, int offset) {
        DriverInfo entity = new DriverInfo( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // driverId
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // driverName
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // driverPhone
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // driverAddress
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // numberPlate
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // carModel
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // frameNum
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // engineNum
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // departmentName
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // departmentPhone
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10) // departmentAddr
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, DriverInfo entity, int offset) {
        entity.setDriverId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setDriverName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setDriverPhone(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setDriverAddress(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setNumberPlate(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setCarModel(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setFrameNum(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setEngineNum(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setDepartmentName(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setDepartmentPhone(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setDepartmentAddr(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(DriverInfo entity, long rowId) {
        entity.setDriverId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(DriverInfo entity) {
        if(entity != null) {
            return entity.getDriverId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(DriverInfo entity) {
        return entity.getDriverId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
