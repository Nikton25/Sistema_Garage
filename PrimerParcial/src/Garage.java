import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Garage {
    private int capacidadMax = 50;
    private List<Vehiculo> estacionados;



    public int getCapacidadMax() {
        return capacidadMax;
    }

    public List<Vehiculo> getEstacionados() {
        return estacionados;
    }

    public Garage() {
        this.estacionados = new ArrayList<>();
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


    public void registrarEntrada (Vehiculo vehiculo) {
        if (espacioLibre() >= vehiculo.getEspacio()) {
            estacionados.add(vehiculo);
            JOptionPane.showMessageDialog(null, "Vehiculo ingresado con exito.");
        }
        else {
            JOptionPane.showMessageDialog(null, "ERROR, no hay espacio suficiente para este vehiculo.");
        }

    }

    public Vehiculo registrarSalida(String patente) {
        Vehiculo vehiculoEncontrado = null;
        for (Vehiculo vehiculo : estacionados) {
            if (vehiculo.getPatente().equalsIgnoreCase(patente)) {
                vehiculoEncontrado = vehiculo;
                break;
            }
        }

        if (vehiculoEncontrado != null) {
            estacionados.remove(vehiculoEncontrado);
            JOptionPane.showMessageDialog(null, "Salida de vehiculo registrada con exito.");
            return vehiculoEncontrado;
        }
        else {
            JOptionPane.showMessageDialog(null, "ERROR: no se encontro ningun vehiculo con patente: " +  patente);
            return null;
        }
    }

    public void mostrarVehiculosEstacionados(){
        StringBuilder est = new StringBuilder();
        int contadorAutos = 0;
        int contadorMotos = 0;
        int contadorCamiones = 0;


        if (estacionados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El garage esta vacio.");
        }
        else {
            for (Vehiculo vehiculo : estacionados) {
                String tipo =  vehiculo.getTipoVehiculo();

                if (tipo.equals("Moto")) {
                    contadorMotos++;
                }
                else if (tipo.equals("Camion")) {
                    contadorCamiones++;
                }
                else if (tipo.equals("Auto")) {
                    contadorAutos++;
                }

            }
        }


        est.append("\n--- RESUMEN DE VEHICULOS ESTACIONADOS ---\n");
        est.append("Espacio Total: ").append(capacidadMax).append("\n");
        est.append("Espacio Libre: ").append(espacioLibre()).append("\n");
        est.append("Espacio Ocupado: ").append(espacioOcupado()).append("\n");
        est.append("Total Autos: ").append(contadorAutos).append("\n");
        est.append("Total Motos: ").append(contadorMotos).append("\n");
        est.append("Total Camiones: ").append(contadorCamiones).append("\n");


        JOptionPane.showMessageDialog(null, est.toString());

        }

























    }








































