plugins {
    id("java-library")
    id("maven-publish")
}

group = "su.nightexpress.economybridge"
version = "1.2.0"
description = "economy-bridge"
java.sourceCompatibility = JavaVersion.VERSION_21

repositories {
    mavenLocal()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://repo.nightexpressdev.com/releases")
    maven("https://jitpack.io")
    maven("https://repo1.maven.org/maven2/")
    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")
    maven("https://repo.codemc.io/repository/maven-public/")
    maven("https://repo.codemc.io/repository/maven-releases/")
    maven("https://repo.rosewooddev.io/repository/public/")
    maven("https://nexus.bencodez.com/repository/maven-public/")
    maven("https://repo.techscode.com/repository/techscode-apis/")
    maven("https://repo.maven.apache.org/maven2/")
    
    maven("https://repo.magmaguy.com/releases")
    maven("https://repo.nexomc.com/releases")
    maven("https://repo.oraxen.com/releases")
    maven("https://nexus.phoenixdevt.fr/repository/maven-public/")
}

dependencies {
    compileOnly(libs.org.spigotmc.spigot.api)
    compileOnly(libs.su.nightexpress.nightcore.nightcore)
    compileOnly(libs.com.github.milkbowl.vaultapi)
    compileOnly(libs.me.clip.placeholderapi)
    compileOnly(libs.org.black.ixx.playerpoints)
    // compileOnly(libs.me.mraxetv.beasttokens.beasttokens)
    compileOnly(libs.com.bencodez.votingplugin)
    compileOnly(libs.com.magmaguy.elitemobs)
    compileOnly(libs.su.nightexpress.coinsengine.coinsengine)
    compileOnly(libs.me.techscode.ultraeconomyapi)
    compileOnly(libs.com.nexomc.nexo)
    compileOnly(libs.su.nightexpress.excellentcrates.excellentcrates)
    compileOnly(libs.io.th0rgal.oraxen)
    compileOnly(libs.com.github.lonedev6.api.itemsadder)
    // compileOnly(libs.io.lumine.mythic.lib.mythiclib)
    // compileOnly(libs.com.ssomar.score.score)
    compileOnly(libs.net.indyuce.mmoitems.api)
    
    compileOnly(files("libs/BeastTokensAPI.jar", "libs/RivalCreditsAPI.jar", "libs/SCore.jar", /*"libs/MythicLib.jar"*/));
}

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<Javadoc> {
    options.encoding = "UTF-8"
}

tasks.processResources {
    val props = mapOf("version" to version)
    inputs.properties(props)
    filteringCharset = "UTF-8"
    filesMatching("plugin.yml") {
        expand(props)
    }
}
