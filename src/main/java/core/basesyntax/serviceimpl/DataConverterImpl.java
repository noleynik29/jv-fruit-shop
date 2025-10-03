package core.basesyntax.serviceimpl;

import core.basesyntax.common.FruitTransaction;
import core.basesyntax.service.DataConverter;

import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (int i = 1; i < inputReport.size(); i++) {
            String[] lineArray = inputReport.get(i).split(",");
            String code = lineArray[0].trim();
            String fruit = lineArray[1].trim();
            int quantity = Integer.parseInt(lineArray[2].trim());

            FruitTransaction.Operation operation = FruitTransaction.Operation.fromCode(code);

            FruitTransaction transaction = new FruitTransaction(operation, fruit, quantity);
            fruitTransactions.add(transaction);
        }
        return fruitTransactions;
    }
}
