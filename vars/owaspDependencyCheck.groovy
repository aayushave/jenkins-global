def checkDependency(sourceDir){
    // dir(sourceDir) {
        bat "mkdir -p ${sourceDir}"
        dependencyCheck additionalArguments: ''' 
        -o ${sourceDir}
        -s ${sourceDir}
        -f 'ALL' 
        --prettyPrint''', odcInstallation: 'OWASP-Dependency-Check'

      dependencyCheckPublisher pattern: 'dependency-check-report.xml unstableTotalAllCritical:5'
    // }
}
  
