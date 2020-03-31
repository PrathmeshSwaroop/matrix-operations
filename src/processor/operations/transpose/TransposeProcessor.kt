package processor.operations.transpose

/**
 * Interface defining the abstract structure of Transpose Processor
 */
interface TransposeProcessor<T> {
    fun transpose(matrix: T): T
}