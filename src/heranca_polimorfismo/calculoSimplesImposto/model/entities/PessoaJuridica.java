package heranca_polimorfismo.calculoSimplesImposto.model.entities;

public class PessoaJuridica extends Contribuinte{

    private Integer numeroFuncionarios;

    public PessoaJuridica() {
        super();
    }

    public PessoaJuridica(String name, Double rendaAnual, Integer numeroFuncionarios) {
        super(name, rendaAnual);
        this.numeroFuncionarios = numeroFuncionarios;
    }

    public Integer getNumeroFuncionarios() {
        return numeroFuncionarios;
    }

    public void setNumeroFuncionarios(Integer numeroFuncionarios) {
        this.numeroFuncionarios = numeroFuncionarios;
    }

    @Override
    public double tax() {
        if (numeroFuncionarios > 10){
            return super.getRendaAnual() * 0.14;
        }
        else {
            return super.getRendaAnual() * 0.16;
        }
    }
}
