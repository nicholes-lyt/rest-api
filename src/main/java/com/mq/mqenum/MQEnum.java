package com.mq.mqenum;

public enum MQEnum {
	
	CONTRACT_FANOUT("CONTRACT_FANOUT", "消息分发"),
    CONTRACT_TOPIC("CONTRACT_TOPIC", "消息订阅"),
    CONTRACT_DIRECT("CONTRACT_DIRECT", "点对点");

    private String code;
    private String name;

    MQEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
	
}
