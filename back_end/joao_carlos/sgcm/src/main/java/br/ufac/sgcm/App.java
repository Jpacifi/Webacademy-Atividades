package br.ufac.sgcm;

import java.sql.Connection;
import java.util.List;

import br.ufac.sgcm.dao.ConexaoDB;
import br.ufac.sgcm.dao.EspecialidadeDao;
import br.ufac.sgcm.dao.ProfissionalDao;
import br.ufac.sgcm.dao.UnidadesDao;
import br.ufac.sgcm.model.Especialidade;
import br.ufac.sgcm.model.Profissional;
import br.ufac.sgcm.model.Unidade;

public class App {
    public static void main(String[] args) {
        Profissional p1 = new Profissional();
        p1.setId(14L);
        p1.setNome("Limeira Pacifico");
        p1.setEmail("limeira@ufac.br");
        p1.setTelefone("999999999");
        p1.setRegistro("CRM-123");
        p1.setEspecialidade(1L);
        p1.setUnidade(1L);

        Unidade u1 = new Unidade();
        u1.setId(6L);
        u1.setNome("Rua Apodi");
        u1.setEndereco("Bela Vista");

        Especialidade e1 = new Especialidade();
        e1.setId(13L);
        e1.setNome("Oncologista Alterado 3");


        ConexaoDB conexao = new ConexaoDB();
        Connection instancia = conexao.getConexao();
        if (instancia != null) {
            System.out.println("Conectou");
        } else {
            System.out.println("Falhou");
        }
        EspecialidadeDao eDao = new EspecialidadeDao();
        List<Especialidade> listaEspecialidade = eDao.get();
        System.out.println("Lista de Especialidades");
        for (Especialidade item : listaEspecialidade) {
            System.out.println(item.getId() + "|" + item.getNome());
        }
        System.out.println("Uma especialidade");
        Especialidade esp = eDao.get(2L);
        System.out.println(esp.getId() + "|" + esp.getNome());
        System.out.println("Lista com termo de busca: gia");
        List<Especialidade> listaBusca = eDao.get("gia");
        for (Especialidade item : listaBusca) {
            System.out.println(item.getId() + "|" + item.getNome());
        }
        // Inserindo uma especialidade
        /*
         * if (eDao.insert(e1) == 1)
         * System.out.println("Especialidade inserida com sucesso!");
         * System.out.println("Lista de Especialidades");
         * listaEspecialidade = eDao.get(); // Recarregando a lista
         * for (Especialidade item : listaEspecialidade) {
         * System.out.println(item.getId() + "|" + item.getNome());
         * }
         */
        // Atualizando uma especialidade
        // eDao.update(e1);
        // System.out.println("Especialidade Alterada: " + eDao.get(13L).getNome());
        // Deletando uma especialidade
        /*eDao.delete(e1);
        listaEspecialidade = eDao.get();
        System.out.println("Lista de Especialidades");
        for (Especialidade item : listaEspecialidade) {
            System.out.println(item.getId() + "|" + item.getNome());
        }*/

        UnidadesDao eDao2 = new UnidadesDao();
        List<Unidade> listaUnidades = eDao2.get();
        System.out.printf("\nLista de Unidades:\n");
        for (Unidade item : listaUnidades) {
            System.out.println(item.getId() +"|" + item.getNome()+"|"+item.getEndereco());
        }
        System.out.println("\nUma Unidade:\n");
        Unidade esp2 = eDao2.get(2L);
        System.out.println(esp2.getId() + "|" + esp2.getNome()+"|"+esp2.getEndereco());

        /*if (eDao2.insert(u1) == 1){
            System.out.println("\nUnidade inserida com sucesso!\n");
            listaUnidades = eDao2.get();
            System.out.printf("\nLista de Unidades:\n");
            for (Unidade item : listaUnidades) {
            System.out.println(item.getId() +"|" + item.getNome()+"|"+item.getEndereco());
        }
    }*/

        /*System.out.println("\nLista com termo de busca: Bela\n");
        List<Unidade> listaBusca2 = eDao2.get("Bela");
        for (Unidade item : listaBusca2) {
            System.out.println(item.getId() + "|" + item.getNome() +"|"+item.getEndereco());
        }
        eDao2.update(u1);
        System.out.println("Unidade Alterada: " + eDao2.get(5L).getNome()+"|"+eDao2.get(5L).getEndereco());
        
        System.out.printf("\nLista de Unidades:\n");
        for (Unidade item : listaUnidades) {
            System.out.println(item.getId() +"|" + item.getNome()+"|"+item.getEndereco());
        }

        eDao2.delete(u1);
        listaUnidades = eDao2.get();
        System.out.printf("\nLista de Unidades:\n");
        for (Unidade item : listaUnidades) {
            System.out.println(item.getId() +"|" + item.getNome()+"|"+item.getEndereco());
        }*/

        ProfissionalDao eDao3 = new ProfissionalDao();
        List<Profissional> listaProfissional = eDao3.get();
        System.out.printf("\nLista de Profissional:\n");
        for (Profissional item : listaProfissional) {
            System.out.println(item.getId() +"|" + item.getNome()+"|"+item.getRegistro()+"|"+item.getEmail()+"|"+item.getTelefone()+"|"+item.getEspecialidade()+"|"+item.getUnidade());
        }
        /*if(eDao3.insert(p1)==1){
            System.out.println("\nProfissional inserido com sucesso!\n");
            listaProfissional = eDao3.get();
            System.out.printf("\nLista de Profissional:\n");
            for (Profissional item : listaProfissional) {
            System.out.println(item.getId() +"|" + item.getNome()+"|"+item.getRegistro()+"|"+item.getEmail()+"|"+item.getTelefone()+"|"+item.getEspecialidade()+"|"+item.getUnidade());
            }
        }*/
        /*if(eDao3.update(p1)==1){
            System.out.println("\nProfissional alteardo com sucesso!\n");
            listaProfissional = eDao3.get();
            System.out.printf("\nLista de Profissional:\n");
            for (Profissional item : listaProfissional) {
            System.out.println(item.getId() +"|" + item.getNome()+"|"+item.getRegistro()+"|"+item.getEmail()+"|"+item.getTelefone()+"|"+item.getEspecialidade()+"|"+item.getUnidade());
            }
        }*/
        if(eDao3.delete(p1)==1){
            System.out.println("\nProfissional deletado com sucesso!\n");
            listaProfissional = eDao3.get();
            System.out.printf("\nLista de Profissional:\n");
            for (Profissional item : listaProfissional) {
            System.out.println(item.getId() +"|" + item.getNome()+"|"+item.getRegistro()+"|"+item.getEmail()+"|"+item.getTelefone()+"|"+item.getEspecialidade()+"|"+item.getUnidade());
            }
        }
    }
}
