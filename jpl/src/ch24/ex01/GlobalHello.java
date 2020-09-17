package ch24.ex01;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class GlobalHello {

	static final String KEY_HELLO = "hello";
	static final String KEY_GOODBYE = "goodbye";

	public static void main(String[] args) {
		ResourceBundle res = ResourceBundle.getBundle("ch24.ex01.GlobalRes");
		ResourceBundle res2 = PropertyResourceBundle.getBundle("ch24.ex01.GlobalRes_en");
		String msg;
		if (args.length > 0) {
			msg = res.getString(GlobalHello.KEY_HELLO);
		} else {
			msg = res.getString(GlobalHello.KEY_GOODBYE);
		}
		System.out.println(msg);

		if (args.length > 0) {
			msg = res2.getString("key1");
		} else {
			msg = res2.getString("key2");
		}
		System.out.println(msg);
	}

}
