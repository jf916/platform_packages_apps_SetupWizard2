package app.grapheneos.setupwizard.view.activity

import android.content.Intent
import android.util.Log
import android.view.View
import app.grapheneos.setupwizard.R
import app.grapheneos.setupwizard.action.AppsActions
import app.grapheneos.setupwizard.action.SetupWizard

class AppsActivity : SetupWizardActivity(
    R.layout.activity_apps,
    R.drawable.apps_glif,
    R.string.install_apps,
    R.string.app_install_desc
) {
    companion object {
        private const val TAG = "AppsActivity"
    }

    override fun bindViews() {
        primaryButton.setText(this, R.string.install)
    }

    override fun setupActions() {
        secondaryButton.setOnClickListener { SetupWizard.next(this) }
        primaryButton.setOnClickListener { AppsActions.launchAppsInstaller(this) }
    }

    override fun onActivityResult(resultCode: Int, data: Intent?) {
        Log.d(TAG, "onActivityResult: $resultCode, data=$data")
        AppsActions.handleResult(this, resultCode)
        super.onActivityResult(resultCode, data)
    }
}
