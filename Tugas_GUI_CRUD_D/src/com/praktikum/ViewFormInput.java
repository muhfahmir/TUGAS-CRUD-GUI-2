package com.praktikum;

import javax.swing.*;
import java.awt.*;

public class ViewFormInput extends JFrame {
    Font fontt = new Font("SanSerif", Font.PLAIN, 20);
    JLabel lnama = new JLabel("Nama      :");
    JTextField tfnama = new JTextField();
    JLabel lnim = new JLabel("NIM          :");
    JTextField tfnim = new JTextField();
    JLabel lalamat = new JLabel("Alamat    :");
    JTextField tfalamat = new JTextField();
    JButton btnSimpan = new JButton("Simpan");
    JButton btnKembali = new JButton("Kembali");
    public ViewFormInput(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("INPUT DATA MAHASISWA");
        setVisible(true);
        setLayout(null);
        setSize(800, 600);
        setBackground(Color.white);
        JLabel label = new JLabel("INPUT DATA MAHASISWA");
        add(label);
        label.setFont(fontt);
        label.setBounds(240, 20, 250, 20);

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
        add(btnSimpan);
        btnSimpan.setBounds(250, 180, 90, 20);

        add(btnKembali);
        btnKembali.setBounds(350, 180, 90, 20);
    }
    public String getNama() {
        return tfnama.getText();
    }

    public String getNim() {
        return tfnim.getText();
    }

    public String getAlamat() {
        return tfalamat.getText();
    }
}
