package main;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.Font;

/**
 * Created by Sem on 09-Jul-17.
 */
public class Fonts {
    public static Font createFont(final FontType type){
        int fontSize;
        int fontWeight;
        switch (type){
            case SMALL:
                fontSize = 9;
                fontWeight = Font.PLAIN;
                break;
            case NORMAL:
                fontSize = 11;
                fontWeight = Font.PLAIN;
                break;
            case HEADER_SMALL:
                fontSize = 16;
                fontWeight = Font.BOLD;
                break;
            case HEADER_MEDIUM:
                fontSize = 22;
                fontWeight = Font.BOLD;
                break;
            case HEADER_LARGE:
                fontSize = 28;
                fontWeight = Font.BOLD;
                break;
            case TITLE:
                fontSize = 48;
                fontWeight = Font.BOLD;
                break;
            case BIGGER:
                fontSize = 14;
                fontWeight = Font.PLAIN;
                break;
            default:
                throw new NotImplementedException();
        }

        Font newFont = new Font("Arial", fontWeight, fontSize);
        return newFont;
    }
}


