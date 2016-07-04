package com.cmbc.most.message;

import com.alibaba.fastjson.JSON;

import java.util.Date;

/**
 * Created by Yan on 16/5/27.
 */
public class Message {

    public static int EMAIL = 1;

    public static int SMS = 2;

    public static int EMAIL_SMS = 3;

    private Integer id;
    /**
     * UUID
     * 16位唯一标识, 通过客户端工具包生成,由APP,时间等信息生成
     */
    private String uuid;

    /**
     *  应用来源
     */
    private Integer appId;

    /**
     * 生成时间
     */
    private Date createdDate;

    /**
     * 写入时间
     */
    private Date saveDate;

    /**
     * 最后一次发送时间
     */
    private Date sendDate;

    /**
     * 发送次数
     */
    private Integer sendNumber;

    /**
     * 成功与否
     */
    private Boolean send;

    /**
     * 重要消息, 强制发送
     */
    private Boolean important;

    /**
     * 发送渠道
     * 二进制 1 1 1
     */
    private Integer channel;

    /**
     * 状态
     * 2 表示 未发送
     * 1 表示 已发送
     * 0 表示 无效
     */
    private Integer status;


    /**
     * 邮件标题
     */
    private String subject;

    /**
     * 邮件发件人
     */
    private String from;

    /**
     * 邮件接受人  to&cc&bcc
     */
    private String recevier;

    /**
     * 邮件邮件体
     */
    private String body;

    /**
     * 错误code
     */
    private String errorCode;

    /**
     * 错误描述
     */
    private String errorDescription;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getSaveDate() {
        return saveDate;
    }

    public void setSaveDate(Date saveDate) {
        this.saveDate = saveDate;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public Integer getSendNumber() {
        return sendNumber;
    }

    public void setSendNumber(Integer sendNumber) {
        this.sendNumber = sendNumber;
    }

    public Boolean getSend() {
        return send;
    }

    public void setSend(Boolean send) {
        this.send = send;
    }

    public Boolean getImportant() {
        return important;
    }

    public void setImportant(Boolean important) {
        this.important = important;
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getRecevier() {
        return recevier;
    }

    public void setRecevier(String recevier) {
        this.recevier = recevier;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public static String toJson(Message m){

        //TODO 1. 验证消息 2. 生成uuid

        return JSON.toJSONString(m);
    }

    public static Message parseMessage(String m){
        return JSON.parseObject(m, Message.class);
    }
}
