def checkout(branch, credentials, poll, url) {
    // stage('Checkout-Stage') {
        // steps {
            // git branch: branch , changelog: false, credentialsId: credentials, poll: poll, url: url
            // echo "test"
        // }
    // }

    checkout([$class: 'GitSCM',
        branches: [[name: branch]],
        userRemoteConfigs: [[url: url, credentialsId: credentialsId]],
        extensions: [[$class: 'CleanBeforeCheckout'], 
                    [$class: 'DisableChangelog'],
                    [$class: 'DisableRemotePoll']]
    ])
}
