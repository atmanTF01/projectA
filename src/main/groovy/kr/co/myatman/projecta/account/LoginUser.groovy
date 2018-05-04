package kr.co.myatman.projecta.account

import kr.co.myatman.projecta.database.User


class LoginUser extends org.springframework.security.core.userdetails.User {
    final private User user

    LoginUser(User user) {
        super(user.id.toString(), user.password, user.authorities)
        this.user = user
    }

    User getUser() {
        return user
    }
}
