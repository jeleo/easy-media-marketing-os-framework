package easy.media.marketing.os.framework.commons.constants;

/**
 * 通用布尔状态
 *
 * Created by jeleo on 16-7-4.
 */
public enum BooleanStatus {

    TRUE(true),
    FALSE(false);

    BooleanStatus(boolean value) {
        this.value = value;
    }

    public boolean value;

}
