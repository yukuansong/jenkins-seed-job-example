// MyProject-Build.groovy

def gitUrl = "https://github.com/example/project.git"

job("MyProject-Build") {
    description "Builds MyProject from master branch."
    parameters {
        stringParam('COMMIT', 'HEAD', 'Commit to build')
    }
    scm {
        git {
            remote {
                url gitUrl
                branch "origin/master"
            }
            extensions {
                wipeOutWorkspace()
                localBranch 'master'
            }
        }
    }
    steps {
        shell "echo Look: I am building master!"
    }
}