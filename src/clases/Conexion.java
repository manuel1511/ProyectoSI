/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Tejada
 */
public class Conexion {
    /*Declaracion de variables*/
    static Connection conn=null;
    static Statement st=null;
    static ResultSet rs=null;
    /*Asignar datos de conexion*/
    static String bd="XE";//TIPO DE BASE DE DATOS
    static String login="HR";//USUARIO DE LA BASE DE DATOS
    static String password="catolica";//CONTRASEÑA DEL USUARIO
    static String url="jdbc:oracle:thin:@localhost:1521:XE";//URL DE CONEXION
 /*Metodo de conexion a la base de datos*/
    public static Connection Enlace(Connection conn)throws SQLException    {

        try {
         Class.forName("oracle.jdbc.OracleDriver");
         conn=DriverManager.getConnection(url, login, password);
        }
        catch(Exception e)//Si no se puede conectar
		{
                System.out.println("Error de conexion del driver: "+e.getMessage());
		}
        return conn;
    }
    /*Establecer la conexion a la base de datos*/
     public static Statement sta(Statement st)throws SQLException    {
        conn=Enlace(conn);
        st=conn.createStatement();
        return st;
    }
     /*Hacer una consulta a la tabla*/
    public static ResultSet Consulta(ResultSet rs,String Sql)throws SQLException    {
       st=sta(st);
       rs=st.executeQuery(Sql);
        return rs;
    }
}
