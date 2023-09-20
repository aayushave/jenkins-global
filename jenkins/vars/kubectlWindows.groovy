// Kubectl apply command 
// Param::
// filePath: Location of kubernetes file, can be a directory
// env: selected during jenkins build stage, default by initial 
def apply(filePath, env="default"){
  bat "kubectl apply -f ${filePath} -n ${env}"
}

// Kubectl delete command 
// Param::
// filePath: Location of kubernetes file, can be a directory
// env: selected during jenkins build stage, default by initial 
def delete (filePath, env="default"){
  bat "kubectl delete -f ${filePath} -n ${env}"
}
