package com.Authentication.SpringSecurity.User;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.Authentication.SpringSecurity.User.Permissions.ADMIN_CREATE;
import static com.Authentication.SpringSecurity.User.Permissions.ADMIN_DELETE;
import static com.Authentication.SpringSecurity.User.Permissions.ADMIN_READ;
import static com.Authentication.SpringSecurity.User.Permissions.ADMIN_UPDATE;
import static com.Authentication.SpringSecurity.User.Permissions.MANAGER_CREATE;
import static com.Authentication.SpringSecurity.User.Permissions.MANAGER_DELETE;
import static com.Authentication.SpringSecurity.User.Permissions.MANAGER_READ;
import static com.Authentication.SpringSecurity.User.Permissions.MANAGER_UPDATE;



@RequiredArgsConstructor
public enum Role {

    USER(Collections.emptySet()),
    ADMIN(
            Set.of(
                    ADMIN_CREATE,
                    ADMIN_DELETE,
                    ADMIN_READ,
                    ADMIN_UPDATE,
                    MANAGER_CREATE,
                    MANAGER_DELETE,
                    MANAGER_READ,
                    MANAGER_UPDATE
            )
    ),
    MANAGER(
            Set.of(
                    MANAGER_CREATE,
                    MANAGER_DELETE,
                    MANAGER_READ,
                    MANAGER_UPDATE
            )
    )
    ;

    @Getter
    private final Set<Permissions> permissions;
    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }

}
