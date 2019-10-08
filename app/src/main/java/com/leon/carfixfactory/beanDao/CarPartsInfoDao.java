package com.leon.carfixfactory.beanDao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.leon.carfixfactory.bean.CarPartsInfo;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "CAR_PARTS_INFO".
*/
public class CarPartsInfoDao extends AbstractDao<CarPartsInfo, Long> {

    public static final String TABLENAME = "CAR_PARTS_INFO";

    /**
     * Properties of entity CarPartsInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property PartId = new Property(0, Long.class, "partId", true, "_id");
        public final static Property CarId = new Property(1, Long.class, "carId", false, "CAR_ID");
        public final static Property PartName = new Property(2, String.class, "partName", false, "PART_NAME");
        public final static Property PartPrice = new Property(3, String.class, "partPrice", false, "PART_PRICE");
        public final static Property PartCount = new Property(4, int.class, "partCount", false, "PART_COUNT");
    }


    public CarPartsInfoDao(DaoConfig config) {
        super(config);
    }
    
    public CarPartsInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"CAR_PARTS_INFO\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: partId
                "\"CAR_ID\" INTEGER," + // 1: carId
                "\"PART_NAME\" TEXT," + // 2: partName
                "\"PART_PRICE\" TEXT," + // 3: partPrice
                "\"PART_COUNT\" INTEGER NOT NULL );"); // 4: partCount
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"CAR_PARTS_INFO\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, CarPartsInfo entity) {
        stmt.clearBindings();
 
        Long partId = entity.getPartId();
        if (partId != null) {
            stmt.bindLong(1, partId);
        }
 
        Long carId = entity.getCarId();
        if (carId != null) {
            stmt.bindLong(2, carId);
        }
 
        String partName = entity.getPartName();
        if (partName != null) {
            stmt.bindString(3, partName);
        }
 
        String partPrice = entity.getPartPrice();
        if (partPrice != null) {
            stmt.bindString(4, partPrice);
        }
        stmt.bindLong(5, entity.getPartCount());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, CarPartsInfo entity) {
        stmt.clearBindings();
 
        Long partId = entity.getPartId();
        if (partId != null) {
            stmt.bindLong(1, partId);
        }
 
        Long carId = entity.getCarId();
        if (carId != null) {
            stmt.bindLong(2, carId);
        }
 
        String partName = entity.getPartName();
        if (partName != null) {
            stmt.bindString(3, partName);
        }
 
        String partPrice = entity.getPartPrice();
        if (partPrice != null) {
            stmt.bindString(4, partPrice);
        }
        stmt.bindLong(5, entity.getPartCount());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public CarPartsInfo readEntity(Cursor cursor, int offset) {
        CarPartsInfo entity = new CarPartsInfo( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // partId
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // carId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // partName
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // partPrice
            cursor.getInt(offset + 4) // partCount
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, CarPartsInfo entity, int offset) {
        entity.setPartId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setCarId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setPartName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setPartPrice(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setPartCount(cursor.getInt(offset + 4));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(CarPartsInfo entity, long rowId) {
        entity.setPartId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(CarPartsInfo entity) {
        if(entity != null) {
            return entity.getPartId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(CarPartsInfo entity) {
        return entity.getPartId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}