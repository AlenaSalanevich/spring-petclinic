pipeline {
  agent any
       stages {
           stage("Hello") {
                     steps {
                         echo 'Hello World!!!!'
                      }
                  }

           stage("Build") {
                     steps {
                          git url: 'https://github.com/AlenaSalanevich/spring-petclinic', branch: 'main'
                          echo 'Checkout branch'
                          def app =  docker.build("asalanevich/spring-petclinic:${env.BUILD_ID}")
                          app.push()
                          app.push 'latest'
                       
                    }
                }
                      
           stage("Push") {
                     steps {
                         withCredentials([usernamePassword(credentialsId: 'jenkins-docker', usernameVariable: 'login', passwordVariable: 'password')])
                         sh """
                         docker login -u ${login} -p ${password}
                         docker push asalanevich/spring-petclinic:${env.BUILD_ID}
                         docker push asalanevich/spring-petclinic:latest
                        """
                     }
                }
          }
   }
