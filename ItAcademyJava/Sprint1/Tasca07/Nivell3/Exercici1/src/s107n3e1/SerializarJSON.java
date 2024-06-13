package s107n3e1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)

public @interface SerializarJSON {

	String rutaArchivo() default "D:\\00proyectos\\S107N3E1\\src\\persona_serializada";
	
	

}
