import gleam/erlang/os.{type OsFamily}
import gleam/io

fn priv_check_os(ex_os_family: OsFamily) -> Bool {
  let os_msg = case ex_os_family {
    os.WindowsNt -> "Not implemented yet."
    //Review feasibility
    os.Linux | os.Darwin | os.FreeBsd -> "target environment checked:"
    _ -> "Unknown OS."
  }

  io.println("Environment check status: " <> os_msg)
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
