import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    Garage gar = new Garage(50);
    int opcion = 0;

    System.out.println("=== SISTEMA DE GARAGE ===");

    while(opcion!=6){
        System.out.println("\n1. Registrar ingreso");
        System.out.println("2. Registrar salida");
        System.out.println("3. Listar vehiculos");
        System.out.println("4. Estado del garage");
        System.out.println("5. Reportes");
        System.out.println("6. Salir");

        opcion = scan.nextInt();
        scan.nextLine();

        switch(opcion){
            case 1:
                //Solicitamos al usuario los datos del vehiculo a ingresar
                try {
                    System.out.println("Ingresa el tipo de vehiculo (1, 2 o 3): \n");
                    System.out.println("1) VEHICULO \n");
                    System.out.println("2) MOTOCICLETA\n");
                    System.out.println("3) CAMION");
                    int tipoVehiculo = Integer.parseInt(scan.nextLine());
                    System.out.println("Ingresa la marca");
                    String marca = scan.nextLine();
                    System.out.println("Ingresa el modelo");
                    String modelo = scan.nextLine();
                    System.out.println("Ingresa la patente");
                    String patente = scan.nextLine();
                    System.out.println("Ingrese la cantidad de horas estimadas de estadía:");
                    int horasEstimadas = Integer.parseInt(scan.nextLine());

                    //Instanciamos nuevo vehiculo
                    Vehiculo nuevoVehiculo = null;

                    switch (tipoVehiculo){
                        case 1:
                            nuevoVehiculo = new Auto(marca,modelo,patente,horasEstimadas);
                            break;

                        case 2:
                            nuevoVehiculo = new Moto(marca,modelo,patente,horasEstimadas);
                            break;

                        case 3:
                            nuevoVehiculo = new Camion(marca,modelo,patente,horasEstimadas);
                            break;

                        default:
                            System.out.println("ERROR: Tipo de vehiculo invalido.");
                    }

                    //Intentamos ingresar el vehiculo al garage
                    if(nuevoVehiculo != null){
                        gar.registrarEntrada(nuevoVehiculo);
                    }


                    //Manejamos las excepciones en caso de que arroje un error
                }
                catch (GarageLlenoException | HorasInvalidasException | PatenteDuplicadaException e) {
                    System.err.println(e.getMessage());
                }
                catch (NumberFormatException e) {
                    System.err.println("ERROR: Por Favor ingrese un número válido.");
                    System.err.println("Recuerde que las horas estimadas de estadía deben ser mayor a 0.");
                }
                break;

            case 2:
                try {
                    System.out.println("Ingrese la patente del vehiculo");
                    String patente = scan.nextLine();

                    Vehiculo vehiculoSalida = gar.registrarSalida(patente);
                    System.out.println("Monto a cobrar: $" + vehiculoSalida.calcularTarifa());
                }
                catch (VehiculoNoEncontradoException e) {
                    System.err.println(e.getMessage());
                }
                break;

            case 3:
                    gar.mostrarVehiculosEstacionados();
                    break;

            case 4:
                System.out.println("=== ESTADO DEL GARAGE ===\n");
                System.out.println("CAPACIDAD MAXIMA: " + gar.getCapacidadMax() + " espacios.\n");
                System.out.println("Espacios libres: " + gar.espacioLibre() + " espacios.\n");
                System.out.println("Espacios ocupados: " +  gar.espacioOcupado() + " espacios.\n");
                break;

            case 5:
                System.out.println("\n=== MENÚ DE REPORTES ===");
                System.out.println("1) Cantidad total de vehículos");
                System.out.println("2) Cantidad por tipo de vehículo");
                System.out.println("3) Recaudación total estimada");
                System.out.println("4) Volver al menú principal");
                System.out.print("Seleccione una opción: ");

                try {
                    int opcionReporte = Integer.parseInt(scan.nextLine());

                    switch (opcionReporte) {
                        case 1:
                            System.out.println("\n TOTAL DE VEHÍCULOS ESTACIONADOS: " + gar.getEstacionados().size());
                            break;

                        case 2:
                            int contadorAutos = 0;
                            int contadorMotos = 0;
                            int contadorCamiones = 0;

                            for (Vehiculo v : gar.getEstacionados()) {
                                if (v instanceof Auto) {
                                    contadorAutos++;
                                } else if (v instanceof Moto) {
                                    contadorMotos++;
                                } else if (v instanceof Camion) {
                                    contadorCamiones++;
                                }
                            }

                            System.out.println("\n=== CANTIDAD POR TIPO DE VEHICULO ESTACIONADO ===");
                            System.out.println("- Autos: " + contadorAutos);
                            System.out.println("- Motos: " + contadorMotos);
                            System.out.println("- Camiones: " + contadorCamiones);
                            break;

                        case 3:
                            double totalRecaudado = 0;
                            for (Vehiculo v : gar.getEstacionados()) {
                                totalRecaudado += v.calcularTarifa();
                            }
                            System.out.println("\n>> RECAUDACIÓN TOTAL ESTIMADA: $" + totalRecaudado);
                            break;

                        case 4:
                            System.out.println("Volviendo al menú principal..");
                            break;

                        default:
                            System.err.println("Opción de reporte no válida.");
                    }
                } catch (NumberFormatException e) {
                    System.err.println("ERROR: Debe ingresar un número válido para seleccionar el reporte.");
                }
                break;

            case 6:
                System.out.println("Cerrando Sistema Garage. Hasta la proxima!");
                break;

            default:
                System.out.println("ERROR: Debe elegir una opcion del 1 al 6.");

        }
    }




























































        }
}
