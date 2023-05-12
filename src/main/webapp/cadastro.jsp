<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<html>

		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
			<title>Cadastro de Atividades</title>
			<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
			<style>
				.navbar-nav {
					gap: 40px;
					flex-direction: row !important;
				}
			</style>
		</head>

		<body>
			<header>
				<nav class="navbar navbar-dark bg-primary">
					<div>
						<a href="" class="navbar-brand">Cadastro de Atividade</a>
					</div>
					<ul class="navbar-nav">
						<a href="<%=request.getContextPath()%>/listagem" class="nav-link">Listagem
							de atividades</a>
						</li>
						<li><a href="<%=request.getContextPath()%>" class="nav-link">Menu
								Inicial</a></li>
						<li>
					</ul>
				</nav>
			</header>
			<br>
			<div class="container col-md-5">
				<div class="card">
					<div class="card-body">
						<c:if test="${atividade != null}">
							<form action="atualizar" method="post">
						</c:if>
						<c:if test="${atividade == null}">
							<form action="inserir" method="post">
						</c:if>
						<caption>
							<h2>
								<c:if test="${atividade != null}">
									Editar Atividade
									<hr>
								</c:if>
								<c:if test="${atividade == null}">
									Adicionar Atividade
									<hr>
								</c:if>
							</h2>
						</caption>
						<c:if test="${atividade != null}">
							<input type="hidden" name="id" value="<c:out value='${atividade.id}' />" />
						</c:if>
						<fieldset class="form-group">
							<label>Projeto</label> <input type="text" placeholder="Ex: Projeto Senai" value="<c:out value='${atividade.projeto}' />" class="form-control" name="projeto" required="required">
						</fieldset>
						<fieldset class="form-group">
							<label>Atividade</label> <input type="text" placeholder="Ex: Criar tela de login" value="<c:out value='${atividade.atividade}' />" class="form-control" name="atividade" required="required">
						</fieldset>
						<fieldset class="form-group">
							<label>Responsavel</label> <input type="text" placeholder="Ex: Leonardo Portes" value="<c:out value='${atividade.responsavel}' />" class="form-control" name="responsavel" required="required">
						</fieldset>
						<fieldset class="form-group">
							<label>Data de Inicio da Atividade</label> <input type="text" placeholder="Ex: 12/05/2023" value="<c:out value='${atividade.inicioAtividade}' />" class="form-control" name="inicioAtividade" required="required">
						</fieldset>
						<fieldset class="form-group">
							<label>Data de Final da Atividade</label> <input type="text" placeholder="Ex: 13/05/2023" value="<c:out value='${atividade.finalAtividade}' />" class="form-control" name="finalAtividade" required="required">
						</fieldset>
						<fieldset class="form-group">
							<label>Id da atividade de dependência</label> <input type="text" placeholder="Ex: 1" value="<c:out value='${atividade.dependencia}' />" class="form-control" name="dependencia" required="required">
						</fieldset>
						<button type="submit" class="btn btn-success btn-sm">Salvar</button>
						<a class="btn btn-danger btn-sm" href="<%=request.getContextPath()%>/listagem">Cancelar</a>
						</form>
					</div>
				</div>
			</div>
		</body>

		</html>