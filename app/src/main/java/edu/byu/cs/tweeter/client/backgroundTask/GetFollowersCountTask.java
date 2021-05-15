package edu.byu.cs.tweeter.client.backgroundTask;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import edu.byu.cs.tweeter.shared.domain.AuthToken;
import edu.byu.cs.tweeter.shared.domain.User;

/**
 * Background task that queries how many followers a user has.
 */
public class GetFollowersCountTask extends Template {
    private static final String LOG_TAG = "LogoutTask";

    public GetFollowersCountTask(AuthToken authToken, User targetUser, Handler messageHandler) {
        super(messageHandler);
        this.authToken = authToken;
        this.targetUser = targetUser;
    }

    @Override
    public void run() {
        try {

            sendSuccessMessageInt(20);

        } catch (Exception ex) {
            Log.e(LOG_TAG, ex.getMessage(), ex);
            sendMessage(EXCEPTION_KEY, ex);
        }
    }

}
