def buildJarFromDirectory(sourceDir) {
            // Change the working directory to the specified source directory
            dir(sourceDir) {
                // Replace with your build command to generate the JAR file
                        chmod +x -R ${sourceDir}
                        sh "./mvnw clean install"
            }
        }
