/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cimara_Compito;

import java.util.concurrent.Semaphore;
import java.util.Random;

/**
 *
 * @author informatica
 */
public class Cuoco extends Thread{
    
    Semaphore vuoto = new Semaphore(0);
    Semaphore pieno = new Semaphore(1);
    private int piatto = 0;
    private Dipendente a = new Dipendente();
    
    private Bancone n = new Bancone();
    
    public void aggiungiPiatto()
    {
        piatto++;
        
         try {
            vuoto.acquire();
            System.out.println("Il piatto nr. " + piatto + " è pronto: ");
            n.aggiungiPiatto();
            
            sleep((int) (Math.random() * 30));
            
            a.ammetti();
            
        } catch (InterruptedException ex) {
        }
        pieno.release();
    }
    
    public void rilasciaPiatto()
    {
        try {
            pieno.acquire();
            n.rimuoviPiatto();
        } catch (InterruptedException ex) {
        }
        vuoto.release();
    }
    
    @Override
    public void run()
    {
        aggiungiPiatto();
    }
}
