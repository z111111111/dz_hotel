package com.hoteljavafx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MovieClientApplication extends Application {

    private static final String BASE_URL = "http://localhost:8080/movies";

    private TableView<Order> tableView;
    private ObservableList<Order> orderList;

    public static void main(String[] args) {
        launch(args);
    }

    private void refreshOrders() {
        try {
            // Создание URL для запроса
            URL url = new URL(BASE_URL);
            //Gson gson = new Gson();

            // Создание соединения
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Чтение ответа от сервера
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
            String jsonResponse = reader.readLine();

            reader.close();
            connection.disconnect();

            System.out.println(jsonResponse);

            // Преобразование JSON-ответа в список фильмов
            JSONParser parser = new JSONParser();
            JSONArray jsonArray = (JSONArray) parser.parse(jsonResponse);

            List<Order> orders = new ArrayList<>();
            for (Object obj : jsonArray) {
                JSONObject orderJson = (JSONObject) obj;
                // Преобразование каждого JSON-объекта в объект Movie
                Order order = new Order((Long) orderJson.get("id"), (String) orderJson.get("name"), (Set) orderJson.get("additionalServices"));
                orders.add(order);
            }

            // Обновление списка фильмов в таблице
            movieList = FXCollections.observableArrayList(movies);
            tableView.setItems(movieList);

            // Закрытие ридера и соединения
            reader.close();
            connection.disconnect();
        }  catch (ParseException | IOException e) {
            throw new RuntimeException(e);
        }
    }









    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Order Client");

        // Создание таблицы для отображения списка заказов
        tableView = new TableView<>();
        orderList = FXCollections.observableArrayList();
        tableView.setItems(orderList);

        // Создание столбцов таблицы
        TableColumn<Order, Long> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());


        TableColumn<Movie, String> nameColumn = new TableColumn<>("Наименование");
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        TableColumn<Movie, String> genreColumn = new TableColumn<>("Жанр");
        genreColumn.setCellValueFactory(cellData -> cellData.getValue().genreProperty());

        TableColumn<Movie, Long> durationColumn = new TableColumn<>("Длительность");
        durationColumn.setCellValueFactory(cellData -> cellData.getValue().durationProperty().asObject());

        TableColumn<Movie, Long> yearColumn = new TableColumn<>("Год выхода");
        yearColumn.setCellValueFactory(cellData -> cellData.getValue().yearProperty().asObject());

        tableView.getColumns().addAll(idColumn, nameColumn, genreColumn, durationColumn, yearColumn);

        // Создание кнопок для действий
        Button refreshButton = new Button("Обновить");
        Button addButton = new Button("Добавить");
        Button editButton = new Button("Редактировать");
        Button deleteButton = new Button("Удалить");

        // Добавление обработчиков событий для кнопок
        refreshButton.setOnAction(event -> refreshOrders());
        //addButton.setOnAction(event -> addMovie());
        //editButton.setOnAction(event -> editMovie());
        //deleteButton.setOnAction(event -> deleteMovie());

        // Создание панели с кнопками
        GridPane buttonPane = new GridPane();
        buttonPane.setHgap(10);
        buttonPane.setPadding(new Insets(10));
        buttonPane.add(refreshButton, 0, 0);
        buttonPane.add(addButton, 1, 0);
        buttonPane.add(editButton, 2, 0);
        buttonPane.add(deleteButton, 3, 0);

        // Создание корневого контейнера и размещение элементов
        BorderPane root = new BorderPane();
        root.setCenter(tableView);
        root.setBottom(buttonPane);

        // Создание сцены и установка на primaryStage
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

        // При запуске приложения, загружаем список фильмов с сервера
        refreshOrders();
    }

}