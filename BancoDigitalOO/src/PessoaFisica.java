public class PessoaFisica extends Cliente {
    //atributo
    private String cpf;
    //construtor
    public PessoaFisica(String nome, String cpf){
        setNome(nome);
        this.cpf = cpf;
    }

    public String getCpf(){
        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

}
