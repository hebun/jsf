package hellojsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.omg.CORBA.PRIVATE_MEMBER;

@ManagedBean
@SessionScoped
public class PersonBean {

	private String firstname;
	private boolean rememberme=true;
	public boolean isRememberme() {
		return rememberme;
	}

	public void setRememberme(boolean rememberme) {
		this.rememberme = rememberme;
	}

	private String surname;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String savePerson() {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Welcome " + firstname + " " + surname + "!"));
		return "bbbb";
	}
	public void savePerson(ActionEvent actionEvent) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Welcome " + firstname + " " + surname + "!"));
	}
}