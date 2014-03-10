import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

import model.Cart;
import model.Member;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.primefaces.context.RequestContext;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.TabCloseEvent;

@SuppressWarnings("serial")
@RequestScoped
@ManagedBean
public class Members implements Serializable {

	private List<Member> members;
	private Member selected;
	private boolean detailRendered;
	private int activeIndex;
	private Member currentRow;
	Configuration configuration = new Configuration();
	Session ss = null;

	@SuppressWarnings("unchecked")
	public List<Cart> getSelCarts() {
		if (this.currentRow == null) {
			setSelCarts(new ArrayList<Cart>());
		}

		return (List<Cart>) this.currentRow.getCarts();

	}

	public void setSelCarts(List<Cart> selCarts) {
		this.currentRow.setCarts(new HashSet<Cart>(selCarts));
		;
	}

	public boolean isDetailRendered() {

		return detailRendered;
	}

	public void save(ActionEvent event) {
		if (configuration == null)
			configuration = new Configuration();

		try {

			ss.beginTransaction();

			ss.save(selected);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			ss.close();

		}

	}

	public void setDetailRendered(boolean detailDisabled) {
		this.detailRendered = detailDisabled;
	}

	public int getActiveIndex() {
		return activeIndex;
	}

	public void setActiveIndex(int activeIndex) {
		this.activeIndex = activeIndex;
	}

	public Members() {
		activeIndex = 0;
		detailRendered = false;

		try {

			Configuration cfg = configuration.configure();
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
					.applySettings(cfg.getProperties());
			SessionFactory factory = cfg.buildSessionFactory(builder.build());

			ss = factory.openSession();
			ss.beginTransaction();

			@SuppressWarnings("unchecked")
			List<Member> list = ss.createCriteria(Member.class).list();
			System.out.println("mem size:" + list.size());
			setMembers(list);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void add(ActionEvent event) {
		System.out.println("add called");
		currentRow = new Member();
		setDetailRendered(true);
		setActiveIndex(1);
		System.out.println(getActiveIndex() + ".lll");
	}

	public Member getCurrentRow() {
		return currentRow;
	}

	public void setCurrentRow(Member currentRow) {
		this.currentRow = currentRow;
	}

	public void edit(ActionEvent event) {
		currentRow = selected;
		if (selected == null) {

			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"What we do in life", "Echoes in eternity.");

			RequestContext.getCurrentInstance().showMessageInDialog(message);
			System.out.println("edit called nulll");
		} else {

			setDetailRendered(true);
			setActiveIndex(1);
			System.out.println("edit called ");
		}

	}

	public void onTabChange(TabChangeEvent event) {

	}

	public void onTabClose(TabCloseEvent event) {

		setDetailRendered(false);
		setActiveIndex(0);
		System.out.println("close called");

	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	public Member getSelected() {
		return selected;
	}

	public void setSelected(Member selected) {
		this.selected = selected;
	}

}
