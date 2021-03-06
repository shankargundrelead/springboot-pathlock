# springboot-pathlock
name: Build and deploy WAR app to Azure Web App - springboot-pathlock

on:
push:
branches:
- master
workflow_dispatch:

jobs:
build:
runs-on: windows-latest

steps:
- uses: actions/checkout@v2

- name: Set up Java version
uses: actions/setup-java@v1
with:
java-version: '8'

- name: Build with Maven
run: mvn clean install

- name: Upload artifact for deployment job
uses: actions/upload-artifact@v2
with:
name: java-app
path: '${{ github.workspace }}/target/*.war'

deploy:
runs-on: windows-latest
needs: build
environment:
name: 'production'
url: ${{ steps.deploy-to-webapp.outputs.webapp-url }}

steps:
- name: Download artifact from build job
uses: actions/download-artifact@v2
with:
name: java-app
path: '${{ github.workspace }}/target/*.war'

- name: Deploy to Azure Web App
id: deploy-to-webapp
uses: azure/webapps-deploy@v2
with:
app-name: 'springboot-pathlock'
slot-name: 'production'
publish-profile: ${{ secrets.AzureAppService_PublishProfile_167bf1dd771949f58a102b0c665e84f6 }}
package: '*.war'
