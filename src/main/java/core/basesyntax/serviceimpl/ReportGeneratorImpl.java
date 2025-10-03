package core.basesyntax.serviceimpl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity").append(System.lineSeparator());

        Storage.storage.entrySet().stream()
                .forEach(entry -> report
                .append(entry.getKey())
                        .append(",")
                        .append(entry.getValue())
                        .append(System.lineSeparator()));
        return report.toString();
    }
}
