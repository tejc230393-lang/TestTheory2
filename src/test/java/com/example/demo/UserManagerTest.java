package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class UserManagerTest {

    @Test
    public void インスタンスが同じか確認するテスト() {
        UserManager manager1 = UserManager.getInstance();
        UserManager manager2 = UserManager.getInstance();

        assertThat(manager1).isSameAs(manager2);
    }

    @Test
    public void Listに登録できるか確認するテスト() {
        UserManager manager = UserManager.getInstance();
        manager.deleteAllUser();

        User user1 = new User("001");
        User user2 = new User("002");
        manager.setUserToList(user1);
        manager.setUserToList(user2);

        assertThat(manager.getUserList()).contains(user1, user2);
    }

    @Test
    public void Mapに登録できるか確認するテスト() {
        UserManager manager = UserManager.getInstance();
        manager.deleteAllUser();

        User user1 = new User("001");
        User user2 = new User("002");
        manager.setUserToMap(user1);
        manager.setUserToMap(user2);

        assertThat(manager.getUserMap()).containsKeys("001", "002");
    }

    @Test
    public void 全削除のテスト() {
        UserManager manager = UserManager.getInstance();
        manager.deleteAllUser();

        User user = new User("001");
        manager.setUserToList(user);
        manager.setUserToMap(user);

        manager.deleteAllUser();

        assertThat(manager.getUserList()).isEmpty();
        assertThat(manager.getUserMap()).isEmpty();
    }

    @Test
    public void codeを指定して削除するテスト() {
        UserManager manager = UserManager.getInstance();
        manager.deleteAllUser();

        User user1 = new User("001");
        User user2 = new User("002");
        manager.setUserToList(user1);
        manager.setUserToList(user2);
        manager.setUserToMap(user1);
        manager.setUserToMap(user2);

        manager.deleteUser("001");

        assertThat(manager.getUserList()).doesNotContain(user1);
        assertThat(manager.getUserList()).contains(user2);
        assertThat(manager.getUserMap()).doesNotContainKey("001");
        assertThat(manager.getUserMap()).containsKey("002");
    }

    @Test
    public void 同じcodeのユーザーを削除するテスト() {
        UserManager manager = UserManager.getInstance();
        manager.deleteAllUser();

        User user1 = new User("001");
        User user2 = new User("001");
        manager.setUserToList(user1);
        manager.setUserToList(user2);
        manager.setUserToMap(user1);
        manager.setUserToMap(user2);

        manager.deleteUser("001");

        assertThat(manager.getUserList()).isEmpty();
        assertThat(manager.getUserMap()).isEmpty();
    }


    @Test
    public void ListとMapの初期状態を確認するテスト() {
        UserManager manager = UserManager.getInstance();
        manager.deleteAllUser();

        assertThat(manager.getUserList()).isNotNull();
        assertThat(manager.getUserList()).isEmpty();
        assertThat(manager.getUserMap()).isNotNull();
        assertThat(manager.getUserMap()).isEmpty();
    }

    @Test
    public void Listの登録順を確認するテスト() {
        UserManager manager = UserManager.getInstance();
        manager.deleteAllUser();

        User user1 = new User("001");
        User user2 = new User("002");
        manager.setUserToList(user1);
        manager.setUserToList(user2);

        assertThat(manager.getUserList()).containsExactly(user1, user2);
    }

    @Test
    public void Mapのキーを確認するテスト() {
        UserManager manager = UserManager.getInstance();
        manager.deleteAllUser();

        User user1 = new User("001");
        User user2 = new User("002");
        manager.setUserToMap(user1);
        manager.setUserToMap(user2);

        assertThat(manager.getUserMap()).containsKeys("001", "002");
    }
}
