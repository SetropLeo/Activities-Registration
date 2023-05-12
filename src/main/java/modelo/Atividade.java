package modelo;

public class Atividade {
  protected int id;
  protected String projeto;
  protected String atividade;
  protected String responsavel;
  protected String inicioAtividade;
  protected String finalAtividade;
  protected int dependencia;

  public Atividade() {
  }

  public Atividade(String projeto, String atividade, String responsavel, String inicioAtividade,
      String finalAtividade,
      int dependencia) {
    super();
    this.projeto = projeto;
    this.atividade = atividade;
    this.responsavel = responsavel;
    this.inicioAtividade = inicioAtividade;
    this.finalAtividade = finalAtividade;
    this.dependencia = dependencia;
  }

  public Atividade(int id, String projeto, String atividade, String responsavel, String inicioAtividade,
      String finalAtividade,
      int dependencia) {
    super();
    this.id = id;
    this.projeto = projeto;
    this.atividade = atividade;
    this.responsavel = responsavel;
    this.inicioAtividade = inicioAtividade;
    this.finalAtividade = finalAtividade;
    this.dependencia = dependencia;
  }

  public int getId() {
    return id;
  }

  public String getProjeto() {
    return projeto;
  }

  public String getAtividade() {
    return atividade;
  }

  public String getResponsavel() {
    return responsavel;
  }

  public String getInicioAtividade() {
    return inicioAtividade;
  }

  public String getFinalAtividade() {
    return finalAtividade;
  }

  public int getDependencia() {
    return dependencia;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setProjeto(String projeto) {
    this.projeto = projeto;
  }

  public void setAtividade(String atividade) {
    this.atividade = atividade;
  }

  public void setResponsavel(String responsavel) {
    this.responsavel = responsavel;
  }

  public void setInicioAtividade(String inicioAtividade) {
    this.inicioAtividade = inicioAtividade;
  }

  public void setFinalAtividade(String finalAtividade) {
    this.finalAtividade = finalAtividade;
  }

  public void setDependencia(int dependencia) {
    this.dependencia = dependencia;
  }
}
