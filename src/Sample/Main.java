package Sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Scanner;


public class Main extends Application {
    public static Connection conn;


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/Scenes/sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1000, 500));
        primaryStage.show();
    }

    /**
     * @param file
     * @throws SQLException
     * @throws FileNotFoundException
     */

    public static void ConnectDB(String file) throws SQLException, FileNotFoundException {

        try {
            String url = "jdbc:sqlite:C:/SQLite/db/" + file;
            conn = DriverManager.getConnection(url);

            System.out.println("Connection is established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        File schema = new File("oblig3v1_database.sql");
        InputStream in = new FileInputStream(schema);

        importSQL(conn, in);
    }

    /**
     * Metode for å importere den vedlagte SQL fila.
     * @param conn connection
     * @param in inputstream
     * @throws SQLException
     */
    public static void importSQL(Connection conn, InputStream in) throws SQLException {

        if (checkSQL()) {
            System.out.println("SQLfile already run.");
            return;
        }
        Scanner s = new Scanner(in);
        s.useDelimiter("(;(\r)?\n)|(--\n)");
        Statement st = null;
        try {
            st = conn.createStatement();
            while (s.hasNext()) {
                String line = s.next();
                if (line.startsWith("/*!") && line.endsWith("*/")) {
                    int i = line.indexOf(' ');
                    line = line.substring(i + 1, line.length() - " */".length());
                }

                if (line.trim().length() > 0) {
                    st.execute(line);
                }
            }
        } finally {
            if (st != null) st.close();
        }
    }

    // Metode for å sjekke om SQL fila allerede er inn.
    public static boolean checkSQL(){
        boolean isDriven = false;
        try {
            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery("SELECT product FROM invoice_items WHERE invoice=1");

            int product = rs.getInt("product");

            if (product == 1){
                isDriven = true;
            }

        } catch (SQLException e) {
            isDriven = false;
        }
        return isDriven;
    }

    public static void main(String[] args) throws FileNotFoundException, SQLException {
        System.out.println("hello");

        ConnectDB("test.db");
        launch(args);
        conn.close();
        System.out.println("Connection is closed.");
    }
}
