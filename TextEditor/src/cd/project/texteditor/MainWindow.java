package cd.project.texteditor;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

/**
 * Created by devcon90 on 12/27/16.
 */
public class MainWindow extends JFrame
{
    public TextField textPanel;
    public File file;

    public MainWindow()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textPanel = new TextField();
        add(textPanel, BorderLayout.NORTH);

        //Open button
        JButton openButton = new JButton("OPEN");
        openButton.addActionListener(buttonListenerOpen);
        add(openButton, BorderLayout.WEST);

        //Save button
        JButton saveButton = new JButton("SAVE");
        saveButton.addActionListener(buttonListenerSave);
        add(saveButton, BorderLayout.EAST);

        //Button panel
        JPanel p = new JPanel();
        p.add(openButton);
        p.add(saveButton);
        add(p,BorderLayout.SOUTH);

        //Display the window.
        pack();
        setVisible(true);
    }

    public void buttonClickedOpen()
    {
        System.out.println("Open");
        JFileChooser chooser = new JFileChooser("./");

        int returnVal = chooser.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION)
        {
            System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
        }

        file = chooser.getSelectedFile();
        try
        {
            Scanner scanner = new Scanner(file);
            String text = "";
            while(scanner.hasNext())
            {
                text = text + "\n" + scanner.nextLine();
            }

            textPanel.setText(text);
        }

        catch(FileNotFoundException e)
        {
            System.out.println("File not found!");
        }
    }

    public void buttonClickedSave()
    {
        System.out.println("Save");
        try
        {
            FileWriter out = new FileWriter(file);
            out.write(textPanel.getText());
            out.close();
        }

        catch (Exception e)
        {
            System.out.println("Error!");
        }
    }

    ActionListener buttonListenerOpen = new ActionListener()
    {
        public void actionPerformed( ActionEvent e )
        {
            buttonClickedOpen();
        }
    };

    ActionListener buttonListenerSave = new ActionListener()
    {
        public void actionPerformed( ActionEvent e )
        {
            buttonClickedSave();
        }
    };
}