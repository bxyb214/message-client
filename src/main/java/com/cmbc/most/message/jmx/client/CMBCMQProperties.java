package com.cmbc.most.message.jmx.client;

/**
 * Created by Yan on 16/5/27.
 */
public class CMBCMQProperties {

    String queueManager;
    String host;
    int port;
    String channel;
    int CCSID;

    public String getQueueManager() {
        return queueManager;
    }

    public void setQueueManager(String queueManager) {
        this.queueManager = queueManager;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public int getCCSID() {
        return CCSID;
    }

    public void setCCSID(int CCSID) {
        this.CCSID = CCSID;
    }
}
