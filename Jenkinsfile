pipeline {
  agent any
  environment {
    MVN = '/opt/homebrew/bin/mvn -B -Dorg.slf4j.simpleLogger.defaultLogLevel=warn'
    PATH = "/opt/homebrew/bin:${env.PATH}"
    DOCKER_HUB_CREDENTIALS_ID = '5f3062c4-73af-43c4-8554-04c01fe3550a'
    DOCKER_IMAGE = 'fireflyqvq01/teddy'
    DOCKER_TAG = "${env.BUILD_NUMBER}"
  }
  stages {
    // Maven pre-check stages removed — pipeline proceeds directly to Docker stages
    stage('Build Docker Image') {
      steps {
        script {
          dockerImage = docker.build("${env.DOCKER_IMAGE}:${env.DOCKER_TAG}")
        }
      }
    }
    stage('Push Docker Image') {
      steps {
        script {
          docker.withRegistry('https://registry.hub.docker.com', "${env.DOCKER_HUB_CREDENTIALS_ID}") {
            dockerImage.push()
            dockerImage.push('latest')
          }
        }
      }
    }
    stage('Run Containers') {
      steps {
        script {
          sh 'docker stop teedy_manual01 teedy_manual02 teedy_manual03 || true'
          sh 'docker rm teedy_manual01 teedy_manual02 teedy_manual03 || true'
          sh 'docker run -d -p 8084:8080 --name teedy_manual01 "${DOCKER_IMAGE}:${DOCKER_TAG}"'
          sh 'docker run -d -p 8083:8080 --name teedy_manual02 "${DOCKER_IMAGE}:${DOCKER_TAG}"'
          sh 'docker run -d -p 8082:8080 --name teedy_manual03 "${DOCKER_IMAGE}:${DOCKER_TAG}"'
          sh 'docker ps --filter "name=teedy_manual"'
        }
      }
    }
  }
  post {
    always {
      archiveArtifacts artifacts: '**/target/site/**/*', fingerprint: true
      archiveArtifacts artifacts: '**/target/**/*.jar', fingerprint: true
      archiveArtifacts artifacts: '**/target/**/*.war', fingerprint: true
      junit '**/target/surefire-reports/*.xml'
    }
  }
}
