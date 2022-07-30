package Classes;

import java.util.Locale;

public class PreProcessorToUpperImpl implements PreProcessor{

    @Override
    public String changeText(String text) {
        text = text.toUpperCase(Locale.ROOT);
        return text;
    }

}
