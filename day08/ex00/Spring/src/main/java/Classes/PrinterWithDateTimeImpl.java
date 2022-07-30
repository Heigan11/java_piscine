package Classes;

import java.time.LocalDateTime;

public class PrinterWithDateTimeImpl implements Printer {
    public Renderer renderer;

    @Override
    public void print(String text) {
        text = LocalDateTime.now() + " " + text;
        renderer.printMessage(text);
    }

    public PrinterWithDateTimeImpl(Renderer renderer) {
        this.renderer = renderer;
    }
}


