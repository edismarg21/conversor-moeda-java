import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws Exception {
        Scanner leitura = new Scanner(System.in);
        ServicoConversao servico = new ServicoConversao();

        int opcao = 0;
        while (opcao != 10 ){
            System.out.println("\n===CONVERSOR DE MOEDAS ===");
            System.out.println("1 - USD => BRL");
            System.out.println("2 - BRL => USD");
            System.out.println("3 - USD => ARS");
            System.out.println("4 - ARS => USD");
            System.out.println("5 - USD => EUR");
            System.out.println("6 - EUR => USD");
            System.out.println("7 - VES => BRL");
            System.out.println("8 - BRL => VES");
            System.out.println("9 - VES => USD");
            System.out.println("10- USD => VES");
            System.out.println("11- Sair");
            System.out.println("Escolha uma opção:");

            opcao = leitura.nextInt();

            if(opcao >= 1 && opcao <=  10 ){

                System.out.println("Digite o valor: ");
                double valor = leitura.nextDouble();

                String base = "";
                String destino = "";

                switch (opcao) {
                    case 1:
                        base = "USD";
                        destino = "BRL";
                        break;
                    case 2:
                        base = "BRL";
                        destino = "USD";
                        break;
                    case 3:
                        base = "USD";
                        destino = "ARS";
                        break;
                    case 4:
                        base = "ARS";
                        destino = "USD";
                        break;
                    case 5:
                        base = "USD";
                        destino = "EUR";
                        break;
                    case 6:
                        base = "EUR";
                        destino = "USD";
                        break;
                    case 7:
                        base = "VES";
                        destino = "BRL";
                        break;
                    case 8:
                        base = "BRL";
                        destino = "VES";
                        break;
                    case 9:
                        base = "VES";
                        destino = "USD";
                        break;
                    case 10:
                        base = "USD";
                        destino = "VES";
                        break;

                }

                double resultado = servico.converter(base, destino, valor);

                System.out.println("valor convertido: " + resultado);

            }

        }

    System.out.println("Programa Encerrado.");

        leitura.close();

    }
}
