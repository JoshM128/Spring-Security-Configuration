package com.Authentication.SpringSecurity.User;

import com.Authentication.SpringSecurity.Token.Token;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "_users")
public class User implements UserDetails {

    /*
     * Postgre uses .SEQUENCE when set to auto
     * MySQL(I also assume maria DB) uses .Table when set to auto, it does not use .SEQUENCE
     */
    @Id
    @GeneratedValue
    private Integer id;

    private String firstname;

    private String lastname;

    private String email;

    private String password;


    //Enum is used here, need to research what Enumerated is
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Token> tokens;

    /**
     * @return Authorities - A collection of them, Sets are preferable because they do not allow duplicates
     *
     * The YT video used a List which I don't know why
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return role.getAuthorities();
    }

    /**
     * Returns the password used to authenticate the user.
     *
     * @return the password
     */
    @Override
    public String getPassword() {
        return this.password;
    }

    /**
     * @return String - The username of the user
     */
    @Override
    public String getUsername() {
        return this.email;
    }

    /**
     * @return boolean - is the account expired
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * @return boolean - is the account locked
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * @return boolean - are credentials(authorization) expired
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * @return boolean - no clue what this is
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
