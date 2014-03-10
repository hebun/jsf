import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;

@SuppressWarnings("serial")
@SessionScoped
@ManagedBean
public class App implements Serializable {
	private String extention = ".faces";

	public String getExtention() {
		return extention;
	}

	public void setExtention(String extention) {
		this.extention = extention;
	}

	public App() {
		this.extention = ".faces";
	}

}
