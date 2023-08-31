Before you begin, we need jdk 17 for new version of spring-boot:

```
sudo apt update
sudo apt install openjdk-17-jdk


export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
```

or you can use sdkman

```
sdk install java 18.0.1.fx-zulu

```


To visit the open api specification portal, head to http://localhost:8080/api-docs and to get the openapi yaml by downloading http://localhost:8080/api-docs.yaml



To make a mock server run, we use the Prism framework (internally it uses the WireMock):
```
npx @stoplight/prism-cli@latest mock openapi.yaml
```

Test the mock server (wiremock server will run on 4010 port)
```
http :4010/persons names="jjy"
```


To spin up wiremock server with docker:
```
docker run -it --rm   -p 8081:8080   --name wiremock  rodolpheche/wiremock
```


 http://localhost:8080/__admin/mappings 
 http://localhost:8080/__admin/recorder


To record the requests properly, you must enter the public ip or domain name for forward url. (May be it makes the browser side request)

references:

- https://www.jvt.me/posts/2022/03/04/openapi-local-prism/
- https://www.baeldung.com/spring-rest-openapi-documentation
- https://wiremock.org/docs/standalone/docker/
