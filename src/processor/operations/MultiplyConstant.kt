package processor.operations

import processor.MatrixProcessor
import java.util.*

/**
 * Created by Prathmesh Swaroop
 */
object MultiplyConstant : MatrixProcessor<Array<Array<Double>>, Double> {

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

            for (i in a.indices) {
                input = scanner.nextLine().split(" ")
                for (j in a[i].indices) {
                    a[i][j] = input[j].toDouble()
                }
            }

            print("Enter the constant value to multiply: ")
            val c = scanner.nextLine().toDouble()
            val ans = processorFunction(a, c)

            println("The result is: ")
            for (i in ans) {
                for (j in i) {
                    print("$j ")
                }
                println()
            }

        }

    override fun processorFunction(a: Array<Array<Double>>, b: Double): Array<Array<Double>> {
        for (i in a.indices) {
            for (j in a[i].indices) {
                a[i][j] *= b
            }
        }
        return a
    }

}