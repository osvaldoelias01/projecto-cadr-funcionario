package utlility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {

    String driver =("com.mysql.cj.jdbc.Driver");
    String db_username = "root";
    String db_password = "";
    String db_url = "jdbc:mysql://localhost:3306/db_funcionario?serverTimezone=UTC";

   private Connection conexao;

    public DataBase ()
    {

    }

    public Connection conexao()
    {

        try {
            Class.forName(driver);
            this.conexao = DriverManager.getConnection(db_url, db_username, db_password);

            System.out.println("conexao: " + this.conexao.prepareStatement("show table;"));

            return this.conexao;

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return null;
    }



}
