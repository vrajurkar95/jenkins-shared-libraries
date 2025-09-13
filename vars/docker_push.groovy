def call(String Project, String ImageTag, String dockerhubuser){
   withCredentials([usernamePassword(credentialsId: 'DockerHubCred', passwordVariable: 'DockerHubCredpass', usernameVariable: 'DockerHubCreduser')]) {
                    sh "docker login -u "${DockerHubCreduser}" -p "${DockerHubCredpass}" "
                }
  sh "docker push ${DockerHubCreduser}/${project}:${ImageTag}"
}
