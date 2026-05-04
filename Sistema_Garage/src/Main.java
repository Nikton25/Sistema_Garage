
public class Main {
    public static void main(String[] args) {


    Garage gar = new Garage(4);

    Auto Focus = new Auto("Ford", "Focus", "iob471", 5);
    Auto Chevi = new Auto("Chevi", "Chevi", "iob471", 5);

    try {gar.registrarEntrada(Chevi);}
    catch (HorasInvalidasException | PatenteDuplicadaException | GarageLlenoException e) {
        System.out.println(e.getMessage());
    }

    gar.mostrarVehiculosEstacionados();

    try {gar.registrarSalida("iob984");}
    catch (VehiculoNoEncontradoException e) {
        System.out.println(e.getMessage());
    }




























































        }
}
