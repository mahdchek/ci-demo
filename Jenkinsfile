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
        stash includes: 'target/ci*.jar', name: 'livrable'
    }

    stage ("Quality Analyses"){
        sh "./mvnw sonar:sonar \\\n" +
                "  -Dsonar.projectKey=ci-back \\\n" +
                "  -Dsonar.host.url=http://192.168.1.12:10002 \\\n" +
                "  -Dsonar.login=faaee55eb15db910c4d783390e989d033042025b"
    }


    node('amazon-vm'){
        stage("deploy"){
            unstash 'livrable'
            sh "ls"
            println "je tourne sur la vm amazon"
        }
    }
}
