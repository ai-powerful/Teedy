pipeline {
  agent any
  environment {
    MVN = '/opt/homebrew/bin/mvn -B -Dorg.slf4j.simpleLogger.defaultLogLevel=warn'
    PATH = "/opt/homebrew/bin:${env.PATH}"
    DOCKER_HUB_CREDENTIALS_ID = 'dockerhub_credentials'
    DOCKER_IMAGE = 'your-dockerhub-user/teedy-app'
    DOCKER_TAG = "${env.BUILD_NUMBER}"
  }
  stages {
    stage('Clean') {
      steps {
        sh "${MVN} clean"
      }
    }
    stage('Compile') {
      steps {
        sh "${MVN} compile"
      }
    }
    stage('Test') {
      steps {
        sh "${MVN} test -Dmaven.test.failure.ignore=true"
      }
    }
    stage('PMD') {
      steps {
        sh "${MVN} pmd:pmd"
      }
    }
    stage('JaCoCo') {
      steps {
        sh "${MVN} jacoco:report"
      }
    }
    stage('Javadoc') {
      steps {
        sh "${MVN} javadoc:javadoc"
      }
    }
    stage('Site') {
      steps {
        sh "${MVN} site -DskipTests"
      }
    }
    stage('Package') {
      steps {
        sh "${MVN} package -DskipTests"
      }
    }
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
          docker.withRegistry('https://registry.hub.docker.com', 'dockerhub_credentials') {
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
