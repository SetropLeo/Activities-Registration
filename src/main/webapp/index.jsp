<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <html>

    <head>
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
      <title>Realize seus agendamentos da academia</title>
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous" />
      <style>
        body {
          background: url("https://qualyteam.com/pb/wp-content/uploads/2014/01/Blog-post-documento-e-registro.jpg") no-repeat center center fixed;
          background-size: cover;
        }

        .login-box {
          margin-top: 25%;
          border: 1px solid #f2f2f2;
          background-color: #fff;
          border-radius: 5px;
          -webkit-box-shadow: 0px 0px 15px 5px rgba(0, 0, 0, 0.4);
          -moz-box-shadow: 0px 0px 15px 5px rgba(0, 0, 0, 0.4);
          box-shadow: 0px 0px 15px 5px rgba(0, 0, 0, 0.4);
          animation: slide-up 0.5s ease;
        }

        .login-box-header {
          background-color: #63B8E1;
          color: #fff;
          padding: 20px;
          border-top-left-radius: 5px;
          border-top-right-radius: 5px;
          text-align: center;
          font-weight: bold;
          font-size: 24px;
          display: flex;
          flex-direction: column;
        }

        .login-box-body {
          padding: 20px;
          display: flex;
          flex-direction: column;
        }

        .btn-login {
          color: black;
          border-radius: 3px;
          margin-top: 20px;
          padding: 10px;
          font-weight: bold;
          transition: background-color 0.5s ease;
          border: 1px solid black;
        }

        .btn-login:hover {
          background-color: #63B8E1;
          color: #fff;
        }

        @keyframes slide-up {
          0% {
            transform: translateY(100px);
            opacity: 0;
          }

          100% {
            transform: translateY(0px);
            opacity: 1;
          }
        }
      </style>
    </head>

    <body>
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-md-8 col-lg-6">
            <div class="login-box">
              <div class="login-box-header">
                <p>Sistema de Gerenciamento de projetos</p>
                <p>Controle de atividades</p>
              </div>
              <div class="login-box-body">
                <a class="btn btn-login" href="<%=request.getContextPath()%>/novo">Criar uma nova atividade para um projeto </a>
                <a class="btn btn-login" href="<%=request.getContextPath()%>/listagem">Visualizar atividades</a>
                <p class="mt-4 text-center">DeveloperSystems ©</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </body>

    </html>