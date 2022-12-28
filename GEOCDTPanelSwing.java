package project1_ver5;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Write a description  here.
 *
 */
public class GEOCDTPanelSwing extends JPanel {

    private GeoCountDownTimer watch;
    private Timer javaTimer;

    private JButton startButton, stopButton, suspendButton;
    private JTextField yearsField, monthsField, daysField;
    private JTextField addField, newField;
    private JButton addButton, loadButton, saveButton, continueButton;
    private JButton daysToGoButton, daysInFutureButton, newButton;


    private JLabel lblTime;

    public GEOCDTPanelSwing() {

        // create the game object as well as the GUI1024 Frame
        watch = new GeoCountDownTimer();
        javaTimer = new Timer(1000, new TimerListener());

        setLayout(new GridLayout(10, 2));
        setBackground(Color.lightGray);

        yearsField = new JTextField("2022", 3);
        add(yearsField);
        add(new JLabel("Years:"));

        monthsField = new JTextField("10", 3);
        add(monthsField);
        add(new JLabel("Months:"));

        daysField = new JTextField("10", 3);
        add(daysField);
        add(new JLabel("Days:"));


        stopButton = new JButton("Stop");
        add(stopButton);

        startButton = new JButton("Start");
        add(startButton);

        loadButton = new JButton("Load");
        add(loadButton);

        saveButton = new JButton("Save");
        add(saveButton);

        daysToGoButton = new JButton("Days To Go");
        add(daysToGoButton);

        daysInFutureButton = new JButton("Days In Future");
        add(daysInFutureButton);

        addButton = new JButton("Add");
        add(addButton);

        addField = new JTextField("0",3);
        add(addField);

        newButton = new JButton("New");
        add(newButton);

        newField = new JTextField("1/1/2022", 3);
        add(newField);

        continueButton = new JButton("Continue");
        add(continueButton);



        add(new JLabel(" "));

        lblTime = new JLabel();
        lblTime.setText(watch.toString());
        add(lblTime);

        add(new JLabel("   Date "));

        stopButton.addActionListener(new ButtonListener());
        startButton.addActionListener(new ButtonListener());
        addButton.addActionListener(new ButtonListener());
        continueButton.addActionListener(new ButtonListener());
        loadButton.addActionListener(new ButtonListener());
        saveButton.addActionListener(new ButtonListener());
        daysToGoButton.addActionListener(new ButtonListener());
        daysInFutureButton.addActionListener(new ButtonListener());
        newButton.addActionListener(new ButtonListener());


    }

    private class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            int mins, sec, milli, p;

            if (event.getSource() == stopButton) {
                javaTimer.stop();
            }
            //TIMER NEEDS TO STOP AT 1/1/2022
            if (event.getSource() == startButton) {
                try {
                    mins = Integer.parseInt(yearsField.getText());
                    sec = Integer.parseInt(monthsField.getText());
                    milli = Integer.parseInt(daysField.getText());
                    watch = new GeoCountDownTimer(mins, sec, milli);
                    javaTimer.start();
                } catch (NumberFormatException io) {
                    JOptionPane.showMessageDialog(null, "Enter an integer in all fields");
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, "Error in field");
                }
            }

            //opens a box asking for a date, opens another box that gives the number of days to go from given date
            if(event.getSource() == daysToGoButton) {
                String userInput = JOptionPane.showInputDialog("Enter a date in the form: x/x/xxxx");

                if (userInput == null || userInput == "") {
                    System.out.println("User hit cancel");
                } else {
                    try {
                        int s = watch.daysToGo(userInput);
                        JOptionPane.showMessageDialog(null, s + " days to go");
                    } catch (NumberFormatException io) {
                        JOptionPane.showMessageDialog(null, "Enter an integer in all fields");
                    } catch (IllegalArgumentException e) {
                        JOptionPane.showMessageDialog(null, "Error in field");
                    }
                }
            }

            //opens a box asking for # of days in the future, opens another box returning the date in the future
            if(event.getSource() == daysInFutureButton){
                String userInput = JOptionPane.showInputDialog("Enter a number of days");

                if(userInput == null || userInput == ""){
                    System.out.println("User hit cancel");
                }else {
                    try {
                        GeoCountDownTimer s = watch.daysInFuture(Integer.parseInt(userInput));
                        JOptionPane.showMessageDialog(null, "The date in the future is " + s);


                    } catch (NumberFormatException io) {
                        JOptionPane.showMessageDialog(null, "Enter an integer in all fields");
                    } catch (IllegalArgumentException e) {
                        JOptionPane.showMessageDialog(null, "Error in field");
                    }
                }
            }
            //adds the number of days in the add text field to the current timer at the bottom
            if(event.getSource() == addButton){
                try{
                        watch.inc(Integer.parseInt(addField.getText()));
                }
                catch (NumberFormatException io) {
                    JOptionPane.showMessageDialog(null, "Enter an integer in all fields");
                }
                catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, "Error in field");
                }
            }

            if(event.getSource() == newButton){
                try{
                    watch = new GeoCountDownTimer(newField.getText());
                }
                catch (NumberFormatException io) {
                    JOptionPane.showMessageDialog(null, "Enter an integer in all fields");
                }
                catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, "Error in field");
                }
            }

            if(event.getSource() == saveButton){
                JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView());
                int r = j.showSaveDialog(null);
                if(r == JFileChooser.APPROVE_OPTION){
                    watch.save(j.getSelectedFile().getAbsolutePath());
                }
                else{
                    JOptionPane.showMessageDialog(null, "User cancelled operation");
                }
            }
            if(event.getSource() == loadButton){
                try {
                    JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                    int r = j.showOpenDialog(null);
                    if (r == JFileChooser.APPROVE_OPTION) {
                        watch.load(j.getSelectedFile().getAbsolutePath());
                    } else {
                        JOptionPane.showMessageDialog(null, "User cancelled operation");
                    }
                }
                catch(RuntimeException a){
                    JOptionPane.showMessageDialog(null, "Date in file is invalid");
                }
            }

            if (event.getSource() == continueButton)
                javaTimer.start();


            lblTime.setText(watch.toString());
        }
    }

    private class TimerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                watch.dec(1);
                lblTime.setText(watch.toString());
            }
            catch (IllegalArgumentException f) {
                JOptionPane.showMessageDialog(null, "Timer Stopped at 1/1/2022");
                javaTimer.stop();
            }
        }
    }
}
