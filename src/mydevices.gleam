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
