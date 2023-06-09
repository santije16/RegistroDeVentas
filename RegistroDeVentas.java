/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicios;

import java.util.Scanner;

/**
 *
 * @author Santiago Jimenez Escobar
 * El templo de la ropa
Registro de ventas
El templo de la ropa requiere realizar un algoritmo para el registro de ventas y decide
contratar con usted para su desarrollo.
El almacén únicamente vende tres productos (camisas, pantalones y gorras) a sus clientes.
Cada producto tiene un valor determinado que debe ser ingresado por teclado (almacenar
en un vector).
Cada día (lunes a viernes) se vende una cantidad por cada producto (debe ser ingresado
por teclado la cantidad vendida de cada producto por día y almacenar en una matriz).
Se requiere determinar el valor de venta de cada producto en la semana (almacenar en otro
vector).
El algoritmo que desarrolle debe:(usar ciclos)
* Almacenar el valor de los productos y la cantidad vendida en la semana de acuerdo a la
descripción del problema. (1 punto).
* Hallar el valor de la venta total de cada producto al final de la semana. (2 puntos).
* Hallar el producto más vendido ($) de la semana, indicando su nombre y el valor vendido
(1 punto).
* El usuario ingresa el día de la semana y el algoritmo calcula el promedio de unidades
vendidas de todos los productos (camisas, pantalones, gorras) de ese día. (1 punto).
 */
public class RegistroDeVentas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String productos[] = new String[3];
        int valorProductos[] = new int[3];
        productos[0] = "camisas";
        productos[1] = "pantalones";
        productos[2] = "gorras";
        String diaSemana[] = new String[5];
        diaSemana[0] = "Lunes";
        diaSemana[1] = "Martes";
        diaSemana[2] = "Miercoles";
        diaSemana[3] = "Jueves";
        diaSemana[4] = "Viernes";
        int cantidadProductos[][] = new int[3][5];
        int valorVentaCadProXSemana [] = new int[3];
        int f, c, i, sumaCantidadCamisas=0, sumaCantidadPantalones=0, sumaCantidadGorras=0, 
                valorProdMasVendido=0, diaAValidar, sumaCantidadVendida=0;
        double promedio=0;
        String nombreProdMasVendido=""; 
        
        //Almacenar el valor de los productos
        for (i=0; i<valorProductos.length; i++) {
            System.out.println("Ingrese el valor del producto "+productos[i]);
            valorProductos[i] = sc.nextInt();
        }
        
        //Almacenar la cantidad vendida de cada producto por cada dia de la semana
        for (f=0; f<cantidadProductos.length; f++) {
            for (c=0; c<cantidadProductos[0].length; c++) {
                System.out.println("Ingrese la cantidad vendida de "+productos[f]+" "
                        + "el dia "+diaSemana[c]);
                cantidadProductos[f][c] = sc.nextInt();
            }
        }
        
        //Hallar el valor de la venta total de cada producto al final de la semana
        for (f=0; f<cantidadProductos.length; f++) {
            for (c=0; c<cantidadProductos[0].length; c++) {
                if(f==0) {
                    sumaCantidadCamisas = sumaCantidadCamisas+cantidadProductos[f][c];
                }
                if (f==1) {
                    sumaCantidadPantalones = sumaCantidadPantalones+cantidadProductos[f][c];
                }
                if (f==2) {
                    sumaCantidadGorras = sumaCantidadGorras+cantidadProductos[f][c];
                }
            }
        }
        for (i=0; i<valorVentaCadProXSemana.length; i++) {
            if (i==0) {
                valorVentaCadProXSemana[i] = sumaCantidadCamisas*valorProductos[i];
            }
            if (i==1) {
                valorVentaCadProXSemana[i] = sumaCantidadPantalones*valorProductos[i];
            }
            if (i==2) {
                valorVentaCadProXSemana[i] = sumaCantidadGorras*valorProductos[i];
            }
        }
        
        //* Hallar el producto más vendido ($) de la semana, indicando su nombre y el valor vendido
        valorProdMasVendido=valorVentaCadProXSemana[0];
        for (i=0; i<valorVentaCadProXSemana.length; i++) {
            if (valorVentaCadProXSemana[i]>=valorProdMasVendido) {
                valorProdMasVendido = valorVentaCadProXSemana[i];
                nombreProdMasVendido = productos[i];
            }
        }
        
        //* El usuario ingresa el día de la semana y el algoritmo calcula el promedio de unidades
        //vendidas de todos los productos (camisas, pantalones, gorras) de ese día.
        i=0;
        while (i<1 || i>5) {
            System.out.println("Ingresa el dia de la semana para consultar el "
                + "promedio de unidades vendidas de todos los productos"
                + "\n1. Para Lunes \n2. Para Martes \n3. Para Miercoles \n4. Para Jueves"
                + "\n5. Para Viernes"  );
            i=sc.nextInt();
            if (i<1 || i>5) {
                System.out.println("El numero ingresado no es valido");
            }
        }
        diaAValidar = (i-1);
        for (f=0; f<cantidadProductos.length; f++) {
            for (c=0; c<cantidadProductos[0].length; c++) {
                if(diaAValidar==c) {
                    sumaCantidadVendida = sumaCantidadVendida+cantidadProductos[f][c];
                }
            }
        }
        
        // Mostrar datos en pantalla
        for (f=0; f<cantidadProductos.length; f++) {
            for (c=0; c<cantidadProductos[0].length; c++) {
                System.out.print(cantidadProductos[f][c]+"\t");
            }
            System.out.print("\n");
        }
        System.out.println();
        
        promedio=(double) sumaCantidadVendida/3;
        for (i=0; i<valorVentaCadProXSemana.length; i++) {
            System.out.println("La venta total de "+productos[i]+" en la semana fue de "+valorVentaCadProXSemana[i]);
        }
        System.out.println("El promedio de productos vendidos el dia "+diaSemana[diaAValidar]+" "
                + "fue de "+promedio);
        System.out.println("El producto mas vendido de la semana fue "+nombreProdMasVendido+" "
                + "con un valor de "+valorProdMasVendido);
    }
}
