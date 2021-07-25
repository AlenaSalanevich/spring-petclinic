pipeline {
  agent any
       stages {
           stage('Hello') {
                     steps {
                         echo 'Hello World!!!!'
                      }
                  }

         stage ('Mavne package') {
          steps {
         
            script {
              def MVNHOME = tool name: 'mvn', type: 'maven'
              def MVNCMD = "${MVNHOME}/bin/mvn"
              
              sh "if [ -z "$JAVA_HOME" ] && [ -x "/usr/libexec/java_home" ]; then export JAVA_HOME=`/usr/libexec/java_home -v1.8.0` fi ${MVNCMD} clean package"
            }

      }
 }
         
         
         stage('Build image') {
                     steps {
                    // checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'jenkins-github', url: 'https://github.com/AlenaSalanevich/spring-petclinic']]])
                     git branch: 'main', credentialsId: 'jenkins-github', url: 'https://github.com/AlenaSalanevich/spring-petclinic'
                       
                     echo 'Checkout branch'
                 
 //                      step([$class: 'DockerBuilderPublisher', cleanImages: false, cleanupWithJenkinsJobDelete: false, cloud: '', dockerFileDirectory: 'https://github.com/AlenaSalanevich/spring-petclinic', fromRegistry: [], pushCredentialsId: 'jenkins-docker', pushOnSuccess: false, tagsString: 'asalanevich/spring-petclinic:${env.BUILD_ID}'])
                         script{
                          def app =  docker.build("asalanevich/spring-petclinic:${env.BUILD_ID}")

                          }
                    }
                }
                      
           stage('Push') {
                     steps {
                        withCredentials([usernamePassword(credentialsId: 'jenkins-docker', passwordVariable: 'secret', usernameVariable: 'login')]) {
                         sh """
                         docker login -u ${login} -p ${secret}
                         docker push asalanevich/spring-petclinic:${env.BUILD_ID}
                         docker push asalanevich/spring-petclinic:latest
                        """
                     }
                }
          }
     }
}
