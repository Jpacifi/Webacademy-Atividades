package br.ufac.sgcm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufac.sgcm.model.Profissional;

public class ProfissionalDao {
    Connection conexao;
    PreparedStatement ps;
    ResultSet rs;

    public ProfissionalDao(){
        conexao = new ConexaoDB().getConexao();
    }
    // Retorna todos os profissionais
        public List<Profissional> get() {
        List<Profissional> registros = new ArrayList<>();
        String sql = "SELECT * FROM profissional";
        try {
            ps = conexao.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Profissional registro = new Profissional();
                registro.setId(rs.getLong("id"));
                registro.setNome(rs.getString("nome"));
                registro.setEmail(rs.getString("email"));
                registro.setRegistro(rs.getString("registro_conselho"));
                registro.setTelefone(rs.getString("telefone"));
                registro.setEspecialidade(rs.getLong("especialidade_id"));
                registro.setUnidade(rs.getLong("unidade_id"));
                registros.add(registro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }
    //Inserir um profissional
    public int insert(Profissional profissional) {
        int registrosAfetados = 0;
        String sql = "INSERT INTO profissional (nome, registro_conselho, email, telefone, unidade_id, especialidade_id) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, profissional.getNome());
            ps.setString(2, profissional.getRegistro());
            ps.setString(3, profissional.getEmail());
            ps.setString(4, profissional.getTelefone());
            ps.setLong(5, profissional.getUnidade());  // ID da unidade como chave estrangeira
            ps.setLong(6, profissional.getEspecialidade());  // ID da especialidade como chave estrangeira
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }
    public int update(Profissional profissional) {
        int registrosAfetados = 0;
        String sql = "UPDATE profissional SET nome = ?, registro_conselho = ?, email = ?, telefone = ?, unidade_id = ?, especialidade_id = ? WHERE id = ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, profissional.getNome());
            ps.setString(2, profissional.getRegistro());
            ps.setString(3, profissional.getEmail());
            ps.setString(4, profissional.getTelefone());
            ps.setLong(5, profissional.getUnidade());
            ps.setLong(6, profissional.getEspecialidade());
            ps.setLong(7, profissional.getId());

            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  registrosAfetados;
    }    
    public int delete(Profissional profissional) {
        int registrosAfetados = 0;
        String sql = "DELETE FROM profissional WHERE id = ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, profissional.getId());
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }
}
