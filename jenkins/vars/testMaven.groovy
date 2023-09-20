def testFromWinDirectory(sourceDir) {
            // Change the working directory to the specified source directory
            // sh "pwd"
            dir(sourceDir) {
                // Replace with your build command to generate the JAR file
                        bat "cd"
                        bat "mvn test"
            }
        }
