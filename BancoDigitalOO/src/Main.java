import javax.swing.JOptionPane;

public class Main {

    public static void main (String[] args){
        
        String nome = JOptionPane.showInputDialog("Digite o nome do titular:");

        String tipoPessoa = JOptionPane.showInputDialog("A pessoa é Fisica ou Juridica? (F/J): ");

        Cliente titular;
        if(tipoPessoa.equalsIgnoreCase("F")){
            String cpf;
            do{
                cpf = JOptionPane.showInputDialog("Digite o CPF do titular: ");
                if(!isCPF(cpf)){
                    JOptionPane.showMessageDialog(null, "CPF inválido. Tente novamente. ");
                }
            }while(!isCPF(cpf));
            titular = new PessoaFisica(nome, cpf);
        }else{
            String cnpj;
            do{
                cnpj = JOptionPane.showInputDialog("Digite o CNPJ do titular:");
                if(!isCNPJ(cnpj)){
                    JOptionPane.showMessageDialog(null,"CNPJ inválido. Tente novamente. ");
                }
            }while(!isCNPJ(cnpj));
            titular = new PessoaJuridica(nome, cnpj);
        }
             

        ContaCorrente cc = new ContaCorrente(titular);
        ContaPoupanca cp = new ContaPoupanca(titular);

        Banco banco = new Banco("Meu Banco");
        banco.adicionarConta(cc);
        banco.adicionarConta(cp);

        double saldoInicialCc = Double.parseDouble(JOptionPane.showInputDialog("Digite o saldo inicial da conta corrente: "));
        cc.depositar(saldoInicialCc);

        double saldoInicialCp = Double.parseDouble(JOptionPane.showInputDialog("Digite o saldo incial da conta poupança: "));
        cp.depositar(saldoInicialCp);

        double depositoCc = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor a ser depositado na conta corrente: "));
        cc.depositar(depositoCc);

        double saqueCc = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor a ser sacado da conta corrente: "));
        cc.sacar(saqueCc);

        double transferencia = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor a ser transferido da conta corrente para a poupança: "));
        cc.transferir(transferencia, cp);

        cc.imprimirExtrato();
        cp.imprimirExtrato();    
    }

    //Método para validar CPF
    public static boolean isCPF(String CPF){
        // Removendo caracteres não numéricos
        CPF = CPF.replaceAll("[^0-9]","");
        if(CPF.length() != 11 || CPF.matches("(\\d)\\1{10}")){
            return false;
        }
        // calculando os digitos verificadores
        int[]pesos = {10,9,8,7,6,5,4,3,2};
        int soma = 0;
        for(int i = 0; i < 9; i++){
            soma += (CPF.charAt(i) - '0') * pesos[i];
        }
        int resto = 11 - (soma % 11);
        char digito1 = (resto > 9)? '0' : (char) (resto + '0');
        if(digito1 != CPF.charAt(9)){
            return false;
        }

        pesos = new int[]{11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
        soma = 0;
        for (int i = 0; i < 10; i++){
            soma += (CPF.charAt(i) - '0') * pesos[i];
        }

        resto = 11 - (soma % 11);
        char digito2 = (resto > 9) ? '0' : (char)(resto + '0');
        return digito2 == CPF.charAt(10);
    }
    
    // metodo para validar CNPJ
    public static boolean isCNPJ(String CNPJ){
        // removendo caracteres não numéricos
        CNPJ = CNPJ.replaceAll("[^0-9]", "");
        if(CNPJ.length() != 14 || CNPJ.matches("(\\d)\\1{13}")){
            return false;
        }

        // calculando os digitos verificadores
        int[] pesos = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4,  3, 2};
        int soma = 0;
        for(int i = 0; i < 12; i++){
            soma += (CNPJ.charAt(i) - '0' * pesos[i]);
        }

        int resto = soma % 11;
        char digito1 = (resto < 2) ? '0' : (char) (11 - resto + '0');
        if (digito1 != CNPJ.charAt(12)){
            return false;
        }

        pesos = new int[]{6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        soma = 0;
        for(int i = 0; i < 13; i++){
            soma += (CNPJ.charAt(i) - '0' * pesos[i]);
        }

        resto = soma % 11;
        char digito2 = (resto < 2) ? '0' : (char) (11 - resto + '0');
        return digito2 == CNPJ.charAt(13);
    }

}



















/*
        Cliente raphael = new Cliente();
        raphael.setNome("Raphael");

        Conta cc = new ContaCorrente(raphael);
        cc.depositar(1000);

        Conta poupanca = new ContaPoupanca(raphael);
        cc.transferir(100, poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
        */

        /*

        import java.util.Scanner;

public class Main {

    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do Titular: ");
        String nome = scanner.nextLine();

        System.out.println("A pessoa é Fisica ou Juridica? (F/J): ");
        String tipoPessoa = scanner.nextLine();

        Cliente titular;
        if(tipoPessoa.equalsIgnoreCase("F")){
            System.out.println("Digite o CPF do titular: ");
            String cpf = scanner.nextLine();
            titular = new PessoaFisica(nome, cpf);
        }else{
            System.out.println("Digite o CNPJ do titular: ");
            String cnpj = scanner.nextLine();
            titular = new PessoaJuridica(nome, cnpj);
        }

        ContaCorrente cc = new ContaCorrente(titular);
        ContaPoupanca cp = new ContaPoupanca(titular);

        Banco banco = new Banco("Meu Banco");
        banco.adicionarConta(cc);
        banco.adicionarConta(cp);

        System.out.println("Digite o saldo inicial da conta corrente: ");
        double saldoInicialCc = scanner.nextDouble();
        cc.depositar(saldoInicialCc);

        System.out.println("Digite o saldo incial da conta poupança: ");
        double saldoInicialCp = scanner.nextDouble();
        cp.depositar(saldoInicialCp);

        System.out.println("Digite o valor a ser depositado na conta corrente: ");
        double depositoCc = scanner.nextDouble();
        cc.depositar(depositoCc);

        System.out.println("Digite o valor a ser sacado da conta corrente: ");
        double saqueCc = scanner.nextDouble();
        cc.sacar(saqueCc);

        System.out.println("Digite o valor a ser transferido da conta corrente para a poupança: ");
        double transferido = scanner.nextDouble();
        cc.transferir(transferido, cp);

        cc.imprimirExtrato();
        cp.imprimirExtrato();

        scanner.close();

        
    }

}
*/