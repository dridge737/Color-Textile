package testing2;
/**
 *
 * @author asakanaboy_00
 */
import java.sql.*;

public class ConnectToDB 
{
    public Connection connection = null;
    
    public ConnectToDB()
    {
        String url = "jdbc:mysql://localhost:3306/color_textile";
        String user = "asd"; 
        String password = "qwe";   
                   
        try 
        {
            //System.out.println("Connecting database...");
            connection = DriverManager.getConnection(url,user,password);
            //System.out.println("Database connected!");
        } 
        catch(SQLException ex) 
        {
            ex.printStackTrace();
        }    
    }
}