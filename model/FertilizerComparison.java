public class FertilizerComparison {

    private String fertilizerName;
    private double theoreticalN; // Общее количество азота
    private double theoreticalP; // Общее количество фосфора
    private double theoreticalK; // Общее количество калия
    private double actualN; // Фактическое количество азота
    private double actualP; // Фактическое количество фосфора
    private double actualK; // Фактическое количество калия

    // Метод для получения названия удобрения
    public void setFertilizerName(String name) {
        this.fertilizerName = name;
    }

    // Метод для получения теоретического состава
    public void setTheoreticalComposition(double n, double p, double k) {
        this.theoreticalN = n;
        this.theoreticalP = p;
        this.theoreticalK = k;
    }

    // Метод для получения фактического состава
    public void setActualComposition(double n, double p, double k) {
        this.actualN = n;
        this.actualP = p;
        this.actualK = k;
    }

    // Метод для сравнения и вывода результатов
    public String compareCompositions() {
        StringBuilder results = new StringBuilder();
        results.append("\nСравнение составов для удобрения \"").append(fertilizerName).append("\":\n");

        results.append(compareNutrient("Азот (N)", theoreticalN, actualN));
        results.append(compareNutrient("Фосфор (P)", theoreticalP, actualP));
        results.append(compareNutrient("Калий (K)", theoreticalK, actualK));

        return results.toString();
    }

    // Вспомогательная функция для сравнения отдельных питательных веществ
    private String compareNutrient(String nutrientName, double theoretical, double actual) {
        StringBuilder result = new StringBuilder();
        result.append(nutrientName).append(" - Теоретически: ").append(theoretical)
              .append(", Фактически: ").append(actual).append(" - ");

        double difference = actual - theoretical;

        if (difference == 0) {
            result.append("Состав соответствует.\n");
        } else if (difference < 0) {
            result.append("Недостаточно! Не хватает: ").append(-difference).append("\n");
        } else {
            result.append("Избыточно! Превышение: ").append(difference).append("\n");
        }
        return result.toString();
    }
}
