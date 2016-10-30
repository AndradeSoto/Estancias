
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Raul Andrade
 */
public class ConsultMysql {
    Connection conexion = null;
    ResultSet rs = null;
    Statement comando = null;
    private int id ;
    private int nivel; 
    /////////////Constructor: Permite conectarnos a mysql
    public void ConsultMysql() throws InstantiationException, IllegalAccessException{
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            this.conexion = DriverManager.getConnection("jdbc:mysql://localhost/estancias", "root", "");    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConsultMysql.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    //////////////////////////////////////////////////////
    
    ///// Verifica que el usuario ingresado y la contraseña sean validos
    public String Login(String Usuario, String Clave){
            try{
                this.comando = this.conexion.createStatement();
                this.rs = this.comando.executeQuery("SELECT * FROM usuarios WHERE usuario = '"+Usuario+"' && clave = '"+Clave+"'");
                if (rs.first()) {/////dudassss
                   this.id = rs.getInt("id");
                   this.nivel = rs.getInt("nivel");
                   // while (rs.next()) {}   Dudaaaaaaaaaassssssssssss
                    return "Usuario Valido";
                }else{
                    return "Usuario o contraseña invalido";
                }
           }catch(SQLException e){
                return "Error: "+e.toString();
            }
    }
    /////////////////////////////////////////////////////////
    
    ///////Metodo que devuelve el id del usuario Logueado o El nivel con el que cuenta
    public int InfoUsuario(String requiere){
        int ID , NIVEL;
        System.out.println("requiere "+requiere);
        switch (requiere) {
            case "id":
                
                ID = this.id;System.out.println("id"+this.id);
                return ID;
            case "nivel":
                NIVEL = this.nivel;
                return NIVEL;
            default:
                return 0;
        }
    }
    //////////////////////////////////////////////////////////////////////////
    
}
