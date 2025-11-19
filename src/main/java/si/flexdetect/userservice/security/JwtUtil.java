package si.flexdetect.userservice.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.security.Key;

@Component
public class JwtUtil {


    private static String SECRET_KEY;

    private Key key;

    private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 ura

    @Autowired
    public JwtUtil(@Value("${jwt.secret}") String secretKey) {
        JwtUtil.SECRET_KEY = secretKey;
        this.key = Keys.hmacShaKeyFor(secretKey.getBytes());
    }


    //generiramo JWT token
    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
    //razcleni token in pridobi email iz polja subject
    public String extractEmail(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
    //preverba JWT
    public boolean isTokenValid(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }
}
