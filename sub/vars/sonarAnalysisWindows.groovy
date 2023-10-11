/**
 * Perform a SonarQube analysis for a given project.
 *
 * @param sourceDir      The directory containing the source code to be analyzed.
 * @param sonarUrl       The URL of the SonarQube server.
 * @param sonarToken     The authentication token or access token for connecting to SonarQube.
 * @param sonarProjectKey The unique key identifying the project in SonarQube.
 * @param sonarProjectName The human-readable name of the project in SonarQube.
 * @param dbUrl          The URL of the database used by SonarQube (if applicable).
 * @param dbUsername     The username for authenticating with the database (if applicable).
 * @param dbPassword     The password for authenticating with the database (if applicable).
 */
 def sonarAnalysis(sourceDir,sonarUrl,sonarToken,sonarProjectKey,sonarProjectName,dbUrl,dbUsername,dbPassword){
  // withEnv(["PATH+SONAR_SCANNER=${scannerHome}/bin"]) {
  dir(sourceDir) {
    bat """mvn clean verify sonar:sonar \
           -DskipTests \
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
