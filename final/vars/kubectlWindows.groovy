/**
 * Apply Kubernetes configuration from File using 'kubectl apply'.
 *
 * @param filePath Location of Kubernetes file or directory.
 * @param env The environment context selected during the Jenkins build stage.
              (optional, defaults to initial).
 * @return Status of 'kubectl apply' operation.
 */
def apply(filePath, env="default"){
  try {
bat "kubectl apply -f ${filePath} -n ${env}"
  }catch(Exception e){
  return 0
  }
}

/**
 * Delete Kubernetes resources from File using 'kubectl delete' command.
 *
 * @param filePath Location of Kubernetes file or directory.
 * @param env The environment context selected during the Jenkins build stage.
              (optional, defaults to initial).
 * @return Status of 'kubectl delete' operation.
 */
def deletefromFile (filePath, env="default"){
    try {
      bat "kubectl delete -f ${filePath} -n ${env}"
   }catch(Exception e){
  return 0
  }
}

/**
 * Delete Kubernetes resources using 'kubectl delete' command.
 *
 * @param filePath Location of Kubernetes file or directory.
 * @param env The environment context selected during the Jenkins build stage.
              (optional, defaults to initial).
 * @return Status of 'kubectl delete' operation.
 * example: kubectl delete configmap flywaymastersql -n dev
 * example: $param: configmap flywaymastersql
 * example: $env: dev
 */
def delete (param, env="default"){
     try {
       bat "kubectl delete ${param} -n ${env}"
     }catch(Exception e){
  return 0
  }
}

/**
 * Create an object with specified parameters and environment.
 *
 * @param params The parameters for object creation.
 * @param env (Optional) The environment context (default is 'default').
 * example: kubectl create configmap flywaymastersql --from-file=$DATABASE_DIR/master/baseline -n dev
 * example: $param: configmap flywaymastersql --from-file=$DATABASE_DIR/master/baseline 
 * example: $env: dev
 */
def create (param,  env="default" ){
     try {
       bat "kubectl create ${param} -n ${env}"
      }catch(Exception e){
  return 0
  }
}
