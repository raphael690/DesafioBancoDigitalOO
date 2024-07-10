import javax.swing.JOptionPane;

public class ContaPoupanca extends Conta{

    public ContaPoupanca(Cliente cliente){
        super(cliente);
    }

    public void imprimirExtrato() {        
       // System.out.println("=== Extrato Conta Poupança ===");
       JOptionPane.showMessageDialog(null, "=== Extrato Conta Poupança ===");
        super.imprimirInfosComuns();
    }        
  
}
