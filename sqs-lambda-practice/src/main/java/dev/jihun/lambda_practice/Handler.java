package dev.jihun.lambda_practice;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;

// dev.jihun.lambda_practice.Handler
public class Handler implements RequestHandler<SQSEvent, Void> {

    @Override
    public Void handleRequest(final SQSEvent input, final Context context) {
        return null;
    }
}
