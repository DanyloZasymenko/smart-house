#include <Arduino.h>
#include <ArduinoJson.h>
#include <DHT.h>
#include <ESP8266WiFi.h>
#include <ESP8266WiFiMulti.h>
#include <ESP8266HTTPClient.h>
#define DHT_PIN 2
#define BLUE_SIGNAL 5
#define RED_SIGNAL 4
#define BUTTON_PIN 0
#define DHT_TYPE DHT11

ESP8266WiFiMulti WiFiMulti;

DHT dht(DHT_PIN, DHT_TYPE);
const String serial = "serial_228_1488";
const String host = "http://mplus.hopto.org:9090/arduino";
//const String host = "http://192.168.1.232:9090/arduino";
//const String host = "http://192.168.1.7:9090/arduino";
String scheduleUrl = host + "/confirm-activity/" + serial;
String checkUrl = host + "/check";
bool active = false;
int pin = -1;
bool status = false;

boolean fire = false;
boolean police = false;

void setup() {
  pinMode(BUTTON_PIN, INPUT);
  pinMode(BLUE_SIGNAL, OUTPUT);
  pinMode(RED_SIGNAL, OUTPUT);
  pinMode(15, OUTPUT);
  pinMode(16, OUTPUT);
  Serial.begin(115200);
  String payload;
  for(uint8_t t = 4; t > 0; t--) {
//      Serial.printf("[SETUP] WAIT %d...\n", t);
        Serial.flush();
        delay(1000);
    }
    WiFi.mode(WIFI_STA);
    WiFiMulti.addAP("m-plus-Guest", "15935746297");
//    WiFiMulti.addAP("krasavchik", "12345678");
//    WiFiMulti.addAP("UKrtelecom_92F8BA", "UKR_3436");
    dht.begin();
}

void loop() {
  alert();
  if(round(millis() / 1000) % 2 == 0){
    if((WiFiMulti.run() == WL_CONNECTED)) {
        HTTPClient http;
      if(round(millis() / 1000) % 15 == 0){    
        http.begin(scheduleUrl);
        int httpCode = http.GET();
        if(httpCode > 0) {            
            if(httpCode == HTTP_CODE_OK) {
                String scheduleResponse = http.getString();
                if(scheduleResponse == "true"){
                  active = true;
                } else {
                  active = false;
                }
            }
        http.end();
        }
      }
      if(active){   
        http.begin(checkUrl);
        Serial.print("[HTTP] GET...\n");
        int httpCode = http.GET();
        if(httpCode > 0) {
            Serial.printf("[HTTP] GET... code: %d\n", httpCode);
            Serial.println(httpCode);
            if(httpCode == HTTP_CODE_OK) {
                String checkResponse = http.getString();
                Serial.println(checkResponse);
                StaticJsonBuffer<200> jsonBuffer;
                JsonObject& root = jsonBuffer.parseObject(checkResponse);
                if (root.success()) {
                  pin = root["pin"];
                  Serial.println(pin);
                  status = root["active"]; 
                  Serial.println(status);
                  jsonBuffer.clear();
                } else
                  Serial.println("Problems...");
            }
        } else {
            Serial.printf("[HTTP] GET... failed, error: %s\n", http.errorToString(httpCode).c_str());
        }
      }
        http.end();
    }
  }
  sendTemperature();
  digitalWrite(pin, status);
}

void sendTemperature(){
  float h = dht.readHumidity();
  float t = dht.readTemperature();
  float f = dht.readTemperature(true);
  if (isnan(h) || isnan(t) || isnan(f)) {
    Serial.println("Failed to read from DHT sensor!");
//    return;
  }
  float hif = dht.computeHeatIndex(f, h);
  float hic = dht.computeHeatIndex(t, h, false);
  Serial.print("Humidity: ");
  Serial.print(h);
  Serial.print(" %\t");
  Serial.print("Temperature: ");
  Serial.print(t);
  Serial.print(" *C ");
  Serial.print(f);
  Serial.print(" *F\t");
  Serial.print("Heat index: ");
  Serial.print(hic);
  Serial.print(" *C ");
  Serial.print(hif);
  Serial.println(" *F");
  HTTPClient http;
  String temperatureUrl = host + "/send-temperature/" + h + "/" + t + "/" + f + "/" + hic + "/" + hif;
  http.begin(temperatureUrl);
  int httpCode = http.GET();
  if(httpCode == HTTP_CODE_OK) {
  Serial.println("send temperature");
  }
  http.end();
  checkTemperature(t);
}

void alert(){
  HTTPClient http;
  police = digitalRead(BUTTON_PIN);
  String checkAlert = host + "/check-alert";
  String alert = host + "/alert?fire=" + fire + "&police=" + police;
  if(police || fire){
    http.begin(alert);
    int httpCode = http.GET();
    if(httpCode == HTTP_CODE_OK) {
    }
    http.end();
  }
  http.begin(checkAlert);
  int httpCode = http.GET();
  if(httpCode == HTTP_CODE_OK) {
    String checkResponse = http.getString();
    Serial.println(checkResponse);
    StaticJsonBuffer<200> jsonBuffer;
    JsonObject& root = jsonBuffer.parseObject(checkResponse);
    if (root.success()) {
      fire = root["fire"];
      Serial.println(fire);
      police = root["police"]; 
      Serial.println(police);
      jsonBuffer.clear();
    } else
    Serial.println("Problems...");
  }
  http.end();
  if(fire){
    if(round(millis() / 500) % 2 == 0)
      digitalWrite(RED_SIGNAL, HIGH);
    else
      digitalWrite(RED_SIGNAL, LOW);
  }
  if(police){
    if(round(millis() / 500) % 2 == 0) {
      digitalWrite(RED_SIGNAL, HIGH);
      digitalWrite(BLUE_SIGNAL, LOW);
    } else {
      digitalWrite(RED_SIGNAL, LOW);
      digitalWrite(BLUE_SIGNAL, HIGH);
    }
  }
  if(!fire && !police){
    digitalWrite(RED_SIGNAL, LOW);
    digitalWrite(BLUE_SIGNAL, LOW);
  }
}

void checkTemperature(float t){
  if(t >= 65.0){
    fire = true;
  } else {
    fire = false; 
  }
}
