def sendFailureEmail(recipientEmail, buildUrl, emailBody) {
    mail to: recipientEmail, subject: 'Pipeline failed', body: body: emailBody + "\n\nBuild URL: " + buildUrl
}
