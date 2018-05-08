package kr.co.myatman.projecta.database

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonView
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils

import javax.persistence.*

@Entity
@Table(name = 'users')
class User implements Serializable {
    private static final long serialVersionUID = 1L

    @Id
    @GeneratedValue
    Long id
    @JsonView(View.class)
    String username
    String password
    //String registeredDate
    @Column(insertable = false, updatable = false, columnDefinition = 'DATETIME default CURRENT_TIMESTAMP')
    @Temporal(TemporalType.TIMESTAMP)
    Date registeredDate

    // Authority
    @OneToMany(fetch = FetchType.EAGER, mappedBy = 'user')
    @JsonView(View.class)
    Set<UserAuth> auths

    UserAuth addAuth(long authId) {
        UserAuth userAuth = new UserAuth( pk: new UserAuth.PK( userId: id, authId: authId ) )
        this.auths.add( userAuth )
        return userAuth
    }

    @JsonIgnore
    Collection<? extends GrantedAuthority> getAuthorities() {
        if (auths == null || auths.size() == 0)
            return []
        return AuthorityUtils.createAuthorityList( AuthorityUtils.authorityListToSet( auths ).toArray( new String[auths.size()] ) )
    }

    // View
    interface View extends UserAuth.View {}
}
