package processor.operations.transpose

/**
 * Created by Prathmesh Swaroop
 * Class to perform Vertical line transpose
 */
class VerticalLineTranspose : TransposeProcessor<Array<Array<Double>>> {
    override fun transpose(matrix: Array<Array<Double>>): Array<Array<Double>> {

        var temp: Double
        var lastIndex: Int
        var count: Int
        for (row in matrix) {
            lastIndex = row.lastIndex
            count = row.size / 2
            for (j in 0 until count){
                temp = row[lastIndex]
                row[lastIndex] = row[j]
                row[j] = temp
                lastIndex--
            }
        }
        return matrix
    }
}