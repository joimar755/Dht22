/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author joimar
 */
public class Sql_usuarios extends Conexion {

    public boolean registrar(Modelo_Usuarios usr) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String Sql = "INSERT INTO users(nombre, email, password)VALUES(?,?,?)";
        System.out.println(Sql);
        try {
            ps = con.prepareStatement(Sql);
            ps.setString(1, usr.getNombre());
            ps.setString(2, usr.getCorreo());
            ps.setString(3, usr.getPassword());

            ps.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(Sql_usuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public int existe_Usuarios(String usuario) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        ResultSet rs = null;
        String Sql = "SELECT count(id) FROM users WHERE nombre=?";
        System.out.println(Sql);
        try {
            ps = con.prepareStatement(Sql);
            ps.setString(1, usuario);

            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;

        } catch (SQLException ex) {
            Logger.getLogger(Sql_usuarios.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }

    }

    public boolean Iniciar_Session(Modelo_Usuarios usuario) {
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        ResultSet rs = null;

    try {
    

        // Consulta preparada (solo busca por nombreUsuario)
        String sql = "SELECT id, nombreUsuario, contraseña, nombre, idTipo_usuario FROM usuarios WHERE nombreUsuario = ?";
        ps = con.prepareStatement(sql);
        ps.setString(1, usuario.getNombre());

        rs = ps.executeQuery();

        if (rs.next()) {
            // Validar contraseña
            if (usuario.getPassword().equals(rs.getString("contraseña"))) {
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                return true;
            } else {
                System.out.println("⚠️ Contraseña incorrecta.");
                return false;
            }
        } else {
            System.out.println("⚠️ Usuario no encontrado.");
            return false;
        }

    } catch (SQLException e) {
        System.out.println("❌ Error en la validación: " + e.getMessage());
        return false;
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException ex) {
            System.out.println("⚠️ Error al cerrar recursos: " + ex.getMessage());
        }
    }
    }

    public boolean validarEmail(String email) {
        // Patrón para validar dirección de correo electrónico
        String patron = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        // Compilar la expresión regular
        Pattern pattern = Pattern.compile(patron);

        // Comparar el correo electrónico con la expresión regular
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
