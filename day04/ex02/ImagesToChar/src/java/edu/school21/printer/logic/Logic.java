package edu.school21.printer.logic;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Parameters(separators = "=")
public class Logic {

    @Parameter(names = "--white")
    private String arg1;
    @Parameter(names = "--black")
    private String arg2;

    public void run() {
        try {
            File file = new File("./src/resources/it.bmp");
            BufferedImage source = ImageIO.read(file);

            ColoredPrinter coloredPrinter = new ColoredPrinter.Builder(1, false).build();

            Ansi.BColor white = Ansi.BColor.valueOf(arg1);
            Ansi.BColor black = Ansi.BColor.valueOf(arg2);

            for (int x = 0; x < source.getWidth(); x++) {
                for (int y = 0; y < source.getHeight(); y++) {
                    Color color = new Color(source.getRGB(y, x));
                    int blue = color.getBlue();
                    int red = color.getRed();
                    int green = color.getGreen();
                    if (blue == 0 && red == 0 && green == 0) {
                        coloredPrinter.setBackgroundColor(black);
                        coloredPrinter.print("   ");
                    } else {
                        coloredPrinter.setBackgroundColor(white);
                        coloredPrinter.print("   ");
                    }
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Bad path");
        }
    }
}
