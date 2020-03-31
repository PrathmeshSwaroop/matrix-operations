package processor

import processor.operations.UIActions
import java.util.*

/**
 * Created by Prathmesh Swaroop
 */
fun main() {
    val scanner = Scanner(System.`in`)
    var userAction = UIActions.ADD_MATRICES
    applicationLoop@ while (userAction != UIActions.EXIT) {
        for (action in UIActions.values()) {
            println("${action.actionNumber}. ${action.actionString}")
        }
        print("Your choice: ")
        userAction = UIActions.getActionByNumber(scanner.nextInt())
        userAction.processor.invoke()
    }
}
