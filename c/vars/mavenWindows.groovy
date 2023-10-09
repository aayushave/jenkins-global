/**
 * Execute a Maven Clean Install with SkipTests.
 *
 * @param sourceDir Directory containing the pom.xml file.
 */
def buildFromDirectory(sourceDir) {
    dir(sourceDir) {
                bat "cd"
                bat "mvn clean install -DskipTests"
    }
}

/**
 * Execute Maven tests.
 *
 * @param sourceDir Directory containing the pom.xml file.
 */
def testFromDirectory(sourceDir) {
    dir(sourceDir) {
                bat "cd"
                bat "mvn test"
    }
}
