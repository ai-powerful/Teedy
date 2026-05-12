pipeline {
  agent any
  tools {
    maven 'Maven'
  }
  environment {
    MVN_OPTS = '-B'
  }
  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }
    stage('Build') {
      steps {
        sh "/opt/homebrew/bin/mvn ${MVN_OPTS} -pl docs-core clean package"
      }
      post {
        always {
          archiveArtifacts artifacts: 'docs-core/target/*.jar', fingerprint: true
        }
      }
    }
    stage('Test') {
      steps {
        sh "/opt/homebrew/bin/mvn ${MVN_OPTS} -pl docs-core test"
      }
      post {
        always {
          junit 'docs-core/target/surefire-reports/*.xml'
        }
      }
    }
    stage('Site') {
      steps {
        sh "/opt/homebrew/bin/mvn ${MVN_OPTS} -pl docs-core site"
        // publishHTML requires the HTML Publisher Plugin in Jenkins
        publishHTML (target: [
          allowMissing: false,
          alwaysLinkToLastBuild: true,
          keepAll: true,
          reportDir: 'docs-core/target/site',
          reportFiles: 'index.html',
          reportName: 'Docs Core Site'
        ])
      }
      post {
        always {
          archiveArtifacts artifacts: 'docs-core/target/site/**', fingerprint: true
        }
      }
    }
  }
  post {
    always {
      echo 'Pipeline finished.'
    }
  }
}
