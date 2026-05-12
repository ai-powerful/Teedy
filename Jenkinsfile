pipeline {
  agent any
  environment {
    MVN = '/opt/homebrew/bin/mvn -B -Dorg.slf4j.simpleLogger.defaultLogLevel=warn'
    PATH = "/opt/homebrew/bin:${env.PATH}"
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
