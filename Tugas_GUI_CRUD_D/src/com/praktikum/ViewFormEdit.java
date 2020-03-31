package com.praktikum;

import javax.swing.*;
import java.awt.*;

public class ViewFormEdit extends JFrame {
    JLabel lnama = new JLabel("Nama      :");
    JTextField tfnama = new JTextField();
    JLabel lnim = new JLabel("NIM          :");
    JTextField tfnim = new JTextField();
    JLabel lalamat = new JLabel("Alamat    :");
    JTextField tfalamat = new JTextField();

    JButton btnEdit = new JButton("Edit");
    JButton btnKembali = new JButton("Kembali");

    public ViewFormEdit() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("FORM EDIT DATA");
        setLayout(null);
        setSize(800, 600);
        setBackground(Color.white);

        JLabel label = new JLabel("FORM EDIT DATA");
        add(label);
        label.setBounds(320, 20, 200, 20);

        add(lnama);
        lnama.setBounds(250, 100, 90, 20);
        add(tfnama);
        tfnama.setBounds(350, 100, 120, 20);
        add(lnim);
        lnim.setBounds(250, 125, 90, 20);
        add(tfnim);
        tfnim.setBounds(350, 125, 120, 20);
        add(lalamat);
        lalamat.setBounds(250, 150, 90, 20);
        add(tfalamat);
        tfalamat.setBounds(350, 150, 120, 20);

        add(btnEdit);
        btnEdit.setBounds(250, 180, 90, 20);

        add(btnKembali);
        btnKembali.setBounds(350, 180, 90, 20);

    }

    public String getTfnama() {
        return tfnama.getText();
    }

    public String getTfnim() {
        return tfnim.getText();
    }

    public String getTfalamat() {
        return tfalamat.getText();
    }
}
