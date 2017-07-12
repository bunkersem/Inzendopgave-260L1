package main;

import internationalization.Language;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.prefs.Preferences;

import static main.Helpers.GetImageFromUrl;

/**
 * Created by Sem on 09-Jul-17.
 */
public class Helpers {
    static Language lang = null;
    public static Language getLang(){
        if (lang != null)
            return lang;
        Preferences prefs = preferences();
        int result = prefs.getInt("Lang", Language.NL.ordinal());

        try {
            lang = Language.values()[result];
            return Language.values()[result];
        } catch(IndexOutOfBoundsException ex){
            return Language.NL;
        }
    }
    public static void setLang(final Language lang){
        Preferences prefs = preferences();
        final int val = lang.ordinal();
        prefs.putInt("Lang", val);
    }

    static Preferences preferences(){
        return Preferences.userRoot();
    }

    public static java.net.URL getResourceUrl(String path){
        return Helpers.class.getResource(path);
    }

    public static ImageIcon GetImageFromUrl(final String path, final int width, final int height) throws IOException {
        System.out.println("Getting image from: " + path);
        URL url = new URL(path);
        BufferedImage image = ImageIO.read(url);
        Image img = image.getScaledInstance(width, height, Image.SCALE_FAST);
        return new ImageIcon(img);
    }

    public static String printResultSet(final ResultSet resultSet) throws SQLException {
        return printResultSet(resultSet, ", ", "\n");
    }

    public static String printResultSet(final ResultSet resultSet, String collumnSeperator, String lineSeperator) throws SQLException {
        ResultSetMetaData rsmd = resultSet.getMetaData();
        StringBuilder sb = new StringBuilder();
        int columnsNumber = rsmd.getColumnCount();
        while (resultSet.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) sb.append(collumnSeperator);
                String columnValue = resultSet.getString(i);
                sb.append( rsmd.getColumnName(i) + ": " + columnValue );
            }
            sb.append(lineSeperator);
        }
        return sb.toString();
    }

    public static void resourceTaskRunner(String path, JPanel parent) {
        (new ResourceTaskRunner(path, parent)).start();
    }
}

class ResourceTaskRunner extends Thread {
    String path;
    JPanel parent;
    public ResourceTaskRunner(String path, JPanel parent){
        this.path = path;
        this.parent = parent;
    }
    @Override
    public void run() {
        super.run();
        // Add image
        JLabel image = null;
        try {
            image = new JLabel(GetImageFromUrl(path, 100, 100));
            parent.add(image, 0);
            parent.revalidate();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}