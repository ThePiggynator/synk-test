package web.vieropnrijsb.app.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import web.vieropnrijsb.app.exceptions.AuthenticationException;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Calendar;
import java.util.Date;


@Component
public class JWTokenUtils {

    @Value("${jwt.issuer:MyOrganisation}")
    private String issuer;

    @Value("${jwt.pass-phrase}")
    private String passphrase;

    @Value("${jwt.expiration-seconds}")
    private int expiration;

    @Value("${jwt.refresh-expiration-seconds}")
    private int refreshExpiration;


    public String encode(String email, String roletype) {

        Key key = getKey(passphrase);

        return Jwts.builder()
                .claim(Claims.SUBJECT, email) // registered claim
                .claim(Claims.AUDIENCE, roletype) // public claim
                .setIssuer(issuer) // registered claim
                .setIssuedAt(new Date()) // registered claim
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000L)) // registered claim
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }

    private Key getKey(String passPhrase) {
        byte[] hmacKey = passPhrase.getBytes(StandardCharsets.UTF_8);
        return new SecretKeySpec(hmacKey, SignatureAlgorithm.HS512.getJcaName());
    }

    public JWTokenInfo decode(String encodedToken, boolean expirationLenient) throws AuthenticationException {
        try {
            // Validate the token
            Key key = getKey(passphrase);

            Jws<Claims> jws = Jwts.parserBuilder().
                                    setSigningKey(passphrase.getBytes(StandardCharsets.UTF_8)).
                                    build().
                                    parseClaimsJws(encodedToken);

            Claims claims = jws.getBody();
            System.out.println(claims.size());
            System.out.println("TOKEN INFO "+generateTokenInfo(claims));
            return generateTokenInfo(claims);

        } catch (MalformedJwtException |
                UnsupportedJwtException | IllegalArgumentException| SignatureException e) {
            throw new AuthenticationException(e.getMessage());
        } catch(ExpiredJwtException e) {
            if(!expirationLenient) {
                throw new AuthenticationException(e.getMessage());
            } else {
                return generateTokenInfo(e.getClaims());
            }
        }
    }

    private JWTokenInfo generateTokenInfo(Claims claims) {

        JWTokenInfo tokenInfo = new JWTokenInfo();
        tokenInfo.setEmail(claims.getSubject());

        tokenInfo.setRoletype(claims.getAudience());

        tokenInfo.setIssuedAt(claims.getIssuedAt());
        tokenInfo.setExpiration(claims.getExpiration());

        return tokenInfo;

    }

    public boolean isRenewable(JWTokenInfo tokenInfo) {

        // If token is still valid there is no reason to issue a new one
        if(tokenInfo.getExpiration().compareTo(new Date()) > 0) {
            return false;
        }

        // Calculating the refresh time limit
        Calendar cal = Calendar.getInstance();
        cal.setTime(tokenInfo.getIssuedAt());
        cal.add(Calendar.SECOND,refreshExpiration);

//        System.out.println("max refresh: " + cal.getTime());
//        System.out.println("current date: " + new Date());

        // max refresh time should be greater than current time
        return cal.getTime().compareTo(new Date()) > 0;
    }

}
