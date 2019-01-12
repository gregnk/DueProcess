import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.*;

public class Witness  {
	
	private String name;
	private String side;
	private String desc;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSide() {
		return side;
	}
	public void setSide(String side) {
		this.side = side;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public Witness(String name, String side, String desc) {
		this.name = name;
		this.side = side;
		this.desc = desc;
	}
	
	@Override
	public String toString() {
		return "Witness [name=" + name + ", side=" + side + ", desc=" + desc + "]";
	}
	
	
}
