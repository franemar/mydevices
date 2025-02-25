// For more information see https://aka.ms/fsharp-console-apps
let cmd = "pacman -Qqei > ~/.config/aconfmgr/pklist.txt"

printfn "Command to query installed packages: `%s`" cmd
