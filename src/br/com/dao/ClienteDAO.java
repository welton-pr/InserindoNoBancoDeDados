/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.persistencia.Conexao;
import br.com.vo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Laryssa
 */
public class ClienteDAO {
    
    public int insert(Cliente c){
        PreparedStatement pst = null;
        int resultado = 0;
        try{
            Connection con = Conexao.conectar();
            String sql = " insert into cliente (codigo, nome, email, nascimento) "
                    + " values (?,?,?,?)";
            
            pst = con.prepareStatement(sql);
            pst.setInt(1, c.getCodigo());
            pst.setString(2, c.getNome());
            pst.setString(3, c.getEmail());
            pst.setTimestamp(4, c.getNascimento());
            resultado = pst.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            Conexao.desconectaPst(pst);
            Conexao.desconectar();
        }
        return resultado;
    }
    
}
