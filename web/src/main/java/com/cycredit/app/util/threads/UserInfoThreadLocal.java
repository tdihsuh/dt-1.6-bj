package com.cycredit.app.util.threads;

import com.cycredit.app.util.authc.UserToken;
import com.cycredit.app.util.cache.pojo.UserInfo;
import com.cycredit.dao.entity.User;

/**
 * Created by qiyubin on 2017/11/29 0029.
 *
 * @author qiyubin
 */
public class UserInfoThreadLocal {

    private static ThreadLocal<UserInfo> userThreadLocal = new ThreadLocal<>();

    public static void putIntoThread(UserInfo user) {
        userThreadLocal.set(user);
    }

    public static UserInfo getFromThread() {
        return userThreadLocal.get();
    }


}
