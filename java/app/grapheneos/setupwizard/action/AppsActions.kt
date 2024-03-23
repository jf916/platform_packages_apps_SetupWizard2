package app.grapheneos.setupwizard.action

import android.app.Activity
import android.content.ComponentName
import android.content.Intent
import android.util.Log
import androidx.core.app.ActivityCompat.startActivityForResult
import app.grapheneos.setupwizard.view.activity.SetupWizardActivity

object AppsActions {
    private const val TAG = "AppsActions"

    init {
    }

    fun launchAppsInstaller(context: SetupWizardActivity) {
        Log.d(TAG, "launchAppInstaller")
        val intent = Intent(Intent.ACTION_MAIN)
        val packageName = "app.grapheneos.apps";
        intent.setComponent(
            ComponentName(
                packageName,
                "$packageName.ui.MainActivity"
            )
        )
        SetupWizard.startActivityForResult(context, intent)
    }

    fun handleResult(context: Activity, resultCode: Int) {
        if (resultCode != Activity.RESULT_CANCELED) {
            SetupWizard.next(context)
        }
    }
}
