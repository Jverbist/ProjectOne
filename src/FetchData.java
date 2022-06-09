import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class FetchData implements ActionListener {

    JFrame frame1;
    JLabel nameLabel;
    JTextField nameTextField;
    JButton fetchButton;
    JButton resetButton;


    FetchData() {

        frame1 = new JFrame();
        frame1.setTitle("Search Database");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagLayout bagLayout = new GridBagLayout();
        GridBagConstraints bagConstraints = new GridBagConstraints();
        frame1.setSize(500, 300);
        frame1.setLayout(bagLayout);


        bagConstraints.insets = new Insets(15, 40, 0, 0);


        fetchButton = new JButton("Push me");
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 1;
        bagConstraints.ipadx = 60;
        frame1.add(fetchButton, bagConstraints);
        fetchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("org.mariadb.jdbc.Driver");
                } catch(ClassNotFoundException exception) {
                    System.out.println("Class not found "+ e);
                }
                try {
                    Connection con = DriverManager.getConnection(
                            "jdbc:mysql://100.117.244.98/jornt", "jornt", "nO0/Ikl1bd");

                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT *  FROM student");
                    System.out.println("stud_id  naam ");

                    while (rs.next()) {
                        int stud_id = rs.getInt("stud_id");
                        String naam = rs.getString("naam");
                        System.out.println(stud_id+"   "+naam+"    ");
                    }
                } catch(SQLException exception) {
                    System.out.println("SQL exception occured " + e);
                }
            }
        });






        frame1.setVisible(true);
        frame1.validate();
    }

    public static void main(String[] args) {

        new FetchData();

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

}