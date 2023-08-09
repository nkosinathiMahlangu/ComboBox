/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.combobox;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import za.ac.tut.box.Box;

/**
 *
 * @author MR
 */
public class comboBox extends JFrame{
    //Panels
    private JPanel headingPnl;
    private JPanel namePnl;
    private JPanel comboPnl;
    private JPanel comboHead;
    private JPanel combination;
    private JPanel areaPnl;
    private JPanel buttonPnl;
    private JPanel mainPnl;
    //Labels
    private JLabel headingLb;
    private JLabel comboLb;
    private JLabel nameLb;
    private JLabel comboBoxLb;
    //TextField
    private JTextField nameTx;
    //Area field
    private JTextArea areaText;
    //Buttons
    private JComboBox combo;
    //Scroll
    private JScrollPane pane;
    //Buttons
    private JButton submit;
    private JButton display;
    private JButton clear;
    private JButton exit;
    //Arraylist
    private ArrayList<Box> myBox;
   
    public comboBox() {
        // INStsa arra
        myBox = new ArrayList<>();
        //Setting the frame
        setTitle("Combo Box");
        setSize(500,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Insta panels
        headingPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
        comboPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        namePnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        comboHead = new JPanel(new GridLayout(5,1,1,1));
        comboHead.setBorder(new TitledBorder(new LineBorder(Color.BLACK,1),"Heading"));
        areaPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        combination = new JPanel(new BorderLayout());
        mainPnl = new JPanel(new BorderLayout());
        //Insta labels
        headingLb = new JLabel("Combo Box Example");
        headingLb.setForeground(Color.RED);
        headingLb.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        nameLb = new JLabel("Name: ");
        comboBoxLb = new JLabel("Select a country from a list");
        //Teaxt field
        nameTx = new JTextField(10);
        //comme area
        areaText = new JTextArea(15,50);
        areaText.setEditable(false);
        areaText.setBorder(new TitledBorder(new LineBorder(Color.BLACK,1),"Area"));
        pane = new JScrollPane(areaText,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        //combo box buttons
        combo = new JComboBox();
        combo.addItem("--Select country-- ");
        combo.addItem("South Africa");
        combo.addItem("France");
        combo.addItem("United State of America");
        combo.addItem("China");
        combo.addItem("Spain");
        combo.addItem("Russia");
       // combo.addActionListener(new comboButton());
        //Buttons
        submit = new JButton("Submit");
        submit.addActionListener(new submitButton());
        display = new JButton("Display");
        display.addActionListener(new displayButton());
        clear = new JButton("Clear");
        clear.addActionListener(new clearButton());
        exit = new JButton("Exit");
        exit.addActionListener(new exitButton());
        //Adding compoents to respict panels
        headingPnl.add(headingLb);
        namePnl.add(nameLb);
        namePnl.add(nameTx);
        comboPnl.add(comboBoxLb);
        comboPnl.add(combo);
        areaPnl.add(pane);
        
        comboHead.add(namePnl);
        comboHead.add(comboPnl);
        
        combination.add(headingPnl,BorderLayout.NORTH);
        combination.add(comboHead,BorderLayout.CENTER);
        
        buttonPnl.add(submit);
        buttonPnl.add(display);
        buttonPnl.add(clear);
        buttonPnl.add(exit);
        //Adding to main panel
        mainPnl.add(combination,BorderLayout.NORTH);
        mainPnl.add(areaPnl,BorderLayout.CENTER);
        mainPnl.add(buttonPnl,BorderLayout.SOUTH);
        //adding main to frame
        add(mainPnl);
        
        pack();
        setVisible(true);
    }

    private class exitButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
          System.exit(0);
        }

       
    }

    private class clearButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
        areaText.setText("");
        }

  
    }


    private  class displayButton implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent ae) {
        String data,record = "";
        File file;
        int val;
        BufferedReader br;
        JFileChooser fc;
        //Insta the file chooser
        fc = new JFileChooser();
        //Showing the dialog
        val = fc.showOpenDialog(comboBox.this);
        //get file select
        file = fc.getSelectedFile();
            try {
                //Open reading
                br = new BufferedReader(new FileReader(file));
                //Concate the data
                while((data = br.readLine()) != null){
                    record += data +"\n";
                }
                br.close();
                areaText.setText(record);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(comboBox.class.getName()).log(Level.SEVERE, null, ex);
            }catch(IOException e){
                Logger.getLogger(comboBox.class.getName()).log(Level.SEVERE, null, e);
            }
          
          
        }

        
    }

    private class submitButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            //Declare variable
            File file;
            JFileChooser jc;
            BufferedWriter bw;
            Box box;
            int val;
            
            //Read that from the fields
            String name = nameTx.getText();
            String country = (String) combo.getSelectedItem();
            //Create member
            box = new Box(name,country);
            //Ista chooser
            jc = new JFileChooser();
            //Showing file chooser
             val = jc.showSaveDialog(comboBox.this);
            
            if(val== JFileChooser.APPROVE_OPTION){
            
           
            //gets the file that is select
            file = jc.getSelectedFile();
            try {
                //write on the file
                bw = new BufferedWriter(new FileWriter(file,true));
                //Write to the file
                bw.write(box.toString());
                bw.newLine();
                bw.close();
                //Confirmation 
               JOptionPane.showMessageDialog (comboBox.this,"Details saved");
                //Clear fields
                nameTx.setText("");
                areaText.setText("");
                combo.setSelectedIndex(0);
                //set fo
                nameTx.setFocusable(true);
            } catch (IOException ex) {
                Logger.getLogger(comboBox.class.getName()).log(Level.SEVERE, null, ex);
            }
            }else{
                JOptionPane.showMessageDialog(null,"File not found");
            }
            
        }
    }

  
       
    }


    

