package com.wyvern.wyvern;


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
}
