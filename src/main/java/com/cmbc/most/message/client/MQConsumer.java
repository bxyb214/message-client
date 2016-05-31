package com.cmbc.most.message.client;

import com.ibm.mq.*;
import com.ibm.mq.constants.MQConstants;

public class MQConsumer {
    private static final String qManager = "QM_Yan";
    private static final String qName = "LQ01";
    public static void main(String args[]) {
        try {
            MQEnvironment.hostname = "9.110.83.36";
            MQEnvironment.channel = "CNN_Yan";
            MQEnvironment.port = 1414;
            MQEnvironment.userID="Yan";
//            MQEnvironment.sslCipherSuite = "";
            MQQueueManager qMgr = new MQQueueManager(qManager);
            int openOptions = MQConstants.MQOO_INPUT_AS_Q_DEF ;
            MQQueue queue = qMgr.accessQueue(qName, openOptions);

            MQMessage rcvMessage = new MQMessage();
            MQGetMessageOptions gmo = new MQGetMessageOptions();
            queue.get(rcvMessage, gmo);
            String msgText = rcvMessage.readUTF();
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
    }
}

