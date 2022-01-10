/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg19710100_bi;

import java.sql.*;
import javax.swing.JOptionPane;/**
 *
 * @author ASUS ROG
 */
public class bayes {
    private String url ="jdbc:mysql://localhost:3306/csv_db";
    private String username="root";
    private String password="";
    
    
    public bayes(){}
    
    public Connection KoneksiDatabase() throws SQLException{
        try {
            
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.toString() );
        }
        
        return DriverManager.getConnection(url, username, password);
    }
    
    
    public double getJumlahData(){
        int jumlah = 0;
        
        try {
            Statement perintah = KoneksiDatabase().createStatement();
            ResultSet data = perintah.executeQuery("SELECT*FROM lenses ");
            while (data.next()) {                
              jumlah++;  
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
        
        return jumlah;
    }
    public double getJumlahYes(){
        int jumlah = 0;
        try {
            Statement perintah = KoneksiDatabase().createStatement();
            ResultSet data = perintah.executeQuery("SELECT*FROM lenses WHERE astigmatic='yes' ");
            while (data.next()) {                
              jumlah++;  
            }  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
        return jumlah ;
    }
    public double getJumlahNo(){
        int jumlah = 0;
        try {
            Statement perintah = KoneksiDatabase().createStatement();
            ResultSet data = perintah.executeQuery("SELECT*FROM lenses WHERE astigmatic='no' ");
            while (data.next()) {                
              jumlah++;  
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return jumlah;
    }
    
    public double FatkaYes(){
      
      return getJumlahYes()/getJumlahData();
    }  
    
    public double FaktaNo(){
        
      
        return getJumlahNo()/getJumlahData();
    }

public double spectacleprescriptionYES(String value){
        double jumlah = 0;
        try {
            Statement perintah = KoneksiDatabase().createStatement();
            ResultSet data = perintah.executeQuery("SELECT*FROM lenses WHERE spectacleprescription='"+value+"' AND astigmatic='Yes'");
            while (data.next()) {                
                jumlah++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
        return (jumlah/getJumlahData())/FatkaYes();
    }
public double spectacleprescriptionNO(String value){
        double jumlah = 0;
        try {
            Statement perintah = KoneksiDatabase().createStatement();
            ResultSet data = perintah.executeQuery("SELECT*FROM lenses WHERE spectacleprescription='"+value+"' AND astigmatic='No'");
            while (data.next()) {                
                jumlah++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
        return (jumlah/getJumlahData())/FaktaNo();
    }

    
public double ageYES(String value){
        double jumlah = 0;
        try {
            Statement perintah = KoneksiDatabase().createStatement();
            ResultSet data = perintah.executeQuery("SELECT*FROM lenses WHERE age='"+value+"' AND astigmatic='Yes'");
            while (data.next()) {                
                jumlah++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
        return (jumlah/getJumlahData())/FatkaYes();
    }
      
     public double ageNO(String value){
        double jumlah = 0;
        try {
            Statement perintah = KoneksiDatabase().createStatement();
            ResultSet data = perintah.executeQuery("SELECT*FROM lenses WHERE age='"+value+"' AND astigmatic='No'");
            while (data.next()) {                
                jumlah++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
        return (jumlah/getJumlahData())/FaktaNo();
    }
     
     
     public double tearproductionrateYES(String value){
        double jumlah = 0;
        try {
            Statement perintah = KoneksiDatabase().createStatement();
            ResultSet data = perintah.executeQuery("SELECT*FROM lenses WHERE tearproductionrate='"+value+"' AND astigmatic='Yes'");
            while (data.next()) {                
                jumlah++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
        return (jumlah/getJumlahData())/FatkaYes();
    }
     
     
    public double tearproductionrateNO(String value){
        double jumlah = 0;
        try {
            Statement perintah = KoneksiDatabase().createStatement();
            ResultSet data = perintah.executeQuery("SELECT*FROM lenses WHERE tearproductionrate='"+value+"' AND astigmatic='No'");
            while (data.next()) {                
                jumlah++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
        return (jumlah/getJumlahData())/FaktaNo();
    }
    
    public double contactlensesYES(String value){
        double jumlah = 0;
        try {
            Statement perintah = KoneksiDatabase().createStatement();
            ResultSet data = perintah.executeQuery("SELECT*FROM lenses WHERE contactlenses='"+value+"' AND astigmatic='Yes'");
            while (data.next()) {                
                jumlah++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
        return (jumlah/getJumlahData())/FatkaYes();
    }
    
    
     public double contactlensesNO(String value){
        double jumlah = 0;
        try {
            Statement perintah = KoneksiDatabase().createStatement();
            ResultSet data = perintah.executeQuery("SELECT*FROM lenses WHERE contactlenses='"+value+"' AND astigmatic='No'");
            while (data.next()) {                
                jumlah++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
        return (jumlah/getJumlahData())/FaktaNo();
    }
     
     
    public Double JumlahYes(String Spectacleprescription,String Age, String Tearproductionrate, String Contactlenses){
        return FatkaYes()*spectacleprescriptionYES(Spectacleprescription)*ageYES(Age)*tearproductionrateYES(Tearproductionrate)*contactlensesYES(Contactlenses);
    }
    
    public Double JumlahNo(String Spectaclerescription,String Age, String Tearproductionrate, String Contactlenses){
        return FaktaNo()*spectacleprescriptionNO(Spectaclerescription)*ageNO(Age)*tearproductionrateNO(Tearproductionrate)*contactlensesNO(Contactlenses);
    }
}
