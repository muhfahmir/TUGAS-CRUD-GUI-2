package com.praktikum;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Controller_Mahasiswa {
    Model_Mahasiswa model_mahasiswa;
    ViewFormInput viewFormInput;
    ViewFormRead viewFormRead;
    ViewFormEdit viewFormEdit;
    int baris,kolom;
    String dataterpilih=null;

    Controller_Mahasiswa(ViewFormInput viewFormInput,Model_Mahasiswa model_mahasiswa){
        this.model_mahasiswa = model_mahasiswa;
        this.viewFormInput=viewFormInput;
        viewFormInput.btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (viewFormInput.getNama().equals("")
                        || viewFormInput.getNama().equals("")
                        || viewFormInput.getAlamat().equals("")) {
                    JOptionPane.showMessageDialog(null, "field kosong");
                } else {
                    String nim = viewFormInput.getNim();
                    String nama = viewFormInput.getNama();
                    String alamat = viewFormInput.getAlamat();
                    model_mahasiswa.insertMahasiswa(nim, nama, alamat);
                    viewFormInput.tfnim.setText("");
                    viewFormInput.tfnama.setText("");
                    viewFormInput.tfalamat.setText("");

                }
            }
        });
        viewFormInput.btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewFormInput.dispose();
                new Menu();
            }
        });
    }

    Controller_Mahasiswa(ViewFormRead viewFormRead,Model_Mahasiswa model_mahasiswa){
        this.viewFormRead=viewFormRead;
        this.model_mahasiswa = model_mahasiswa;
        if (model_mahasiswa.getBanyakData() != 0) {
            String dataMahasiswa[][] = model_mahasiswa.readMahasiswa();
            viewFormRead.tabel.setModel(new JTable(dataMahasiswa, viewFormRead.namaKolom).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }

        viewFormRead.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                baris = viewFormRead.tabel.getSelectedRow();
                kolom = viewFormRead.tabel.getSelectedColumn();

                dataterpilih = viewFormRead.tabel.getValueAt(baris, 0).toString();
                if (dataterpilih != null) {
                    viewFormRead.btnHapus.setEnabled(true);
                    viewFormRead.btnEdit.setEnabled(true);
                }
            }
        });

        viewFormRead.btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewFormRead.dispose();
                new Menu();
            }
        });

        viewFormRead.btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    if (dataterpilih != null) {
                        int selectedOption = JOptionPane.showConfirmDialog(null,
                                "Apakah anda yakin\nmenghapus data tersebut?", "HAPUS DATA", JOptionPane.YES_NO_OPTION);

                        if (selectedOption == JOptionPane.YES_OPTION) {
                            model_mahasiswa.deleteMahasiswa(dataterpilih);
                            updateTable();
                            viewFormRead.btnHapus.setEnabled(true);
                        }
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    System.out.println("Gagal Hapus!");
                }
            }
        });

        viewFormRead.btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try{
                    if(dataterpilih != null){
                        String dataEditNim = viewFormRead.tabel.getValueAt(baris,0).toString();
                        String dataEditNama = viewFormRead.tabel.getValueAt(baris,1).toString();
                        String dataEditAlamat = viewFormRead.tabel.getValueAt(baris,2).toString();

                        viewFormEdit = new ViewFormEdit();

                        viewFormRead.dispose();
                        viewFormEdit.tfnim.setText(dataEditNim);
                        viewFormEdit.tfnama.setText(dataEditNama);
                        viewFormEdit.tfalamat.setText(dataEditAlamat);
                        viewFormEdit.tfnim.setEditable(false);
                        viewFormEdit.btnEdit.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent ae) {
                                if(dataterpilih != null){
                                    model_mahasiswa.updateMahasiswa(
                                            viewFormEdit.getTfnim(),
                                            viewFormEdit.getTfnama(),
                                            viewFormEdit.getTfalamat());
                                    viewFormEdit.dispose();
                                    ViewFormRead viewFormRead1 = new ViewFormRead(4);
                                    new Controller_Mahasiswa(viewFormRead1,model_mahasiswa);
                                }
                            }
                        });

                        viewFormEdit.btnKembali.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                viewFormEdit.dispose();
                                ViewFormRead viewFormRead1 = new ViewFormRead(4);
                                new Controller_Mahasiswa(viewFormRead1,model_mahasiswa);
                            }
                        });

                    }
                }catch(Exception ex){
                    System.out.println(ex.getMessage());
                    System.out.println("Edit Gagal!");
                }
            }
        });

    }

    private void updateTable() {
        String dataMahasiswa[][] = model_mahasiswa.readMahasiswa();
        viewFormRead.tabel.setModel(new JTable(dataMahasiswa, viewFormRead.namaKolom).getModel());
    }

}
