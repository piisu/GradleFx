
plugins {
    id("java-gradle-plugin")
    `kotlin-dsl`
    id("groovy")
    `maven-publish`
}

group = "org.gradlefx"
version = "1.5.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("commons-lang:commons-lang:2.6")
    implementation("commons-io:commons-io:2.4")
    testImplementation("org.spockframework:spock-core:2.0-M2-groovy-2.5")
}


tasks {
}

configure<GradlePluginDevelopmentExtension> {
    plugins {
        mapOf("templates" to "org.gradlefx.templates.plugins.TemplatesPlugin",
                "gradlefx" to "org.gradlefx.plugins.GradleFxPlugin",
                "creator" to "org.gradlefx.templates.plugins.CreatorPlugin",
                "ideafx" to "org.gradlefx.ide.plugins.IdeaPlugin",
                "fdt" to "org.gradlefx.ide.plugins.FDTPlugin",
                "scaffold" to "org.gradlefx.templates.plugins.ScaffoldPlugin",
                "ide" to "org.gradlefx.ide.plugins.IDEPlugin",
                "flashdevelop" to "org.gradlefx.ide.plugins.FlashDevelopPlugin",
                "flashbuilder" to "org.gradlefx.ide.plugins.FlashBuilderPlugin",
                "flexbuilder" to "org.gradlefx.ide.plugins.FlexBuilderPlugin"
        ).forEach {
            register(it.key) {
                id = it.key
                implementationClass = it.value
            }
        }
    }
}

