/**
 * Send a failure email notification.
 *
 * @param recipientEmail Email address of the recipient.
 * @param buildUrl URL of the build or job.
 * @param emailBody Body of the email containing failure details.
 */
def sendFailureEmail(recipientEmail, buildUrl, emailBody) {
    mail to: recipientEmail, subject: 'Pipeline failed', body: body: emailBody + "\n\nBuild URL: " + buildUrl
}
