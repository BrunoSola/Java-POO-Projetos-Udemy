package heranca_polimorfismo.calculoSimplesImposto.model.entities;

public class PessoaFisica extends Contribuinte {

    private Double gastoSaude;

    public PessoaFisica() {
        super();
    }

    public PessoaFisica(String name, Double rendaAnual, Double gastosSaude) {
        super(name, rendaAnual);
        gastoSaude = gastosSaude;
    }

    public Double getGastoSaude() {
        return gastoSaude;
    }

    public void setGastoSaude(Double gastoSaude) {
        this.gastoSaude = gastoSaude;
    }

    @Override
    public double tax() {
        if (super.getRendaAnual() < 20000){
            return super.getRendaAnual() * 0.15 - gastoSaude * 0.5;
        }
        else {
            return super.getRendaAnual() * 0.25 - gastoSaude * 0.5;
        }
    }
}

