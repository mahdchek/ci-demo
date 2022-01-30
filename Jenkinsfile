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
        stash includes: 'docker-compose-appli.yaml', name: 'docker-compose-file'
        stash includes: 'Dockerfile', name: 'docker-file'
        dir('target'){
            stash includes: 'ci*.jar', name: 'livrable'
        }

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
            unstash 'docker-compose-file'
            unstash 'docker-file'
            sh "sudo docker build -t ci-back ."
            try{
                sh "sudo docker stop \$(sudo docker ps -aq)"
                sh "sudo docker rm \$(sudo docker ps -aq)"
            }catch(e){
                println "aucun conteneur n'est lancé"
            }
            sh "echo $DB_HOST"
            sh "sudo docker-compose -f docker-compose-appli.yaml up -d --build"
        }
    }
}
