// Linux & Centos Supported Libraries

/**
 * Build a Docker image.
 *
 * @param sourceDir Directory containing the Dockerfile.
 * @param registryUrl Nexus Repository URL.
 * @param registryPort Nexus Repository Port.
 * @param imageName Name for the Docker image.
 * @param imageTag Version number for the image (e.g., 1.0).
 */
def buildImage(sourceDir,registryUrl,registryPort,imageName,imageTag){
  dir(sourceDir) {
    sh "docker build -t ${imageName}:${imageTag} ."
  }
}

/**
 * Push a Docker image to a container registry.
 *
 * @param credentials Jenkins added credential for authentication.
 * @param registryUrl Nexus Repository URL.
 * @param registryPort Nexus Repository Port.
 * @param imageName Name of the Docker image.
 * @param imageTag Version number for the image (e.g., 1.0).
 */
def pushImage(credentials,registryUrl,registryPort,imageName,imageTag){
  withCredentials([usernamePassword(credentialsId: credentials, usernameVariable: 'USER', passwordVariable: 'PASSWORD')]) {
      sh "docker login -u $USER -p $PASSWORD $registryUrl:$registryPort" 
      }
      sh "docker tag ${imageName}:${imageTag} ${registryUrl}:${registryPort}/${imageName}:${imageTag}"
      sh "docker push ${registryUrl}:${registryPort}/${imageName}:${imageTag}"
}
