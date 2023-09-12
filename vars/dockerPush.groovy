def pushImage(url,credentials,username,password,imageName,imageTag){

                withCredentials([usernamePassword(credentialsId: credentials, usernameVariable: username, passwordVariable: password)]) {
                    // sh "docker login -u $K_USER -p $K_PASS ${url}"
                     bat "docker login -u $K_USER -p $K_PASS ${url}"
                }
                // sh 'docker push registry.karman.com:8080/ems:$BUILD_TIMESTAMP-$BUILD_ID'
                bat "docker push ${imageName}:${imageTag}"
            }
        }
}
