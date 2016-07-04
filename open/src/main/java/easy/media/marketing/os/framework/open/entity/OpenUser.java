package easy.media.marketing.os.framework.open.entity;

import easy.media.marketing.os.framework.commons.constants.BooleanStatus;
import easy.media.marketing.os.framework.commons.utils.Encoding;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import javax.persistence.*;
import java.util.UUID;

/**
 * 公众用户
 *
 * Created by jeleo on 16-7-3.
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "EMM_OPEN_USER")
public class OpenUser {

    public OpenUser() {
        this.setUid(UUID.randomUUID().toString());
        this.setEnabled(BooleanStatus.TRUE);
        this.setDeleted(BooleanStatus.FALSE);
    }

    public OpenUser(String username, String password, String email) {
        this();
        this.username = username;
        this.password = Encoding.MD5(password);
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "UID", unique = true, nullable = false)
    private String uid;

    @Column(name = "USERNAME", unique = true, nullable = false)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "EMAIL", unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "ENABLED", nullable = false)
    private BooleanStatus enabled;

    @CreatedDate
    @Column(name = "CREATED_DATE")
    private Long createdDate;

    @CreatedBy
    @Column(name = "CREATED_BY")
    private String createdBy;

    @LastModifiedDate
    @Column(name = "LAST_MODIFIED_DATE")
    private Long lastModifiedDate;

    @LastModifiedBy
    @Column(name = "LAST_MODIFIED_BY")
    private String lastModifiedBy;

    @Enumerated(EnumType.STRING)
    @Column(name = "DELETED", nullable = false)
    private BooleanStatus deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BooleanStatus getEnabled() {
        return enabled;
    }

    public void setEnabled(BooleanStatus enabled) {
        this.enabled = enabled;
    }

    public Long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Long getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Long lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public BooleanStatus getDeleted() {
        return deleted;
    }

    public void setDeleted(BooleanStatus deleted) {
        this.deleted = deleted;
    }
}
