node('linux')
{
  stage ('Poll') {
    checkout([
      $class: 'GitSCM',
      branches: [[name: '*/main']],
      doGenerateSubmoduleConfigurations: false,
      extensions: [],
      userRemoteConfigs: [[url: 'https://github.com/zopencommunity/nghttp2port.git']]])
  }
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/zopencommunity/nghttp2port.git'), string(name: 'PORT_DESCRIPTION', value: 'This is an implementation of the Hypertext Transfer Protocol version 2 in C.' ), string(name: 'BUILD_LINE', value: 'DEV') ]
  }
}
