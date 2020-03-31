package processor.operations.transpose

/**
 * Created by Prathmesh Swaroop
 * Class to perform Horizontal line transpose
 */
class HorizontalLineTranspose : TransposeProcessor<Array<Array<Double>>> {
    override fun transpose(matrix: Array<Array<Double>>): Array<Array<Double>> {
        var count = matrix.size / 2
        var lastIndex: Int = matrix.lastIndex
        for (i in 0 until count) {
            var temp: Double
            for (j in matrix[i].indices) {
                temp = matrix[lastIndex - i][j]
                matrix[lastIndex - i][j] = matrix[i][j]
                matrix[i][j] = temp
            }
        }
        return matrix
    }
}