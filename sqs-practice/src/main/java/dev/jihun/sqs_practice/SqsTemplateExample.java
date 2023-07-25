package dev.jihun.sqs_practice;

import io.awspring.cloud.sqs.operations.SendResult;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SqsTemplateExample {

    private static final Logger log = LoggerFactory.getLogger(SqsTemplateExample.class);

    private final SqsTemplate sqsTemplate;

    @Value("${spring.cloud.aws.sqs.name.practice}")
    private String practiceQueueName;

    public SqsTemplateExample(final SqsTemplate sqsTemplate) {
        this.sqsTemplate = sqsTemplate;
    }

    public void publish(String message) {

        final SendResult<String> send = sqsTemplate.send(practiceQueueName, message);

        log.info("SQS Response : {}", send.messageId());
    }
}
