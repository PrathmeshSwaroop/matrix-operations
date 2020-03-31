package processor.operations.transpose

/**
 * Created by Prathmesh Swaroop
 * Class to perform Side Diagonal transpose
 */
class SideDiagonalTranspose : TransposeProcessor<Array<Array<Double>>> {
    override fun transpose(matrix: Array<Array<Double>>): Array<Array<Double>> {
        var temp: Double
        var varCount: Int
        for (i in matrix.indices) {
            varCount = matrix[i].lastIndex - i
            for (j in 0..(matrix[i].lastIndex - i)) {
                temp = matrix[i + varCount][j + varCount]
                matrix[i + varCount][j + varCount] = matrix[i][j]
                matrix[i][j] = temp
                varCount--
            }
        }
        return matrix
    }
}