package kr.co.myatman.projecta.database

import com.fasterxml.jackson.annotation.JsonView
import org.springframework.security.core.GrantedAuthority

import javax.persistence.*

@Entity
@Table
class UserAuth implements GrantedAuthority, Serializable {
    @Embeddable
    static class PK implements Serializable {
        Long userId
        Long authId

        @Override
        int hashCode() {
            return super.hashCode()
        }

        @Override
        boolean equals(Object obj) {
            return super.equals(obj)
        }
    }
    @EmbeddedId
    PK pk

    @ManyToOne
    @JoinColumn(name = 'userId', insertable = false, updatable = false)
    User user

    @ManyToOne
    @JoinColumn(name = 'authId', insertable = false, updatable = false)
    Authority authority

    @JsonView(View.class)
    String getAuthority() {
        return authority.name
    }

    interface View {}
}