package easy.media.marketing.os.framework.open.repository;

import easy.media.marketing.os.framework.open.entity.WeixinChannel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jeleo on 16-7-15.
 */
public interface WeixinChannelRepository extends JpaRepository<WeixinChannel, Long> {

    @Query("SELECT e FROM WeixinChannel e WHERE e.userUid = :userUid")
    List<WeixinChannel> findByUserUid(@Param("userUid")String userUid);

    @Transactional
    @Modifying
    @Query("UPDATE WeixinChannel e SET e.token = :token WHERE e.id = :id")
    void updateToken(@Param("token")String token, @Param("id")Long id);

}
