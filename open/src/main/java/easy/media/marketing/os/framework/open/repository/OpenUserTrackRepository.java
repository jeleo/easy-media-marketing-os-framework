package easy.media.marketing.os.framework.open.repository;

import easy.media.marketing.os.framework.open.entity.OpenUserTrack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * 公众用户行踪持久化
 *
 * Created by jeleo on 16-7-4.
 */
public interface OpenUserTrackRepository extends JpaRepository<OpenUserTrack, Long> {

    @Query("SELECT e FROM OpenUserTrack e WHERE e.uid = :uid")
    OpenUserTrack getOneByUid(@Param("uid")String uid);

}
