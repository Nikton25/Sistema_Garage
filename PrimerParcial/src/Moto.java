public class Moto extends Vehiculo {


    public Moto(String marca, String modelo, String patente, int horasEstadia) {
        super(marca, modelo, patente, horasEstadia);
    }

    @Override
    public String getPatente() {
        return super.getPatente();
    }

    @Override
    public double calcularTarifa(int horasEstadia) {
        int valorHoraMoto = 700;
        return (valorHoraMoto * horasEstadia);
    }

    @Override
    public int getEspacio() {
        return 1;
    }
    @Override
    public String getTipoVehiculo() {
        return "Moto";
    }
















}
