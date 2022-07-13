# learning git

Building tag condition 

```groovy
pipeline {
    agent any
	
    stages {
        stage('Build') {
		
			when{
				buildingTag()
			}
		
            steps {                
                echo 'Hello World building tag'
            }
        }
    }
}
```
Criar o build job - MultiBranch Pipeline - Repositorio soh tem a branch Master

Apontar o repo -- e mais o Jenkinsfile -- [ADD] discover tags  

```text
$ git branch
* master

/pipeline-stage-when-buildingTag-tag (master)
$ git tag 1.0
fatal: tag '1.0' already exists

/pipeline-stage-when-buildingTag-tag (master)
$ git push origin :refs/tags/1.0

remote: warning: Deleting a non-existent ref.
To https://github.com/alexfbasa/pipeline-stage-when-buildingTag-tag
 - [deleted]         1.0   

Subscrever a tag
$ git tag -fa 1.0
Updated tag '1.0' (was 5fa87d0)

$ git push origin --tags

```