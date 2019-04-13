# Kotlin-StatusBarUtils

**动态改变状态栏颜色**

[ ![Download](https://api.bintray.com/packages/xqy/maven/statusbarUtils/images/download.svg?version=1.0.0) ](https://bintray.com/xqy/maven/statusbarUtils/1.0.0/link)

```
## 1.依赖
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

`implementation 'com.xqy.android.statusbar:statusbarUtils:1.0.0'`

## 2.使用
```
在Activity的onCreate()方法中调用
//isDark true表示黑色，false表示白色
StatusBarHelper.setStatusBarMode(activity,isDark)
