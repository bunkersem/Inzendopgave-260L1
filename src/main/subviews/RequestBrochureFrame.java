package main.subviews;

import database.Dataservice;
import main.FontType;
import main.Fonts;
import models.BrochureRequest;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Enumeration;

import static internationalization.LanguageProvider.*;
import static main.Helpers.getLang;

/**
 * Created by Sem on 10-Jul-17.
 */
public class RequestBrochureFrame extends JFrame{
    ContentPanel content = new ContentPanel();

    public RequestBrochureFrame(){
        setSize(960, 720);
        setLocationRelativeTo(null);
        setTitle(welcomeFrameTitle(getLang()));
        setFont(Font.getFont("Arial"));
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setContentPane(content);
    }

    public void init() {
        setVisible(true);
    }

    class ContentPanel extends JPanel {
        LayoutManager layout = new GridLayout(2, 2, 20, 20);
        JPanel[] panels = new JPanel[4];

        // Brochure type.
        JRadioButton oneDayBtn = new JRadioButton(brochureTypeOneDay(getLang()));
        JRadioButton multipleDayBtn = new JRadioButton(brochureTypeMultipleDays(getLang()));
        JRadioButton winterSportsBtn = new JRadioButton(brochureTypeWinterSports(getLang()));
        ButtonGroup brochureTypeRadioGroup = new ButtonGroup();

        // Brochure destination.
        JRadioButton paris = new JRadioButton(paris(getLang()));
        JRadioButton berlin = new JRadioButton(berlin(getLang()));
        JRadioButton london = new JRadioButton(london(getLang()));
        ButtonGroup brochureDestinationRadioGroup = new ButtonGroup();

        // Brochure contact information.
        JTextField nameField = new JTextField();
        JTextField adressField = new JTextField();
        JTextField postalCodeField = new JTextField();
        JTextField residenceField = new JTextField();
        JTextField phoneField = new JTextField();
        JTextField mobilePhoneField = new JTextField();
        JTextField emailField = new JTextField();

        // Additional input.
        JTextArea remarksAndOrSupplementsTextArea = new JTextArea(5, 12);
        JCheckBox clientCallBackCheckbox = new JCheckBox();
        JButton submitBtn = new JButton(submit(getLang()));


