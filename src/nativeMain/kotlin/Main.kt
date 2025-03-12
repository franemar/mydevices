import Env.platformChecked
//import Env.platformOsFamily
import kotlin.system.exitProcess

//JSON/PrettyPrint version

/*import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
private data class Message(
    val topic: String,
    val content: String,
)

private val PrettyPrintJson = Json {
    prettyPrint = true
}

fun main() {
    val message = Message(
        topic = "Kotlin/Native",
        content = "Hello!"
    )
    println(PrettyPrintJson.encodeToString(message))
}
*/

// Counting characters in input version

/*fun String.countDistinctCharacters() = lowercase().toList().distinct().count()

fun main() {
    // Read the input value.
    println("Hello, enter your name:")
    val name = readln()
    // Count the letters in the name.
    name.replace(" ", "").let {
        println("Your name contains ${it.length} letters")
        // Print the number of unique letters.
        println("Your name contains ${it.countDistinctCharacters()} unique letters")
    }
}
*/

fun main() {
  println("Hello from MyDevices!")

  val platformChecked = platformChecked

  val msg = when (platformChecked) {
    true -> "Creating command..."
    false ->"Cannot continue, execution stopped."
  }

  println("\n$msg")

  when (platformChecked) {
    //true -> null
    false -> exitProcess(0)
    else -> Unit
  }
}
