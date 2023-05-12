package controle;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AtividadeDAO;
import modelo.Atividade;

@WebServlet("/")
public class AtividadeServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private AtividadeDAO atividadeDAO;

  public void init() {
    atividadeDAO = new AtividadeDAO();
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String acao = request.getServletPath();

    try {
      switch (acao) {
        case "/novo":
          exibirNovaAtividade(request, response);
          break;
        case "/inserir":
          inserirAtividade(request, response);
          break;
        case "/deletar":
          deletarAtividade(request, response);
          break;
        case "/editar":
          exibirEditarAtividade(request, response);
          break;
        case "/atualizar":
          atualizarAtividade(request, response);
          break;
        default:
          listarAtividades(request, response);
          break;
      }
    } catch (SQLException ex) {
      throw new ServletException(ex);
    }
  }

  private void listarAtividades(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException, ServletException {
    List<Atividade> listarAtividades = atividadeDAO.listarAtividades();
    request.setAttribute("listarAtividades", listarAtividades);
    RequestDispatcher dispatcher = request.getRequestDispatcher("listagem.jsp");
    dispatcher.forward(request, response);
  }

  private void exibirNovaAtividade(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    RequestDispatcher dispatcher = request.getRequestDispatcher("cadastro.jsp");
    dispatcher.forward(request, response);
  }

  private void exibirEditarAtividade(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, ServletException, IOException {
    int id = Integer.parseInt(request.getParameter("id"));
    Atividade atividade = atividadeDAO.selecionarAtividadeById(id);
    RequestDispatcher dispatcher = request.getRequestDispatcher("cadastro.jsp");
    request.setAttribute("atividade", atividade);
    dispatcher.forward(request, response);
  }

  private void inserirAtividade(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException {
    String projeto = request.getParameter("projeto");
    String atividade = request.getParameter("atividade");
    String responsavel = request.getParameter("responsavel");
    String inicioAtividade = request.getParameter("inicioAtividade");
    String finalAtividade = request.getParameter("finalAtividade");
    int dependencia = Integer.parseInt(request.getParameter("dependencia"));
    Atividade novaAtividade = new Atividade(projeto, atividade, responsavel, inicioAtividade, finalAtividade,
        dependencia);
    atividadeDAO.inserirAtividade(novaAtividade);
    response.sendRedirect("listagem");
  }

  private void atualizarAtividade(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException {
    int id = Integer.parseInt(request.getParameter("id"));
    String projeto = request.getParameter("projeto");
    String atividade = request.getParameter("atividade");
    String responsavel = request.getParameter("responsavel");
    String inicioAtividade = request.getParameter("inicioAtividade");
    String finalAtividade = request.getParameter("finalAtividade");
    int dependencia = Integer.parseInt(request.getParameter("dependencia"));
    Atividade atividadeAtualizada = new Atividade(id, projeto, atividade, responsavel, inicioAtividade, finalAtividade,
        dependencia);
    atividadeDAO.atualizarAtividade(atividadeAtualizada);
    response.sendRedirect("listagem");
  }

  private void deletarAtividade(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException {
    int id = Integer.parseInt(request.getParameter("id"));
    atividadeDAO.deletarAtividade(id);
    response.sendRedirect("listagem");
  }
}
