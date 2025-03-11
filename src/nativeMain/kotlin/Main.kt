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

import env
import gleam/io
import gleave

pub fn main() {
  io.println("Hello from mydevices!\n")

  let env_os = env.check_os()

  let msg = case env_os.0 {
    True -> "Creating command..."
    False ->"Cannot continue, execution stopped."
  }

  io.println("\n" <> msg)

  let _ = case env_os.0 {
    True -> Nil
    False -> gleave.exit(0)
  }
}
