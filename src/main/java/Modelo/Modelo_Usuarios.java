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
public class Modelo_Usuarios extends Modelo_Persona{
    private String Tipo_Doc;
    private int Tipo_user;
    private String Password;
    private String Correo;

    public Modelo_Usuarios(String Tipo_Doc, int Tipo_user, String Password, String Correo, int Id, String Nombre, String Apellido, int Cedula, Date Fecha_Nac) {
        super(Id, Nombre, Apellido, Cedula, Fecha_Nac);
        this.Tipo_Doc = Tipo_Doc;
        this.Tipo_user = Tipo_user;
        this.Password = Password;
        this.Correo = Correo;
    }

    public Modelo_Usuarios(String Tipo_Doc, int Tipo_user, String Password, String Correo) {
        this.Tipo_Doc = Tipo_Doc;
        this.Tipo_user = Tipo_user;
        this.Password = Password;
        this.Correo = Correo;
    }

    public Modelo_Usuarios() {
    }
    

    public String getTipo_Doc() {
        return Tipo_Doc;
    }

    public void setTipo_Doc(String Tipo_Doc) {
        this.Tipo_Doc = Tipo_Doc;
    }

    public int getTipo_user() {
        return Tipo_user;
    }

    public void setTipo_user(int Tipo_user) {
        this.Tipo_user = Tipo_user;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    
   
  
    
}
