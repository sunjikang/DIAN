package com.xing.manage.service;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.xing.commonbase.constants.Constants;
import com.xing.commonbase.util.SharedPreferenceUtil;
import com.xing.manage.bean.device.Area;
import com.xing.manage.bean.device.Facility;
import com.xing.manage.bean.device.Inspection;
import com.xing.manage.bean.device.Line;
import com.xing.manage.bean.device.Record;
import com.xing.manage.bean.device.Resource;
import com.xing.manage.db.AreaDao;
import com.xing.manage.db.DbManager;
import com.xing.manage.db.FacilityDao;
import com.xing.manage.db.InspectionDao;
import com.xing.manage.db.LineDao;
import com.xing.manage.db.RecordDao;
import com.xing.manage.db.ResourceDao;
import com.xing.manage.util.ThreadPoolManager;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class UploadService  extends JobService {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("sjk","oncreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("sjk","ondestroy");
    }

     @Override
    public boolean onStartJob(JobParameters params) {
        doJob(params);
        return true;
    }

    private void doJob(final JobParameters params) {
        try {
            //初始化上传数据资源
            long lineId =  params.getJobId();
            RecordDao recordDao = DbManager.getInstance().
                    getRecordDao();
            final List<Record> records = recordDao.queryBuilder().where(RecordDao.Properties.LineId.eq(lineId))
                    .where(RecordDao.Properties.IsUploaded.eq(false))
                    .list();
            for (final Record record:records) {
             Runnable work  =   new Runnable(){
                    @Override
                    public void run() {
                        initData(record);
                    }
                };

                ThreadPoolManager.getInstance().execute(work);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /***
     * 初始化上传资源
     * @param record
     */
    private void initData(Record record) {

        Line line =   DbManager.getInstance().
                getLineDao().queryBuilder().where(LineDao.Properties.Mmid.eq(record.lineId)).list().get(0);
      //  Area area  = DbManager.getInstance().getAreaDao().queryBuilder().where(AreaDao.Properties.Mmid.eq(record.areaId)).list().get(0);

       // Facility facility = DbManager.getInstance().getFacilityDao().queryBuilder().where(FacilityDao.Properties.Mmid.eq(record.facilityId)).list().get(0);

       // Inspection inspection = DbManager.getInstance().getInspectionDao().queryBuilder().where(InspectionDao.Properties.Mmid.eq(record.inspectionId)).list().get(0);

        List<Resource> resources = DbManager.getInstance().
                getResourceDao().queryBuilder().where(ResourceDao.Properties.RecordId.eq(record.mmid)).list();


        //todo 上传数据和文件到服务器
        uploadFile(line,record,resources);
    }
    private void updateSql(Record record) {
        Log.e("sjk","----job updateSql-----");
        //todo 更新数据库 该record 上传为true
        RecordDao recordDao = DbManager.getInstance().
                getRecordDao();
        record.isUploaded=true;
        recordDao.update(record);
    }

    private void uploadFile(Line line, final Record record, List<Resource> list) {
        Log.e("sjk","----job uploadFile-----");
        String startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(line.startCheckTime);
        String endTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(line.endCheckTime);

        OkHttpClient client=new OkHttpClient();

        RequestBody requestBody;
        MultipartBody.Builder   builder   = new MultipartBody.Builder()
                .setType(MultipartBody.ALTERNATIVE)

                .addFormDataPart("startTime",startTime)
                .addFormDataPart("endTime",endTime)
                .addFormDataPart("pollingType",record.pollingType)
                .addFormDataPart("taskType",line.taskType)
//                .addFormDataPart("areaId",""+record.areaServerId)
//                .addFormDataPart("lineId",""+record.lineServerId)
//                .addFormDataPart("facilityId",""+record.facilityServerId)
//                .addFormDataPart("inspectionId",""+record.inspectionServerId)
                .addFormDataPart("abnormalStatus",record.isNormal?"正常":"异常")
                .addFormDataPart("lineName",record.lineName)
                .addFormDataPart("lineCode",record.lineCode)
                .addFormDataPart("areaName",record.areaName)
                .addFormDataPart("facilityName",record.facilityName)
                .addFormDataPart("inspectionName",record.inspectionName)
                .addFormDataPart("measuringValue",record.observedValue)
                .addFormDataPart("remarks",record.remark);


        for (int i = 0; i < list.size(); i++) {
            Resource resource = list.get(i);
            Log.e("sjk",resource.path);
            String suffix = resource.path.substring(resource.path.lastIndexOf("."));//后缀
            String yyyyMMddHHmmss = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
             String fileName=line.title+"_"+resource.mmid+"_"+yyyyMMddHHmmss+"_"+System.currentTimeMillis()+suffix;

            File file  = new File(resource.path);

            builder.addFormDataPart("upload", fileName, RequestBody.create(MediaType.parse("multipart/form-data"), file));

        }
         requestBody=builder.build();
        String token = SharedPreferenceUtil.read(Constants.FILE_TOKEN, Constants.ACCESS_TOKEN, "");
        String host = SharedPreferenceUtil.read(Constants.HOST, Constants.HOST, "");
        String url = host+"xboot/appPush/uploadPollingRecord";
        Request request=new Request.Builder().url(url)
                .addHeader("User-Agent","android")
                .addHeader("Content-Type","text/html; charset=gbk;")
                .addHeader("accessToken",token)
                .post(requestBody)//传参数、文件或者混合
                .build();
        try {
            Response response = client.newCall(request).execute();
            String sResult = new String(response.body().toString().getBytes("UTF-8"), "UTF-8");
            Log.e("sjk","连接成功获取的内容"+sResult);

            //todo 解析返回code为200时;
            if (response.isSuccessful()){
                if (response.code() == 200){
                    updateSql(record);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    @Override
    public boolean onStopJob(JobParameters params) {
        Log.e("sjk","----job onStopJob-----");
         return false;
    }
}
