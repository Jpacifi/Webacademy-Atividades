package br.ufac.sgcm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.ufac.sgcm.dao.UsuarioDao;
import br.ufac.sgcm.model.Usuario;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UsuarioController implements IController<Usuario> {

    private UsuarioDao usuarioDao;

    public UsuarioController() {
        this.usuarioDao = new UsuarioDao();
    }

    @Override
    public int delete(Usuario objeto) {
        return usuarioDao.delete(objeto);
    }

    @Override
    public List<Usuario> get() {
        return usuarioDao.get();
    }

    @Override
    public Usuario get(Long id) {
        return usuarioDao.get(id);
    }

    @Override
    public List<Usuario> get(String termoBusca) {
        return usuarioDao.get(termoBusca);
    }

    @Override
    public int save(Usuario objeto) {
        if (objeto.getId() == null) {
            return usuarioDao.insert(objeto);
        } else {
            return usuarioDao.update(objeto);
        }
    }

    @Override
    public List<Usuario> processListRequest(HttpServletRequest req) {
        List<Usuario> registros = new ArrayList<>();
        String paramExcluir = req.getParameter("excluir");
        if (paramExcluir != null && !paramExcluir.isEmpty()) {
            Usuario usuario = new Usuario();
            Long id = Long.parseLong(paramExcluir);
            usuario = this.get(id);
            this.delete(usuario);
        }
        registros = this.get();
        return registros;
    }

    @Override
    public Usuario processFormRequest(HttpServletRequest req, HttpServletResponse res) {
        Usuario usuario = new Usuario();
        String submit = req.getParameter("submit");
        String paramId = req.getParameter("id");

        if (paramId != null && !paramId.isEmpty()) {
            Long id = Long.parseLong(paramId);
            usuario = this.get(id); 

        if (submit != null) {
            usuario.setNomeCompleto(req.getParameter("nomeCompleto"));
            usuario.setNomeUsuario(req.getParameter("nomeUsuario"));
            usuario.setSenha(req.getParameter("senha"));
            usuario.setAtivo(Boolean.parseBoolean(req.getParameter("ativo")));
            usuario.setPapel(req.getParameter("papel"));
            this.save(usuario);

            try {
                res.sendRedirect("usuarios.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return usuario;
    }
}

