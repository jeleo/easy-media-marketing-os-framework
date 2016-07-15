package easy.media.marketing.os.framework.open.service;

import easy.media.marketing.os.framework.open.entity.OpenUserTrack;

/**
 * 用户轨迹服务
 *
 * Created by jeleo on 16-7-13.
 */
public interface OpenUserTrackService {

    OpenUserTrack create(String userUid, String ip, String agent);

}
