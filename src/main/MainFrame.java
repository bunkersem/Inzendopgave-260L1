package main;

import javax.swing.*;
import java.awt.*;

import static internationalization.LanguageProvider.*;
import static main.Helpers.*;

/**
 * Created by Sem on 09-Jul-17.
 */
public class MainFrame extends JFrame
{
    WelcomePanel welcomePanel = new WelcomePanel();
    ParentPanel parentPanel = new ParentPanel(welcomePanel);

    JMenuBar menuBar = new MenuBar();

    public MainFrame(){
        setSize(720, 460);
        setLocationRelativeTo(null);
        setTitle(welcomeFrameTitle(getLang()));
        setFont(Font.getFont("Arial"));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setJMenuBar(menuBar);

        setContentPane(parentPanel);

        setVisible(true);
    }
}
