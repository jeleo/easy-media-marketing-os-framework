package easy.media.marketing.os.framework.api.model.weixin;

import javax.xml.bind.annotation.XmlElement;

/**
 * 上报地理位置
 * <p>
 * Created by zhoukai on 2016/5/12.
 */
public class LocationEvent extends Event {

    /**
     * 地理位置纬度
     * */
    @XmlElement(name = "Latitude")
    private Double latitude;

    /**
     * 地理位置经度
     * */
    @XmlElement(name = "Longitude")
    private Double longitude;

    /**
     * 地理位置精度
     * */
    @XmlElement(name = "Precision")
    private Double precision;

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getPrecision() {
        return precision;
    }

    public void setPrecision(Double precision) {
        this.precision = precision;
    }
}
