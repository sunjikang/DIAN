package com.xing.module.quality.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.xing.module.quality.bean.QCRecord;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "QCRecord".
*/
public class QCRecordDao extends AbstractDao<QCRecord, Long> {

    public static final String TABLENAME = "QCRecord";

    /**
     * Properties of entity QCRecord.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Matnr = new Property(1, String.class, "matnr", false, "MATNR");
        public final static Property Name = new Property(2, String.class, "name", false, "NAME");
        public final static Property Werks = new Property(3, String.class, "werks", false, "WERKS");
        public final static Property UserID = new Property(4, Long.class, "userID", false, "USER_ID");
        public final static Property CreateDate = new Property(5, java.util.Date.class, "createDate", false, "CREATE_DATE");
        public final static Property SerialNo = new Property(6, String.class, "serialNo", false, "SERIAL_NO");
        public final static Property BillID = new Property(7, Long.class, "billID", false, "BILL_ID");
        public final static Property Type = new Property(8, int.class, "type", false, "TYPE");
        public final static Property Flag = new Property(9, String.class, "flag", false, "FLAG");
        public final static Property ItemCode = new Property(10, String.class, "itemCode", false, "ITEM_CODE");
        public final static Property IsUpload = new Property(11, String.class, "isUpload", false, "IS_UPLOAD");
        public final static Property CodeCount = new Property(12, int.class, "codeCount", false, "CODE_COUNT");
        public final static Property ImageCount = new Property(13, int.class, "imageCount", false, "IMAGE_COUNT");
    }

    private DaoSession daoSession;


    public QCRecordDao(DaoConfig config) {
        super(config);
    }
    
    public QCRecordDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"QCRecord\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"MATNR\" TEXT," + // 1: matnr
                "\"NAME\" TEXT," + // 2: name
                "\"WERKS\" TEXT," + // 3: werks
                "\"USER_ID\" INTEGER," + // 4: userID
                "\"CREATE_DATE\" INTEGER," + // 5: createDate
                "\"SERIAL_NO\" TEXT," + // 6: serialNo
                "\"BILL_ID\" INTEGER," + // 7: billID
                "\"TYPE\" INTEGER NOT NULL ," + // 8: type
                "\"FLAG\" TEXT," + // 9: flag
                "\"ITEM_CODE\" TEXT," + // 10: itemCode
                "\"IS_UPLOAD\" TEXT," + // 11: isUpload
                "\"CODE_COUNT\" INTEGER NOT NULL ," + // 12: codeCount
                "\"IMAGE_COUNT\" INTEGER NOT NULL );"); // 13: imageCount
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"QCRecord\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, QCRecord entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String matnr = entity.getMatnr();
        if (matnr != null) {
            stmt.bindString(2, matnr);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
 
        String werks = entity.getWerks();
        if (werks != null) {
            stmt.bindString(4, werks);
        }
 
        Long userID = entity.getUserID();
        if (userID != null) {
            stmt.bindLong(5, userID);
        }
 
        java.util.Date createDate = entity.getCreateDate();
        if (createDate != null) {
            stmt.bindLong(6, createDate.getTime());
        }
 
        String serialNo = entity.getSerialNo();
        if (serialNo != null) {
            stmt.bindString(7, serialNo);
        }
 
        Long billID = entity.getBillID();
        if (billID != null) {
            stmt.bindLong(8, billID);
        }
        stmt.bindLong(9, entity.getType());
 
        String flag = entity.getFlag();
        if (flag != null) {
            stmt.bindString(10, flag);
        }
 
        String itemCode = entity.getItemCode();
        if (itemCode != null) {
            stmt.bindString(11, itemCode);
        }
 
        String isUpload = entity.getIsUpload();
        if (isUpload != null) {
            stmt.bindString(12, isUpload);
        }
        stmt.bindLong(13, entity.getCodeCount());
        stmt.bindLong(14, entity.getImageCount());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, QCRecord entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String matnr = entity.getMatnr();
        if (matnr != null) {
            stmt.bindString(2, matnr);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
 
        String werks = entity.getWerks();
        if (werks != null) {
            stmt.bindString(4, werks);
        }
 
        Long userID = entity.getUserID();
        if (userID != null) {
            stmt.bindLong(5, userID);
        }
 
        java.util.Date createDate = entity.getCreateDate();
        if (createDate != null) {
            stmt.bindLong(6, createDate.getTime());
        }
 
        String serialNo = entity.getSerialNo();
        if (serialNo != null) {
            stmt.bindString(7, serialNo);
        }
 
        Long billID = entity.getBillID();
        if (billID != null) {
            stmt.bindLong(8, billID);
        }
        stmt.bindLong(9, entity.getType());
 
        String flag = entity.getFlag();
        if (flag != null) {
            stmt.bindString(10, flag);
        }
 
        String itemCode = entity.getItemCode();
        if (itemCode != null) {
            stmt.bindString(11, itemCode);
        }
 
        String isUpload = entity.getIsUpload();
        if (isUpload != null) {
            stmt.bindString(12, isUpload);
        }
        stmt.bindLong(13, entity.getCodeCount());
        stmt.bindLong(14, entity.getImageCount());
    }

    @Override
    protected final void attachEntity(QCRecord entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public QCRecord readEntity(Cursor cursor, int offset) {
        QCRecord entity = new QCRecord( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // matnr
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // name
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // werks
            cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4), // userID
            cursor.isNull(offset + 5) ? null : new java.util.Date(cursor.getLong(offset + 5)), // createDate
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // serialNo
            cursor.isNull(offset + 7) ? null : cursor.getLong(offset + 7), // billID
            cursor.getInt(offset + 8), // type
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // flag
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // itemCode
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // isUpload
            cursor.getInt(offset + 12), // codeCount
            cursor.getInt(offset + 13) // imageCount
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, QCRecord entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setMatnr(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setWerks(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setUserID(cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4));
        entity.setCreateDate(cursor.isNull(offset + 5) ? null : new java.util.Date(cursor.getLong(offset + 5)));
        entity.setSerialNo(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setBillID(cursor.isNull(offset + 7) ? null : cursor.getLong(offset + 7));
        entity.setType(cursor.getInt(offset + 8));
        entity.setFlag(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setItemCode(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setIsUpload(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setCodeCount(cursor.getInt(offset + 12));
        entity.setImageCount(cursor.getInt(offset + 13));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(QCRecord entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(QCRecord entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(QCRecord entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
