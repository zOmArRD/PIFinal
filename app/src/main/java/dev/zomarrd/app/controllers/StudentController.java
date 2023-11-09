package dev.zomarrd.app.controllers;

import dev.zomarrd.app.AppLauncher;
import dev.zomarrd.app.models.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class StudentController extends BaseController {

    @FXML
    public TableView<Student> tableView;

    @FXML
    public TableColumn<Student, Integer> tableId;

    @FXML
    public TableColumn<Student, String> tableName;

    @FXML
    public TableColumn<Student, Integer> tableAge;

    @FXML
    public TableColumn<Student, Integer> tableGrade;

    @Override
    public void initialize(Stage stage) {
        super.initialize(stage);

        ObservableList<Student> students = FXCollections.observableArrayList();

        try {
            URL url = new URL("http://localhost:3000/api/v1/students");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                JSONArray jsonArray = new JSONArray(response.toString());

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonStudent = jsonArray.getJSONObject(i);
                    int id = jsonStudent.getInt("id");
                    String name = jsonStudent.getString("name");
                    int age = jsonStudent.getInt("age");
                    int grade = jsonStudent.getInt("grade");
                    students.add(new Student(id, name, age, grade));
                }
            } else {
                System.err.println("Error en la solicitud GET a la API. Código de respuesta: " + responseCode);

                // Quitar la TableView y mostrar un mensaje de error en la pantalla
                tableView.setVisible(false);

            }
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        tableView.setItems(students);
    }

    public void deleteRow() {
        Student selectedStudent = tableView.getSelectionModel().getSelectedItem();

        if (selectedStudent != null) {
            tableView.getItems().remove(selectedStudent);

            try {
                URL url = new URL("http://localhost:3000/api/v1/students/" + selectedStudent.getId());
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("DELETE");
                connection.connect();

                int responseCode = connection.getResponseCode();

                if (responseCode == HttpURLConnection.HTTP_OK) {
                    System.out.println("Student deleted successfully.");
                } else {
                    System.err.println("Error deleting student from API. Response code: " + responseCode);
                }

                connection.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void redirectToStudent() {
        try {
            AppLauncher.loadFXML("app/student_menu", "Student Menu", getStage());
        } catch (Exception e) {
            AppLauncher.getLogger().log(System.Logger.Level.ERROR, e.getMessage());
        }
    }

    public void redirectToTeacher() {
        try {
            AppLauncher.loadFXML("app/student_menu", "Student Menu", getStage());
        } catch (Exception e) {
            AppLauncher.getLogger().log(System.Logger.Level.ERROR, e.getMessage());
        }
    }

    public void redirectToMenu() {
        try {
            AppLauncher.loadFXML("app/menu", "Student Menu", getStage());
        } catch (Exception e) {
            AppLauncher.getLogger().log(System.Logger.Level.ERROR, e.getMessage());
        }
    }

    public void addRow(MouseEvent mouseEvent) {
    }

    public void editRow(MouseEvent mouseEvent) {
    }
}
