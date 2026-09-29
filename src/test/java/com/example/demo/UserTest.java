package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void ユーザー管理コードのテスト() {
        User user = new User("001");
        user.setCode("002");

        assertThat(user.getCode()).isEqualTo("002");
    }

    @Test
    public void 名前のテスト() {
        User user = new User("001");
        user.setName("田中太郎");

        assertThat(user.getName()).isEqualTo("田中太郎");
    }

    @Test
    public void 年齢のテスト() {
        User user = new User("001");
        user.setAge(20);

        assertThat(user.getAge()).isEqualTo(20);
    }

    @Test
    public void 範囲外の年齢のテスト() {
        User user = new User("001");
        user.setAge(200);

        assertThat(user.getAge()).isEqualTo(-1);
    }

    @Test
    public void 範囲外の年齢をあとから設定するテスト() {
        User user = new User("001");
        user.setAge(20);
        user.setAge(200);

        assertThat(user.getAge()).isEqualTo(-1);
    }
}
