/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg19710100_bi;

/**
 *
 * @author ASUS ROG
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String Spectacleprescription="Hypermetrope";
        String Age="Young";
        String Tearproductionrate="Reduce";
        String Contactlenses="No Lens";
        
        
        bayes bys = new bayes();
        
        double yes = bys.JumlahYes(Spectacleprescription, Age, Tearproductionrate, Contactlenses);
        double no = bys.JumlahNo(Spectacleprescription, Age, Tearproductionrate, Contactlenses);
        
        System.out.println("P(Spectacleprescription=Hypermetrope|astigmatic=Yes)"+ bys.spectacleprescriptionYES("Hypermetrope"));
        System.out.println("P(Spectacleprescription=Hypermetrope|astigmatic=No)"+ bys.spectacleprescriptionNO("Hypermetrope"));
        System.out.println("P(Spectacleprescription=Myope|astigmatic=Yes)"+ bys.spectacleprescriptionYES("Myope"));
        System.out.println("P(Spectacleprescription=Myope|astigmatic=No)"+ bys.spectacleprescriptionNO("Myope"));
        
        System.out.println("P(Age=Pre-Presbyopic|astigmatic=Yes)"+ bys.ageYES("Pre-Presbyopic"));
        System.out.println("P(Age=Pre-Presbyopic|astigmatic=No)"+ bys.ageNO("Pre-Presbyopic"));
        System.out.println("P(Age=Young|astigmatic=Yes)"+ bys.ageYES("Young"));
        System.out.println("P(Age=Young|astigmatic=No)"+ bys.ageNO("Young"));
        System.out.println("P(Age=Presbyopic|astigmatic=Yes)"+ bys.ageYES("Presbyopic"));
        System.out.println("P(Age=Presbyopic|astigmatic=No)"+ bys.ageNO("Presbyopic"));
        
        System.out.println("P(Tearproductionrate=Reduce|astigmatic=Yes)"+ bys.tearproductionrateYES("Reduce"));
        System.out.println("P(Tearproductionrate=Reduce|astigmatic=No)"+ bys.tearproductionrateNO("Reduce"));
        System.out.println("P(Tearproductionrate=Normal|astigmatic=Yes)"+ bys.tearproductionrateYES("Normal"));
        System.out.println("P(Tearproductionrate=Normal|astigmatic=No)"+ bys.tearproductionrateNO("Normal"));
        
        System.out.println("P(Contactlenses=No Lens|astigmatic=Yes)"+ bys.contactlensesYES("No Lens"));
        System.out.println("P(Contactlenses=No Lens|astigmatic=No)"+ bys.contactlensesNO("No Lens"));
        System.out.println("P(Contactlenses=Hard|astigmatic=Yes)"+ bys.contactlensesYES("Hard"));
        System.out.println("P(Contactlenses=Hard|astigmatic=No)"+ bys.contactlensesNO("Hard"));
        System.out.println("P(Contactlenses=Soft|astigmatic=Yes)"+ bys.contactlensesYES("Soft"));
        System.out.println("P(Contactlenses=Soft|astigmatic=No)"+ bys.contactlensesNO("Soft"));
        
        
        if (yes>no){
            System.out.println("Hasil Prediksi Yes");
        }else{
            System.out.println("Hasil Prediksi No");
        }
         
    }
    
}
