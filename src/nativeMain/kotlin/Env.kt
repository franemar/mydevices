import kotlin.native.Platform
import kotlin.native.OsFamily

data class Env (private var checked: Boolean = false){
    @OptIn(kotlin.experimental.ExperimentalNativeApi::class)
    val platformOsFamily = Platform.osFamily
    @OptIn(kotlin.experimental.ExperimentalNativeApi::class)
    val platformChecked = when (platformOsFamily) {
        in arrayOf(OsFamily.MACOSX, OsFamily.LINUX) -> true
        OsFamily.WINDOWS -> false
        else -> false
    }

    fun checkOS(): Boolean {
      val osMsg = when (platformChecked) {
        false -> "not implemented yet."
        true -> "target environment checked."
      }

      checked = true
      println("\nEnvironment check status: $osMsg")
      @OptIn(kotlin.experimental.ExperimentalNativeApi::class)
      println("Platform OS Family: $platformOsFamily")
      return platformChecked
   }
}

// Drop if it works

/*fun privCheckOS(exOSFamily: Env) -> Bool {
  osMsg = when exOSFamily.nativeTarget {
    mingwX64("native") -> "Not implemented yet."
    //Review feasibility
    else -> "target environment checked:"
  }

  println("Environment check status: " <> os_msg)
  io.debug(ex_os_family)

  case ex_os_family {
    os.Linux | os.Darwin | os.FreeBsd -> True
    os.WindowsNt -> False
    _ -> False
  }
}


pub fn check_os() -> #(Bool, OsFamily) {
  let ex_os_family = os.family()
  #(priv_check_os(ex_os_family), ex_os_family)
}
*/

// F# version
// For more information see https://aka.ms/fsharp-console-apps
//let os = System.Environment.OSVersion

//printfn "Current OS Information:"
//printfn $"OS: {os.ToString()}"
//printfn $"Platform: {os.Platform.ToString()}"
//printfn $"Version String: {os.VersionString}"
//printfn "Version Information:"
//printfn $"   Major: {os.Version.Major}"
//printfn $"   Minor: {os.Version.Minor}"
//printfn $"Service Pack: {os.ServicePack.ToString()}"

//let isTargetPlatform = System.OperatingSystem.IsLinux()

//if not isTargetPlatform then
//  printfn $"Not in target platform: {os.Platform.ToString()}"
//  printfn "Exiting..."
//else
//  printfn "Platform validated, creating command..."
