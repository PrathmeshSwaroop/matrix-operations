package processor.operations

/**
 * Created by Prathmesh Swaroop
 * Enum class to trigger various operations on matrix as per user actions
 */
enum class UIActions(val actionNumber: Int, val actionString: String, val processor: () -> Unit) {
    ADD_MATRICES(1, "Add matrices", AddMatrices.processor),
    MULTIPLY_CONSTANT(2, "Multiply matrix to a constant", MultiplyConstant.processor),
    MULTIPLY_MATRICES(3, "Multiply matrices", MultiplyMatrices.processor),
    TRANSPOSE_MATRIX(4, "Transpose matrix", TransposeMatrix.processor),
    CALCULATE_DETERMINANT(5, "Calculate a determinant", CalculateDeterminant.processor),
    INVERSE_MATRIX(6, "Inverse matrix", InverseMatrix.processor),
    EXIT(0, "Exit", {});

    companion object {
        const val ERROR = "ERROR"
        fun getActionByNumber(number: Int): UIActions {
            for (action in values()) {
                if (action.actionNumber == number) {
                    return action
                }
            }
            return EXIT
        }
    }


}