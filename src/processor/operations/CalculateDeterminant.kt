package processor.operations

import processor.MatrixProcessor
import java.util.*
import kotlin.math.pow

/**
 * Created by Prathmesh Swaroop
 */
object CalculateDeterminant : MatrixProcessor<Double, Array<Array<Double>>> {
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
            println(processorFunction(0.0, a))
        }

    override fun processorFunction(a: Double, b: Array<Array<Double>>): Double {
        return determinant(b)
    }

    /**
     * Method to calculate the determinant of passed matrix
     * @param a passed as a 2-D Array Matrix
     */
    private fun determinant(a: Array<Array<Double>>): Double {
        if (a.size == 1) {
            return a[0][0]
        } else if (a.size == 2) {
            return (a[0][0] * a[1][1] - a[1][0] * a[0][1])
        }
        val i = getOptimizedRowForDeterminant(a)
        var det = 0.0
        for (j in 0..a.lastIndex) {
            if (a[i][j] != 0.0) {
                det += a[i][j] * coFactor(getMinorMatrix(a, i, j), i, j)
            }
        }
        return det
    }

    /**
     * Method to calculate the co-factor of an element at index i, j of matrix
     * @param minorMatrix is a minor matrix of element present at index i, j
     * @param i is row index i of an element
     * @param j is colum index j of an element
     */
    fun coFactor(minorMatrix: Array<Array<Double>>, i: Int, j: Int): Double {
        val sign = (-1.0).pow((i + j).toDouble())
        return sign * determinant(minorMatrix)
    }

    /**
     * Method which returns a minor matrix of an element
     * @param a original matrix passed as 2-D array
     * @param i row index of element for which minor matrix needs to be returned
     * @param j column index of element for which minor matrix needs to be returned
     */
    fun getMinorMatrix(a: Array<Array<Double>>, i: Int, j: Int): Array<Array<Double>> {
        val newMatrix = Array(a.size - 1) {
            Array(a.size - 1) {
                0.0
            }
        }
        var newRowIndex = 0
        var newColumnIndex = 0
        for (row in a.indices) {
            if (row != i) {
                newColumnIndex = 0
                for (column in a[row].indices) {
                    if (column != j) {
                        newMatrix[newRowIndex][newColumnIndex] = a[row][column]
                        newColumnIndex++
                    }
                }
                newRowIndex++
            }
        }
        return newMatrix
    }

    /**
     * Method to return row index which has most zeros so that determinant calculation becomes easy
     * @param a original matrix passed as 2-D array
     */
    private fun getOptimizedRowForDeterminant(a: Array<Array<Double>>): Int {
        var maxZeroCount = 0
        var rowIndex = 0
        for (i in 0..a.lastIndex) {
            var zeroCount = 0
            for (j in 0..a[i].lastIndex) {
                if (a[i][j] == 0.0) {
                    zeroCount++
                }
            }
            if (maxZeroCount < zeroCount) {
                maxZeroCount = zeroCount
                rowIndex = i
            }
        }

        return rowIndex
    }
}
