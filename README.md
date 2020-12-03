#clone sample project
git clone https://github.com/timo-a/openapi-generator-spring-subproject.git

#clone openapi
git clone https://github.com/timo-a/openapi-generator.git
cd openapi-generator
git checkout 6258_add_gradle_build_to_spring
mvn clean install


java -jar modules/openapi-generator-cli/target/openapi-generator-cli.jar generate\
     -g spring\
     -i ../openapi-generator/src/main/resources/petstore_v1.0.5.yaml\
     -o ../openapi-generator-spring-subproject/petstore-api\
     --additional-properties=apiPackage="com.example.petstore.backend.api",\
invokerPackage="com.example.petstore.backend.api.invoker",modelPackage="com.example.petstore.backend.api.model",configPackage="com.example.petstore.backend.api.configuration",dateLibrary="java8",interfaceOnly="true"
