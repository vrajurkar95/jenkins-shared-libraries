def call(String Project, String ImageTag, String DockerHubUser) {
    withCredentials([usernamePassword(
        credentialsId: 'DockerHubCred',
        passwordVariable: 'DockerHubCredpass',
        usernameVariable: 'DockerHubCreduser'
    )]) {
        sh """
          echo "${DockerHubCredpass}" | docker login -u "${DockerHubCreduser}" --password-stdin
          docker push ${DockerHubCreduser}/${Project}:${ImageTag}
        """
    }
}
