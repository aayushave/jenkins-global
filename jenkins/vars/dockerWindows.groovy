def buildImage(sourceDir,registryUrl,registryPort,imageName,imageTag){
  dir(sourceDir) {
    // docker build -t "${imageName}"":""${imageTag}"
    // sh "docker build -t ${imageName}:${imageTag} ."
    bat "docker build -t ${imageName}:${imageTag} ."
  }
}

def pushImage(credentials,registryUrl,registryPort,imageName,imageTag){

  withCredentials([usernamePassword(credentialsId: credentials, usernameVariable: 'USER', passwordVariable: 'PASSWORD')]) {
      bat "docker login -u $USER -p $PASSWORD $registryUrl:$registryPort" 
      }
      bat "docker tag ${imageName}:${imageTag} ${registryUrl}:${registryPort}/${imageName}:${imageTag}"
      bat "docker push ${registryUrl}:${registryPort}/${imageName}:${imageTag}"
}
