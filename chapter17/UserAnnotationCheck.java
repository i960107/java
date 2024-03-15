package chapter17;

import java.lang.reflect.Method;

public class UserAnnotationCheck {
    public static void main(String[] args) {
        UserAnnotationCheck sample = new UserAnnotationCheck();
        sample.checkAnnotations(UserAnnotationSample.class);
    }

    private void checkAnnotations(Class<UserAnnotationSample> userClass) {
        Method[] methods = userClass.getDeclaredMethods();
        for (Method method : methods) {
            UserAnnotation annotation = method.getAnnotation(UserAnnotation.class);
            if (annotation != null) {
                int number = annotation.number();
                String text = annotation.text();
                System.out.println(method.getName() + "() : number = " + number + " text= " + text);
            } else {
                System.out.println(method.getName() + "() : annotation is null");
            }
        }
    }
}
