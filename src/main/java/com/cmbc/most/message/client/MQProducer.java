package com.cmbc.most.message.client;

import com.ibm.mq.*;
import com.ibm.mq.constants.MQConstants;

public class MQProducer {
    private static final String qManager = "QM_TIPS_2027100000_01";
    private static final String qName = "PBC.2600.ONLINE.TRAN";

    public static void main(String args[]) {
        try {
            MQEnvironment.hostname = "195.216.145.19";
            MQEnvironment.port = 1414;
            MQEnvironment.channel = "SVRCONN";
            MQEnvironment.CCSID = 819;

//            MQEnvironment.userID="Yan";
//            MQEnvironment.password="O9i8u7y6";
            MQQueueManager qMgr = new MQQueueManager(qManager);
            int openOptions = MQConstants.MQOO_OUTPUT;
            MQQueue queue = qMgr.accessQueue(qName, openOptions);

            MQMessage msg = new MQMessage();
            String message = MQClientUtils.DEFAULT_PLACEORDER_PAYLOAD;
            msg.writeUTF(message);
            MQPutMessageOptions pmo = new MQPutMessageOptions();
            queue.put(msg, pmo);

            queue.close();
            qMgr.disconnect();
        } catch (MQException ex) {
            ex.printStackTrace();
            System.out.println("A WebSphere MQ Error occurred : Completion Code " + ex.completionCode
                    + " Reason Code " + ex.reasonCode);


        } catch (java.io.IOException ex) {
            System.out.println("An IOException occurred whilst writing to the message buffer: " + ex);
        }
    }
}

