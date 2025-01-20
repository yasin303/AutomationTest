plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.seleniumhq.selenium:selenium-java:4.7.2")
    testImplementation("io.github.bonigarcia:webdrivermanager:5.9.2")
    testImplementation("io.cucumber:cucumber-java:7.15.0")
    testImplementation("io.cucumber:cucumber-junit:7.15.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.11.4")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.11.4")

    testImplementation("io.rest-assured:rest-assured:5.5.0")
    testImplementation("org.json:json:20240303")
    testImplementation("io.rest-assured:json-path:5.5.0")
    testImplementation("io.rest-assured:json-schema-validator:5.5.0")
    testImplementation("org.assertj:assertj-core:3.27.2")

}

val cucumberRuntime: Configuration by configurations.creating {
    extendsFrom(configurations["testImplementation"])
}

tasks.test {
    useJUnit()
}

tasks.register("apirun") {
    description = "Running API Test"
    dependsOn("assemble", "testClasses")
    doLast {
        javaexec {
            mainClass.set("io.cucumber.core.cli.Main")
            classpath = configurations.getByName("cucumberRuntime") +
                    sourceSets.main.get().output +
                    sourceSets.test.get().output
            args = listOf(
                "--plugin", "html:reports/api/index.html",
                "--plugin", "json:reports/api/index.json",
                "--plugin", "pretty",
                "--glue", "com.yasin.Apistepdef",
                "--tags", "@api",
                "src/test/resources/apifeature"
            )
        }
    }
}

tasks.register("webrun") {
    description = "Running Web Test"
    dependsOn("assemble", "testClasses")
    doLast {
        javaexec {
            mainClass.set("io.cucumber.core.cli.Main")
            classpath = configurations.getByName("cucumberRuntime") +
                    sourceSets.main.get().output +
                    sourceSets.test.get().output
            args = listOf(
                "--plugin", "html:reports/web/index.html",
                "--plugin", "json:reports/web/index.json",
                "--plugin", "pretty",
                "--glue", "com.yasin.Webstepdef",
                "--tags", "@web",
                "src/test/resources/webfeature"
            )
        }
    }
}