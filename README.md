This project demonstrates the functionality of a yet unmerged PR to openapi-generator.
With this PR a spring server can be generated as a gradle submodule.
This repository holds code for an example project and instructions on how to generate the submodule.

A gradle task for generation is already present on the build.gradle of the root project, but not used because I don't know how to build and load a custom version from my PR.


```
#clone sample project
git clone https://github.com/timo-a/openapi-generator-spring-subproject.git

#clone openapi
git clone https://github.com/timo-a/openapi-generator.git
cd openapi-generator
git checkout 6258_add_gradle_build_to_spring
export JAVA_HOME=/usr/lib/jvm/java-11-amazon-corretto
mvn clean install


java -jar modules/openapi-generator-cli/target/openapi-generator-cli.jar generate\
     -g spring\
     -i ../openapi-generator-spring-subproject/src/main/resources/petstore_v1.0.5.yaml\
     -o ../openapi-generator-spring-subproject/petstore-api\
     --additional-properties=apiPackage="com.example.petstore.backend.api",\
invokerPackage="com.example.petstore.backend.api.invoker",modelPackage="com.example.petstore.backend.api.model",configPackage="com.example.petstore.backend.api.configuration",dateLibrary="java8",interfaceOnly="true"

cd ../openapi-generator-spring-subproject/
./gradlew bootRun
```