package easy.media.marketing.os.framework.open.service;

import easy.media.marketing.os.framework.open.entity.OpenUserTrack;
import easy.media.marketing.os.framework.open.repository.OpenUserTrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpenUserTrackServiceImpl implements OpenUserTrackService {

    @Override
    public OpenUserTrack create(String uid, String ip, String agent) {
        OpenUserTrack openUserTrack = new OpenUserTrack();
        openUserTrack.setUid(uid);
        openUserTrack.setIp(ip);
        openUserTrack.setAgent(agent);
        return openUserTrackRepository.save(openUserTrack);
    }

    @Autowired
    private OpenUserTrackRepository openUserTrackRepository;
}
