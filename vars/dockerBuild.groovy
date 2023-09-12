def buildImage(sourceDir,imageName,imageTag){
  dir(sourceDir) {
    // docker build -t "${imageName}"":""${imageTag}"
    sh "docker build -t ${imageName}:${imageTag} ."
  }
}
