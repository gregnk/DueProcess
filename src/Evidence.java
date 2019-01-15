import javax.swing.*;

public class Evidence {
	private String name;
	private String desc;
	private String image;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public Evidence(String name, String desc, String image) {
		super();
		this.name = name;
		this.desc = desc;
		this.image = image;
	}
	
	@Override
	public String toString() {
		return "Evidence [name=" + name + ", desc=" + desc + ", image=" + image + "]";
	}
}
