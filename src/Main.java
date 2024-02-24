import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть шлях до файлу з графом:");//src/test.txt
        String graphFile = scanner.nextLine();

        try {
            Graph graph = new Graph(graphFile);

            System.out.println("Введіть шлях до файлу для збереження матриці суміжності:");
            String adjacencyMatrixFile = scanner.nextLine();//src/testSum.txt
            graph.printAdjacencyMatrix(adjacencyMatrixFile);

            System.out.println("Введіть шлях до файлу для збереження матриці інцидентності:");
            String incidenceMatrixFile = scanner.nextLine();//src/testIden.txt
            graph.printIncidenceMatrix(incidenceMatrixFile);

            System.out.println("Матриці суміжності та інцидентності були успішно збережені.");
        } catch (IOException e) {
            System.out.println("Помилка при читанні або запису файлу: " + e.getMessage());
        }
    }

}