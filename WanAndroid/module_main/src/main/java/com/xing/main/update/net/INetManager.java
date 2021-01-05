package com.xing.main.update.net;

import java.io.File;

public interface INetManager {
    void get(String  url, INetCallBack  back,Object tag);
    void download(String url, File targetFile , INetDownloadCallBack downloadCallBack, Object  tag);
    void cancel(Object tag);
}
