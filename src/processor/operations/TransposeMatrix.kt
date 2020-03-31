package processor.operations

import processor.MatrixProcessor
import processor.operations.transpose.TransposeAction
import java.util.*

/**
 * Created by Prathmesh Swaroop
 */
object TransposeMatrix : MatrixProcessor<Array<Array<Double>>, TransposeAction> {

    override val processor: () -> Unit
        get() = {

            val scanner = Scanner(System.`in`)
            println()
            for (action in TransposeAction.values()) {
                println("${action.displayNumber}. ${action.displayString}")
            }
            print("Your choice: ")
            val action = TransposeAction.getActionByChoice(scanner.nextLine().toInt())
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
            val answer = processorFunction(a, action)
            for (i in answer) {
                for (j in i) {
                    print("${j.toInt()} ")
                }
                println()
            }
        }


    override fun processorFunction(a: Array<Array<Double>>, b: TransposeAction): Array<Array<Double>> {
        return b.processor.transpose(a)
    }
}