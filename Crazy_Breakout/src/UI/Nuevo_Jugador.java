/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.io.*;
import java.net.Socket;
import java.util.logging.*;
import java.util.*;

/**
 *
 * @author gustavohg
 */
class Nuevo_Jugador extends Thread{
    protected Socket sk;
    protected DataOutputStream dos;
    protected DataInputStream dis;
    private final int id;
    
    /**
     * 
     * @param id 
     */
    public Nuevo_Jugador(int id) {
        this.id = id;
    }
    
    /**
     * 
     */
    @Override
    public void run() {
        try {
            sk = new Socket("127.0.0.1", 8080);
            dos = new DataOutputStream(sk.getOutputStream());
            dis = new DataInputStream(sk.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(Nuevo_Jugador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 
     */
    public void close() {
        try {
            dis.close();
            dos.close();
            sk.close();
        } catch (IOException ex) {
            Logger.getLogger(Nuevo_Jugador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 
     * @throws IOException 
     */
    public void leer() throws IOException{
        String e;
        e = dis.readUTF();
        System.out.println("Servidor >>> "+e);
    }
    
    
}