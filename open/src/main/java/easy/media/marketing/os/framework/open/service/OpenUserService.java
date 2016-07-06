package easy.media.marketing.os.framework.open.service;

import easy.media.marketing.os.framework.open.entity.OpenUser;

import java.util.List;

/**
 * 提供公众用户对象各项服务
 *
 * Created by jeleo on 16-7-4.
 */
public interface OpenUserService {

    OpenUser create(String username, String password, String email);

    OpenUser update(String uid, String username, String password, String email);

    void delete(String uid);

    void enable(String uid);

    void disable(String uid);

    OpenUser loginByUsername(String username, String password);

    OpenUser getOneByUsername(String username);

    OpenUser getOneByEmail(String email);

    List<OpenUser> findNotDeleted();

    List<OpenUser> findAll();

}
