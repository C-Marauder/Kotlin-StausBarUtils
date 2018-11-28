# Kotlin-StatusBarHelper
## 1.使用
```
在Activity的onCreate()方法中调用
//isDark true表示黑色，false表示白色
StatusBarHelper.setStatusBarMode(activity,isDark)
```
## 2.依赖
//application build.gradle

```
allprojects {
    repositories {
        maven {
            url 'https://dl.bintray.com/xqy666/maven/'
        }
    }
}

```
//app build.gradle

`implementation 'com.core.statusbarhelper:statusbarhelper:1.0.1'`
