package school21.annotations;

import java.lang.annotation.*;

@Inherited
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.SOURCE)
public @interface HtmlInput {
    String type();
    String name();
    String placeholder();
}
