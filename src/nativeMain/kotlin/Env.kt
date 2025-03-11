import kotlin.native.Platform @kotlin.experimental.ExperimentalNativeApi

data object Env {
    val hostOs = Platform.osFamily()
    //val isArm64 = System.getProperty("os.arch") == "aarch64"
    //val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" && isArm64 -> macosArm64("native")
        hostOs == "Mac OS X" && !isArm64 -> macosX64("native")
        hostOs == "Linux" && isArm64 -> linuxArm64("native")
        hostOs == "Linux" && !isArm64 -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }


    fun CheckOS() -> Boolean {
      osMsg = when nativeTarget {
        mingwX64("native") -> "Not implemented yet."
        //Review feasibility
        else -> "target environment checked:"
      }

      println("Environment check status: " <> os_msg)
      println(exOSFamily)

      when nativeTarget {
        is mingwX64("native") -> false
	else -> true
      }
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
