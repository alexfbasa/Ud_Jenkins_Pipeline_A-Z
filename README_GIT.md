## Repository of this course

https://github.com/pipelineascodecourse/source_code

# learning git

Building tag condition

```groovy
pipeline {
    agent any

    stages {
        stage('Build') {

            when {
                tag '2.0'
            }

            steps {
                echo 'Hello World building tag'
            }
        }
    }
}
```

Criar o build job - MultiBranch Pipeline - Repositorio soh tem a branch Master

Apontar o repo -- Jenkinsfile -- [ADD] discover tags

Criar uma tag

```text
$ git branch
* master

/pipeline-stage-when-buildingTag-tag (master)
$ git tag 1.0

/pipeline-stage-when-buildingTag-tag (master)
$ git push origin --tags

To https://github.com/alexfbasa/Ud_Jenkins_Pipeline_A-Z.git
 * [new tag]         1.0 -> 1.0   
```
![git_tag](images/git-tag.png)
```
$ git commit 
$ git push
```

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