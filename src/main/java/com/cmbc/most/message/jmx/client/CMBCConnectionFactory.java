package com.cmbc.most.message.jmx.client;

import com.ibm.mq.jms.MQQueueConnectionFactory;
import com.ibm.msg.client.wmq.WMQConstants;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
/**
 * Created by Yan on 16/5/27.
 */
public class CMBCConnectionFactory extends MQQueueConnectionFactory {


    private static MQQueueConnectionFactory factory = null;

    private CMBCConnectionFactory(){

    }

    public static ConnectionFactory getCMBCConnectionFactoryInstance(CMBCMQProperties properties) throws JMSException {
        if(factory == null){
            synchronized(CMBCConnectionFactory.class) {
                if (factory == null) {
                    factory = new MQQueueConnectionFactory();
                    factory.setHostName(properties.getHost());
                    factory.setPort(properties.getPort());
                    factory.setQueueManager(properties.getQueueManager());
                    factory.setChannel(properties.getChannel());
                    factory.setCCSID(properties.getCCSID());
                    factory.setTransportType(WMQConstants.WMQ_CM_CLIENT);
                }
            }
        }
        return factory;
    }
}
