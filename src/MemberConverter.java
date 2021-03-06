import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import model.Member;

@FacesConverter(forClass = model.Member.class, value = "member")
public class MemberConverter implements Converter {

	public MemberConverter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2)
			throws ConverterException {
		if (arg2==null|| arg2.trim().equals(""))
			return null;
		//System.out.println("getasobject:" + arg2);
		Carts bean = (Carts) arg0.getApplication().evaluateExpressionGet(arg0,
				"#{carts}", Carts.class);
		for (Member mem : bean.getMembers()) {

			if (mem.getId().toString().equals(arg2))
				return mem;

		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ConverterException {
		if (arg2 == null || arg2.equals(""))
			return "";
	//	System.out.println("getasstring:" + ((Member) arg2).getId());
		return ((Member) arg2).getId().toString();
	}

}
