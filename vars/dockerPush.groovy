def pushImage(credentials,registryUrl,registryPort,imageName,imageTag){

                // withCredentials([usernamePassword(credentialsId: credentials, usernameVariable: username, passwordVariable: password)]) {
                //     // sh "docker login -u $K_USER -p $K_PASS ${url}"
                //      bat "docker login -u $K_USER -p $K_PASS ${url}"
                // }
                // // sh 'docker push registry.karman.com:8080/ems:$BUILD_TIMESTAMP-$BUILD_ID'
                // bat "docker push ${imageName}:${imageTag}"
                withCredentials([usernamePassword(credentialsId: credentials, usernameVariable: 'USER', passwordVariable: 'PASSWORD')]) {
                    bat "docker login -u $USER -p $PASSWORD $registryUrl:$registryPort" 
                    // bat "docker tag postgres:2.0 192.168.34.62:8082/postgres:2.0"
                    }
                    bat "docker push ${registryUrl}:${registryPort}/${imageName}:${imageTag}"
  
}
