package com.example.demo.stream;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class JobAddMessage implements Serializable {
    private static final long serialVersionUID = -1382022142897948978L;

    private List<String> taskScheduleIdList;

    //实例id，用于标识消息发送方实例
    private String instanceId;
}
