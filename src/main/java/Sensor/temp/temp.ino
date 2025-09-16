#include "DHT.h"
#include <Wire.h>
#define DHTPIN 33
#define DHTTYPE DHT22
#include <LiquidCrystal_PCF8574.h>

//DHTTYPE = DHT11, but there are also DHT22 and 21
LiquidCrystal_PCF8574 lcd(0x3F);
DHT dht(DHTPIN, DHTTYPE);  // constructor to declare our sensor

unsigned long tiempo2 = 0;

int LED1 = 27;
int LED2 = 26;
int LED3 = 25;


const int BTN1 = 13;
const int BTN2 = 12;
const int BTN3 = 14;

bool lastBtn1 = LOW;
bool lastBtn2 = LOW;
bool lastBtn3 = LOW;

bool statusE1 = false, statusE2 = false, statusE3 = false;

void actualizarLCD() {
  lcd.clear();
  lcd.setCursor(0, 0);
  lcd.print("LD1:");
  lcd.print(statusE1 ? "ON" : "OFF");
  lcd.setCursor(9, 0);
  lcd.print("LD2:");
  lcd.print(statusE2 ? "ON" : "OFF");
  lcd.setCursor(0, 1);
  lcd.print("LD3:");
  lcd.print(statusE3 ? "ON" : "OFF");
}

void setup() {
  Serial.begin(9600);
  dht.begin();
  Wire.begin(21, 22);  // SDA = 19, SCL = 18 en ESP32

  lcd.begin(16, 2);
  lcd.setBacklight(255);
  lcd.clear();
  pinMode(LED1, OUTPUT);
  pinMode(LED2, OUTPUT);
  pinMode(LED3, OUTPUT);
  pinMode(BTN1, INPUT);
  pinMode(BTN2, INPUT);
  pinMode(BTN3, INPUT);

  digitalWrite(LED1, LOW);
  digitalWrite(LED2, LOW);
  digitalWrite(LED3, LOW);


  actualizarLCD();
}
void myFunction() {
  float h = dht.readHumidity();
  float t = dht.readTemperature();
  if (isnan(h) || isnan(t)) {
    lcd.print("Failed reception");
    return;
    //Returns an error if the ESP32 does not receive any measurements
  }
  lcd.clear();
  lcd.setCursor(0, 0);
  lcd.print("Temp: ");
  lcd.print(t);
  lcd.setCursor(0, 1);
  lcd.print("Hum: ");
  lcd.print(h);
  lcd.print("%");
}
void Led() {
  if (Serial.available() > 0) {
    char dato = Serial.read();  // Leer el dato enviado desde Java

    if (dato == '1') {
      if (!statusE1) {  // solo enciende si estaba apagado
        statusE1 = true;
        digitalWrite(LED1, HIGH);
        Serial.println("LED1 ENCENDIDO");
        actualizarLCD();
      }
    } else if (dato == '0') {
      if (statusE1) {  // solo apaga si estaba encendido
        statusE1 = false;
        digitalWrite(LED1, LOW);
        Serial.println("LED1 APAGADO");
        actualizarLCD();
      }
    } else if (dato == '2') {
      if (!statusE2) {
        statusE2 = true;
        digitalWrite(LED2, HIGH);
        Serial.println("LED2 ENCENDIDO");
        actualizarLCD();
      }
    } else if (dato == '3') {
      if (statusE2) {  // solo apaga si estaba encendido
        statusE2 = false;
        digitalWrite(LED2, LOW);
        Serial.println("LED2 APAGADO");
        actualizarLCD();
      }
    } else if (dato == '4') {
      if (!statusE3) {  //
        statusE3 = true;
        digitalWrite(LED3, HIGH);
        Serial.println("LED3 ENCENDIDO");
        actualizarLCD();
      }
    } else if (dato == '5') {
      if (statusE3) {  // solo apaga si estaba encendido
        statusE3 = false;
        digitalWrite(LED3, LOW);
        Serial.println("LED3 APAGADO");
        actualizarLCD();
      }
    }
  }
}
void loop() {
  Led();
  bool currentBtn1 = digitalRead(BTN1);
  if (lastBtn1 == HIGH && currentBtn1 == LOW) {  // transición ALTO → BAJO (pulsado)
    statusE1 = !statusE1;                        // cambiar estado del LED
    digitalWrite(LED1, statusE1);
    Serial.println(statusE1 ? "LED1 ENCENDIDO" : "LED1 APAGADO");
    actualizarLCD();
    delay(50);  // antirrebote
  }
  lastBtn1 = currentBtn1;

  // --- BOTÓN 2 ---
  bool currentBtn2 = digitalRead(BTN2);
  if (lastBtn2 == HIGH && currentBtn2 == LOW) {
    statusE2 = !statusE2;
    digitalWrite(LED2, statusE2);
    Serial.println(statusE2 ? "LED2 ENCENDIDO" : "LED2 APAGADO");
    actualizarLCD();
    delay(50);
  }
  lastBtn2 = currentBtn2;

  // --- BOTÓN 3 ---
  bool currentBtn3 = digitalRead(BTN3);
  if (lastBtn3 == HIGH && currentBtn3 == LOW) {
    statusE3 = !statusE3;
    digitalWrite(LED3, statusE3);
    Serial.println(statusE3 ? "LED3 ENCENDIDO" : "LED3 APAGADO");
    actualizarLCD();
    delay(50);
  }
  lastBtn3 = currentBtn3;


  if (millis() - tiempo2 >= 5000) {
    float h = dht.readHumidity();
    float t = dht.readTemperature();
    float f = dht.readTemperature(true);

    if (isnan(h) || isnan(t) || isnan(f)) {
      Serial.println("Failed reception");
      return;
    }

    Serial.print("Temperatura:");
    Serial.print(t);
    Serial.print(";");
    Serial.print("Humedad:");
    Serial.println(h);
  }

  if (millis() - tiempo2 >= 5000) {
    tiempo2 = millis();
    myFunction();
  }






  //myFunction();


  // Transmits the measurements received in the serial monitor
}