package com.cycredit.app.util.threads;

import com.cycredit.app.util.authc.UserToken;

/**
 * Created by qiyubin on 2017/7/19 0019.
 */
public class UserTokenThreadLocal {

    private static ThreadLocal<UserToken> userTokenThreadLocal = new ThreadLocal<>();

    public static void putIntoThread(UserToken userToken) {
        userTokenThreadLocal.set(userToken);
    }

    public static UserToken getFromThread() {
        return userTokenThreadLocal.get();
    }

}
