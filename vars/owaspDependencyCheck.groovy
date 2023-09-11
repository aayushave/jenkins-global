def checkDependency(sourceDir){
    // dir(sourceDir) {
      dependencyCheck additionalArguments: ''' 
        -o './OWASP-Data'
        -s './OWASP-Data'
        -f 'ALL' 
        --prettyPrint''', odcInstallation: 'OWASP-Dependency-Check'
              
      dependencyCheckPublisher pattern: 'dependency-check-report.xml unstableTotalAllCritical:5'
    // }
}
  
