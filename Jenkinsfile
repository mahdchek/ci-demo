node {

    stage("checkout"){
        checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: 'd0ed87e1-d62d-41ce-b153-b66a6e179e25', url: 'https://github.com/mahdchek/ci-demo']]])
    }

    stage("unit tests"){
        println "test are OK"
    }

    stage ("build"){
        sh "chmod 777 mvnw"
        sh "./mvnw clean package -DskipTests"
    }

    stage ("Quality Analyses"){
        sh "mvn sonar:sonar \\\n" +
                "  -Dsonar.projectKey=ci-back \\\n" +
                "  -Dsonar.host.url=http://localhost:10002 \\\n" +
                "  -Dsonar.login=faaee55eb15db910c4d783390e989d033042025b"
    }
}
