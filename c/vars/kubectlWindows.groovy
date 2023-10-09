/**
 * Apply Kubernetes configuration using 'kubectl apply'.
 *
 * @param filePath Location of Kubernetes file or directory.
 * @param env The environment context selected during the Jenkins build stage.
              (optional, defaults to initial).
 * @return Status of 'kubectl apply' operation.
 */
def apply(filePath, env="default"){
  bat "kubectl apply -f ${filePath} -n ${env}"
}

/**
 * Delete Kubernetes resources using 'kubectl delete' command.
 *
 * @param filePath Location of Kubernetes file or directory.
 * @param env The environment context selected during the Jenkins build stage.
              (optional, defaults to initial).
 * @return Status of 'kubectl delete' operation.
 */
def delete (filePath, env="default"){
  bat "kubectl delete -f ${filePath} -n ${env}"
}
