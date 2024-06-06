package br.ufac.sgcm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufac.sgcm.model.Usuario;

public class UsuarioDao implements IDao<Usuario> {

    private Connection conexao;

    public UsuarioDao() {
        this.conexao = ConexaoDB.getConexao();
    }

    @Override
    public int delete(Usuario objeto) {
        int registrosAfetados = 0;
        String sql = "DELETE FROM usuario WHERE id = ?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setLong(1, objeto.getId());
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }

    @Override
    public List<Usuario> get() {
        List<Usuario> registros = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        try (PreparedStatement ps = conexao.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Usuario registro = new Usuario();
                registro.setId(rs.getLong("id"));
                registro.setNomeCompleto(rs.getString("nome_completo"));
                registro.setNomeUsuario(rs.getString("nome_usuario"));
                registro.setSenha(rs.getString("senha"));
                registro.setAtivo(rs.getBoolean("ativo"));
                registro.setPapel(rs.getString("papel"));
                registros.add(registro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    @Override
    public Usuario get(Long id) {
        Usuario registro = new Usuario();
        String sql = "SELECT * FROM usuario WHERE id = ?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    registro.setId(rs.getLong("id"));
                    registro.setNomeCompleto(rs.getString("nome_completo"));
                    registro.setNomeUsuario(rs.getString("nome_usuario"));
                    registro.setSenha(rs.getString("senha"));
                    registro.setAtivo(rs.getBoolean("ativo"));
                    registro.setPapel(rs.getString("papel"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registro;
    }

    @Override
    public List<Usuario> get(String termoBusca) {
        List<Usuario> registros = new ArrayList<>();
        String sql = "SELECT * FROM usuario WHERE nome_completo LIKE ? OR nome_usuario LIKE ?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, "%" + termoBusca + "%");
            ps.setString(2, "%" + termoBusca + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Usuario registro = new Usuario();
                    registro.setId(rs.getLong("id"));
                    registro.setNomeCompleto(rs.getString("nome_completo"));
                    registro.setNomeUsuario(rs.getString("nome_usuario"));
                    registro.setSenha(rs.getString("senha"));
                    registro.setAtivo(rs.getBoolean("ativo"));
                    registro.setPapel(rs.getString("papel"));
                    registros.add(registro);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    @Override
    public int insert(Usuario objeto) {
        int registrosAfetados = 0;
        String sql = "INSERT INTO usuario (nome_completo, nome_usuario, senha, ativo, papel) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, objeto.getNomeCompleto());
            ps.setString(2, objeto.getNomeUsuario());
            ps.setString(3, objeto.getSenha());
            ps.setBoolean(4, objeto.isAtivo());
            ps.setString(5, objeto.getPapel());
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }

    @Override
    public int update(Usuario objeto) {
        int registrosAfetados = 0;
        String sql = "UPDATE usuario SET nome_completo = ?, nome_usuario = ?, senha = ?, ativo = ?, papel = ? WHERE id = ?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, objeto.getNomeCompleto());
            ps.setString(2, objeto.getNomeUsuario());
            ps.setString(3, objeto.getSenha());
            ps.setBoolean(4, objeto.isAtivo());
            ps.setString(5, objeto.getPapel());
            ps.setLong(6, objeto.getId());
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }
}
