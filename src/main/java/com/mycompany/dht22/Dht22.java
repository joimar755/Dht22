/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.dht22;

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
       try {
            // Paso 1: abrir el puerto (9600 baudios igual que en tu sketch de Arduino/ESP32)
            arduino.arduinoTX("ttyUSB0", 9600);

            // Paso 2: enviar datos DESPUÉS de que el puerto esté abierto
            Thread.sleep(2000); // espera pequeña para que el ESP32 reinicie el puerto
            arduino.sendData("1"); // por ejemplo, encender LED
            System.out.println("Dato enviado al Arduino");

            Thread.sleep(2000);
            arduino.sendData("0"); // apagar LED
            System.out.println("Dato enviado al Arduino");

        } catch (ArduinoException | SerialPortException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
