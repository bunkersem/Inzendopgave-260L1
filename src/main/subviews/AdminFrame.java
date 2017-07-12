package main.subviews;

import database.Repository;
import main.FontType;
import main.Fonts;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static internationalization.LanguageProvider.welcomeFrameTitle;
import static main.Helpers.getLang;
import static main.Helpers.printResultSet;

/**
 * Created by Sem on 10-Jul-17.
 */
public class AdminFrame extends JFrame{
    ContentPanel content = new ContentPanel();

    public AdminFrame(){
        setSize(960, 720);
        setLocationRelativeTo(null);
        setTitle(welcomeFrameTitle(getLang()));
        setFont(Font.getFont("Arial"));
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setContentPane(content);
        setResizable(false);
    }

    public void init(){
        setVisible(true);
    }

    class ContentPanel extends JPanel {
        JPanel queryPane = new JPanel();
        JPanel queryFieldContainer = new JPanel(new GridLayout(1,1, 2, 0));
        JTextArea queryField = new JTextArea("Write Query here...");
        JPanel buttonContainer = new JPanel();
        JButton queryGoBtn = new JButton("Query");
        JButton updateGoBtn = new JButton("Update");
        JTextArea queryResult = new JTextArea("Query Results");
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, queryPane, queryResult);

        public ContentPanel(){
            queryField.setLineWrap(true);
            queryResult.setLineWrap(true);
            queryField.setFont(Fonts.createFont(FontType.BIGGER));
            queryResult.setFont(Fonts.createFont(FontType.BIGGER));
            queryPane.setLayout(new BoxLayout(queryPane, BoxLayout.X_AXIS));
            buttonContainer.setLayout(new BoxLayout(buttonContainer, BoxLayout.Y_AXIS));
            setLayout(new GridLayout(1,1));
            queryFieldContainer.add(queryField);
            queryPane.add(queryFieldContainer);
            buttonContainer.add(queryGoBtn);
            buttonContainer.add(updateGoBtn);
            queryPane.add(buttonContainer);
            queryPane.revalidate();
            queryResult.setEditable(false);
            setBorder(new EmptyBorder(10, 10, 10, 10));
            splitPane.setDividerLocation(60);

            add(splitPane);

            queryGoBtn.addActionListener(queryBtnClick);
            updateGoBtn.addActionListener(updateBtnClick);
        }

        ActionListener queryBtnClick = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String result = query(queryField.getText());
                queryResult.setText(result);
            }
        };

        ActionListener updateBtnClick = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String result = update(queryField.getText());
                queryResult.setText(result);
            }
        };

        String query(final String statement){
            try {
                return printResultSet(Repository.executeQuery(statement));
            } catch (SQLException e) {
                e.printStackTrace();
                return e.getLocalizedMessage();
            }
        }

        String update(final String statement){
            try {
                Repository.executeUpdate(statement);
            } catch (SQLException e) {
                e.printStackTrace();
                return e.getLocalizedMessage();
            }
            return "Executed updated successfully.";
        }
    }
}
