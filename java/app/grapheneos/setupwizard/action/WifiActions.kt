package app.grapheneos.setupwizard.action

import android.app.Activity
import android.content.Intent
import app.grapheneos.setupwizard.R
import app.grapheneos.setupwizard.USE_LEGACY_WIFI_SETUP
import app.grapheneos.setupwizard.view.activity.SetupWizardActivity

object WifiActions {
    private const val TAG = "WifiActions"

    private const val ACTION_SETUP_INTERNET = "android.settings.SETUP_INTERNET"
    private const val ACTION_SETUP_INTERNET_LEGACY = "android.settings.NETWORK_PROVIDER_SETTINGS"
    private const val EXTRA_SKIP_TEXT = "extra_prefs_set_skip_text";
    private const val EXTRA_ENABLE_NEXT_ON_CONNECT = "wifi_enable_next_on_connect"
    private const val EXTRA_MODE_WIFI = "setup_wizard_mode_wifi"
    private const val EXTRA_SETUP_WIZARD_TITLE = "setup_wizard_title";
    private const val EXTRA_SETUP_WIZARD_DESC = "setup_wizard_description";

    init {
    }

    fun launchSetup(context: SetupWizardActivity) {
        val intent = Intent(
            if (USE_LEGACY_WIFI_SETUP) ACTION_SETUP_INTERNET_LEGACY else ACTION_SETUP_INTERNET
        )
        intent.putExtra(EXTRA_SETUP_WIZARD_TITLE, context.getString(R.string.connect_to_wi_fi))
        intent.putExtra(EXTRA_SETUP_WIZARD_DESC, context.getString(R.string.select_a_network))
        intent.putExtra(EXTRA_SKIP_TEXT, context.getString(R.string.set_up_without_wi_fi))
        intent.putExtra(EXTRA_ENABLE_NEXT_ON_CONNECT, true)
        intent.putExtra(EXTRA_MODE_WIFI, true)
        SetupWizard.startActivityForResult(context, intent)
    }

    fun handleResult(context: Activity, resultCode: Int) {
        if (resultCode == Activity.RESULT_CANCELED) throw IllegalArgumentException()
        SetupWizard.next(context)
    }
}
