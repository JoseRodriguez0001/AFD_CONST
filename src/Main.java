import services.AnalizadorFloat;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AnalizadorFloat analizador = new AnalizadorFloat();

        System.out.println("=== AFD para Números Flotantes ===");
        System.out.println("Ejemplos válidos: 3.14, -5., +10e-3, 42, 1.2E10");
        System.out.println("Escribe 'exit' para salir.\n");

        while (true) {
            System.out.print("Ingrese un número: ");
            String entrada = scanner.nextLine();

            if (entrada.equalsIgnoreCase("exit")) {
                System.out.println("Saliendo del programa...");
                break;
            }

            String resultado = analizador.verificar(entrada);
            System.out.println(resultado);
        }

        scanner.close();

    }
}