def CheckDependency(sourceDir){
    dir(sourceDir) {
      dependencyCheck additionalArguments: ''' 
        -o ${sourceDir}
        -s ${sourceDir}
        -f 'ALL' 
        --prettyPrint''', odcInstallation: 'OWASP-Dependency-Check'
              
      dependencyCheckPublisher pattern: 'dependency-check-report.xml unstableTotalAllCritical:5'
    }
}
  
