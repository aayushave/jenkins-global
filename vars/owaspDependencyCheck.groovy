def checkDependency(sourceDir){
    // dir(sourceDir) {
    def windowsSourceDir = sourceDir.replaceAll('/', '\\\\')
    // bat "echo windowsSourceDir ${windowsSourceDir}" 
    // bat "echo sourceDir ${sourceDir}"
    
    def dirExists = bat(script: "if exist ${windowsSourceDir} (exit 0) else (exit 1)", returnStatus: true) == 0
    if (!dirExists) {
        bat "mkdir ${windowsSourceDir}"
    }
    
    dependencyCheck additionalArguments: """ 
        -o "${sourceDir}"
        -s "./"
        -f 'ALL' 
        --prettyPrint""", odcInstallation: 'OWASP-Dependency-Check'

    dependencyCheckPublisher pattern: "${sourceDir}/dependency-check-report.xml"
    // , unstableTotalCritical: 5
    // }
}
  
