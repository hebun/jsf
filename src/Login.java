import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class Login implements Serializable {

	private boolean isDebug;
	public String email;
	private String name;
	private List<String> list = null;

	public Login() {

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

	public static String getResourceBundleString(String resourceBundleName,
			String resourceBundleKey) throws MissingResourceException {

		ResourceBundle bundle = ResourceBundle.getBundle("util.hello",
				FacesContext.getCurrentInstance().getViewRoot().getLocale());
		
		String message = bundle.getString(resourceBundleKey);
		
		return message;
	}

	public void login(ActionEvent actionEvent) {
		RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage msg = null;
		boolean loggedIn = false;

		if (this.name != null && name.equals("admin") && email != null
				&& email.equals("admin")) {
			loggedIn = true;
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", name);
		} else {
			loggedIn = false;

			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					getResourceBundleString("util.hello", "invalidCred"),
					"Invalid credentials");
		}

		FacesContext.getCurrentInstance().addMessage("auth", msg);
		context.addCallbackParam("loggedIn", loggedIn);
	}
}
