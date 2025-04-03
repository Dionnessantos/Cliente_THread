/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sd.clientethreadform270325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author Dionnes
 */
public class GerenciarConexao extends Thread {
    private Socket conexao;
    private TelaClienteThread form;
    
    public GerenciarConexao(Socket conexao, TelaClienteThread form) {
        this.conexao = conexao;
        this.form = form;
    }
    
    @Override
     public void run() {


        try {
            BufferedReader entrada = new BufferedReader(
                new InputStreamReader(conexao.getInputStream()));
        String linha = "";
        //String conversa = "";

        while (true) {
            linha = linha + entrada.readLine();
            if (linha == null) {
                System.out.println("Conexao Encerrada!!!");
                break;
            }
            //conversa = conversa+linha+"\n";
            linha = linha+"\n";
            form.getTextAreaMensagem().setText(linha);
          
        }
    }
    catch(IOException ex){
        ex.printStackTrace();
    }
   
    }
    
    
    
}
