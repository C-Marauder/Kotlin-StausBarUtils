package com.core.statusbarhelper

import android.annotation.SuppressLint
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.view.View


object StatusBarHelper  {


    fun setStatusBarMode(activity:AppCompatActivity,isDark: Boolean) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            activity.window.decorView.systemUiVisibility =
                    if (isDark) {
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                                View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                    } else {
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    }

        } else {
            when(Build.BRAND){
                "Xiaomi"->setMIUIMode(activity,isDark)
                "Meizu"-> setFlymeMode(activity,isDark)
                else-> {
                    activity.window.decorView.systemUiVisibility = if (isDark){
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    }else{
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    }

                }

            }

        }
    }

    @SuppressLint("PrivateApi")
    private fun setMIUIMode(activity: AppCompatActivity,isDark: Boolean){
        val clazz = activity.window.javaClass
        try {
            var darkModeFlag = 0
            val layoutParams = Class.forName("android.view.MiuiWindowManager\$LayoutParams")
            val field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE")
            darkModeFlag = field.getInt(layoutParams)
            val extraFlagField =
                clazz.getMethod("setExtraFlags", Int::class.javaPrimitiveType, Int::class.javaPrimitiveType)
            extraFlagField.invoke(activity.window, if (isDark) darkModeFlag else 0, darkModeFlag)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
    private fun setFlymeMode(activity: AppCompatActivity,isDark: Boolean){
        try {
            val attributes = activity.window.attributes
            val f = attributes.javaClass.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON")
            f.isAccessible = true
            val bits = f.getInt(attributes)
            val f2 = attributes.javaClass.getDeclaredField("meizuFlags")
            f2.isAccessible = true
            var meizuFlags = f2.getInt(attributes)
            val oldFlags = meizuFlags
            meizuFlags = if (isDark) {
                meizuFlags or bits
            } else {
                meizuFlags and bits.inv()
            }
            if (oldFlags != meizuFlags) {
                f2.setInt(attributes, meizuFlags)
            }
        } catch (e: NoSuchFieldException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
        } catch (e: Throwable) {
            e.printStackTrace()
        }

    }
}

