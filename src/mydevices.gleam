import env
import gleam/io

pub fn main() {
  io.println("Hello from mydevices!\n")

  let env_os = env.check_os()

  let msg = case env_os.0 {
    True -> "Creating command..."
    False -> "Cannot continue, execution stopped."
  }

  io.println("\n" <> msg)
}
