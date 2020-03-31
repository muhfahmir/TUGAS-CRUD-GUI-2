package com.praktikum;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Menu extends JFrame implements ActionListener {
    JLabel ljudul;
    JButton btnInput, btnHapus, btnEdit, btnTampil, btnExit;
    Model_Mahasiswa model_mahasiswa = new Model_Mahasiswa();
    Font fontt = new Font("SanSerif", Font.PLAIN, 20);
    public Menu() {
        ljudul = new JLabel("MENU");
        btnInput = new JButton("1. Input Data Mahasiswa");
        btnTampil = new JButton("2. Tampilkan Seluruh Data");
        btnHapus = new JButton("3. Hapus Data Mahasiswa");
        btnEdit = new JButton("4. Edit Data Mahasiswa");
        btnExit = new JButton("0. Exit");

        btnInput.addActionListener(this);
        btnTampil.addActionListener(this);
        btnHapus.addActionListener(this);
        btnEdit.addActionListener(this);
        btnExit.addActionListener(this);

        setLayout(null);
        add(ljudul);
        ljudul.setFont(fontt);
        add(btnExit);
        add(btnEdit);
        add(btnHapus);
        add(btnTampil);
        add(btnInput);

        ljudul.setBounds(70, 10, 200, 25);
        btnInput.setBounds(70, 60, 200, 25);
        btnTampil.setBounds(70, 90, 200, 25);
        btnHapus.setBounds(70, 120, 200, 25);
        btnEdit.setBounds(70, 150, 200, 25);
        btnExit.setBounds(70, 180, 200, 25);

        setTitle("GUI MAHASISWA");
        setSize(350, 280);
        ljudul.setHorizontalAlignment(SwingConstants.CENTER);
        btnInput.setHorizontalAlignment(SwingConstants.LEFT);
        btnTampil.setHorizontalAlignment(SwingConstants.LEFT);
        btnHapus.setHorizontalAlignment(SwingConstants.LEFT);
        btnEdit.setHorizontalAlignment(SwingConstants.LEFT);
        btnExit.setHorizontalAlignment(SwingConstants.LEFT);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnInput) {
            ViewFormInput viewFormInput = new ViewFormInput();
            new Controller_Mahasiswa(viewFormInput,model_mahasiswa);
            dispose();

        } else if (e.getSource() == btnTampil) {
            ViewFormRead viewFormRead = new ViewFormRead(0);
            new Controller_Mahasiswa(viewFormRead, model_mahasiswa);
            dispose();

        } else if (e.getSource() == btnHapus) {
            ViewFormRead viewFormRead = new ViewFormRead(3);
            new Controller_Mahasiswa(viewFormRead, model_mahasiswa);
            dispose();

        } else if (e.getSource() == btnEdit) {
            ViewFormRead viewFormRead = new ViewFormRead(4);
            new Controller_Mahasiswa(viewFormRead, model_mahasiswa);
            dispose();

        } else if (e.getSource() == btnExit) {
            // kelas exit
            int selectedOption = JOptionPane.showConfirmDialog(null,
                    "Apakah anda akan menutup Aplikasi?", "Tutup Aplikasi", JOptionPane.YES_NO_OPTION);
            if (selectedOption == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }
}
