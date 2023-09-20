// Maven Clean Install with SkipTests
// Param::
// sourceDir: Pom(dot)xml location directory 
def buildFromDirectory(sourceDir) {
    dir(sourceDir) {
                bat "cd"
                bat "mvn clean install -DskipTests"
    }
}

// Maven Test
// Param::
// sourceDir: Pom(dot)xml location directory 
def testFromDirectory(sourceDir) {
    dir(sourceDir) {
                bat "cd"
                bat "mvn test"
    }
}
