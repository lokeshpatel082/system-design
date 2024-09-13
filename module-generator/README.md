# Module Generator
To use module generator, execute below steps from terminal

- checkout the project
- switch to **system-design** dir and execute command **mvn clean install**
- switch to module-generator module
- execute command **mvn clean install**
- switch back to the root directory ie **system-design**
- after successful install execute below command by replace **<module_name>** to the desired module name

```
mvn archetype:generate \
-DarchetypeGroupId=com.loki \
-DarchetypeArtifactId=module-generator  \
-DgroupId=com.loki \
-DartifactId=<module_name> \
-Dversion=1.0.0 \
-Dpackage=com.loki
```

- this will generate a module with name **<module_name>**
- one change has to be done in the parent pom.xml in the modules tag and add the newly created module just above the **distribution** module