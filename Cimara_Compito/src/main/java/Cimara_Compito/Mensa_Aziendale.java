/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cimara_Compito;

/**
 *
 * @author informatica
 */
public class Mensa_Aziendale {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        
        
        
        System.out.println("Mensa aperta.");
        
        for(int i = 0; i < 10; i++)
        {
            Dipendente a = new Dipendente();
            a.start();
        }
        
        for(int i = 0; i < 10; i++)
        {
            Dipendente a = new Dipendente();
            a.join();
        }
    }
    
}
