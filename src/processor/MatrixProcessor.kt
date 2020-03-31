package processor

/**
 * Created by Prathmesh Swaroop
 * Interface defining the abstract Structure of Matrix Processor class
 */
interface MatrixProcessor<A, B> {

    /**
     * Member variable holding the Lamda method to trigger particular operation
     */
    val processor: () -> Unit

    /**
     * Method which will take two form of input either in form of matrices or values
     */
    fun processorFunction(a: A, b: B): A
}
