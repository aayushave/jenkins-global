def sonarWinAnalysis(sonarUrl,sonarToken,sonarProjectKey,dbUrl,dbUsername,dbPassword){
  withEnv(["PATH+SONAR_SCANNER=${scannerHome}/bin"]) {
                        bat """
                            mvn sonar:sonar \
                            -Dsonar.host.url=http://your-sonarqube-server:9000 \
                            -Dsonar.projectKey=your-project-key \
                            -Dsonar.projectName=YourProjectName \
                            -Dsonar.projectVersion=1.0
                            -Dsonar.jdbc.url=${SONAR_DB_URL} \
                            -Dsonar.jdbc.username=${SONAR_DB_USERNAME} \
                            -Dsonar.jdbc.password=${SONAR_DB_PASSWORD}
}
