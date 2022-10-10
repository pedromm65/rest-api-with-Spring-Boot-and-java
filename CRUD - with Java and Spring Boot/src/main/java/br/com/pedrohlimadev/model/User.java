package br.com.pedrohlimadev.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User implements UserDetails, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", unique = true)
    private String userName;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "password")
    private String password;

    @Column(name = "account_non_expired")
    private Boolean accountNonExpired;

    @Column(name = "account_non_locked")
    private Boolean accountNonLocked;

    @Column(name = "credentials_non_expired")
    private Boolean credentialsNonExpired;

    @Column(name = "enabled")
    private Boolean enable;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_permission", joinColumns = {@JoinColumn (name = "id_user")},
        inverseJoinColumns = {@JoinColumn (name = "id_permission")}
    )
    private List<Permission> permissions;

    public User() {}

    public List<String> getRoles() {
        List<String> roles = new ArrayList<>();
        for (Permission permission : permissions) {
            roles.add(permission.getDescription());
        }

        return roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.permissions;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!Objects.equals(id, user.id)) return false;
        if (!Objects.equals(userName, user.userName)) return false;
        if (!Objects.equals(fullName, user.fullName)) return false;
        if (!Objects.equals(password, user.password)) return false;
        if (!Objects.equals(accountNonExpired, user.accountNonExpired))
            return false;
        if (!Objects.equals(accountNonLocked, user.accountNonLocked))
            return false;
        if (!Objects.equals(credentialsNonExpired, user.credentialsNonExpired))
            return false;
        if (!Objects.equals(enable, user.enable)) return false;
        return Objects.equals(permissions, user.permissions);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (accountNonExpired != null ? accountNonExpired.hashCode() : 0);
        result = 31 * result + (accountNonLocked != null ? accountNonLocked.hashCode() : 0);
        result = 31 * result + (credentialsNonExpired != null ? credentialsNonExpired.hashCode() : 0);
        result = 31 * result + (enable != null ? enable.hashCode() : 0);
        result = 31 * result + (permissions != null ? permissions.hashCode() : 0);
        return result;
    }
}
