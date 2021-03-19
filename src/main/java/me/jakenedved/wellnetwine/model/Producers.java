package me.jakenedved.wellnetwine.model;

public class Producers implements java.io.Serializable {

  private String producersID;
  private String producersName;
  private String producersEmail;
  private String producersRegion;

  public Producers() {
  }

  public String getProducersID() {
    return producersID;
  }

  public void setProducersID(String producersID) {
    this.producersID = producersID;
  }

  public String getProducersName() {
    return producersName;
  }

  public void setProducersName(String producersName) {
    this.producersName = producersName;
  }

  public String getProducersEmail() {
    return producersEmail;
  }

  public void setProducersEmail(String producersEmail) {
    this.producersEmail = producersEmail;
  }

  public String getProducersRegion() {
    return producersRegion;
  }

  public void setProducersRegion(String producersRegion) {
    this.producersRegion = producersRegion;
  }

}
