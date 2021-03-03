package lab01.tdd;

public interface SelectStrategyFactory {

    /**
     * Creates the SelectStrategy to get the next even element
     * @return the EvenStrategy
     */
    SelectStrategy createEvenStrategy();
    /**
     * Creates the SelectStrategy to get the next multiple of a given number
     * @return the MultipleOfStrategy
     */
    SelectStrategy createMultipleOfStrategy(int number);
    /**
     * Creates the SelectStrategy to get the next equal element of a given one
     * @return the EqualsStrategy
     */
    SelectStrategy createEqualsStrategy(int number);

}
