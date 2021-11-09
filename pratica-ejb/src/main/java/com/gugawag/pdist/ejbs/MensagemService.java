package com.gugawag.pdist.ejbs;

import com.gugawag.pdist.model.Mensagem;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless(name = "mensagemService")
public class MensagemService {

    @EJB
    private MensagemDAO mensagemDAO;

    public List<Mensagem> listar() {
        return mensagemDAO.listar();
    }

    public void inserir(long id, String texto) {
        mensagemDAO.inserir(new Mensagem(id, texto));
    }

    public Mensagem pesquisarPorId(long id) {
        return mensagemDAO.pesquisarPorId(id);
    }
}
