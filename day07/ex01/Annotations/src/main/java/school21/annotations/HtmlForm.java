package school21.annotations;

import java.lang.annotation.*;

@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface HtmlForm {
    String fileName();
    String action();
    String method();
}
