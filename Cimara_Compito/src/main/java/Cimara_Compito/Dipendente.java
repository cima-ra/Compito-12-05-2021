/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cimara_Compito;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author informatica
 */
public class Dipendente extends Thread{
    Semaphore vuoto = new Semaphore(1);
    Semaphore pieno = new Semaphore(0);
    
    private int consumi;
    
    private final Cuoco m = new Cuoco();
 
      
    public void ammetti() throws InterruptedException{
        consumi++;
        m.aggiungiPiatto();
        vuoto.acquire();
        System.out.println("Consumi: " + consumi);
        pieno.release();
    }
    
    public void nega() throws InterruptedException{
        pieno.acquire();
        System.out.println();
        vuoto.release();
    }
    
    @Override
    public void run()
    {
        try {
            ammetti();
        } catch (InterruptedException ex) {
            Logger.getLogger(Dipendente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
