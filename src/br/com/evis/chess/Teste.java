package br.com.evis.chess;

import javax.swing.*;

public class Teste {



    public static void main(String[] args) {

        int[][] tab = new int[8][8];
        int cont = 1;

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                tab[i][j] = cont;
                cont++;
            }
        }

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                System.out.print("["+tab[i][j]+"]");
            }
            System.out.println();
        }



    }
}
