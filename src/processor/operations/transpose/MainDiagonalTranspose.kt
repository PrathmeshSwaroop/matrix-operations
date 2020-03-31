package processor.operations.transpose

/**
 * Created by Prathmesh Swaroop
 * Class to perform Main Diagonal transpose
 */
class MainDiagonalTranspose : TransposeProcessor<Array<Array<Double>>> {
    override fun transpose(matrix: Array<Array<Double>>): Array<Array<Double>> {
        var temp: Double
        for (i in matrix.indices) {
            for (j in i..matrix[i].lastIndex) {
                if (i != j) {
                    temp = matrix[i][j]
                    matrix[i][j] = matrix[j][i]
                    matrix[j][i] = temp
                }
            }
        }
        return matrix
    }
}
