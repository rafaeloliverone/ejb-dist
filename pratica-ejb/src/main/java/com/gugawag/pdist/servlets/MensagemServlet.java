package com.gugawag.pdist.servlets;

import com.gugawag.pdist.ejbs.MensagemService;
import com.gugawag.pdist.model.Mensagem;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/mensagem.do"})
public class MensagemServlet extends javax.servlet.http.HttpServlet{
    @EJB(lookup="java:module/mensagemService")
    private MensagemService mensagemService;

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {

        String operacao = request.getParameter("operacao");
        PrintWriter resposta = response.getWriter();

        switch (operacao) {
            case "1": {
                long id = Integer.parseInt(request.getParameter("id"));
                String text = request.getParameter("text");
                mensagemService.inserir(id, text);
            }
            case "2": {
                for(Mensagem msg: mensagemService.listar()){
                    resposta.println(msg.getTexto());
                }
                break;
            }
            case "3": {
                long idMsg = Integer.parseInt(request.getParameter("id"));
                Mensagem msg = mensagemService.pesquisarPorId(idMsg);

                resposta.println(msg.getTexto());
                break;
            }

        }

    }
}
