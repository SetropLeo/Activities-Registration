<h1> SA06 - Parte 2 </h1>

<p>
  Sistema de gerenciamento de atividades de projetos. DeveloperSystems ©.
</p>

## Sumário
<ul>
  <li><a href="#telas">Telas</a></li>
  <li><a href="#tecnologias">Tecnologias utilizadas</a></li>
  <li><a href="#getting-started">Getting Started</a></li>
  <li><a href="#licença">Licença</a></li>
</ul>
</br>

## Telas
<table>
<tr>
  <th>Tela Inicial</th>
  <th>Listagem de reservas</th>
  <th>Adição de Reservas</th>
  <th>Edição de Reserva</th>
  </tr>
  <tr>
    <td><img src="./src/base/index.jpg"/></td>
    <td><img src="./src/base/listagem.jpg"/></td>
    <td><img src="./src/base/adicao.jpg"/></td>
    <td><img src="./src/base/edicao.jpg"/></td>
  </tr>
</table>
</br>



## Tecnologias

- Java
- WildFly 24
- HTML
- CSS
- Bootstrap
- MySQL
</br>



## Getting Started

- Eclipse [Required]
- Gerenciador de banco SQL (MySQL WorkBench / PostGres / Adjacente) [Required]
- Java 8 [Required]
- JDK 1.8+ [Required]
- WildFly 24 [Required]
</br>

1. Clonar o repositório
<pre>
<code>git clone https://github.com/SetropLeo/Activities-Registration.git</code>
</pre>
</br>

2. Configurar o projeto com o banco de dados no arquivo AtividadeDAO (src/main/java/dao/AtividadeDAO.java)
<pre>
<code>1. Alterar login do banco</code>
<code>2. Alterar senha do banco</code>
<code>3. Alterar url do banco</code>
</pre>
</br>

3. No gerenciador de bancos, criar um novo banco chamado activitiesregistration. Rodar o seguinte comando: 
<pre>
<code>create database activitiesregistration</code>
</pre>
</br>

4. Criar a seguinte tabela dentro do banco gymschedule: 
<pre>
<code>CREATE TABLE atividades (
id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
projeto VARCHAR(50),
atividade VARCHAR(50), 
responsavel VARCHAR(50), 
inicioAtividade VARCHAR(50), 
finalAtividade VARCHAR(50),
dependencia int
);</code>
</pre>
</br>

5. Para rodar o projeto, clicar com o botão direito em cima da pasta do projeto e selecionar: 
<pre>
 <code>Run As -> Run on Server -> WildFly 24</code>
</pre>
<p> Após isso, é só acessar o seguinte link:</p>
<code><a href="http://localhost:8080/GymSchedule/">http://localhost:8080/ActivitiesRegistration/</a></code>
<br><br>


## Licença

- Licença MIT
<br><br>
