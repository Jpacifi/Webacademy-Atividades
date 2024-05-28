package br.ufac.sgcm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.ufac.sgcm.model.Profissional;

public class ProfissionalDao {
    Connection conexao;
    PreparedStatement ps;
    ResultSet rs;

    public ProfissionalDao (){
        conexao = new ConexeaoDB().getConexao();
    }

    public int insert(Profissional obejeto)
    {   int registrosAfetados = 0;
        try {
            ps = conexao.prepareStatement("INSERT INTO profissional (nome, email, registro_conselho, telefone, unidade_id, especialidade_id) VALUES (?,?,?,?,?,?)");
            ps.setString(1, obejeto.getNome());
            ps.setString(2, obejeto.getEmail());
            ps.setString(3, obejeto.getRegistro());
            ps.setString(4, obejeto.getTelefone());
            ps.setObject(5, obejeto.getUnidade());
            ps.setObject(6, obejeto.getEspecialidade());

            registrosAfetados = ps.executeUpdate();

            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }

    public int update(Profissional obejeto)
    {   int registrosAfetados = 0;
        try {
            ps = conexao.prepareStatement("UPDATE profissional SET nome = ?, email = ?, registro_conselho = ?, telefone = ?, unidade_id = ?, especialidade_id = ?  WHERE  id = ?");
            ps.setString(1, obejeto.getNome());
            ps.setString(2, obejeto.getEmail());
            ps.setString(3, obejeto.getRegistro());
            ps.setString(4, obejeto.getTelefone());
            ps.setObject(5, obejeto.getUnidade());
            ps.setObject(6, obejeto.getEspecialidade());
            ps.setLong(7, obejeto.getId());
            registrosAfetados = ps.executeUpdate();

            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }

    public int delete(Profissional obejeto)
    {   int registrosAfetados = 0;
        try {
            ps = conexao.prepareStatement("DELETE FROM profissional WHERE id = ?");
            ps.setLong(1, obejeto.getId());
            registrosAfetados = ps.executeUpdate();

            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }

}
