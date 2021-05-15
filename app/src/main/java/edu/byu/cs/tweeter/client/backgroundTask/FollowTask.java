package edu.byu.cs.tweeter.client.backgroundTask;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import edu.byu.cs.tweeter.shared.domain.AuthToken;
import edu.byu.cs.tweeter.shared.domain.User;

/**
 * Background task that establishes a following relationship between two users.
 */
public class FollowTask extends Template {
    private static final String LOG_TAG = "FollowTask";


    public FollowTask(AuthToken authToken, User followee, Handler messageHandler) {
        super(messageHandler);
        this.authToken = authToken;
        this.followee = followee;
    }

    @Override
    public void run() {
        try {

            sendSuccessMessageTemplate();

        } catch (Exception ex) {
            Log.e(LOG_TAG, ex.getMessage(), ex);
            sendExceptionMessage(ex);
        }
    }
}
