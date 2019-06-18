package luyao.util.ktx.ui

import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.files.FileFilter
import com.afollestad.materialdialogs.files.fileChooser
import luyao.util.ktx.bean.ItemBean
import luyao.util.ktx.ext.goToAppInfoPage
import luyao.util.ktx.ext.goToDateAndTimePage
import luyao.util.ktx.ext.goToLanguagePage
import luyao.util.ktx.ext.installApk

/**
 * Created by luyao
 * on 2019/6/18 10:48
 */
class IntentExtActivity : CommonListActivity() {

    override fun getToolbarTitle() = "IntentExt"

    override fun initList() {
        dataList.run {
            add(ItemBean("App Info", null))
            add(ItemBean("Date And Timezone", null))
            add(ItemBean("Language And Input", null))
            add(ItemBean("Install Apk", null))
        }
    }

    override fun handleClick(position: Int) {
        when (position) {
            0 -> goToAppInfoPage()
            1 -> goToDateAndTimePage()
            2 -> goToLanguagePage()
            3 -> installApk()
        }
    }

    private val apkFilter: FileFilter = { it.name.endsWith(".apk") }
    private fun installApk() {
        MaterialDialog(this).show {
            fileChooser(filter = apkFilter) { dialog, file ->
                installApk(file)
            }
        }
    }
}