def buildJarFromDirectory(sourceDir) {
            // Change the working directory to the specified source directory
            // sh "pwd"
            dir(sourceDir) {
                // Replace with your build command to generate the JAR file
                        // sh " chmod +x -R ${sourceDir}"
                        // sh "./mvnw clean install"
                        sh "pwd"
                        // sh "mvn clean install -DSkipTests"
            }
        }
