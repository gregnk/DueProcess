import javax.swing.*;

public class Evidence extends JLabel {
	private String name;
	private String desc;
	private ImageIcon icon;
	
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
	public ImageIcon getIcon() {
		return icon;
	}
	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
	
	public Evidence(String name, String desc, ImageIcon icon) {
		this.name = name;
		this.desc = desc;
		this.icon = icon;
	}
	
	@Override
	public String toString() {
		return "Evidence [name=" + name + ", desc=" + desc + ", icon=" + icon + "]";
	}	
}
