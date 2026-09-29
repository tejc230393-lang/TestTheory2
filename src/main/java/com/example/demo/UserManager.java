package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** ユーザー情報管理 */
public class UserManager {

    private static class UserManagerHolder {
        private static final UserManager instance = new UserManager();
    }

    private List<User> userList;
    private Map<String, User> userMap;

    private UserManager() {
        userList = new ArrayList<User>();
        userMap = new HashMap<String, User>();
    }

    public static UserManager getInstance() {
        return UserManagerHolder.instance;
    }

    public List<User> getUserList() {
        return userList;
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserToList(User user) {
        userList.add(user);
    }

    public void setUserToMap(User user) {
        userMap.put(user.getCode(), user);
    }

    public void deleteUser(String code) {
        userMap.remove(code);

        User deleteUser = null;
        for (User user : userList) {
            if (user.getCode().equals(code)) {
                deleteUser = user;
                break;
            }
        }
        userList.remove(deleteUser);
    }

    public void deleteAllUser() {
        userList = new ArrayList<User>();
        userMap = new HashMap<String, User>();
    }
}
