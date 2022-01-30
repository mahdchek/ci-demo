node {

    stage("checkout"){
        checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: 'd0ed87e1-d62d-41ce-b153-b66a6e179e25', url: 'https://github.com/mahdchek/ci-demo']]])
    }

    stage("unit tests"){
        sh "./mvnw test"
    }
}
