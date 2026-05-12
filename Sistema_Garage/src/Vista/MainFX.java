package Vista;

import Model.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MainFX extends Application {

    private Garage miGarage = new Garage(50);
    private Stage ventanaPrincipal;

    @Override
    public void start(Stage primaryStage) {

        this.ventanaPrincipal = primaryStage;
        mostrarMenuPrincipal();
    }

    public void mostrarMenuPrincipal() {
        VBox layoutMenu = new VBox(20);
        layoutMenu.setPadding(new Insets(50));
        layoutMenu.setAlignment(Pos.CENTER);

        Label titulo = new Label("GESTIÓN DE GARAGE");
        titulo.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        Button btnIngreso = new Button ("Registrar ingreso");
        Button btnListado = new Button("Ver Vehículos");
        Button btnSalir = new Button("Salir");

        // Estilo rápido para los botones
        btnIngreso.setMinWidth(200);
        btnListado.setMinWidth(200);
        btnSalir.setMinWidth(200);

        // Eventos
        btnIngreso.setOnAction(e -> mostrarFormularioIngreso());
        btnSalir.setOnAction(e -> ventanaPrincipal.close());
        btnListado.setOnAction(e -> mostrarListadoVehiculos());

        layoutMenu.getChildren().addAll(titulo, btnIngreso, btnListado, btnSalir);

        Scene escena = new Scene(layoutMenu, 450, 500);
        ventanaPrincipal.setTitle("Sistema Garage - Menú Principal");
        ventanaPrincipal.setScene(escena);
        ventanaPrincipal.show();
    }

    public void mostrarFormularioIngreso() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(30));
        grid.setVgap(15);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);

        // Componentes del Formulario
        Label lblTipo = new Label("Tipo de Vehículo:");
        ComboBox<String> comboTipo = new ComboBox<>();
        comboTipo.getItems().addAll("Automovil", "Motocicleta", "Camión");
        comboTipo.setPromptText("Seleccione...");

        Label lblMarca = new Label("Marca:");
        TextField txtMarca = new TextField();

        Label lblModelo = new Label("Modelo:");
        TextField txtModelo = new TextField();

        Label lblPatente = new Label("Patente:");
        TextField txtPatente = new TextField();

        Label lblHoras = new Label("Horas Estimadas:");
        TextField txtHoras = new TextField();

        Button btnAceptar = new Button("Registrar");
        Button btnVolver = new Button("Volver");

        // Posicionamiento en el Grid (Columna, Fila)
        grid.add(lblTipo, 0, 0);
        grid.add(comboTipo, 1, 0);
        grid.add(lblMarca, 0, 1);
        grid.add(txtMarca, 1, 1);
        grid.add(lblModelo, 0, 2);
        grid.add(txtModelo, 1, 2);
        grid.add(lblPatente, 0, 3);
        grid.add(txtPatente, 1, 3);
        grid.add(lblHoras, 0, 4);
        grid.add(txtHoras, 1, 4);
        grid.add(btnVolver, 0, 5);
        grid.add(btnAceptar, 1, 5);

        // Eventos del formulario
        btnVolver.setOnAction(e -> mostrarMenuPrincipal());

        btnAceptar.setOnAction(e -> {
            try {
                // 1. Validaciones de espacios en blanco
                if (comboTipo.getValue() == null) throw new IllegalArgumentException("Debe seleccionar un tipo de vehiculo.");
                if (txtMarca.getText().trim().isEmpty()) throw new IllegalArgumentException("Debe ingresar la marca del vehiculo.");
                if (txtModelo.getText().trim().isEmpty()) throw new IllegalArgumentException("Debe ingresar el modelo del vehiculo.");
                if (txtPatente.getText().trim().isEmpty()) throw new IllegalArgumentException("Debe ingresar la patente del vehiculo.");

                String marca = txtMarca.getText();
                String modelo = txtModelo.getText();
                String patente = txtPatente.getText();
                int horas = Integer.parseInt(txtHoras.getText());

                // 2. Instanciacion
                Vehiculo nuevo = null;
                String seleccion = comboTipo.getValue();

                switch (seleccion) {
                    case "Automovil" -> nuevo = new Auto(marca, modelo, patente, horas);
                    case "Motocicleta" -> nuevo = new Moto(marca, modelo, patente, horas);
                    case "Camión" -> nuevo = new Camion(marca, modelo, patente, horas);
                }

                // 3. Intento de registro en el modelo
                miGarage.registrarEntrada(nuevo);

                // 4. Feedback de éxito
                mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Vehículo registrado correctamente.");
                mostrarMenuPrincipal();

            } catch (NumberFormatException ex) {
                mostrarAlerta(Alert.AlertType.ERROR, "Error de Datos", "Las horas deben ser un número válido.");
            } catch (Exception ex) {
                // Aca caen las excepciones: GarageLleno, PatenteDuplicada, etc.
                mostrarAlerta(Alert.AlertType.ERROR, "Error", ex.getMessage());
            }
        });

        Scene escenaForm = new Scene(grid, 450, 500);
        ventanaPrincipal.setScene(escenaForm);
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    public void mostrarListadoVehiculos() {
        VBox layout = new VBox(20);
        layout.setPadding(new Insets(30));
        layout.setAlignment(Pos.CENTER);

        Label titulo = new Label("VEHÍCULOS ESTACIONADOS");
        titulo.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        TableView<Vehiculo> tabla = new TableView<>();

        TableColumn<Vehiculo, String> colTipo = new TableColumn<>("Tipo");
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipoVehiculo"));

        TableColumn<Vehiculo, String> colMarca = new TableColumn<>("Marca");
        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));

        TableColumn<Vehiculo, String> colModelo = new TableColumn<>("Modelo");
        colModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));

        TableColumn<Vehiculo, String> colPatente = new TableColumn<>("Patente");
        colPatente.setCellValueFactory(new PropertyValueFactory<>("patente"));

        // Agregamos las columnas a la tabla
        tabla.getColumns().addAll(colTipo, colMarca, colModelo, colPatente);

        ObservableList<Vehiculo> datos = FXCollections.observableArrayList(miGarage.getEstacionados());
        tabla.setItems(datos);

        tabla.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        Button btnVolver = new Button("Volver al Menú");
        btnVolver.setOnAction(e -> mostrarMenuPrincipal());

        layout.getChildren().addAll(titulo, tabla, btnVolver);

        Scene escena = new Scene(layout, 600, 500);
        ventanaPrincipal.setScene(escena);
    }

    public static void main(String[] args) {
        // Lanza la aplicación de JavaFX
        launch(args);
    }
}