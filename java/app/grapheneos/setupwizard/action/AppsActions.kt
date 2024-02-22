package app.grapheneos.setupwizard.action

import android.app.Activity
import android.content.Intent
import android.util.Log
import app.grapheneos.setupwizard.view.activity.SetupWizardActivity

object AppsActions {
    private const val TAG = "AppsActions"
    private const val ACTION_APP_INSTALL = "app.grapheneos.setupwizard.action.APPS"

    init {
    }

    fun launchMigration(context: SetupWizardActivity) {
        Log.d(TAG, "launchAppInstaller")
        val intent = Intent(ACTION_APP_INSTALL)
        SetupWizard.startActivityForResult(context, intent)
    }

    fun handleResult(context: Activity, resultCode: Int) {
        if (resultCode != Activity.RESULT_CANCELED) {
            SetupWizard.next(context)
        }
    }
}
