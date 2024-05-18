package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {

    Connection con;

    public Connection getConnection() {
        try {
            // Configura la URL de conexión a CockroachDB
            String url = "jdbc:postgresql://leafy-troll-14002.7tt.aws-us-east-1.cockroachlabs.cloud:26257/proyecto";
            Properties props = new Properties();
            props.setProperty("user", "andres"); // Nombre de usuario
            props.setProperty("password", "0pwZDN433JlWuNhvWJOXCw"); // Contraseña del usuario
            props.setProperty("sslmode", "verify-full"); // Modo SSL

            // Configura la ruta al certificado SSL
            String pathToCert = System.getProperty("user.home") + "/AppData/Roaming/postgresql/root.crt";
            props.setProperty("sslrootcert", pathToCert); // Ruta al certificado

            // Obtén la conexión
            con = DriverManager.getConnection(url, props);
            return con;
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return null;
    }

}
