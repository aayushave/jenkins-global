def apply(filePath, env="default"){
    // dir(sourceDir) {
      bat "kubectl apply -f ${filePath} -n ${env}"
    // }
  }

def delete (filePath, env="default"){
      // dir(sourceDir) {
      bat "kubectl delete -f ${filePath} -n ${env}"
    // }
}
