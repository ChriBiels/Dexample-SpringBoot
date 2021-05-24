package com.wyvern.wyvern;



import java.util.Map;

import com.wyvern.wyvern.model.DatosModel;
import com.wyvern.wyvern.service.DatosBDService;
import com.wyvern.wyvern.service.TraduceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class HolaMundo {
    @Autowired
    DatosBDService datosBDService;


   @RequestMapping("/")
   public String saludar(){
       return "Elige las rutas a usar"
       +"      "+"/contar/PALABRA"
       +"      "+"/PALABRA"
       +"      "+"/traduce/Palabra"
       +"      "+"/contar/PALABRA";
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


   @GetMapping("/traduce/{word}")
        public String traduce(){
            String texto = traduceService.getTexto();
            return "Palabra traducida: "+texto;
        }
    


    @GetMapping("/listar")
    public String datos() {
        return datosBDService.obtenerDatos().toString();
    }


    @PostMapping("/guarda/formulario")
    public String guardarDato(@RequestParam Map<String, String> body) {
        DatosModel datos = new DatosModel();
        datos.setUsuario(body.get("usuario"));
        datos.setNombre(body.get("nombre"));
        datos.setApellido(body.get("apellido"));
        datos.setEdad(Integer.parseInt(body.get("edad")));
        datos.setPais(body.get("pais"));
        datos.setTelefono(Integer.parseInt(body.get("telefono")));
        datosBDService.guardarDatosModel(datos);
        return "Se ha guardado el formulario";
    }


    @RequestMapping("/formularDatos")
    public String formularDatos() {
        return "formularioDatos";
    }
 
    
    @PostMapping("/guardaManual/{usuario}&{nombre}&{apellido}&{edad}&{pais}&{telefono}")
    public String guardarManual(@RequestParam String usuario, String nombre, String apellido, int edad, String pais, int telefono) {
        DatosModel datos = new DatosModel();
        datos.setUsuario(usuario);
        datos.setNombre(nombre);
        datos.setApellido(apellido);
        datos.setEdad(edad);
        datos.setPais(pais);
        datos.setTelefono(telefono);
        datosBDService.guardarDatosModel(datos);
        return "Los datos han sido guardados de forma manual";
    }

   

}


