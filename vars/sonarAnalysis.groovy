def sonarWinAnalysis(sourceDir,sonarUrl,sonarToken,sonarProjectKey,sonarProjectName,dbUrl,dbUsername,dbPassword){
  // withEnv(["PATH+SONAR_SCANNER=${scannerHome}/bin"]) {
  dir(sourceDir) {
    bat """mvn sonar:sonar \
           -Dsonar.host.url=${sonarUrl} \
           -Dsonar.projectKey=${sonarProjectKey} \
           -Dsonar.projectName=${sonarProjectName} \
           -Dsonar.projectVersion=1.0 \
           -Dsonar.token=${sonarToken} \
           -Dsonar.jdbc.url=${dbUrl} \
           -Dsonar.jdbc.username=${dbUsername} \
           -Dsonar.jdbc.password=${dbPassword}
        """
  }
}
