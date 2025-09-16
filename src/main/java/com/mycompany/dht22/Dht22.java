/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.dht22;

import Controlador.Controlador_Usuarios;
import Modelo.Modelo_Usuarios;
import Modelo.Sql_usuarios;
import Modelo.hash;
import Vista.Registro_usuarios;
import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import jssc.SerialPortException;

/**
 *
 * @author joimar
 */
public class Dht22 {
    static PanamaHitek_Arduino arduino = new PanamaHitek_Arduino();

    public static void main(String[] args) {
       Registro_usuarios r = new Registro_usuarios();
        
        Modelo_Usuarios users = new Modelo_Usuarios();
        Sql_usuarios consulta = new Sql_usuarios();
       
        hash encrypt = new hash();       
        
        
        Controlador_Usuarios controlador = new Controlador_Usuarios(r, users, consulta, encrypt);
        controlador.iniciar();
        r.setVisible(true);
        
    }
}
