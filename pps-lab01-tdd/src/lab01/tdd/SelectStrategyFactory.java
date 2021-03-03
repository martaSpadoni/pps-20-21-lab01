package lab01.tdd;

public interface SelectStrategyFactory {

    SelectStrategy createEvenStrategy();
    SelectStrategy createMultipleOfStrategy(int number);
    SelectStrategy createEqualsStrategy(int number);

}
