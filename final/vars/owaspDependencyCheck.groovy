// Linux & Centos Supported Libraries

/**
 * Run OWASP Dependency-Check to identify and analyze dependencies in the source code.
 *
 * This method checks for the existence of a specified directory, creates it if it doesn't exist,
 * and then runs OWASP Dependency-Check to analyze dependencies in the provided source code directory.
 *
 * @param sourceDir The directory containing the source code to be analyzed for dependencies.
 */

def checkDependency(sourceDir) {
    def dirExists = sh(script: "[ -d \"$sourceDir\" ]", returnStatus: true) == 0
    if (!dirExists) {
        sh "mkdir -p \"$sourceDir\""
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
