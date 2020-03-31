package com.praktikum;

import javax.swing.*;
import java.sql.*;

public class Model_Mahasiswa {
    //koneksi db
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/praktikum?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";//nama database
    static final String DB_USER = "root";
    static final String DB_PASS = "";

    Connection koneksi;
    Statement statement; //Untuk mengambil query

    public Model_Mahasiswa(){
        try{
            Class.forName(JDBC_DRIVER);
            koneksi=(Connection) DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
        }catch(SQLException ex){
            System.err.println("Gagal koneksi");
        }catch (ClassNotFoundException ex){
            System.err.println(ex);
        }
    }

    public void insertMahasiswa(String nim,String nama,String alamat){
        try{
            String query = "INSERT INTO `mahasiswa`(`nim`, `nama`, `alamat`) VALUES ('"+nim+"','"+nama+"','"+alamat+"')";
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query);//Mengubah isi tabel
            JOptionPane.showMessageDialog(null, "Data Berhasil disimpan!");
        } catch (SQLException sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public int getBanyakData(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "Select * from `mahasiswa`";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jmlData++;
            }
            return jmlData;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }

    public String[][] readMahasiswa(){
        try{
            int jmlData=0;
            String data[][] = new String[getBanyakData()][3];
            String query = "Select * from `mahasiswa`";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("nim");
                data[jmlData][1] = resultSet.getString("nama");
                data[jmlData][2] = resultSet.getString("alamat");
                jmlData++;
            }
            return data;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }

    public void deleteMahasiswa(String nim){
        try{
            String query = "DELETE FROM `mahasiswa` WHERE `nim` = '"+nim+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");

        }catch(SQLException sql){
            System.out.println(sql.getMessage());
        }

    }

    public void updateMahasiswa(String nim, String nama, String alamat){
        try{
            statement = koneksi.createStatement();
            String query = "UPDATE `mahasiswa` SET `nim`='"+nim+"',`nama`='"+nama+"',`alamat`='"+alamat+"' WHERE `nim` = '"+nim+"'";
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Edit Data Sukses!");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

}
