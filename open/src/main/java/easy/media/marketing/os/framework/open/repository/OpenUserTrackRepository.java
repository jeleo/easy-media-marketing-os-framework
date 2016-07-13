package easy.media.marketing.os.framework.open.repository;

import easy.media.marketing.os.framework.commons.constants.BooleanStatus;
import easy.media.marketing.os.framework.open.entity.OpenUserTrack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * 公众用户行踪持久化
 *
 * Created by jeleo on 16-7-4.
 */
public interface OpenUserTrackRepository extends JpaRepository<OpenUserTrack, Long> {

    @Query("SELECT e FROM OpenUserTrack e WHERE e.uid = :uid")
    OpenUserTrack getOneByUid(@Param("uid")String uid);

    @Transactional
    @Modifying
    @Query("DELETE FROM OpenUserTrack e WHERE e.uid = :uid")
    void deleteByUid(@Param("uid")String uid);

}
