import java.util.ArrayList;
import java.util.List;

public class Garage {
    private int capacidadMax;
    private List<Vehiculo> estacionados;

    public Garage(int capacidadMax) {
        this.capacidadMax = capacidadMax;
        this.estacionados = new ArrayList<>();
    }

    public int getCapacidadMax() {
        return capacidadMax;
    }

    public List<Vehiculo> getEstacionados() {
        return estacionados;
    }



    public int espacioOcupado(){
        int ocupado = 0;
        for (Vehiculo vehiculo : estacionados) {
            ocupado += vehiculo.getEspacio();
        }
        return ocupado;
    }

    public int espacioLibre(){
        return capacidadMax - espacioOcupado();
    }

    private Vehiculo buscarPorPatente(String patente){
        for (Vehiculo vehiculo : estacionados) {
            if (vehiculo.getPatente().equalsIgnoreCase(patente)) {
                return vehiculo;
            }
        }
        return null;
    }

    public void registrarEntrada (Vehiculo vehiculo) throws HorasInvalidasException, PatenteDuplicadaException, GarageLlenoException {
        //Validacion de Horas Invalidas
        if (vehiculo.getHorasEstimadas()<=0){
            throw new HorasInvalidasException("ERROR: Las horas estimadas de estadia deben ser mayores a 0.");
        }

        //Validacion de patente duplicada
        if (buscarPorPatente(vehiculo.getPatente())!=null){
            throw new PatenteDuplicadaException("ERROR: Ya existe un vehiculo con la patente " +  vehiculo.getPatente() + ".");
        }

        //Validacion de Garage LLeno
        if (espacioLibre() < vehiculo.getEspacio()){
            throw new GarageLlenoException("ERROR: No hay suficiente espacio para estacionar este vehiculo.");
        }

        estacionados.add(vehiculo);
        System.out.println("Vehiculo registrado correctamente.");

    }

    public Vehiculo registrarSalida(String patente) throws VehiculoNoEncontradoException {
        Vehiculo vehiculoEncontrado = buscarPorPatente(patente);

        //Validacion de Vehiculo no encontrado
       if (vehiculoEncontrado==null){
           throw new VehiculoNoEncontradoException("ERROR: No se encontro ningun vehiculo con la patente " + patente + ".");
       }

       estacionados.remove(vehiculoEncontrado);
       System.out.println("Vehiculo retirado del Garage correctamente.");
       return vehiculoEncontrado;
    }

    public void mostrarVehiculosEstacionados(){

        if (estacionados.isEmpty()){
            System.out.println("El Garage esta vacio.");
        }
        else {
            System.out.println("\n--- RESUMEN DE VEHICULOS ESTACIONADOS ---\n");
            for (Vehiculo vehiculo : estacionados) {
                vehiculo.mostrarDatos();
                System.out.println("------------------------------");
            }
        }


        }

























    }








































