package school21.annotations;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Set;

@SupportedAnnotationTypes({"school21.annotations.HtmlForm", "school21.annotations.HtmlInput"})
public class HtmlProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {

        StringBuilder line;

        for (Element userForm : roundEnvironment.getElementsAnnotatedWith(HtmlForm.class)) {
            HtmlForm htmlFormAnn = userForm.getAnnotation(HtmlForm.class);
            line = new StringBuilder("<form action = \"" + htmlFormAnn.action() + "\" method = \"" + htmlFormAnn.method() + "\">\n");
            List<? extends Element> userFormElements = userForm.getEnclosedElements();

            for (Element field : roundEnvironment.getElementsAnnotatedWith(HtmlInput.class)) {
                if (!userFormElements.contains(field)) {
                    continue;
                }
                HtmlInput htmlInputAnn = field.getAnnotation(HtmlInput.class);
                line.append("\t<input type = ")
                        .append(htmlInputAnn.type()).append("\" name = \"")
                        .append(htmlInputAnn.name()).append("\" placeholder = \"")
                        .append(htmlInputAnn.placeholder()).append("\">\n");
            }

            line.append("\t<input type = \"submit\" value = \"Send\">\n</form>");

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("target/classes/" + htmlFormAnn.fileName()))) {
                writer.write(line.toString());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }
}
