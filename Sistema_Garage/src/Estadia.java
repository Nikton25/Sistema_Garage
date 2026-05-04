import java.time.Duration;
import java.time.LocalDateTime;

public class Estadia {
    private Vehiculo vehiculo;
    private LocalDateTime horaIngreso;
    private LocalDateTime horaSalida;



    public Estadia(){};

    public Estadia(Vehiculo vehiculo, LocalDateTime horaIngreso) {
        this.vehiculo = vehiculo;
        this.horaIngreso = horaIngreso;
    }

    public void setHoraSalida(LocalDateTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public int calcularEstadia(Vehiculo vehiculo) {
         Duration estadia = Duration.between(horaIngreso, horaSalida);

         int minutos = (int) estadia.toMinutes();
         return (int) Math.ceil(minutos / 60.0);
    }
















































}
