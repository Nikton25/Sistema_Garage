public class Auto extends Vehiculo {


    public Auto(String marca, String modelo, String patente, int horasEstadia) {
        super(marca, modelo, patente, horasEstadia);
    }

    @Override
    public String getPatente() {
        return super.getPatente();
    }

    @Override
    public double calcularTarifa(int horas) {
        int valorHoraAuto = 1000;
        return (valorHoraAuto * horas);
    }


    @Override
    public int getEspacio() {
        return 2;
    }

    @Override
    public String getTipoVehiculo() {
        return "Auto";
    }














}
