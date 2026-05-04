public class Camion extends Vehiculo {


    public Camion(String marca, String modelo, String patente, int horasEstadia) {
        super(marca, modelo, patente, horasEstadia);
    }

    @Override
    public String getPatente() {
        return super.getPatente();
    }

    @Override
    public double calcularTarifa(int horas) {
        int valorHoraCamion = 1500;
        return (valorHoraCamion * horas);
    }

    @Override
    public int getEspacio(){
        return 4;
    }

    @Override
    public String getTipoVehiculo(){
        return "Camion";
    }

















}
