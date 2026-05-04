public abstract class Vehiculo implements Calculable, Mostrable {

    protected String marca;
    protected String modelo;
    protected String patente;
    protected int horasEstimadas;


    public Vehiculo(String marca, String modelo, String patente, int horasEstimadas) {
        this.marca = marca;
        this.modelo = modelo;
        this.patente = patente;
        this.horasEstimadas = horasEstimadas;
    }

    public String getPatente() {
        return patente;
    }

    public int getHorasEstimadas() {
        return horasEstimadas;
    }

    @Override
    public abstract double calcularTarifa();

    @Override
    public abstract void mostrarDatos();


    public abstract int getEspacio();

    public abstract String getTipoVehiculo();






}
