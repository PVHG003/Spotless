package vn.pvhg.spotless.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import vn.pvhg.spotless.dto.authentication.UserLoginRequest;
import vn.pvhg.spotless.dto.authentication.AuthenticationResponse;
import vn.pvhg.spotless.model.authentication.User;
import vn.pvhg.spotless.util.JwtUtil;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final AuthenticationProvider authenticationProvider;
    private final JwtUtil jwtUtil;

    public AuthenticationResponse login(UserLoginRequest request) {
        Authentication authentication = authenticationProvider.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );
        User user = (User) authentication.getPrincipal();

        Map<String, Object> claims = new HashMap<>();

        String token = jwtUtil.generateToken(claims, user);
        long expiration = jwtUtil.getExpiration();

        return new AuthenticationResponse(
                token,
                expiration,
                user.getId(),
                user.getEmail()
        );
    }
}
