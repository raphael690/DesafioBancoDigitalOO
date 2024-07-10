import javax.swing.JOptionPane;

public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente){
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        
        //System.out.println("=== Extrato Conta Corrente ===");
        JOptionPane.showMessageDialog(null,"=== Extrato Conta Corrente ===");
        super.imprimirInfosComuns();        
    }        

}
