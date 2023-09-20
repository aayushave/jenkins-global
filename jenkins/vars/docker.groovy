// Build Docker Image
// Param:: 
// sourceDir: dockerfile location
// registryUrl: Nexus Repository Url
// registryPort: Nexus Repository Port
// imageName: Name to be given to Image
// imageTag: Version number to be given (Ex 1.0)
def buildImage(sourceDir,registryUrl,registryPort,imageName,imageTag){
  dir(sourceDir) {
    sh "docker build -t ${imageName}:${imageTag} ."
  }
}

// Push Docker Image
// Param:: 
// credentials: Jenkins Added Credential 
// registryUrl: Nexus Repository Url
// registryPort: Nexus Repository Port
// imageName: Name to be given to Image
// imageTag: Version number to be given (Ex 1.0)
def pushImage(credentials,registryUrl,registryPort,imageName,imageTag){
  withCredentials([usernamePassword(credentialsId: credentials, usernameVariable: 'USER', passwordVariable: 'PASSWORD')]) {
      sh "docker login -u $USER -p $PASSWORD $registryUrl:$registryPort" 
      }
      sh "docker tag ${imageName}:${imageTag} ${registryUrl}:${registryPort}/${imageName}:${imageTag}"
      sh "docker push ${registryUrl}:${registryPort}/${imageName}:${imageTag}"
}
