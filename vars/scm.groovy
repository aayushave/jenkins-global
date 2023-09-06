def checkout(branch, credentials, poll, url) {
    stage('Checkout-Stage') {
        steps {
            git branch: ${branch} , changelog: false, credentialsId: ${credentials}, poll: ${poll}, url: ${url}
            echo "test"
        }
    }
}
