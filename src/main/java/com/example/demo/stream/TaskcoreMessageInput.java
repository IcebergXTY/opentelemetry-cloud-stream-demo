package com.example.demo.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @since 2.7.0
 */
public interface TaskcoreMessageInput {

    String INPUT_NAME = "taskcore-message-input";

    @Input(INPUT_NAME)
    SubscribableChannel input();
}
