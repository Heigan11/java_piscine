package edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Logic {
    
    public static void print_img (String path, char white, char black){
        try {
            File file = new File(path);
            BufferedImage source = ImageIO.read(file);
            char[][] array2D = new char[source.getWidth()][source.getHeight()];
            for (int x = 0; x < source.getWidth(); x++) {
                for (int y = 0; y < source.getHeight(); y++) {
                    Color color = new Color(source.getRGB(x, y));
                    int blue = color.getBlue();
                    int red = color.getRed();
                    int green = color.getGreen();
                    if (blue == 0 && red == 0 && green == 0)
                        array2D[y][x] = black;
                    else
                        array2D[y][x] = white;
                }
            }
            for (int x = 0; x < array2D.length; x++)
            {
                for (int y = 0; y < array2D[x].length; y++)
                {
                    System.out.print(array2D[x][y]);
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Bad path");
        }
    }
}
