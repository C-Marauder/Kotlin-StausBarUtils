# Kotlin-StatusBarHelper

[ ![Download](https://api.bintray.com/packages/xqy/maven/statusbar/images/download.svg?version=1.0.0) ](https://bintray.com/xqy/maven/statusbar/1.0.0/link)

## 1.使用
```
在Activity的onCreate()方法中调用
//isDark true表示黑色，false表示白色
StatusBarHelper.setStatusBarMode(activity,isDark)
```
## 2.依赖
* application build.gradle

```
allprojects {
    repositories {
        maven {
            url 'https://dl.bintray.com/xqy/maven'
        }
    }
}

```
* app build.gradle

`implementation 'com.xqy.androidx.statusbar:statusbar:1.0.0'`
