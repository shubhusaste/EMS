package employee;

import java.sql.*;

public class Conn {

        public Connection c;
        public Statement s;

    public Conn() {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1016");

                s = c.createStatement();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

