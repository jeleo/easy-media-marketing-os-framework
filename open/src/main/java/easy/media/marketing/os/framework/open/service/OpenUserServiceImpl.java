package easy.media.marketing.os.framework.open.service;

import easy.media.marketing.os.framework.commons.constants.BooleanStatus;
import easy.media.marketing.os.framework.commons.utils.Encoding;
import easy.media.marketing.os.framework.open.entity.OpenUser;
import easy.media.marketing.os.framework.open.repository.OpenUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpenUserServiceImpl implements OpenUserService {

    @Override
    public OpenUser create(String username, String password, String email) {
        OpenUser openUser = new OpenUser();
        openUser.setUsername(username);
        openUser.setPassword(Encoding.MD5(password));
        openUser.setEmail(email);
        return openUserRepository.save(openUser);
    }

    @Override
    public OpenUser update(String uid, String username, String password, String email) {
        OpenUser openUser = openUserRepository.getOneByUid(uid);
        if (openUser == null) {
            throw new NullPointerException("无法找到uid是" + uid + "的用户");
        }
        openUser.setUsername(username);
        openUser.setPassword(Encoding.MD5(password));
        openUser.setEmail(email);
        return openUserRepository.save(openUser);
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

    @Override
    public OpenUser getOneByUsername(String username) {
        return openUserRepository.getOneByUsername(username);
    }

    @Override
    public OpenUser getOneByEmail(String email) {
        return openUserRepository.getOneByEmail(email);
    }

    @Override
    public List<OpenUser> findNotDeleted() {
        return openUserRepository.findIsDeleted(BooleanStatus.FALSE);
    }

    @Override
    public List<OpenUser> findAll() {
        return openUserRepository.findAll();
    }

    @Autowired
    private OpenUserRepository openUserRepository;
}
