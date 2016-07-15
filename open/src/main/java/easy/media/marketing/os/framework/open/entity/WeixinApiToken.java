package easy.media.marketing.os.framework.open.entity;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 请求微信API的AccessToken
 *
 * Created by jeleo on 2016/7/15.
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "EMM_OPEN_WEIXIN_TOKEN")
public class WeixinApiToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CHANNEL_UID", unique = true, nullable = false)
    private String channelUid;

    @Column(name = "ACCESS_TOKEN", nullable = false)
    private String accessToken;

    @LastModifiedDate
    @Column(name = "LAST_MODIFIED_DATE")
    private Long lastModifiedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChannelUid() {
        return channelUid;
    }

    public void setChannelUid(String channelUid) {
        this.channelUid = channelUid;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Long getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Long lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
