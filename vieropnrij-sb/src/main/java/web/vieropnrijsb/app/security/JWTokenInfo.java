package web.vieropnrijsb.app.security;

import java.util.Date;

/**
 * Class with useful information of token
 * <p>
 * Author: MFK
 */
public class JWTokenInfo {

    public static final String KEY = "tokenInfo";

    private String email;
    private String roletype;
    private Date issuedAt;
    private Date expiration;
    private int companyId;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoletype() {
        return roletype;
    }

    public void setRoletype(String roletype) {
        this.roletype = roletype;
    }

    public Date getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(Date issuedAt) {
        this.issuedAt = issuedAt;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "JWTokenInfo{" +
                "email='" + email + '\'' +
                ", roletype=" + roletype +
                ", companyId=" + companyId +
                ", issuedAt=" + issuedAt +
                ", expiration=" + expiration +
                '}';
    }
}
