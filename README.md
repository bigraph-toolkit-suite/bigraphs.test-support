# bigraphs.test-support

## Overview

**bigraphs.test-support** is a testing utility library for the bigraph ecosystem, providing helper classes, test data generators, and utilities to simplify writing unit tests, regression tests, and integration tests.

## Installation

**Maven Configuration**

```xml
<dependency>
    <groupId>org.bigraphs.testing</groupId>
    <artifactId>bigraph-test-support</artifactId>
    <version>${version}</version>
    <scope>test</scope>
</dependency>
```

**For Gradle (Kotlin DSL)**

```groovy
testImplementation("org.bigraphs.test:bigraphs.test-support:VERSION")
```

## Usage Example

## Development

### Building from Source

Execute the following goals to run the build:
```shell
mvn clean install
```
The `*.jar` can be found inside the `./target/` folder of this project.
The dependency will be also installed in the local Maven repository and
can be used in other projects by following the instruction given [above](#Usage)

### Deployment

**Prerequisites**

The Sonatype account details (username + password) for the deployment must be provided to the
Maven Sonatype Plugin as used in the project's `pom.xml` file.

The Maven GPG plugin is used to sign the components for the deployment.
It relies on the gpg command being installed:
```shell
sudo apt install gnupg2
```

and the GPG credentials being available e.g. from `settings.xml` (see [here](https://central.sonatype.org/publish/publish-maven/)).
In `settings.xml` should be a profile and server configuration both with the `<id>ossrh</id>`.

- More information can be found [here](https://central.sonatype.org/publish/requirements/gpg/).
- Listing keys: `gpg --list-keys --keyid-format short`
- The `pom.xml` must also conform to the minimal requirements containing all relevant tags as required by Sonatype.

**Snapshot Deployment**

Execute the following goals to deploy a SNAPSHOT release of the Java artifact to the snapshot repository:

```shell
# Use the default settings.xml located at ~/.m2/
mvn clean deploy -P ossrh -DskipTests
# mvn clean deploy -P ossrh
```

- The version tag in the `pom.xml` must be suffixed with `-SNAPSHOT`.´

**Release Deployment**

To perform a release deployment, execute:
```shell
mvn clean deploy -P release,ossrh -DskipTests
# mvn clean deploy -P release,ossrh
```
- The SNAPSHOT suffix must be removed from the version tag
- Artifacts must be manually released for Release Deployments in the Nexus Repository Manager.
