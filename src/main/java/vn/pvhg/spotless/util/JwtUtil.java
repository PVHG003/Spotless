package vn.pvhg.spotless.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {
    private static final String SECRET = "mySuperSecretKeyThatIsLongEnough123456!";
    private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(SECRET.getBytes());

    private static final long EXPIRATION_MS = 3600000;

    public String extractUsername(String jwt) {
        return Jwts.parser()
                .decryptWith(SECRET_KEY)
                .build()
                .parseSignedClaims(jwt)
                .getPayload()
                .getSubject();
    }

    public boolean isValid(String jwt, String username) {
        return username.equals(extractUsername(jwt)) && !isExpired(jwt);
    }

    private boolean isExpired(String jwt) {
        return Jwts.parser()
                .verifyWith(SECRET_KEY)
                .build()
                .parseSignedClaims(jwt)
                .getPayload()
                .getExpiration()
                .before(new Date());
    }

    public String generateToken(Map<String, Object> claims, UserDetails userDetails) {
        return Jwts.builder()
                .signWith(SECRET_KEY)
                .subject(userDetails.getUsername())
                .claims(claims)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_MS))
                .compact();
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return generateToken(claims, userDetails);
    }

    public long getExpiration() {
        return EXPIRATION_MS;
    }
}
