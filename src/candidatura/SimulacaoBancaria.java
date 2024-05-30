package candidatura;
import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class SimulacaoBancaria {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double saldo = 0;
        boolean continuar = true;

        while (continuar) {
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                  System.out.println("Por favor, digite o valor a ser depositado");
                  double deposito = scanner.nextDouble();
                  saldo = saldo + deposito;
                  BigDecimal bd = new BigDecimal(Double.toString(saldo));
                  bd = bd.setScale(1, RoundingMode.HALF_UP);
                  double depositoArredondado = bd.doubleValue();
                  System.out.println ("Salto atual: " + depositoArredondado);
                    break;
                case 2:
                  System.out.println("Por favor, digite o valor a ser sacado");
                  double saque = scanner.nextDouble();
                  if (saque <= saldo) {
                  saldo = saldo - saque;
                  BigDecimal bd2 = new BigDecimal(Double.toString(saldo));
                  bd2 = bd2.setScale(1, RoundingMode.HALF_UP);
                  double saqueArredondado = bd2.doubleValue();
                  System.out.println ("Salto atual: " + saqueArredondado);
                  }
                  else 
                  System.out.println ("Salto insuficiente");
                    break;
                case 3:
                  BigDecimal bd3 = new BigDecimal(Double.toString(saldo));
                  bd3 = bd3.setScale(1, RoundingMode.HALF_UP);
                  double saldoArredondado = bd3.doubleValue();
                  System.out.println ("Salto atual: " + saldoArredondado);
                    break;
                case 0:
                    System.out.println("Programa encerrado.");
                    continuar = false;  // Atualiza a variável de controle para encerrar o loop
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }
}