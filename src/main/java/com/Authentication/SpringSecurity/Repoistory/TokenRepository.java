package com.Authentication.SpringSecurity.Repoistory;

import com.Authentication.SpringSecurity.Token.Token;
import com.Authentication.SpringSecurity.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token,Integer> {

    @Query("""
    SELECT t
    FROM Token t\s
    INNER JOIN User u on t.user.id = u.id
    WHERE u.id = :userId and (t.expired = false or t.revoked = false)
    """)
    List<Token> findAllValidByUser(int userId);

    Optional<Token> findByToken(String token);

    void deleteTokenByUser(User user);
}
