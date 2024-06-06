package br.ufac.sgcm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.ufac.sgcm.dao.AtendimentoDao;
import br.ufac.sgcm.model.Atendimento;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AtendimentoController implements IController<Atendimento> {

    private AtendimentoDao aDao;

    public AtendimentoController() {
        aDao = new AtendimentoDao();
    }

    @Override
    public int delete(Atendimento objeto) {
        int registrosAfetados = aDao.delete(objeto);
        return registrosAfetados;
    }

    @Override
    public List<Atendimento> get() {
        List<Atendimento> registros = aDao.get();
        return registros;
    }

    @Override
    public Atendimento get(Long id) {
        Atendimento registro = aDao.get(id);
        return registro;
    }

    @Override
    public List<Atendimento> get(String termoBusca) {
        List<Atendimento> registros = aDao.get(termoBusca);
        return registros;
    }

    @Override
    public int save(Atendimento objeto) {
        int registrosAfetados = 0;
        if (objeto.getId() == null)
            registrosAfetados = aDao.insert(objeto);
        else
            registrosAfetados = aDao.update(objeto);
        return registrosAfetados;
    }

    // Servlet Methods
    @Override
    public List<Atendimento> processListRequest(HttpServletRequest req) {
        List<Atendimento> registros = new ArrayList<>();
        String paramExcluir = req.getParameter("excluir");
        if (paramExcluir != null && !paramExcluir.isEmpty()) {
            Atendimento atendimento = new Atendimento();
            Long id = Long.parseLong(paramExcluir);
            atendimento = this.get(id);
            this.delete(atendimento);
        }
        registros = this.get();
        return registros;
    }

    @Override
    public Atendimento processFormRequest(HttpServletRequest req, HttpServletResponse res) {
        Atendimento item = new Atendimento();
        String submit = req.getParameter("submit");
        String paramId = req.getParameter("id");
        if (paramId != null && !paramId.isEmpty()) {
            Long id = Long.parseLong(paramId);
            item = this.get(id); // Retrieve the existing item from the database
        }
        if (submit != null) {
            item.setData(req.getParameter("data"));
            item.setStatus(req.getParameter("status"));
            item.setConvenio_id(Long.parseLong(req.getParameter("convenio_id")));
            item.setPaciente_id(Long.parseLong(req.getParameter("paciente_id")));
            item.setProfissional_id(Long.parseLong(req.getParameter("profissional_id")));
            this.save(item);

            try {
                res.sendRedirect(req.getContextPath() + "/atendimentos.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return item;
    }

}
