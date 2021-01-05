package com.xing.manage.bean.manage;



import java.util.List;

/**
 * 处理历史记录
 * http://101.200.140.188:8901/xboot/actTask/historicFlow/205001
 */
public class HistoryBean {
    public String  id ; //     "id": "180039",
    public String  name  ; //     "name": "审批",
    public String   key   ; //   "key": "sid-08B96C13-3530-46E0-B316-27017D762F8B",
    public String    executionId  ; //   "executionId": "180028",
    public String   procDefId ;  //    "procDefId": "ticketWorkDq1:6:182512",
    public String    procInstId; //     "procInstId": "180028",
    public String     priority ;/// "priority": 1,
    public String     createTime;//  "createTime": "2020-10-26 16:57:43",
    public String     startTime ;//   "startTime": "2020-10-26 16:57:43",
    public String    endTime  ;//    "endTime": "2020-10-26 16:57:43",
    public String deleteReason ;//"deleteReason": "审批通过",
    public String comment;//        "comment": "通过",
    public String  duration;//       "duration": 54077,
    public List<Assignee>     assignees ;//   "startTime": "2020-10-26 16:57:43",

    public class  Assignee{

        public String  nickname ;
        public String  username ;
        public String  isExecutor ;

    }


}
