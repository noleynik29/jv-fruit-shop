package core.basesyntax.serviceimpl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity").append(System.lineSeparator());
        Map<String, Integer> currentStorage = Storage.getAll();
        if (currentStorage != null && !currentStorage.isEmpty()) {
            currentStorage.forEach((fruit, quantity) ->
                    report.append(fruit)
                            .append(",")
                            .append(quantity)
                            .append(System.lineSeparator())
            );
        }
        return report.toString();
    }
}
