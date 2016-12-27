package cd.project.texteditor;

import java.awt.*;
import javax.swing.*;
//import java.util.*;
//import java.io.*;

/**
 * Created by devcon90 on 12/27/16.
 */
public class MainWindow extends JFrame {
    private TextField textPanel;

    public MainWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textPanel = new TextField();
        add(textPanel, BorderLayout.NORTH);
    }

}
