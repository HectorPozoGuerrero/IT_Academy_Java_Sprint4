package Controllers;

public class HelloWorldController {

    @GetMapping("/HelloWorld")
    public String saluda(@RequestParam(name = "nom", defaultValue = "UNKNOWN") String nom){
        return "Hola, " + nom + ". Estàs executant un projecte Maven";
    }

    @GetMapping(value = {"/HelloWorld2", "/HelloWorld2/{nom}"})
    public String saluda2(@PathVariable(name = "nom", required = false) String nom){
        if (nom == null) {
            nom = "UNKNOWN";
        }
        return "Hola, " + nom + ". Estàs executant un projecte Maven";
    }
}
