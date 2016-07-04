package easy.media.marketing.os.framework.open.service;

import easy.media.marketing.os.framework.commons.constants.BooleanStatus;
import easy.media.marketing.os.framework.commons.utils.Encoding;
import easy.media.marketing.os.framework.open.entity.OpenUser;
import easy.media.marketing.os.framework.open.repository.OpenUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpenUserServiceImpl implements OpenUserService {

    @Override
    public OpenUser create(String username, String password, String email) {
        return null;
    }

    @Override
    public OpenUser update(String uid, String username, String password, String email) {
        return null;
    }

    @Override
    public void delete(String uid) {
        openUserRepository.deleteByUid(BooleanStatus.TRUE, uid);
    }

    @Override
    public void enable(String uid) {
        openUserRepository.enableByUid(BooleanStatus.TRUE, uid);
    }

    @Override
    public void disable(String uid) {
        openUserRepository.enableByUid(BooleanStatus.FALSE, uid);
    }

    @Override
    public OpenUser loginByUsername(String username, String password) {
        return openUserRepository.getOneByUsername(username, Encoding.MD5(password));
    }

    @Autowired
    private OpenUserRepository openUserRepository;
}
