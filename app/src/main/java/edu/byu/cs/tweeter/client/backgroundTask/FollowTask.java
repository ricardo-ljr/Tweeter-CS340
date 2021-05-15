package edu.byu.cs.tweeter.client.backgroundTask;

import android.os.Handler;
import android.util.Log;

import java.io.Serializable;

import edu.byu.cs.tweeter.shared.domain.AuthToken;
import edu.byu.cs.tweeter.shared.domain.User;

/**
 * Background task that establishes a following relationship between two users.
 */
public class FollowTask extends Template {
    private static final String LOG_TAG = "FollowTask";
    private static final String NULL_TAG = "Null";


    public FollowTask(AuthToken authToken, User followee, Handler messageHandler) {
        super(messageHandler);
        this.authToken = authToken;
        this.followee = followee;
    }

    @Override
    public void run() {
        try {
            Serializable value = null;
            sendMessage(NULL_TAG, value);

        } catch (Exception ex) {
            Log.e(LOG_TAG, ex.getMessage(), ex);
            sendMessage(EXCEPTION_KEY, ex);
        }
    }
}
