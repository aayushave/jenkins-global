def checkDependency(sourceDir){
    // dir(sourceDir) {
    def windowsSourceDir = sourceDir.replaceAll('/', '\\')
        
    bat "mkdir -p ${windowsSourceDir}"
    dependencyCheck additionalArguments: ''' 
    -o ${sourceDir}
    -s ${sourceDir}
    -f 'ALL' 
    --prettyPrint''', odcInstallation: 'OWASP-Dependency-Check'

      dependencyCheckPublisher pattern: 'dependency-check-report.xml unstableTotalAllCritical:5'
    // }
}
  
