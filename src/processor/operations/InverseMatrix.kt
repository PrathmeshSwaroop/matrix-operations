package processor.operations

import processor.MatrixProcessor
import processor.operations.transpose.TransposeAction
import java.util.*

/**
 * Created by Prathmesh Swaroop
 */
object InverseMatrix : MatrixProcessor<Array<Array<Double>>, Unit> {
    override val processor: () -> Unit
        get() = {
            val scanner = Scanner(System.`in`)
            print("Enter matrix size: ")
            var input = scanner.nextLine().split(" ")
            val a = Array(input[0].toInt()) {
                Array(input[1].toInt()) {
                    0.0
                }
            }

            println("Enter matrix:")
            for (i in a.indices) {
                input = scanner.nextLine().split(" ")
                for (j in a[i].indices) {
                    a[i][j] = input[j].toDouble()
                }
            }
            println("The result is:")
            val inverseMatrix = processorFunction(a, Unit)
            for (row in inverseMatrix) {
                for (element in row) {
                    print("$element ")
                }
                println()
            }
            println()
        }

    override fun processorFunction(a: Array<Array<Double>>, b: Unit): Array<Array<Double>> {
        val determinantA = CalculateDeterminant.processorFunction(0.0, a)
        val adjA = Array(a.size) {
            Array(a.size) {
                0.0
            }
        }
        for (i in a.indices) {
            for (j in a[i].indices) {
                adjA[i][j] = CalculateDeterminant.coFactor(CalculateDeterminant.getMinorMatrix(a, i, j), i, j)
            }
        }
        return MultiplyConstant.processorFunction(TransposeMatrix.processorFunction(adjA, TransposeAction.MAIN), 1.0 / determinantA)
    }


}