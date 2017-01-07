package cd.project.texteditor;

import java.awt.*;
import javax.swing.*;

/**
 * Created by devcon90 on 12/27/16.
 */
public class TextField extends JPanel
{
    private JTextArea textArea;

    public TextField()
    {
        super(new GridLayout(0, 1));

        textArea = new JTextArea(40,60);
        textArea.setText("Press 'OPEN' to select a file for editing!");
        textArea.setEditable (true);

        add(textArea);
    }

    String getText()
    {
        String saveText = textArea.getText();
        return saveText;
    }

    void setText(String text)
    {
        textArea.setText(text);
    }
}
