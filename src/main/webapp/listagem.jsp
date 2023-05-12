<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <html>

    <head>
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
      <title>Listagem de Atividades</title>
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous" />
      <style>
        nav {
          gap: 40px;
          justify-content: space-between;
        }

        th {
          border-bottom: 1px solid #e2e2e2 !important;
          text-align: center;
        }

        tr {
          border-top: 1px solid #e2e2e2;
          border-bottom: 1px solid #e2e2e2;
          text-align: center;
        }

        .top-content {
          display: flex;
          flex-direction: row;
          align-items: center;
        }

        .title {
          width: 100%;
        }
      </style>
    </head>

    <body>
      <header>
        <nav class="navbar navbar-dark bg-primary">
          <div>
            <a href="" class="navbar-brand">Listagem de Atividades</a>
          </div>
          <ul class="navbar-nav">
            <li>
              <a href="<%=request.getContextPath()%>" class="nav-link">Menu Inicial</a>
            </li>
          </ul>
        </nav>
      </header>
      <br />
      <div class="container">
        <div class="top-content">
          <h3 class="title">Atividades existentes</h3>
          <div class="container text-right">
            <a href="<%=request.getContextPath()%>/novo" class="btn btn-success btn-sm">Nova Atividade</a>
          </div>
        </div>
        <hr />
        <br />
        <table class="table table-hover table-sm">
          <thead>
            <tr>
              <th scope="col">Id</th>
              <th scope="col">Projeto</th>
              <th scope="col">Atividade</th>
              <th scope="col">Responsavel</th>
              <th scope="col">Inicio da Atividade</th>
              <th scope="col">Final da Atividade</th>
              <th scope="col">Dependencia</th>
            </tr>
          </thead>
          <tbody class="align-middle">
            <c:forEach var="atividade" items="${listarAtividades}">
              <tr>
                <td>
                  <c:out value="${atividade.id}" />
                </td>
                <td>
                  <c:out value="${atividade.projeto}" />
                </td>
                <td>
                  <c:out value="${atividade.atividade}" />
                </td>
                <td>
                  <c:out value="${atividade.responsavel}" />
                </td>
                <td>
                  <c:out value="${atividade.inicioAtividade}" />
                </td>
                <td>
                  <c:out value="${atividade.finalAtividade}" />
                </td>
                <td>
                  <c:out value="${atividade.dependencia}" />
                </td>
                <td>
                  <a href="editar?id=<c:out value='${atividade.id}' />" class="btn btn-primary btn-sm">EDITAR</a>
                  <a href="deletar?id=<c:out value='${atividade.id}' />" class="btn btn-danger btn-sm">DELETAR</a>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </body>

    </html>