package easy.media.marketing.os.framework.open.repository;

import easy.media.marketing.os.framework.commons.constants.BooleanStatus;
import easy.media.marketing.os.framework.open.entity.OpenUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * 公众用户持久化
 *
 * Created by jeleo on 16-7-4.
 */
public interface OpenUserRepository extends JpaRepository<OpenUser, Long> {

    @Query("SELECT e FROM OpenUser e WHERE e.uid = :uid")
    OpenUser getOneByUid(@Param("uid")String uid);

    @Query("SELECT e FROM OpenUser e WHERE e.username = :username")
    OpenUser getOneByUsername(@Param("username")String username);

    @Query("SELECT e FROM OpenUser e WHERE e.username = :username AND e.password = :password")
    OpenUser getOneByUsername(@Param("username")String username, @Param("password")String password);

    @Query("SELECT e FROM OpenUser e WHERE e.email = :email")
    OpenUser getOneByEmail(@Param("email")String email);

    @Transactional
    @Modifying
    @Query("UPDATE OpenUser e SET e.enabled = :isEnabled WHERE e.uid = :uid")
    void enableByUid(@Param("isEnabled")BooleanStatus isEnabled, @Param("uid")String uid);

    @Transactional
    @Modifying
    @Query("UPDATE OpenUser e SET e.deleted = :idDeleted WHERE e.uid = :uid")
    void deleteByUid(@Param("idDeleted")BooleanStatus idDeleted, @Param("uid")String uid);

}
