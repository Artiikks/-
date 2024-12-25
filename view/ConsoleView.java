import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ConsoleView {

    private Scanner scanner;
    private FertilizerComparison fertilizerComparison;

    public ConsoleView() throws UnsupportedEncodingException {
        this.scanner = new Scanner(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        fertilizerComparison = new FertilizerComparison();
    }

    // Метод для получения данных пользователя
    public void getInput() {
        System.out.print("Введите название удобрения: ");
        String name = scanner.nextLine();
        fertilizerComparison.setFertilizerName(name);

        System.out.println("Введите теоретический состав удобрения \"" + name + "\":");
        System.out.print("Азот (N): ");
        double theoreticalN = scanner.nextDouble();
        System.out.print("Фосфор (P): ");
        double theoreticalP = scanner.nextDouble();
        System.out.print("Калий (K): ");
        double theoreticalK = scanner.nextDouble();
        fertilizerComparison.setTheoreticalComposition(theoreticalN, theoreticalP, theoreticalK);

        System.out.println("Введите фактический состав удобрения \"" + name + "\":");
        System.out.print("Азот (N): ");
        double actualN = scanner.nextDouble();
        System.out.print("Фосфор (P): ");
        double actualP = scanner.nextDouble();
        System.out.print("Калий (K): ");
        double actualK = scanner.nextDouble();
        fertilizerComparison.setActualComposition(actualN, actualP, actualK);
    }

    // Метод для отображения результатов
    public void displayResults() {
        String results = fertilizerComparison.compareCompositions();
        System.out.println(results);
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        ConsoleView consoleView = new ConsoleView();
        consoleView.getInput();
        consoleView.displayResults();
    }
}
