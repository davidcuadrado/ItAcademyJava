package s107n2e1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)

public @interface Serializar {

	String rutaArchivo() default "C:\\Users\\r610c\\Desktop\\IT Academy\\Eclipse\\S107N2E1\\src\\persona_serializada";

}
