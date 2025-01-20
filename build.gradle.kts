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
}

tasks.test {
    useJUnit()
}

tasks.register<Test>("cucumberApiTests") {
    description = "Execute cucumber tests with @api tag"

    systemProperty("cucumber.filter.tags", "@api")
    systemProperty("cucumber.features", "src/test/resources/apifeature")
    systemProperty("cucumber.glue", "com.yasin.Apistepdef")

    useJUnit()
    testLogging.showStandardStreams = true
}

tasks.register<Test>("cucumberWebTests") {
    description = "Execute cucumber tests with @web tag"

    systemProperty("cucumber.filter.tags", "@web")
    systemProperty("cucumber.features", "src/test/resources/webfeature")
    systemProperty("cucumber.glue", "com.yasin.Webstepdef")

    useJUnit()
    testLogging.showStandardStreams = true
}