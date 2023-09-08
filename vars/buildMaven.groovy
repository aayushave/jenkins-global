def buildJarFromDirectory(sourceDir) {
            // Change the working directory to the specified source directory
            // sh "pwd"
            dir(sourceDir) {
                // Replace with your build command to generate the JAR file
                        // sh " chmod +x -R ${sourceDir}"
                        // sh "./mvnw clean install"
                        sh "pwd"
                        sh "export M2_HOME=/opt/maven"
                        sh "export PATH=$PATH:$M2_HOME/bin"
                        sh "mvn clean install -DSkipTests"
            }
        }
