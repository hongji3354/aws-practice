package dev.jihun.sqs_practice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlRequest;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlResponse;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;
import software.amazon.awssdk.services.sqs.model.SendMessageResponse;

import java.util.UUID;

@Component
public class SqsClientExample {

    private static final Logger log = LoggerFactory.getLogger(SqsClientExample.class);

    @Value("${spring.cloud.aws.credentials.access-key}")
    private String accessKey;

    @Value("${spring.cloud.aws.credentials.secret-key}")
    private String secretKey;

    @Value("${spring.cloud.aws.sqs.name.practice}")
    private String practiceQueueName;

    public void publish(String message) {
        final SqsClient sqsClient = SqsClient.builder()
                .region(Region.AP_NORTHEAST_2)
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.create(accessKey, secretKey)))
                .build();

        final GetQueueUrlResponse queueUrl = sqsClient.getQueueUrl(GetQueueUrlRequest.builder()
                .queueName(practiceQueueName)
                .build());

        final SendMessageResponse sendMessageResponse = sqsClient.sendMessage(
                SendMessageRequest.builder()
                        .queueUrl(queueUrl.queueUrl())
                        .messageGroupId(UUID.randomUUID().toString())
                        .messageBody(message)
                        .build());

        log.info("SQS Response : {}", sendMessageResponse.messageId());
    }
}
