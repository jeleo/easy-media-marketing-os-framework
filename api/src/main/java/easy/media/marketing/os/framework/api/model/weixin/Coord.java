package easy.media.marketing.os.framework.api.model.weixin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "coordinate")
@XmlAccessorType(XmlAccessType.NONE)
public class Coord {
	@XmlElement(name = "longitude")
	private double x;

	@XmlElement(name = "latitude")
	private double y;

	@XmlElement(name = "name")
	private String name;

	@XmlElement(name = "id")
	private int id;

	@XmlElement(name = "scope")
	private int scope;

	public Coord() {
	}

	public Coord(double x, double y, int id, String name, int scope) {
		this.x = x;
		this.y = y;
		this.name = name;
		this.id = id;
		this.scope = scope;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getScope() {
		return scope;
	}

	public void setScope(int scope) {
		this.scope = scope;
	}

	@Override
	public String toString() {
		return String.format("{longitude:%f,latitude:%f,name:%s}", x, y, name);
	}
}
