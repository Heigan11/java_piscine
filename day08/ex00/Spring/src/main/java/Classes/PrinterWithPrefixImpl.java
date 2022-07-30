package Classes;

import java.util.Objects;

public class PrinterWithPrefixImpl implements Printer {

    public Renderer renderer;
    private String prefix;

    public PrinterWithPrefixImpl(Renderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public void print(String text) {
        text = prefix + text;
        renderer.printMessage(text);
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setRenderer(Renderer renderer) {
        this.renderer = renderer;
    }
}
