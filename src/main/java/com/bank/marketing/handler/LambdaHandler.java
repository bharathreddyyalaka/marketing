package com.bank.marketing.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.amazonaws.services.lambda.runtime.events.models.s3.S3EventNotification;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LambdaHandler implements RequestHandler<SQSEvent, String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String handleRequest(SQSEvent event, Context context) {
        try {
            for (SQSEvent.SQSMessage message : event.getRecords()) {
                // Parse the S3 event notification from the message body
                S3EventNotification s3Event = objectMapper.readValue(message.getBody(), S3EventNotification.class);

                for (S3EventNotification.S3EventNotificationRecord record : s3Event.getRecords()) {
                    String bucketName = record.getS3().getBucket().getName();
                    String objectKey = record.getS3().getObject().getKey();

                    context.getLogger().log("File received from bucket: " + bucketName + ", key: " + objectKey);

                    // Process the file here (e.g., download it and parse the JSON content)
                }
            }
            return "Processed all SQS messages.";
        } catch (Exception e) {
            context.getLogger().log("Error processing SQS messages: " + e.getMessage());
            throw new RuntimeException("Error processing SQS messages", e);
        }
    }
}
