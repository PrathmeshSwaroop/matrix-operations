package processor.operations

import processor.MatrixProcessor
import processor.operations.UIActions.Companion.ERROR
import java.util.*

/**
 * Created by Prathmesh Swaroop
 */
object AddMatrices : MatrixProcessor<Array<Array<Double>>, Array<Array<Double>>> {

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

            println("The result is: ")
            if (a.size == b.size && a[0].size == b[0].size) {
                val ans = processorFunction(a, b)
                for (row in ans) {
                    for (element in row) {
                        print("$element ")
                    }
                    println()
                }
            } else {
                println(ERROR)
            }
        }

    override fun processorFunction(a: Array<Array<Double>>, b: Array<Array<Double>>): Array<Array<Double>> {
        for (i in a.indices) {
            for (j in a[i].indices) {
                a[i][j] = a[i][j] + b[i][j]
            }
        }
        return a
    }
}