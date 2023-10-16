/**
 * Perform a Git checkout of a specific branch.
 *
 * @param branch The name of the Git branch to check out.
 * @param credentialsId The ID of the Jenkins credentials for authentication.
 * @param poll Whether to enable polling for changes (true or false).
 * @param repositoryUrl The URL of the Git repository.
 *
 * Note: This function is designed to support multi-branch pipelines.
 */
def checkout(branch, credentialsId, poll, repositoryUrl) {
    checkout([$class: 'GitSCM',
        branches: [[name: branch]],
        userRemoteConfigs: [[url: repositoryUrl, credentialsId: credentialsId]],
        extensions: [[$class: 'CleanBeforeCheckout'], 
                    [$class: 'DisableChangelog'],
                    [$class: 'DisableRemotePoll', poll: poll]]
    ])
}