        public ContentPanel (){
            setLayout(layout);
            setBorder(new EmptyBorder(10, 10, 10, 10));

            for (int i = 0; i < panels.length ; i++) {
                panels[i] = new JPanel();
                add(panels[i]);
            }
            Font boldFont = Fonts.createFont(FontType.HEADER_SMALL);

            // Add brochure type.
            JLabel brochureType = new JLabel(brochureType(getLang()));
            brochureType.setFont(boldFont);
            panels[0].add(brochureType);
            panels[0].add(Box.createRigidArea(new Dimension(5, 5)));

            // Add brochure type radio buttons.
            LayoutManager brochureTypeLayout = new BoxLayout(panels[0], BoxLayout.Y_AXIS);
            panels[0].setLayout(brochureTypeLayout);
            oneDayBtn.setSelected(true);
            brochureTypeRadioGroup.add(oneDayBtn);
            brochureTypeRadioGroup.add(multipleDayBtn);
            brochureTypeRadioGroup.add(winterSportsBtn);
            panels[0].add(oneDayBtn);
            panels[0].add(multipleDayBtn);
            panels[0].add(winterSportsBtn);

            // Add brochure destination radio buttons.
            LayoutManager brochureDestinationLayout = new BoxLayout(panels[1], BoxLayout.Y_AXIS);
            panels[1].setLayout(brochureDestinationLayout);
            JLabel destinationLabel = new JLabel(whichDestination(getLang()));
            destinationLabel.setFont(boldFont);
            panels[1].add(destinationLabel);
            panels[1].add(Box.createRigidArea(new Dimension(5, 5)));
            paris.setSelected(true);
            brochureDestinationRadioGroup.add(paris);
            brochureDestinationRadioGroup.add(berlin);
            brochureDestinationRadioGroup.add(london);
            panels[1].add(paris);
            panels[1].add(berlin);
            panels[1].add(london);

            // Add brochure contact information.
            LayoutManager brochureContactInfoLayout = new GridLayout(7,2, 5, 5);
            panels[2].setLayout(brochureContactInfoLayout);

            // Add brochure contact information input fields.
            String[] labelsTexts = {name(getLang()), adress(getLang()), postalCode(getLang()), placeOfResidence(getLang()),
                    phone(getLang()), mobilePhone(getLang()), email(getLang())};
            JTextField[] textFields = {nameField, adressField, postalCodeField, residenceField, phoneField,
                    mobilePhoneField, emailField};
            for (int i = 0; i < 7; i++) {
                JLabel newLabel = new JLabel(labelsTexts[i]);
                newLabel.setFont(boldFont);
                panels[2].add(newLabel);
                panels[2].add(textFields[i]);
            }

            // Add brochure additional input.
            LayoutManager brochureAdditionalInputLayout = new BoxLayout(panels[3], BoxLayout.Y_AXIS);
            panels[3].setLayout(brochureAdditionalInputLayout);
            JLabel remarksAndOrSupplementsLabel = new JLabel(remarksOrSupplements(getLang()));
            remarksAndOrSupplementsLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            remarksAndOrSupplementsLabel.setFont(boldFont);
            panels[3].add(remarksAndOrSupplementsLabel);
            panels[3].add(Box.createRigidArea(new Dimension(5, 5)));
            remarksAndOrSupplementsTextArea.setAlignmentX(Component.LEFT_ALIGNMENT);
            panels[3].add(remarksAndOrSupplementsTextArea);
            panels[3].add(Box.createRigidArea(new Dimension(5, 5)));
            JPanel clientCallbackContainer = new JPanel(new FlowLayout(FlowLayout.LEADING));
            clientCallbackContainer.setAlignmentX(Component.LEFT_ALIGNMENT);
            clientCallbackContainer.add(clientCallBackCheckbox);
            clientCallbackContainer.add(new JLabel(clientCallback(getLang())));
            panels[3].add(clientCallbackContainer);
            panels[3].add(Box.createRigidArea(new Dimension(5, 5)));
            submitBtn.addActionListener(submitBtnClick);
            panels[3].add(submitBtn);
        }
        ActionListener submitBtnClick = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Submit Brochure Data");
                submitBrochure();
            }
        };

        void submitBrochure(){
            AbstractButton _ab;

            // Brochure type.
            String type = null;
            Enumeration<AbstractButton> brochureTypeRadioButtons = brochureTypeRadioGroup.getElements();
            while(brochureTypeRadioButtons.hasMoreElements()) {
                _ab = brochureTypeRadioButtons.nextElement();
                if (_ab.isSelected()){
                    type = _ab.getText();
                }
            }
            // Sanity check.
            if (type == null){
                type = brochureTypeRadioGroup.getElements().nextElement().getText();
            }


            // Brochure destination.
            String destination = null;
            Enumeration<AbstractButton> brochureDestinationRadioButtons = brochureDestinationRadioGroup.getElements();
            _ab = brochureDestinationRadioButtons.nextElement();
            while(brochureDestinationRadioButtons.hasMoreElements()){
                _ab = brochureDestinationRadioButtons.nextElement();
                if (_ab.isSelected()){
                    destination = _ab.getText();
                }
            }
            // Sanity check.
            if (destination == null){
                destination = brochureDestinationRadioGroup.getElements().nextElement().getText();
            }

            // Brochure contact input.
            String name = nameField.getText();
            String adress = adressField.getText();
            String postalCode = postalCodeField.getText();
            String residence = residenceField.getText();
            String phone = phoneField.getText();
            String mobileFphone = mobilePhoneField.getText();
            String email = emailField.getText();

            // Brochure additional input.
            String remarksAndOrSupplements = remarksAndOrSupplementsTextArea.getText();
            boolean clientCallBack = clientCallBackCheckbox.isSelected();

            BrochureRequest br = new BrochureRequest(0, type, destination, name, adress, postalCode, residence,
                    phone, mobileFphone, email, remarksAndOrSupplements, clientCallBack);

            System.out.println("Sending brochureRequest to the database:");
            System.out.println(br);
            try {
                Dataservice.putBrochureRequest(br);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Could not connect to remote server");
                e.printStackTrace();
            }
        }

    }
}
