package com.cmbc.most.message.jmx.client;

import com.ibm.mq.jms.MQQueueConnectionFactory;
import com.ibm.msg.client.wmq.WMQConstants;

import javax.jms.JMSException;
/**
 * Created by Yan on 16/5/27.
 */
public class CMBCConnectionFactory extends MQQueueConnectionFactory {



    public MQQueueConnectionFactory CMBCConnectionFactory(CMBCMQProperties properties) throws JMSException {
        MQQueueConnectionFactory factory = new MQQueueConnectionFactory();
        factory.setHostName(properties.getHost());
        factory.setPort(properties.getPort());
        factory.setQueueManager(properties.getQueueManager());
        factory.setChannel(properties.getChannel());
        factory.setCCSID(properties.getCCSID());
        factory.setTransportType(WMQConstants.WMQ_CM_CLIENT);
        return factory;
    }
}
