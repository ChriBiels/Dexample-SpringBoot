package com.wyvern.wyvern.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
 
@Service
public class TraduceService {
 
   @Autowired
   RestTemplate restTemplate;
 
   public String getTexto(){
       String url = "https://api.mymemory.translated.net/get?q=";
       ResponseData json = restTemplate.getForObject(url, ResponseData.class );
       return json.translatedText;
   }
}
 

class ResponseData{
    public String translatedText;
 }
 
