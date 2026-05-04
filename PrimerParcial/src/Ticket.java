public class Ticket {

    private Vehiculo vehiculo;
    private Estadia estadia;



    public Ticket(Vehiculo vehiculo, Estadia estadia) {
        this.vehiculo = vehiculo;
        this.estadia = estadia;
    }

    public void cobrarEstadia(){
        int horas = estadia.calcularEstadia(vehiculo);
        double total = vehiculo.calcularTarifa(horas);

        System.out.println("El total es de $" + total);
    }


}
