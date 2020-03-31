package processor.operations

import processor.MatrixProcessor
import java.util.*

/**
 * Created by Prathmesh Swaroop
 */
object MultiplyMatrices : MatrixProcessor<Array<Array<Double>>, Array<Array<Double>>> {

    override val processor: () -> Unit
        get() = {
            val scanner = Scanner(System.`in`)
            print("Enter size of first matrix: ")
            var input = scanner.nextLine().split(" ")
            val a = Array(input[0].toInt()) {
                Array(input[1].toInt()) {
                    0.0
                }
            }
            for (i in a.indices) {
                input = scanner.nextLine().split(" ")
                for (j in a[i].indices) {
                    a[i][j] = input[j].toDouble()
                }
            }

            print("Enter size of second matrix: ")
            input = scanner.nextLine().split(" ")
            val b = Array(input[0].toInt()) {
                Array(input[1].toInt()) {
                    0.0
                }
            }
            for (i in b.indices) {
                input = scanner.nextLine().split(" ")
                for (j in b[i].indices) {
                    b[i][j] = input[j].toDouble()
                }
            }

            println("The multiplication result is: ")
            if (a[0].size == b.size) {
                val ans = processorFunction(a, b)
                for (row in ans) {
                    for (element in row) {
                        print("${element} ")
                    }
                    println()
                }
            } else {
                println(UIActions.ERROR)
            }

        }

    /**
     * Method to find the dot product of row vector of Matrix A and column Vector of Matrix B
     * @param rowVector row vector of Matrix A
     * @param columnVector column vector of Matrix B
     */
    private fun dotProduct(rowVector: Array<Double>, columnVector: Array<Double>): Double {
        var sum = 0.0
        for (i in rowVector.indices) {
            sum += rowVector[i] * columnVector[i]
        }

        return sum
    }

    override fun processorFunction(a: Array<Array<Double>>, b: Array<Array<Double>>): Array<Array<Double>> {
        val c = Array(a.size) {
            Array(b[0].size) {
                0.0
            }
        }

        for (i in c.indices) {
            for (j in c[i].indices) {
                val columnVector = Array(b.size) {
                    b[it][j]
                }
                c[i][j] = c[i][j] + dotProduct(a[i], columnVector)
            }
        }
        return c
    }
}