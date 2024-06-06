package main.java.br.ufac.sgcm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.ufac.sgcm.model.Atendimento;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;

public class AtendimentoServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) {
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        String paramBusca = req.getParameter("busca");
        AtendimentoController controller = new AtendimentoController();
        List<Atendimento> atendimentos;
        
        if (paramBusca != null && !paramBusca.isEmpty()) {
            atendimentos = controller.get(paramBusca);
        } else {
            atendimentos = controller.get();
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            PrintWriter saida = res.getWriter();
            String json = mapper.writeValueAsString(atendimentos);
            saida.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
