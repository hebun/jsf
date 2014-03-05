import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class HelloBean implements Serializable {

	private boolean isDebug;
	public String email;
	private String name;
	private List<String> list = null;

	public HelloBean() {

		this.list = new ArrayList<String>();
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	private int no = 0;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		System.out.println(no + " sent to us");
		this.no = no;
	}

	public boolean getIsDebug() {
		return isDebug;
	}

	public void setIsDebug(boolean isDebug) {
		this.isDebug = isDebug;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String clicked() {
		if (this.list == null) {

		}
		setName("clicked the button");
		System.out.println("..");
		setIsDebug(!getIsDebug());

		setEmail("updated via ajax");

		return "true";

	}

	public String listen() {

		return "from listen method";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String comAction() {

		System.out.println("com action called");
		return "okay";
	}
}
