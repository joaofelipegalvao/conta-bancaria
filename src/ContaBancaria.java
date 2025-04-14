import java.util.Scanner;

public class ContaBancaria {
   public static void main(String[] args) {
      System.out.println("***********************");
      System.out.println("Dados iniciais do Cliente:");
      String nome = "João Felipe Galvão";
      String conta = "Corrente";
      double saldo = 2500.00;

      System.out.println("Nome: " + nome);
      System.out.println("Tipo conta: " + conta);
      System.out.println("Saldo inicial: " + saldo);
      System.out.println("***********************");

      Scanner scanner = new Scanner(System.in);
      int escolha = 0;
      while (escolha != 4) {
         System.out.println("Operações");
         System.out.println("1 - Consultar saldos");
         System.out.println("2 - Receber valor");
         System.out.println("3 - Transferir valor");
         System.out.println("4 - Sair");
         escolha = scanner.nextInt();

         switch (escolha) {
            case 1:
               saldoAtual(saldo);
               break;
            case 2:
               saldo = recebeTransferencia(saldo, scanner);
               break;
            case 3:
               saldo = fazTransferencia(saldo, scanner);
               break;
            case 4:
               System.out.println("Encerrando o programa...");
               break;
            default:
               System.out.println("Opção inválida.");
         }
      }
      scanner.close();
   }
   public static void saldoAtual(double saldo) {
      System.out.printf("Saldo atual: R$ %.2f%n", saldo);
   }
   public static double recebeTransferencia(double saldo, Scanner scanner) {
      System.out.println("Informe o valor a receber: ");
      double recebeValor = scanner.nextDouble();
      saldo += recebeValor;
      System.out.printf("Saldo atualizado R$: %.2f%n " , saldo);
      return saldo;
   }
   public static double fazTransferencia(double saldo, Scanner scanner ) {
      System.out.println("Informe o valor a transferir: ");
      double valorTransferencia = scanner.nextDouble();
      if (valorTransferencia > saldo) {
         System.out.println("Não há saldo suficiente para essa transferência.");
      } else {
         saldo -= valorTransferencia;
         System.out.printf("Saldo atualizado R$: %.2f%n ", saldo);
      }
      return saldo;
   }
}
