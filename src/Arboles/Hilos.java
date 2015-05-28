package Arboles;
import Listas.NodoLUrl;
import java.io.File;
import logica.LectorPDF;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Gustavo
 */
public class Hilos {

public static void main(String[] args) {
   Threads.DireccionArchivoAProcesar = 
           "D:\\Users\\Gustavo\\Desktop\\2014098445-CE1103-20​15-01-R9.pdf";
   Thread test1 = new Thread(new Threads());
test1.start();
    //Threads.DireccionArchivoAProcesar = 
     //      "D:\\Users\\Gustavo\\Desktop\\2014098445-CE1103-20​15-01-R10.pdf";    
    //Thread test2 = new Thread(new Threads());
//test2.start();        
    }
    
    
    /*KeywordsyRepeticiones.print();
    String[] Arreglo = { 
        "D:\\Users\\Gustavo\\Desktop\\r4.docx",
        "D:\\Users\\Gustavo\\Desktop\\r5.docx",
        "D:\\Users\\Gustavo\\Desktop\\guantera.docx",
        "D:\\Users\\Gustavo\\Desktop\\Galaxy Tab 3 8.docx"
    };
    CreaciondeHeapPorTamanoDeDocumentos perro = new CreaciondeHeapPorTamanoDeDocumentos(Arreglo);
    }
    //System.out.println(file);
    
  
    /*Heap nuevo= new Heap();
        nuevo.insert("1");
        nuevo.insert("5");
        nuevo.insert("10");
        nuevo.insert("2");
        nuevo.print();*/
    }
   
   

