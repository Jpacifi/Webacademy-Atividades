package br.ufac.sgcm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufac.sgcm.model.Atendimento;

public class AtendimentoDao implements IDao<Atendimento> {
    private Connection conexao;
    private PreparedStatement ps;
    private ResultSet rs;

    public AtendimentoDao() {
        conexao = ConexaoDB.getConexao();
    }

    @Override
    public List<Atendimento> get() {
        List<Atendimento> registros = new ArrayList<>();
        String sql = "SELECT * FROM atendimento";
        try {
            ps = conexao.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Atendimento registro = new Atendimento();
                registro.setId(rs.getLong("id"));
                registro.setData(rs.getString("data"));
                registro.setStatus(rs.getString("status"));
                registro.setConvenio_id(rs.getLong("convenio_id"));
                registro.setPaciente_id(rs.getLong("paciente_id"));
                registro.setProfissional_id(rs.getLong("profissional_id"));
                registros.add(registro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    @Override
    public Atendimento get(Long id) {
        Atendimento registro = null;
        String sql = "SELECT * FROM atendimento WHERE id = ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                registro = new Atendimento();
                registro.setId(rs.getLong("id"));
                registro.setData(rs.getString("data"));
                registro.setStatus(rs.getString("status"));
                registro.setConvenio_id(rs.getLong("convenio_id"));
                registro.setPaciente_id(rs.getLong("paciente_id"));
                registro.setProfissional_id(rs.getLong("profissional_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registro;
    }

    @Override
    public List<Atendimento> get(String termoBusca) {
        List<Atendimento> registros = new ArrayList<>();
        String sql = "SELECT * FROM atendimento WHERE status LIKE ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, "%" + termoBusca + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Atendimento registro = new Atendimento();
                registro.setId(rs.getLong("id"));
                registro.setData(rs.getString("data"));
                registro.setStatus(rs.getString("status"));
                registro.setConvenio_id(rs.getLong("convenio_id"));
                registro.setPaciente_id(rs.getLong("paciente_id"));
                registro.setProfissional_id(rs.getLong("profissional_id"));
                registros.add(registro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    @Override
    public int insert(Atendimento objeto) {
        int registrosAfetados = 0;
        String sql = "INSERT INTO atendimento (data, status, convenio_id, paciente_id, profissional_id) VALUES (?, ?, ?, ?, ?)";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, objeto.getData());
            ps.setString(2, objeto.getStatus());
            ps.setLong(3, objeto.getConvenio_id());
            ps.setLong(4, objeto.getPaciente_id());
            ps.setLong(5, objeto.getProfissional_id());
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }

    @Override
    public int update(Atendimento objeto) {
        int registrosAfetados = 0;
        String sql = "UPDATE atendimento SET data = ?, status = ?, convenio_id = ?, paciente_id = ?, profissional_id = ? WHERE id = ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, objeto.getData());
            ps.setString(2, objeto.getStatus());
            ps.setLong(3, objeto.getConvenio_id());
            ps.setLong(4, objeto.getPaciente_id());
            ps.setLong(5, objeto.getProfissional_id());
            ps.setLong(6, objeto.getId());
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }

    @Override
    public int delete(Atendimento objeto) {
        int registrosAfetados = 0;
        String sql = "DELETE FROM atendimento WHERE id = ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, objeto.getId());
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }
}
