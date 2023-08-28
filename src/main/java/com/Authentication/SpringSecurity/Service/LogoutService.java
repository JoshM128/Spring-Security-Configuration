package com.Authentication.SpringSecurity.Service;

import com.Authentication.SpringSecurity.Repoistory.TokenRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;
import org.springframework.security.core.context.SecurityContextHolder;

@Service
@RequiredArgsConstructor
public class LogoutService implements LogoutHandler {

    private final TokenRepository tokenRepository;
    /**
     * @param request
     * @param response
     * @param authentication
     */
    @Override
    public void logout(HttpServletRequest request,
                       HttpServletResponse response,
                       Authentication authentication) {
            final String authorizationHeader = request.getHeader("Authorization");
            final String jwt;

            if(authorizationHeader == null || !authorizationHeader.startsWith("Bearer")){
                return;
            }

            jwt = authorizationHeader.substring(7);
            var storedToken = tokenRepository.findByToken(jwt).orElse(null);

            if(storedToken != null){
                /**
                 * Can extract this common code into the token class or create an update method in the repository
                 * to alter the current token ID to false for both values
                 */
                storedToken.setExpired(true);
                storedToken.setRevoked(true);
                tokenRepository.save(storedToken);
                SecurityContextHolder.clearContext();
            }
    }
}
