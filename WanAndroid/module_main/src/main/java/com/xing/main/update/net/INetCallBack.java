package com.xing.main.update.net;

public interface INetCallBack {
    void  success(String  response);
    void  failed(Throwable throwable);
}
