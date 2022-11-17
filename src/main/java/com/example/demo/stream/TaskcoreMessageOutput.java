package com.example.demo.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface TaskcoreMessageOutput {

    String OUTPUT_NAME = "taskcore-message-output";

    @Output(OUTPUT_NAME)
    MessageChannel output();
}
