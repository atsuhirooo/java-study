package ch16.ex04;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
}

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2 {
}

@MyAnnotation
public class GetAnnotation {

	@MyAnnotation2
	private int i;

	public static void main(String[] args) {
		try {
			Class<?> clazz = Class.forName(args[0]);
			// Class<?> clazz = Class.forName(GetAnnotation.class.getName());
			Annotation[] annotations = clazz.getDeclaredAnnotations();
			for (Annotation annotation : annotations) {
				System.out.println(annotation.toString());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
