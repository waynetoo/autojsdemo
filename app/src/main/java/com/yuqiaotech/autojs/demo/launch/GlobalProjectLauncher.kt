package com.yuqiaotech.autojs.demo.launch

import android.annotation.SuppressLint
import com.stardust.app.GlobalAppContext
import com.yuqiaotech.autojs.demo.launch.AssetsProjectLauncher

/**
 * Created by Stardust on 2018/3/21.
 */

@SuppressLint("StaticFieldLeak")
object GlobalProjectLauncher : AssetsProjectLauncher("project", GlobalAppContext.get())
