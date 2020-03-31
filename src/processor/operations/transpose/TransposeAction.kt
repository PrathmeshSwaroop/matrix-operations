package processor.operations.transpose

/**
 * enum class defining the Transpose operations
 */
enum class TransposeAction(val displayNumber: Int, val displayString: String, val processor: TransposeProcessor<Array<Array<Double>>>) {
    MAIN(1, "Main diagonal", MainDiagonalTranspose()),
    SIDE(2, "Side diagonal", SideDiagonalTranspose()),
    VERTICAL(3, "Vertical line", VerticalLineTranspose()),
    HORIZONTAL(4, "Horizontal line", HorizontalLineTranspose());

    companion object {
        fun getActionByChoice(choice: Int): TransposeAction {
            for (action in values()) {
                if (action.displayNumber == choice) {
                    return action
                }
            }
            return MAIN
        }
    }
}