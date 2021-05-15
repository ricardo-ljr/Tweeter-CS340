package edu.byu.cs.tweeter.client.backgroundTask;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.os.Message;

import java.io.Serializable;

import edu.byu.cs.tweeter.shared.domain.AuthToken;
import edu.byu.cs.tweeter.shared.domain.Status;
import edu.byu.cs.tweeter.shared.domain.User;

public class Template implements Runnable {

    /***************** STRING MESSAGES *****************/

    public static final String SUCCESS_KEY = "success";
    public static final String MESSAGE_KEY = "message";
    public static final String EXCEPTION_KEY = "exception";

    public static final String USER_KEY = "user";
    public static final String AUTH_TOKEN_KEY = "auth-token";

    public static final String MORE_PAGES_KEY = "more-pages";
    public static final String STATUSES_KEY = "statuses";
    public static final String COUNT_KEY = "count";

    public static final String FOLLOWERS_KEY = "followers";
    public static final String FOLLOWEES_KEY = "followees";


    public static final String IS_FOLLOWER_KEY = "is-follower";


    /***************** TEMPLATE VARIABLES *****************/
    /**
     * Message handler that will receive task results.
     */
    protected Handler messageHandler;

    /**
     * Auth token for logged-in user.
     * This user is the "follower" in the relationship.
     */
    protected AuthToken authToken;

    /**
     * The alleged follower.
     */
    protected User follower;

    /**
     * The user that is being followed.
     */
    protected User followee;

    /**
     * Maximum number of statuses to return (i.e., page size).
     */
    protected int limit;

    /**
     * The last status returned in the previous page of results (can be null).
     * This allows the new page to begin where the previous page ended.
     */
    protected Status lastStatus;

    /**
     * The user whose feed is being retrieved.
     * (This can be any user, not just the currently logged-in user.)
     */
    protected User targetUser;

    /**
     * The last follower returned in the previous page of results (can be null).
     * This allows the new page to begin where the previous page ended.
     */
    protected User lastFollower;

    /**
     * The last person being followed returned in the previous page of results (can be null).
     * This allows the new page to begin where the previous page ended.
     */
    protected User lastFollowee;

    /**
     * The user's username (or "alias" or "handle"). E.g., "@susan".
     */
    protected String username;

    /**
     * The user's password.
     */
    protected String password;

    /**
     * The new status being sent. Contains all properties of the status,
     * including the identity of the user sending the status.
     */
    protected Status status;

    /**
     * Alias (or handle) for user whose profile is being retrieved.
     */
    protected String alias;

    /**
     * The user's first name.
     */
    protected String firstName;

    /**
     * The user's last name.
     */
    protected String lastName;

    /**
     * The base-64 encoded bytes of the user's profile image.
     */
    protected String image;


    /**
     * Constructor to initialize message handler
     *
     * @param messageHandler
     */
    public Template(Handler messageHandler) {
        this.messageHandler = messageHandler;
    }

    protected void sendSuccessMessage() {
        Bundle msgBundle = new Bundle();
        msgBundle.putBoolean(SUCCESS_KEY, true);

        Message msg = Message.obtain();
        msg.setData(msgBundle);

        messageHandler.sendMessage(msg);
    }

    protected void sendMessage(String key, Serializable value) {
        Bundle msgBundle = new Bundle();
        msgBundle.putBoolean(SUCCESS_KEY, true);
        Message msg = Message.obtain();
        msgBundle.putSerializable(key, value);
        msg.setData(msgBundle);

        messageHandler.sendMessage(msg);
    }

    protected void sendMessageWithBool(String key, Serializable value, boolean isTrue) {
        Bundle msgBundle = new Bundle();
        msgBundle.putBoolean(SUCCESS_KEY, true);
        msgBundle.putSerializable(key, (Serializable) value);
        msgBundle.putBoolean(MORE_PAGES_KEY, isTrue);

        Message msg = Message.obtain();
        msg.setData(msgBundle);

        messageHandler.sendMessage(msg);
    }

    protected void sendSuccessMessageInt(int count) {
        Bundle msgBundle = new Bundle();
        msgBundle.putBoolean(SUCCESS_KEY, true);
        msgBundle.putInt(COUNT_KEY, count);

        Message msg = Message.obtain();
        msg.setData(msgBundle);

        messageHandler.sendMessage(msg);
    }

    protected void sendFailedMessage(String message) {
        Bundle msgBundle = new Bundle();
        msgBundle.putBoolean(SUCCESS_KEY, false);
        msgBundle.putString(MESSAGE_KEY, message);

        Message msg = Message.obtain();
        msg.setData(msgBundle);

        messageHandler.sendMessage(msg);
    }

    @Override
    public void run() {};
}
