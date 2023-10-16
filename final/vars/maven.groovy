// Linux & Centos Supported Libraries

/**
 * Execute a Maven Clean Install with SkipTests.
 *
 * @param sourceDir Directory containing the pom.xml file.
 */
def buildFromDirectory(sourceDir) {
    dir(sourceDir) {
                sh "pwd"
                sh "mvn clean install -DskipTests"
    }
}

/**
 * Execute Maven tests.
 *
 * @param sourceDir Directory containing the pom.xml file.
 */
def testFromDirectory(sourceDir) {
    dir(sourceDir) {
                sh "pwd"
                sh "mvn test"
    }
}
