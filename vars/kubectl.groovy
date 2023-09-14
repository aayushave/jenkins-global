def apply(sourceDir,fileName){
    dir(sourceDir) {
      bat "kubectl apply -f ${sourceDir}/${fileName}"
    }
  }

def delete (sourceDir,fileName){
      dir(sourceDir) {
      bat "kubectl delete -f ${sourceDir}/${fileName}"
    }
}
