package com.cmbc.most.message.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;

import com.cmbc.most.message.EMail;
import com.cmbc.most.message.SMS;
import com.ibm.mq.*;
import com.ibm.mq.constants.MQConstants;

public class MQClientUtils {

    public final static String DEFAULT_PLACEORDER_PAYLOAD = "<m:placeOrder xmlns:m=\"http://services.samples\">\n"
            + "\t<m:order>\n"
            + "\t\t<m:price>1</m:price>\n"
            + "\t\t<m:quantity>200</m:quantity>\n"
            + "\t\t<m:symbol>IBM MQ run in mymgr</m:symbol>\n"
            + "\t</m:order>\n"
            + "</m:placeOrder>";

    private static final String qManager = "QM_TIPS_2027100000_01";
    private static final String qName = "PBC.2600.ONLINE.TRAN";

    /*
     * EMail发送
     */
    public Boolean sendMessage(EMail message){
        sendMessage("111");
        return true;
    }

    /*
     * 短信发送
     */
    public Boolean sendMessage(SMS message) {
        sendMessage("222");
        return true;
    }


    private void ConnectMQ() {
        /**
         * 读取MQ连接配置文件获取相关连接信息
         */
        MQEnvironment.hostname = "192.168.191.10";
        MQEnvironment.port = 1414;
        MQEnvironment.channel = "SVRCONN";
        MQEnvironment.CCSID = 819;
    }
    /**
     * 读取MQ队列中的消息
     */
    public String GetMessage(){
        String msgText="";
        try {
            //MQ连接
            ConnectMQ();
            MQQueueManager qMgr = new MQQueueManager(qManager);
            int openOptions = MQConstants.MQOO_INPUT_AS_Q_DEF ;
            MQQueue queue = qMgr.accessQueue(qName, openOptions);

            MQMessage rcvMessage = new MQMessage();
            MQGetMessageOptions gmo = new MQGetMessageOptions();
            queue.get(rcvMessage, gmo);
            msgText = rcvMessage.readUTF();
            System.out.print(msgText);

            queue.close();
            qMgr.disconnect();
        } catch (MQException ex) {
            ex.printStackTrace();
            System.out.println("A WebSphere MQ Error occurred : Completion Code " + ex.completionCode
                    + " Reason Code " + ex.reasonCode);

        } catch (java.io.IOException ex) {
            System.out.println("An IOException occurred whilst writing to the message buffer: " + ex);
        }
        return msgText;
    }

    /*
     * MQ信息发送
     * 传入要发送的信息
     */
    public void sendMessage(String message) {

        try {
            //MQ连接
            ConnectMQ();
            MQQueueManager qMgr = new MQQueueManager(qManager);
            int openOptions = MQConstants.MQOO_OUTPUT;
            MQQueue queue = qMgr.accessQueue(qName, openOptions);
            MQMessage msg = new MQMessage();
            System.out.println("message:" + message);
            msg.writeUTF(message);
            MQPutMessageOptions pmo = new MQPutMessageOptions();
            queue.put(msg, pmo);
            queue.close();
            qMgr.disconnect();

        } catch (MQException ex) {
            ex.printStackTrace();
            System.out.println("A WebSphere MQ Error occurred : Completion Code " + ex.completionCode + " Reason Code " + ex.reasonCode);
        } catch (java.io.IOException ex) {
            System.out.println("An IOException occurred whilst writing to the message buffer: " + ex);
        }
    }
}
