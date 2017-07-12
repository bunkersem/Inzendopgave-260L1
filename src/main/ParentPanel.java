package main;

import internationalization.Language;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

import static internationalization.LanguageProvider.*;
import static main.Helpers.*;

/**
 * Created by Sem on 09-Jul-17.
 */
public class ParentPanel extends JPanel{
    LayoutManager layout = new BorderLayout(2,2);
    JPanel contentPanel;

    public ParentPanel(final JPanel contentPanel){
        setLayout(layout);
        this.contentPanel = contentPanel;

        // Add toolbar
        add(contentPanel, BorderLayout.CENTER);

        this.revalidate();
    }

    public void setContenetView(final JPanel contentPanel){
        remove(contentPanel);
        this.contentPanel = contentPanel;
    }
}
