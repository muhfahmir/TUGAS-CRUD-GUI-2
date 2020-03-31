package com.praktikum;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewFormRead extends JFrame {
    JPanel panel2 = new JPanel();

    Font fontt = new Font("SanSerif", Font.PLAIN, 20);

    JButton btnKembali = new JButton("Kembali");
    JButton btnHapus = new JButton("Hapus");
    JButton btnEdit = new JButton("Edit");

    JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    Object namaKolom[] = {"NIM","Nama","Alamat"};

    public ViewFormRead(int x) {

        tableModel = new DefaultTableModel(namaKolom,0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);

        setTitle("TAMPILKAN DATA MAHASISWA");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(600, 480);

        JLabel label = new JLabel("SELURUH DATA MAHASISWA");
        panel2.add(label);
        label.setBounds(120, 20, 300, 20);
        label.setFont(fontt);

        add (panel2);

        panel2.setBounds(10, 10, 755, 525);
        panel2.setLayout(null);
        panel2.setBackground(Color.white);

        panel2.add(btnKembali);
        btnKembali.setBounds(220, 60, 90, 20);
        if (x == 3) {
            setTitle("HAPUS DATA MAHASISWA");
            label = new JLabel("HAPUS DATA MAHASISWA");
            btnKembali.setBounds(280, 60, 90, 20);
            panel2.add(btnHapus);
            btnHapus.setBounds(150, 60, 90, 20);
        }

        if (x == 4) {
            setTitle("EDIT DATA MAHASISWA");
            label = new JLabel("EDIT DATA MAHASISWA");
            btnKembali.setBounds(280, 60, 90, 20);
            panel2.add(btnEdit);
            btnEdit.setBounds(150, 60, 90, 20);
        }

        btnEdit.setEnabled(false);
        btnHapus.setEnabled(false);

        panel2.add(scrollPane);
        scrollPane.setBounds(20, 100, 480, 300);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    }




}
