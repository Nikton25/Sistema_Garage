public class Auto extends Vehiculo {


    public Auto(String marca, String modelo, String patente, int horasEstimadas) {
        super(marca, modelo, patente, horasEstimadas);
    }

    @Override
    public String getPatente() {
        return super.getPatente();
    }

    @Override
    public double calcularTarifa() {
        int valorHoraAuto = 1000;
        return valorHoraAuto * this.horasEstimadas;
    }

    @Override
    public void mostrarDatos(){
        System.out.println("Vehiculo: " + getTipoVehiculo()+ "| Marca: " + this.marca + "| Modelo: " + this.modelo + "| Patente: " + this.patente);
        System.out.println("Horas Estimadas: " + this.horasEstimadas + "| Costo total estimado: $" + calcularTarifa());
    }


    @Override
    public int getEspacio() {
        return 2;
    }

    @Override
    public String getTipoVehiculo() {
        return "Automovil";
    }














}
