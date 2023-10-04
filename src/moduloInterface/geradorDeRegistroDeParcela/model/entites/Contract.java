package moduloInterface.geradorDeRegistroDeParcela.model.entites;

import java.time.LocalDate;

public class Contract {

    private Integer contractNumber;
    private LocalDate date;
    private Double totalValue;

    public Contract(Integer contractNumber, LocalDate date, Double totalValue) {
        this.contractNumber = contractNumber;
        this.date = date;
        this.totalValue = totalValue;
    }

    public Integer getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(Integer contractNumber) {
        this.contractNumber = contractNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }
}
