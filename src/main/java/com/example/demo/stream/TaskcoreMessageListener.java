package com.example.demo.stream;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;

import java.io.IOException;

/**
 * @since 2.7.0
 */
@Slf4j
public class TaskcoreMessageListener {

    @StreamListener(TaskcoreMessageInput.INPUT_NAME)
    public void listenJobAddEvent(Message<JobAddMessage> jobAddMessageInStream, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, @Header(AmqpHeaders.CHANNEL) Channel channel) throws IOException {
        try {
            JobAddMessage jobAddMessage = jobAddMessageInStream.getPayload();

        } catch (Exception ex) {
            log.error("根据MQ加载任务失败！", ex);
        } finally {
            channel.basicAck(deliveryTag, false);
        }
    }
}
