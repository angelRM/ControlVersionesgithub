package ejercicios;

class Pizza {
    private String masa = "";
    private String salsa = "";
    private String relleno = "";
 
    public void setMasa(String masa)     { this.masa = masa; }
    public void setSalsa(String salsa)     { this.salsa = salsa; }
    public void setRelleno(String relleno) { this.relleno = relleno; }
}
 
 
/** "Abstract Builder" */
abstract class PizzaBuilder {
    protected Pizza pizza;
 
    public Pizza getPizza() { return pizza; }
    public void crearNuevaPizza() { pizza = new Pizza(); }
 
    public abstract void buildMasa();
    public abstract void buildSalsa();
    public abstract void buildRelleno();
}
 
 
/** "ConcreteBuilder" */
class HawaiPizzaBuilder extends PizzaBuilder {
    public void buildMasa()   { pizza.setMasa("suave"); }
    public void buildSalsa()   { pizza.setSalsa("dulce"); }
    public void buildRelleno() { pizza.setRelleno("chorizo+alcachofas"); }
}
 
/** "ConcreteBuilder" */
class PicantePizzaBuilder extends PizzaBuilder {
    public void buildMasa()   { pizza.setMasa("cocida"); }
    public void buildSalsa()   { pizza.setSalsa("picante"); }
    public void buildRelleno() { pizza.setRelleno("pimienta+salchichón"); }
}
 
 
/** "Director" */
class Cocina {
    private PizzaBuilder pizzaBuilder;
 
    public void setPizzaBuilder(PizzaBuilder pb) { pizzaBuilder = pb; }
    public Pizza getPizza() { return pizzaBuilder.getPizza(); }
 
    public void construirPizza() {
       pizzaBuilder.crearNuevaPizza();
       pizzaBuilder.buildMasa();
       pizzaBuilder.buildSalsa();
       pizzaBuilder.buildRelleno();
    }
}
 
 
/** Un cliente pidiendo una pizza. */
class BuilderExample {
    public static void main(String[] args) {
        Cocina cocina = new Cocina();
        PizzaBuilder hawai_pizzabuilder = new HawaiPizzaBuilder();
        PizzaBuilder picante_pizzabuilder = new PicantePizzaBuilder();
 
        cocina.setPizzaBuilder( hawai_pizzabuilder );
        cocina.construirPizza();
 
        Pizza pizza = cocina.getPizza();
    }
}
 
 
 