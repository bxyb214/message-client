package com.cmbc.most.message.jmx.client;

import com.ibm.mq.jms.MQQueueConnectionFactory;
import com.ibm.msg.client.wmq.WMQConstants;

import javax.jms.JMSException;

/**
 * Created by Yan on 16/5/27.
 */
public class ConnectionFactory extends MQQueueConnectionFactory {

    private CMBCMQProperties cmbcmqProperties;

    public CMBCMQProperties getCmbcmqProperties() {
        return cmbcmqProperties;
    }

    public void setCmbcmqProperties(CMBCMQProperties cmbcmqProperties) throws JMSException {
        this.cmbcmqProperties = cmbcmqProperties;
        this.setHostName(cmbcmqProperties.getHost());
        this.setPort(cmbcmqProperties.getPort());
        this.setQueueManager(cmbcmqProperties.getQueueManager());
        this.setChannel(cmbcmqProperties.getChannel());
        this.setCCSID(cmbcmqProperties.getCCSID());
        this.setTransportType(WMQConstants.WMQ_CM_CLIENT);
    }
}
