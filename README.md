# Product Api Service

A Java Spring boot application that provides product API information from `https://reqres.in/api/products`

## API

* Get products information : `http://<host name>/api/product?page=1&size=5` where page is page number and size is no of items per page

## pre requisites

This application requires java 11 to build and compile the code.

## Build

Execute `./gradlew clean build` from the terminal to build the application


## Running 

Execute `./gradlew bootRun` from the terminal to run the spring boot application


## Deployment

This application can be deployed as docker container on GKE cluster using GCP cloud build. To deploy, we would
need gcloud tool installed and configured.Gcloud build can be submitted to executing below command.

`gcloud builds submit .  --config cloudbuild.yaml --substitutions _TAG=v1.0,_GKE_CLUSTER=<name of gje cluster>,_GKE_LOCATION=<location>`

Ex: gcloud builds submit .  --config cloudbuild.yaml --substitutions _TAG=v1.0,_GKE_CLUSTER=test-project-gke,_GKE_LOCATION=europe-west2

The cloud build will build the application, creates a docker image, pushes the image to GCR and deploys the application to GKE cluster.
The service account used to run the cloud build should have Storage permission and Kubernetes Engine developer permission.

Following k8s objects will be created as part of deployment. The k8s manifest can be found under deployment/k8s folder.

* Namespace 
* Deployment
* Service
* HPA