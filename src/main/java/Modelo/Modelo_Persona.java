/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author joimar
 */
public class Modelo_Persona {
     private int  Id;
     private String Nombre;
     private String Apellido;
     private int Cedula;
     private Date Fecha_Nac;
     

    public Modelo_Persona(int Id, String Nombre, String Apellido, int Cedula, Date Fecha_Nac) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Cedula = Cedula;
        this.Fecha_Nac = Fecha_Nac;
        
    }

    public Modelo_Persona() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public int getCedula() {
        return Cedula;
    }

    public void setCedula(int Cedula) {
        this.Cedula = Cedula;
    }

    public Date getFecha_Nac() {
        return Fecha_Nac;
    }

    public void setFecha_Nac(Date Fecha_Nac) {
        this.Fecha_Nac = Fecha_Nac;
    }
    
 
     
     
}
