def checkDependency(sourceDir){
    // dir(sourceDir) {
    def windowsSourceDir = sourceDir.replaceAll('/', '\\\\')
    bat "echo ${windowsSourceDir}" 
    bat "echo ${sourceDir}"
    bat "mkdir ${windowsSourceDir}"
    dependencyCheck additionalArguments: ''' 
    -o ${sourceDir}
    -s ${sourceDir}
    -f 'ALL' 
    --prettyPrint''', odcInstallation: 'OWASP-Dependency-Check'

    dependencyCheckPublisher pattern: 'dependency-check-report.xml', unstableTotalCritical: 5
    // }
}
  
