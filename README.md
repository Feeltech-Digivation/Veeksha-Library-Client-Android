# Veeksha Library Android Client
This client is for accessing Veeksha's 3D Interactives on Android Platform devices.

---
## Installation Instructions

Firstly you need to add Jitpack in your Gradle Repositories

```groovy
allprojects {
    repositories {
	    ...
	    maven { url 'https://jitpack.io' }
    }
}
```
After then add this dependency to your application
```groovy
dependencies {
    implementation 'com.github.Feeltech-Digivation:Veeksha-Library-Client-Android:1.0.04'
}
```

---
## Usage

To launch the Veeksha you need the authentication token. Generally this token is provided by the backend server.

```java
import app.veeksha.library.LauncherActivity


void launch(Context packageContext, String authToken) {
    if (authToken == null || packageContext ==null){
        throw new NullPointerException("authToken or context is Null");
    }
    Intent intent = new Intent(packageContext, LauncherActivity.class);
    intent.putExtra("token", authToken);
    packageContext.startActivity(intent);
}
```