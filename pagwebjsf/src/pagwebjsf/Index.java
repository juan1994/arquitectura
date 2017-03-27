package pagwebjsf;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
@ManagedBean  (name="new")
@ViewScoped	

public class Index implements Serializable{

	public Index(){
		
	}
	
	public Index(String name) {
		super();
		this.name = name;
	}

	public void fuction (){
		System.out.println("el valor de name es "+ this.name);
		
	}
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	
	
	
}
