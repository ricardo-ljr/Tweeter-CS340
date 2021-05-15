package edu.byu.cs.tweeter.client.backgroundTask;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import edu.byu.cs.tweeter.shared.domain.AuthToken;
import edu.byu.cs.tweeter.shared.domain.Status;

/**
 * Background task that posts a new status sent by a user.
 */
public class PostStatusTask extends Template {
    private static final String LOG_TAG = "PostStatusTask";

    public PostStatusTask(AuthToken authToken, Status status, Handler messageHandler) {
        super(messageHandler);
        this.authToken = authToken;
        this.status = status;
    }

    @Override
    public void run() {
        try {

            sendSuccessMessage();

        } catch (Exception ex) {
            Log.e(LOG_TAG, ex.getMessage(), ex);
            sendMessage(EXCEPTION_KEY, ex);
        }
    }
}
