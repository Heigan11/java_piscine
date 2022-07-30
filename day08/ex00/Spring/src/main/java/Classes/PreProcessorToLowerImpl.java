package Classes;

import java.util.Locale;

public class PreProcessorToLowerImpl implements PreProcessor{

    @Override
    public String changeText(String text) {
        text = text.toLowerCase(Locale.ROOT);
        return text;
    }
}
