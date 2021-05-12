/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cimara_Compito;

import java.util.concurrent.Semaphore;

/**
 *
 * @author informatica
 */
public class Dipendente extends Thread{
    Semaphore vuoto = new Semaphore(1);
    Semaphore pieno = new Semaphore(0);
    
    private int consumi = 0;
    
    protected Bancone n = new Bancone();
      
    public void ammetti() throws InterruptedException{
        consumi++;
        
        vuoto.acquire();
        n.rimuoviPiatto();
        System.out.println("Consumi: " + consumi);
        pieno.release();
    }
    
    public void nega() throws InterruptedException{
        pieno.acquire();
        System.out.println();
        vuoto.release();
    }

}
