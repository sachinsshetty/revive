package com.slabstech.revive.server.dropwizard.auth

/*
import com.okta.jwt.JoseException;
import com.okta.jwt.Jwt;
import com.okta.jwt.JwtVerifier;
*/ //public class OktaOAuthAuthenticator implements Authenticator<String, AccessTokenPrincipal> {
class OktaOAuthAuthenticator { /*
    private final JwtVerifier jwtVerifier;

    public OktaOAuthAuthenticator(JwtVerifier jwtVerifier) {
        this.jwtVerifier = jwtVerifier;
    }

    @Override
    public Optional<AccessTokenPrincipal> authenticate(String accessToken) throws AuthenticationException {

        try {
            Jwt jwt = jwtVerifier.decodeAccessToken(accessToken);
            // if we made it this far we have a valid jwt
            return Optional.of(new AccessTokenPrincipal(jwt));
        } catch (JoseException e) {
            throw new AuthenticationException(e);
        }
    }

     */
}