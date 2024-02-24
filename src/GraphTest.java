import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GraphTest {

    @Test
    public void testPrintAdjacencyMatrix() throws IOException {
        // Створюємо новий граф
        Graph graph = new Graph("src/test.txt");

        // Виводимо матрицю суміжності у файл
        String outputFile = "src/testSum.txt";
        graph.printAdjacencyMatrix(outputFile);

        // Зчитуємо згенерований файл та перевіряємо його вміст
        BufferedReader reader = new BufferedReader(new FileReader(outputFile));
        String line;
        StringBuilder content = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            content.append(line).append("\n");
        }
        reader.close();

        // Очікуваний вміст файлу
        String expectedContent = "0 1 1 0 0 \n1 0 1 1 0 \n1 1 0 1 1 \n0 1 1 0 1 \n0 0 1 1 0 \n";

        // Перевіряємо, чи вміст файлу відповідає очікуваному
        assertEquals(expectedContent, content.toString());
    }
}