pipeline {
  agent any
  environment {
    MVN_OPTS = '-B'
  }
  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }
    stage('Build & Test') {
      steps {
        sh "mvn ${MVN_OPTS} clean package"
      }
      post {
        always {
          junit 'docs-core/target/surefire-reports/*.xml'
        }
      }
    }
    stage('Archive Artifacts') {
      steps {
        archiveArtifacts artifacts: 'docs-core/target/*.jar', fingerprint: true
      }
    }
    stage('Generate Site') {
      steps {
        sh "mvn ${MVN_OPTS} -pl docs-core site"
      }
    }
    stage('Archive Site') {
      steps {
        archiveArtifacts artifacts: 'docs-core/target/site/**', fingerprint: true
      }
    }
  }
  post {
    always {
      echo 'Pipeline finished.'
    }
  }
}
