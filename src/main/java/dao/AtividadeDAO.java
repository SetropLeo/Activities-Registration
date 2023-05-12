package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Atividade;

public class AtividadeDAO {
  private String dbUrl = "jdbc:mysql://localhost/activitiesregistration";
  private String dbUser = "root";
  private String dbPassword = "1234";

  private static final String INSERT_ATIVIDADE = "INSERT INTO atividades"
      + "  (projeto, atividade, responsavel, inicioAtividade, finalAtividade, dependencia) VALUES "
      + " (?, ?, ?, ?, ?, ?);";
  private static final String SELECT_ATIVIDADE_BY_ID = "select id,projeto,atividade,responsavel,inicioAtividade,finalAtividade,dependencia from atividades where id =?";
  private static final String SELECT_ALL_ATIVIDADES = "select * from atividades";
  private static final String DELETE_ATIVIDADE_BY_ID = "delete from atividades where id = ?;";
  private static final String UPDATE_ATIVIDADE_BY_IDL = "update atividades set projeto = ?,atividade= ?, responsavel =?, inicioAtividade =?, finalAtividade =?, dependencia =? where id = ?;";

  public AtividadeDAO() {
  }

  protected Connection getConnection() {
    Connection connection = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    return connection;
  }

  public void inserirAtividade(Atividade atividade) throws SQLException {
    System.out.println(INSERT_ATIVIDADE);
    try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ATIVIDADE)) {
      preparedStatement.setString(1, atividade.getProjeto());
      preparedStatement.setString(2, atividade.getAtividade());
      preparedStatement.setString(3, atividade.getResponsavel());
      preparedStatement.setString(4, atividade.getInicioAtividade());
      preparedStatement.setString(5, atividade.getFinalAtividade());
      preparedStatement.setInt(6, atividade.getDependencia());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      printSQLException(e);
    }
  }

  public Atividade selecionarAtividadeById(int id) {
    Atividade atividade = null;
    try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ATIVIDADE_BY_ID);) {
      preparedStatement.setInt(1, id);
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        String projeto = rs.getString("projeto");
        String atividadeNome = rs.getString("atividade");
        String responsavel = rs.getString("responsavel");
        String inicioAtividade = rs.getString("inicioAtividade");
        String finalAtividade = rs.getString("finalAtividade");
        int dependencia = rs.getInt("dependencia");
        atividade = new Atividade(id, projeto, atividadeNome, responsavel, inicioAtividade, finalAtividade,
            dependencia);
      }
    } catch (SQLException e) {
      printSQLException(e);
    }
    return atividade;
  }

  public List<Atividade> listarAtividades() {
    List<Atividade> atividades = new ArrayList<>();
    try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ATIVIDADES);) {
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        int id = rs.getInt("id");
        String projeto = rs.getString("projeto");
        String atividade = rs.getString("atividade");
        String responsavel = rs.getString("responsavel");
        String inicioAtividade = rs.getString("inicioAtividade");
        String finalAtividade = rs.getString("finalAtividade");
        int dependencia = rs.getInt("dependencia");
        atividades.add(new Atividade(id, projeto, atividade, responsavel, inicioAtividade, finalAtividade,
            dependencia));
      }
    } catch (SQLException e) {
      printSQLException(e);
    }
    return atividades;
  }

  public boolean deletarAtividade(int id) throws SQLException {
    boolean atividadeDeletada;
    try (Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(DELETE_ATIVIDADE_BY_ID);) {
      statement.setInt(1, id);
      atividadeDeletada = statement.executeUpdate() > 0;
    }
    return atividadeDeletada;
  }

  public boolean atualizarAtividade(Atividade atividade) throws SQLException {
    boolean atividadeAtualizada;
    try (Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(UPDATE_ATIVIDADE_BY_IDL);) {
      statement.setString(1, atividade.getProjeto());
      statement.setString(2, atividade.getAtividade());
      statement.setString(3, atividade.getResponsavel());
      statement.setString(4, atividade.getInicioAtividade());
      statement.setString(5, atividade.getFinalAtividade());
      statement.setInt(6, atividade.getDependencia());
      statement.setInt(7, atividade.getId());
      atividadeAtualizada = statement.executeUpdate() > 0;
    }
    return atividadeAtualizada;
  }

  private void printSQLException(SQLException ex) {
    for (Throwable e : ex) {
      if (e instanceof SQLException) {
        e.printStackTrace(System.err);
        System.err.println("SQLState: " + ((SQLException) e).getSQLState());
        System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
        System.err.println("Message: " + e.getMessage());
        Throwable causaErro = ex.getCause();
        while (causaErro != null) {
          System.out.println("Cause: " + causaErro);
          causaErro = causaErro.getCause();
        }
      }
    }
  }
}
