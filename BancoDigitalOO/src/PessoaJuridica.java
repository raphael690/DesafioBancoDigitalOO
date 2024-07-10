public class PessoaJuridica extends Cliente {

    private String cnpj;

    public PessoaJuridica(String nome, String cnpj){
        setNome(nome);
        this.cnpj = cnpj;
    }

    public String getCnpj(){
        return cnpj;
    }

    public void setCnpj(String cnpj){
        this.cnpj = cnpj;
    }
}
