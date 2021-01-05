package com.xing.module.quality.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.Date;
import java.util.List;

import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.DaoException;

import com.xing.module.quality.db.DaoSession;
import com.xing.module.quality.db.QCRImageDao;
import com.xing.module.quality.db.QCRecordCodeDao;
import com.xing.module.quality.db.QCRecordDao;

@Entity(nameInDb = "QCRecord")
public class QCRecord {
    @Id(autoincrement = true)
    private Long id;//品质ID	QC主键ID，关联QCRecordCode. QCRID，QCRImage. QCRID
    private String matnr;//TBL_ZIMPORTSAPMOINFO.SAPCODE；匹配跟单ID，零部件编码
    private String name;//产品名称
    private String werks;//工厂	工厂信息,登陆信息
    private Long userID;//用户ID	F_CREATORUSERID
    private Date createDate;//创建时间
    private String serialNo;//系列号	SAPMOCODE+9901+0001（序列取Right（跟单ID，4）），扫描包装或产品标签截取Left（ID，20）
    private Long billID;//跟单ID	跟单ID写入
    private int type;//类型	成品=1，零部件=0
    private String flag;//缺陷标志	合格=1，不良原因=0
    private String itemCode;//成品编码	tbl_zimportsapmoinfo.SAPCODE
    private String isUpload;//上传标志  上传=1    未上传=0

    private transient boolean isCheck = false;

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    @NotNull
    private int codeCount;
    @ToMany(referencedJoinProperty = "qcrId")
    private List<QCRecordCode> qcRecordCodeList;
    @NotNull
    private int imageCount;
    @ToMany(referencedJoinProperty = "qcrId")
    private List<QCRImage> qcrImageList;
    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /**
     * Used for active entity operations.
     */
    @Generated(hash = 1009080143)
    private transient QCRecordDao myDao;

    @Generated(hash = 832524129)
    public QCRecord(Long id, String matnr, String name, String werks, Long userID,
                    Date createDate, String serialNo, Long billID, int type, String flag,
                    String itemCode, String isUpload, int codeCount, int imageCount) {
        this.id = id;
        this.matnr = matnr;
        this.name = name;
        this.werks = werks;
        this.userID = userID;
        this.createDate = createDate;
        this.serialNo = serialNo;
        this.billID = billID;
        this.type = type;
        this.flag = flag;
        this.itemCode = itemCode;
        this.isUpload = isUpload;
        this.codeCount = codeCount;
        this.imageCount = imageCount;
    }

    @Generated(hash = 2024757986)
    public QCRecord() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatnr() {
        return this.matnr;
    }

    public void setMatnr(String matnr) {
        this.matnr = matnr;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWerks() {
        return this.werks;
    }

    public void setWerks(String werks) {
        this.werks = werks;
    }

    public Long getUserID() {
        return this.userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getSerialNo() {
        return this.serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public Long getBillID() {
        return this.billID;
    }

    public void setBillID(Long billID) {
        this.billID = billID;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getFlag() {
        return this.flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getItemCode() {
        return this.itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getIsUpload() {
        return this.isUpload;
    }

    public void setIsUpload(String isUpload) {
        this.isUpload = isUpload;
    }

    public int getCodeCount() {
        return this.codeCount;
    }

    public void setCodeCount(int codeCount) {
        this.codeCount = codeCount;
    }

    public int getImageCount() {
        return this.imageCount;
    }

    public void setImageCount(int imageCount) {
        this.imageCount = imageCount;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 152001301)
    public List<QCRecordCode> getQcRecordCodeList() {
        if (qcRecordCodeList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            QCRecordCodeDao targetDao = daoSession.getQCRecordCodeDao();
            List<QCRecordCode> qcRecordCodeListNew = targetDao
                    ._queryQCRecord_QcRecordCodeList(id);
            synchronized (this) {
                if (qcRecordCodeList == null) {
                    qcRecordCodeList = qcRecordCodeListNew;
                }
            }
        }
        return qcRecordCodeList;
    }

    /**
     * Resets a to-many relationship, making the next get call to query for a fresh result.
     */
    @Generated(hash = 1418854987)
    public synchronized void resetQcRecordCodeList() {
        qcRecordCodeList = null;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 633451143)
    public List<QCRImage> getQcrImageList() {
        if (qcrImageList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            QCRImageDao targetDao = daoSession.getQCRImageDao();
            List<QCRImage> qcrImageListNew = targetDao._queryQCRecord_QcrImageList(id);
            synchronized (this) {
                if (qcrImageList == null) {
                    qcrImageList = qcrImageListNew;
                }
            }
        }
        return qcrImageList;
    }

    /**
     * Resets a to-many relationship, making the next get call to query for a fresh result.
     */
    @Generated(hash = 453914186)
    public synchronized void resetQcrImageList() {
        qcrImageList = null;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 1438546946)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getQCRecordDao() : null;
    }

    public void setQcRecordCodeList() {
        this.qcRecordCodeList = getQcRecordCodeList();
    }

    public void setQcrImageList() {
        this.qcrImageList = getQcrImageList();
    }
}
