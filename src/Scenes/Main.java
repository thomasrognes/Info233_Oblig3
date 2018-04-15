/**
 *  Obligatorisk oppgave 3 for Thomas Sebastian Rognes (Rut005)
 */


package Scenes;

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
        primaryStage.setTitle("Obligatorisk Oppgave 3 - Thomas Sebastian Rognes (rut005)");
        primaryStage.setScene(new Scene(root, 1000, 500));
        primaryStage.show();
    }

    /**
     * @param file som skal tilkobles.
     * @throws SQLException dersom den ikke blir koblet til.
     * @throws FileNotFoundException dersom den ikke blir koblet til.
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
     * Metode for å importere den vedlagte SQL filen.
     * @param conn connection til databasen
     * @param in inputstream SQL filen som skal legges til.
     * @throws SQLException dersom den ikke blir lagt til.
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

    /**
     * Metode for å sjekke om den vedlagte SQL fila allerede er bltt lagt inn.
     * @return true hvis den allerede er lagt inn, false hvis ikke.
     */
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


    /**
     *Main metode som oppretter en tilkobling til Databasen, og lukker tilkoblingen når programmet blir avsluttet.
     */
    public static void main(String[] args) throws FileNotFoundException, SQLException {
        ConnectDB("faktura.db");
        launch(args);
        conn.close();
        System.out.println("Connection is closed.");
    }
}
