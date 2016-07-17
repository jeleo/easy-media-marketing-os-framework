package easy.media.marketing.os.framework.open.model;

/**
 * Created by jeleo on 16-7-17.
 */
public class EnumHelper {

    private String name;
    private String value;

    public EnumHelper() {
    }

    public EnumHelper(String name, String value) {
        this();
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
