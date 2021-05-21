package com.wyvern.wyvern;



import com.wyvern.wyvern.service.TraduceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class HolaMundo {
   @RequestMapping("/")
   public String saludar(){
       return "Esta es tu primera página web backend";
   }
 
   @RequestMapping("/despidete")
   public String despidete(){
       return "Adios amigo";
   }

   @GetMapping("/saludame/{nombre}")
   public String saludame(@PathVariable String nombre){
       return "Hola que tal " + nombre;
   }

   @GetMapping("/contar/{palabra}")
   public String contar(@PathVariable String palabra){
    char[] vocales ={'a','e','i','o','u'};
    char[] consonantes={'b','c','d','f','g','h','j','k','l','m','n',
                        'ñ','q','r','s','t','v','w','x','y','z'};
    int numeroVocales=0;
    int numeroConsonantes=0;
    for(int i=0;i<palabra.length();i++){
            for(int j=0 ; j<vocales.length ;j++){
                if(palabra.charAt(i) == vocales[j]){
                    numeroVocales++;

                }

            }

            for(int j=0 ; j<consonantes.length;j++){
                if(palabra.charAt(i) == consonantes[j]){
                    numeroConsonantes++;

                }

            }
    }
    return ("Vocales("+numeroVocales+")"+"\n"+"Consonantes("+numeroConsonantes+")");

   }



   @GetMapping("/{word}")
   public String transforma(@PathVariable String word){
    return word.replaceAll("ñ","ni");
    

   }

   @Autowired
   TraduceService traduceService;

   @GetMapping("/traduce")
        public String traduce(){
            String texto = traduceService.getTexto();
            return "Palabra traducida: "+texto;
        }
    


   

}


